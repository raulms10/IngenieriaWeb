package co.edu.udea.iw.bl;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir la lógica de negocio del Usuario
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

@Transactional
public class UsuarioBL {
	
	private UsuarioDAO usuarioDAO;

	/**
	 * Para verificar que el login y la contraseña ingresados como parámetros correspondan
	 * al de un Usuario en nuestra BD
	 * @param login
	 * @param pass
	 * @return true o false(el usuario es válido o no)
	 * @throws MyException
	 */
	public boolean validarUsuario(String login, String pass) throws MyException{
		if (login == null || "".equals(login) ) { //Verificamos que el login no sea vacío
			throw new MyException("Error: El login ingresado no es válido");
		}
		if (pass == null || "".equals(pass) ) { //Verificamos que la contraseña no sea vacía
			throw new MyException("Error: La contraseña no puede estar vacía, verifique");
		}
		Usuario usuario = getUsuarioDAO().obtenerUsuario(login);//Obtenemos el usuario en el BD con el login correspondiente
		if (usuario != null) { //Verificamos de que el usuario si exista en el BD
			//System.out.println("Usuario encontrado, Pass: "+ usuario.getContrasena());
			if (pass.equals(usuario.getContrasena())){  //Verificamos que las contraseñas
				throw new MyException("Usuario validado");//Usuario validado
	
			}
		}
		throw new MyException("Usuario o contraseña incorrecto");
	
		//return false; //Usuario no válido, la contraseña o el login son incorrectos
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
