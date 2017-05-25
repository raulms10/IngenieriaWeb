package co.edu.udea.iw.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir los metodos que vamos a usar en el DAO
 * del Cliente
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * **/
public class ClienteDAOImpl implements ClienteDAO {
	
	SessionFactory sessionFact;

	public SessionFactory getSessionFact() {
		return sessionFact;
	}

	public void setSessionFact(SessionFactory sessionFact) {
		this.sessionFact = sessionFact;
	}

	/**
	 * Entrega todos los clientes que existan en la BD ordenados por su fecha de creacion
	 * @return Lista de Clientes
	 * @see co.edu.udea.iw.dao.impl.ClienteDAOImpl#obtenerClientes()
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	@Override
	public List<Cliente> obtenerClientes() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		try{
			session = sessionFact.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			//SELECT * Clientes Order by FechaCreacion asc
			clientes = criteria.list();
		}catch (HibernateException e) {
			throw new MyException("Error consultando cliente", e);
		}
		return clientes;
	}

	/**
	 * Guarda el cliente en la base de datos
	 * @param cliente
	 * @see co.edu.udea.iw.dao.impl.ClienteDAOImpl#guardarCliente(Cliente)
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	@Override
	public void guardarCliente(Cliente cliente) throws MyException {
		Session session = null;
		try{
			session = sessionFact.getCurrentSession();
			session.save(cliente);			
		}catch (HibernateException e) {
			throw new MyException("Error guardando cliente", e);
		}
	}

}
