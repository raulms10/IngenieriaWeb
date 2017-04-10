package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir los metodos que vamos a usar en el DAO
 * de la Ciudad

 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */


public interface CiudadDAO {
	
	/* @return Lista de Ciudades 
	 * Entrega la lista de Ciudades que existan en la BD ordenadas por nombre
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public List<Ciudad> obtenerCiudad() throws MyException;
	
	
	/* @return Una Ciudad
	 * Entrega una Ciudad que existan en la BD con el codigo ingresado como parámetro
	 * @throws MyException 
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public Ciudad obtenerCiudad(Long codigo) throws MyException;
	
	
	/* Guarda la Ciudad ingresada como parámetro en la BD
	 * @throws MyException 
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public void guardarCiudad(Ciudad ciudad) throws MyException;

}
