package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author rantonio.martinez
 *
 */


@Path("saludo") //Ruta de la URL
public class PrimerEjemplo {
	
	@GET //Tipo de petición a la que responde este método en esta clase(ruta URL), puede ser POST, DELETE o PUT
	@Produces(MediaType.TEXT_HTML) //Resultado que arroja este método
	public String saludar(){
		return "Saludos...";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2") //Para acceder a este sería /saludo/2
	public String saludar2(){
		return "Hola";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("3")
	public String saludar3(@QueryParam("n")String nombre){
		return "Saludos "+nombre+ ", qué hay de nuevo?"; 
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("4/{n}")
	public String saludar4(@PathParam("n")String nombre){
		return "Saludos "+nombre+ ", cómo está?"; 
	}
	
	

}
