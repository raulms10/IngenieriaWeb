package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir los metodos que vamos a usar en el DAO
 * de los Clientes
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public interface ClienteDAO {
	
	/**
	 * Entrega todos los clientes que existan en la BD ordenados por su fecha de creacion
	 * @return Lista de Clientes
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public List<Cliente> obtenerClientes() throws MyException;
	
	
	/**
	 * Guarda el cliente en la base de datos
	 * @param cliente
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public void guardarCliente(Cliente cliente) throws MyException;
}
