package br.com.fiap.banco.resource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Produto;
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

@Path("/produto")
public class ProdutoResource {

	private ProdutoDao dao;
	
	public ProdutoResource() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		dao = new ProdutoDao(conn);
	}
	
	// api/produto GET (Listar todos os produtos)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> lista() throws ClassNotFoundException, SQLException {
		return dao.listar();
	}
	
	//GET http://localhost:8080/07-WebApi/api/produto/1 (Pesquisar pelo Id)
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response busca(@PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
		try {
			return Response.ok(dao.pesquisar(codigo)).build();
		}  catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Produto produto, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		dao.cadastrar(produto);
		//Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/produto/))
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		//Adiciona o id do produto que foi criado na URL
		builder.path(Integer.toString(produto.getCodigo()));
		//Retornar o status 201 com a URL para acessar o produto criado
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Produto produto, @PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
		try {
			produto.setCodigo(codigo);
			dao.atualizar(produto);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
		try {
			dao.remover(codigo);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
}//CLASS