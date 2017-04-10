package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import co.edu.udea.spring.dto.Cliente;
import co.edu.udea.spring.exception.MyException;

/*
 * Para definir los metodos que vamos a usar en el DAO
 * de la Cliente
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * **/

public class ClienteDAOImpl implements ClienteDAO {
	
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** 
	 * @see co.edu.udea.spring.dao.ClienteDAO#obtener()
	 * @return List de clientes
	 */
	@Override
	public List<Cliente> obtener() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
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
	 * @see co.edu.udea.spring.dao.ClienteDAO#guardar(co.edu.udea.spring.dto.Cliente)
	 */
	@Override
	public void guardar(Cliente cliente) throws MyException {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(cliente);
		}catch (HibernateException e) {
			throw new MyException("Error guardando cliente", e);
		}
	}

}
