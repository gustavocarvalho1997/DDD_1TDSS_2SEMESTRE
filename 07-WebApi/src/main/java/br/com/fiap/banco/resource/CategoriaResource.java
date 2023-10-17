package br.com.fiap.banco.resource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.CategoriaDao;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Categoria;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/categoria")
public class CategoriaResource {
	//Atributos
	private CategoriaDao dao;
	
	//Construtor
	public CategoriaResource() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		dao = new CategoriaDao(conn);
	}
	
	//api/categoria GET (Listar todos os produtos)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> lista() throws ClassNotFoundException, SQLException {
		return dao.listar();
	}
	
	//GET api/categoria/1 (Pesquisar pelo Id)
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response busca(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			return Response.ok(dao.pesquisarPorId(id)).build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Categoria categoria, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		dao.cadastrar(categoria);
		//Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/categoria/))
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		//Adiciona o id do produto que foi criado na URL
		builder.path(String.valueOf(categoria.getId()));
		//Retorna o status 201 com a url para acessar o produto criado
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Categoria categoria, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			categoria.setId(id);
			dao.atualizar(categoria);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			dao.deletar(id);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
}//CLASS