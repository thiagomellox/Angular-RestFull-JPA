package br.com.projeto.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.projeto.controller.model.Artista;
import br.com.projeto.controller.model.Request;
import br.com.projeto.controller.model.Response;
import br.com.projeto.service.ArtistaService;

/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http.
 *
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 */
@Path("/artista")
public class ArtistaController {
	
	/** The service. */
	ArtistaService service = new ArtistaService();
	
	
	/**
	 * Listar.
	 *
	 * @param request the request
	 * @return the list
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public List<Artista> listar(Request request){
		
		return service.findByName(request.getPesquisa());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar_todos")
	public List<Artista> listarTodos(){
		
		return service.listAll();
	}
	
	/**
	 * Salvar.
	 *
	 * @param request the request
	 * @return the response
	 */
	@POST	
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public Response salvar(Artista request){
		try{
			service.save(request);
		}catch(Exception e){
			return new Response("danger","Erro ao salvar");
		}
		
		return new Response("success","Salvo com Sucesso");
	}
	
	/**
	 * Remover.
	 *
	 * @param request the request
	 * @return the response
	 */
	@DELETE	
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remover")
	public Response remover(Artista request){
		Response response;
		try{
			service.delete(request);
		}catch(Exception e){
			response = new Response("danger","Erro ao remover");
			return response;
		}
		response = new Response("success","Removido com Sucesso");
		return response;
	}

}
