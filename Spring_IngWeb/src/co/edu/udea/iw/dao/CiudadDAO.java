package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir los metodos que vamos a usar en el DAO
 * de la ciudad
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */


public interface CiudadDAO {
	
	/* @return Lista de las ciudades que existan en la BD ordenadas por nombre
	 * @throws Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public List<Ciudad> obtenerCiudad() throws MyException;
	
	
	/* @return una ciudad que existan en la BD con el codigo ingresado como parametro
	 * @throws Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public Ciudad obtenerCiudad(Long codigo) throws MyException;
	
	
	public void guardarCiudad(Ciudad ciudad) throws MyException;

}
