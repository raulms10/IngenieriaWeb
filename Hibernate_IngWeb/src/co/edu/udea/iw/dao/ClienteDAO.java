package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir los metodos que vamos a usar en el DAO
 * de los Clientes
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */


public interface ClienteDAO {
	/* @return Lista de Clientes
	 * Entrega la lista de Clientes que existan en la BD ordenadas por su fecha de creación
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public List<Cliente> obtenerClientes() throws MyException;
	
	
	/* Guarda el Cliente ingresado como parámetro en la BD
	 * @throws MyException 
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public void guardarCliente(Cliente cliente) throws MyException;
}
