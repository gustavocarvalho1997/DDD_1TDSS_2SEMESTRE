package br.com.fiap.gestao.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.gestao.excecption.BadInfoException;
import br.com.fiap.gestao.excecption.IdNotFoundException;
import br.com.fiap.gestao.model.Usuario;
import br.com.fiap.gestao.service.UsuarioService;
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

@Path("/usuario")
public class UsuarioResource {
	// Atributo
	private UsuarioService service;
	// Construtor
	public UsuarioResource() throws ClassNotFoundException, SQLException {
		service = new UsuarioService();
	}
	
	// Cadastrar INICIO
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Usuario usuario, @Context UriInfo uriInfo) throws SQLException {
		try {
			service.cadastrar(usuario);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(usuario.getCodigo()));
			return Response.created(builder.build()).build();
		}  catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}// Cadastrar FIM
	
	// Listar INICIO
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() throws SQLException {
		return service.listar();
	}// Listar FIM
	
	// PesquisarPorCodigo INICIO
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorCodigo(@PathParam("codigo") int codigo) throws ClassNotFoundException, SQLException{
		try {
			return Response.ok(service.pesquisarPorCodigo(codigo)).build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}// PesquisarPorCodigo FIM
	
	// Atualizar INICIO
	@PUT
	@Path("/{codigo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Usuario usuario, @PathParam("codigo") int codigo) throws SQLException {
		try {
			usuario.setCodigo(codigo);
			service.atualizar(usuario);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	// Deletar INICIO
	@DELETE
	@Path("/{codigo}")
	public Response deletar(@PathParam("codigo") int codigo) throws ClassNotFoundException, SQLException {
		try {
			service.deletar(codigo);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}// Deletar FIM
}//CLASS