package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author rantonio.martinez
 *
 */

@Path("usuario")
@Component
public class UsuarioWS {
	
	@Autowired
	UsuarioBL usuarioBL;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login")String login, @QueryParam("pass")String pass){
		String retorno = "";
		try{
			usuarioBL.validarUsuario(login, pass);
		}catch (MyException e) {
			retorno = e.getMessage();
		}
		
		return retorno;
	}

}
