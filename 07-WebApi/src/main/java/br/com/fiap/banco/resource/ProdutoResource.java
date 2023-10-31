package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Produto;
import br.com.fiap.banco.service.ProdutoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/produto")
public class ProdutoResource {

	private ProdutoService bo;
	
	public ProdutoResource() throws ClassNotFoundException, SQLException {
		bo = new ProdutoService();
	}
	
	// api/produto GET (Listar todos os produtos)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> lista() throws ClassNotFoundException, SQLException {
		return bo.listar();
	}
	//GET http://localhost:8080/07-WebApi/api/produto/query?nome=fiuawhfiu
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> pesquisar(@QueryParam("nome") String pesquisa) throws SQLException {
		return bo.pesquisarPorNome(pesquisa);
	}
	
	//GET http://localhost:8080/07-WebApi/api/produto/1 (Pesquisar pelo Id)
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response busca(@PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
		try {
			return Response.ok(bo.pesquisar(codigo)).build();
		}  catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Produto produto, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException, BadInfoException {
		try {
			bo.cadastrar(produto);
			//Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/produto/))
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			//Adiciona o id do produto que foi criado na URL
			builder.path(Integer.toString(produto.getCodigo()));
			//Retornar o status 201 com a URL para acessar o produto criado
			return Response.created(builder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Produto produto, @PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
		try {
			produto.setCodigo(codigo);
			bo.atualizar(produto);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
		try {
			bo.remover(codigo);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
}//CLASS