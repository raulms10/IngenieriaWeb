package co.edu.udea.iw.bl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.exception.MyException;

/*
 * Pruebas de los metodos de la lógica de Negocio de Cliente
 * @author Raul Martinez Silgado
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/conf.xml")
public class ClienteBLTest {
	
	@Autowired
	ClienteBL clienteBL;
	
	@Test
	public void testGuardarCliente() {
		String cedula = "520";
		String nombres = "Ana";
		String apellidos = "Martinez";
		String email = "a@m.com";
		String usuarioCrea = "elver";
		try {
			clienteBL.guardarCliente(cedula, nombres, apellidos, email, usuarioCrea);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
