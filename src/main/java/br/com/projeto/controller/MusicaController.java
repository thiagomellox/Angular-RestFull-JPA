package br.com.projeto.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.projeto.controller.model.Musica;
import br.com.projeto.controller.model.Request;
import br.com.projeto.controller.model.Response;
import br.com.projeto.service.MusicaService;

/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http.
 *
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 */
@Path("/musica")
public class MusicaController {
	
	/** The service. */
	MusicaService service = new MusicaService();
	
	
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
	public List<Musica> listar(Request request){
		Long codigoArtista = null;
		
		if(request.getArtista() !=null && request.getArtista().getCodigo() != null){
			codigoArtista = request.getArtista().getCodigo();
		}
		
		return service.findByNameAndArtista(request.getPesquisa(), codigoArtista);
	}
	
	
	/**
	 * Salvar.
	 *
	 * @param request the request
	 * @return the response
	 */
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public Response salvar(Musica request){
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
	public Response remover(Musica request){
		try{
			service.delete(request);
		}catch(Exception e){
			return new Response("danger","Erro ao remover");
		}
		
		return new Response("success","Removido com Sucesso");
	}

}
