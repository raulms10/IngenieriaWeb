package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public interface UsuarioDAO {
	
	public Usuario obtenerUsuario(String login) throws MyException;

}
