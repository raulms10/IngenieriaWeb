package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir los metodos que vamos a usar en el DAO
 * del Usuario
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public interface UsuarioDAO {
	
	public Usuario obtenerUsuario(String login) throws MyException;

}
