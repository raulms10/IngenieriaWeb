package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Pruebas de los metodos de CiudadDAO
 * @author Raul Martinez Silgado
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/conf.xml")
public class CiudadDAOImplTest {
	
	@Autowired //Injectar de
	CiudadDAO ciudadDAO;	

	Logger logger = Logger.getLogger(MyException.class);//Para manejar los errores
	
	/* Para probar que la cantidad de ciudades en la base de datos
	 * sea mayor que 0, exista por lo menos una ciudad
	 * */
	@Test
	public void testObtenerCiudades() {
		PropertyConfigurator.configure("src/co/edu/udea/iw/pt/log4j.properties");//propiedades para configurar log4j
		//CiudadDAO ciudadDAO = null; //Defino los objetos del tipo de la interfaz
		List<Ciudad> lista = null; //Defino el objeto para almacenar la lista de ciudades
		try{
			//ciudadDAO = new CiudadDAOImpl(); //Y los inicializo con el constructor de la implementación de la interfaz
			lista = ciudadDAO.obtenerCiudad(); //Consulto la lista de ciudades
			assertTrue(lista.size() > 0);//Verifico que la cantidad de ciudades sea mayor que 0
		}catch (MyException e) {
			e.printStackTrace();//Mostrar más información si ocurre un error, se debería mostar en un logger
			fail(e.getMessage());//Ha ocurrido un error consultando las ciudades
			logger.log(Level.ERROR,"Error consultando: "+ e.getMessage());
		}
	}
	
	/* Para probar que la cantidad de ciudades en la base de datos
	 * sea mayor que 0, exista por lo menos una ciudad
	 * */
	@Test
	public void testObtenerCiudad() {
		PropertyConfigurator.configure("src/co/edu/udea/iw/pt/log4j.properties");//propiedades para configurar log4j
		//CiudadDAO ciudadDAO = null; //Defino los objetos del tipo de la interfaz
		Ciudad ciudad = null; //Defino el objeto para almacenar la ciudad
		try{
			//ciudadDAO = new CiudadDAOImpl(); //Y los inicializo con el constructor de la implementación de la interfaz
			ciudad = ciudadDAO.obtenerCiudad(1L); //Consulto la lista de ciudades
			assertTrue(ciudad != null);//Verifico que la haya por lo menos una ciudad
		}catch (MyException e) {
			e.printStackTrace();//Mostrar más información si ocurre un error, se debería mostar en un logger
			fail(e.getMessage());//Ha ocurrido un error c+++++++++++++++++++onsultando las ciudades+
			logger.log(Level.ERROR,"Error consultando long: "+ e.getMessage());
		}
	}
	
	@Test
	public void guardarCiudad(){
		PropertyConfigurator.configure("src/co/edu/udea/iw/pt/log4j.properties");//propiedades para configurar log4j
		//CiudadDAO ciudadDAO = null; //Defino los objetos del tipo de la interfaz
		Ciudad ciudad = new Ciudad(); //Defino el objeto para almacenar la ciudad
		ciudad.setCodigo(45L);
		ciudad.setCodigoArea("6g");
		ciudad.setNombre("Villa Bonita");
		try{
			//ciudadDAO = new CiudadDAOImpl(); //Y los inicializo con el constructor de la implementación de la interfaz
			ciudadDAO.guardarCiudad(ciudad); //Consulto la lista de ciudades
			assertTrue(ciudad != null);//Verifico que la haya por lo menos una ciudad
		}catch (MyException e) {
			e.printStackTrace();//Mostrar más información si ocurre un error, se debería mostar en un logger
			fail(e.getMessage());//Ha ocurrido un error consultando las ciudades
			logger.log(Level.ERROR,"Error guardando: "+ e.getMessage());
		}
	}
	
	
}
