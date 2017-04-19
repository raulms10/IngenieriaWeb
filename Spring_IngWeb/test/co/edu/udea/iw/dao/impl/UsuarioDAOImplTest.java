package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Pruebas de los metodos de UsuarioDAO
 * @author Raul Martinez Silgado
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/conf.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class UsuarioDAOImplTest {

	@Autowired//Inyectar datos desde la base de datos
	UsuarioDAO usuarioDAO;
	
	Logger logger = Logger.getLogger(MyException.class);//Para manejar los errores
	
	
	@Test
	public void testObtener() {
		PropertyConfigurator.configure("src/co/edu/udea/iw/pt/log4j.properties");//propiedades para configurar log4j
		Usuario usuario = null; //Defino el objeto para almacenar el Usuario
		try{
			usuario = usuarioDAO.obtenerUsuario("elver"); 
			System.out.println("Usuario: "+usuario.getNombres()+" Nombre del Rol: "+usuario.getRol().getNombre());
			assertTrue(usuario != null);		
		}catch (MyException e) {
			logger.log(Level.ERROR,"Error consultando: "+ e.getMessage());
		}
	}

}
