package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir los metodos que vamos a usar en el DAO
 * de los Usuarios
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public interface UsuarioDAO {
	
	/* @return Un Usuario
	 * Entrega el Usuario que existan en la BD con el codigo(login) ingresado como parámetro
	 * @throws MyException 
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public Usuario obtenerUsuario(String login) throws MyException;

}
