package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOImpl implements co.edu.udea.iw.dao.ClienteDAO {

	@Override
	public List<Cliente> obtenerClientes() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		try{
			session = DataSource.getInstanceDataSource().getSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			clientes = criteria.list();
		}catch (HibernateException e) {
			throw new MyException("Error consultando Clientes", e);
		}
		return clientes;
	}

	@Override
	public void guardarCliente(Cliente cliente) throws MyException {
		Transaction tx = null;
		Session session = null;
		try{
			session = DataSource.getInstanceDataSource().getSession();
			tx = session.beginTransaction();
			session.save(cliente);
			tx.commit();
		}catch (HibernateException e) {
			throw new MyException("Error guardando cliente", e);
		}
		
	}

}
