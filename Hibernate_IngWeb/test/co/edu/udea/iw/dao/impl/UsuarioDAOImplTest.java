package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOImplTest {
	@Test
	public void testObtenerUsuario() {
		UsuarioDAO usuarioDAO = null; //Defino los objetos del tipo de la interfaz
		Usuario usuario = null; //Defino el objeto para almacenar el Usuario
		try{
			usuarioDAO = new UsuarioDAOImpl(); //Y los inicializo con el constructor de la implementación de la interfaz
			usuario = usuarioDAO.obtenerUsuario("elver"); //Consulto el Usuario
			assertTrue(usuario != null);//Verifico que la haya por lo menos un Usuario
			System.out.println("Usuario: "+usuario.getNombres()+" Nombre del Rol: "+usuario.getRol().getNombre());
		}catch (MyException e) {
			e.printStackTrace();//Mostrar más información si ocurre un error, se debería mostar en un logger
			fail(e.getMessage());//Ha ocurrido un error consultando las ciudades
		}
	}
}
