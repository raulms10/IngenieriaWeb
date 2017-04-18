package co.edu.udea.iw.bl;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir la lógica de negocio del Usuario
 * 
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public class UsuarioBL {
	
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public boolean validarUsuario(String login, String pass) throws MyException{
		
		if (login == null ||"".equals(login) ) {
			throw new MyException("Error: El login ingresado no es válido");
		}
		if (pass == null ||"".equals(pass) ) {
			throw new MyException("Error: La contraseña no puede estar vacía, verifique");
		}
		Usuario usuario = getUsuarioDAO().obtenerUsuario(login);//Buscamos en la base de datos el usuario por su login
		if (usuario != null) {
			//System.out.println("Usuario encontrado, Pass: "+ usuario.getContrasena());
			if (pass.equals(usuario.getContrasena())) {
				return true;
			}else{
				System.out.println("Contraseña incorrecta");
			}			
		}
		return false;
	}

}
