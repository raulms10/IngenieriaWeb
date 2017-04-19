package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir los metodos que vamos a usar en el DAO
 * de la ciudad
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */


public interface CiudadDAO {
	
	/**
	 * Entrega todas las ciudades que existan en la BD ordenadas por nombre
	 * @return Lista de ciudades
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public List<Ciudad> obtenerCiudad() throws MyException;
	
	
	/** 
	 * Entrega la ciudad que existan en la BD con el codigo ingresado como parametro
	 * @return Ciudad
	 * @throws MyException 
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public Ciudad obtenerCiudad(Long codigo) throws MyException;
	
	
	/**
	 * Guarda una nueva ciudad en la BD 
	 * @param ciudad
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public void guardarCiudad(Ciudad ciudad) throws MyException;

}
