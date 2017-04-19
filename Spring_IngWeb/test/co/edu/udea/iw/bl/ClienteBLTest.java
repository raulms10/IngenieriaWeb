package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.exception.MyException;

/**
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
	
	@Test
	public void testObtenerClientes(){
		List<Cliente> resultado = null;
		try{
			resultado = clienteBL.obtenerClientes();
			for(Cliente c: resultado){
				System.out.println("Cliente: " + c.getNombres() +" Cedula: "+c.getCedula());
				Set<Direccion> dir = c.getDirecciones();
				for(Direccion d: dir){
					System.out.println("Nombre: "+ c.getNombres() + " Direcci�n: "+d.getDireccion());
				}
			}
			assertTrue(resultado.size() > 0);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	

}
