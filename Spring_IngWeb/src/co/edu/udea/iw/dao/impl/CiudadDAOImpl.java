package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir los metodos que vamos a usar en el DAO
 * de la Ciudad
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * **/

public class CiudadDAOImpl implements CiudadDAO{
	
	//@Autowired
	SessionFactory sessionFact;


	public SessionFactory getSessionFact() {
		return sessionFact;
	}

	public void setSessionFact(SessionFactory sessionFact) {
		this.sessionFact = sessionFact;
	}
	
	/**
	 * Entrega todas las ciudades que existan en la BD ordenadas por nombre
	 * @return Lista de ciudades
	 * @see co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtenerCiudad()
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	@Override
	public List<Ciudad> obtenerCiudad() throws MyException {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try{
			//session = DataSource.getInstanceDataSource().getSession();
			session = sessionFact.getCurrentSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();
		}catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		}
		return lista;
	}

	/** 
	 * Entrega la ciudad que existan en la BD con el codigo ingresado como parametro
	 * @return Ciudad
	 * @see co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtenerCiudad(Long)
	 * @throws MyException 
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */	
	@Override
	public Ciudad obtenerCiudad(Long codigo) throws MyException {
		Ciudad ciudad = new Ciudad();
		Session session = null;
		try{
			//session = DataSource.getInstanceDataSource().getSession();
			session = sessionFact.getCurrentSession();
			//Forma 1 de consultar Ciudad
			/*Criteria criteria = session.createCriteria(Ciudad.class);
			criteria.add(Restrictions.eq("codigo", codigo));
			ciudad = (Ciudad) criteria.uniqueResult();*/
			//Forma alternativa
			ciudad = (Ciudad) session.get(Ciudad.class, codigo);			
		}catch (HibernateException e) {
			throw new MyException("Error consultando ciudad", e);
		}
		return ciudad;
	}
	
	/**
	 * Guarda una nueva ciudad en la BD 
	 * @param ciudad
	 * @see co.edu.udea.iw.dao.impl.CiudadDAOImpl#guardarCiudad(Ciudad)
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	@Override
	public void guardarCiudad(Ciudad ciudad) throws MyException {
		Session session = null;
		try{
			//session = DataSource.getInstanceDataSource().getSession();
			/* Obtenemos siempre la Sesión activa, de modo que no hay necesidad
			 * de cerrar Sesión porque Spring ya se encarga de eso
			 */
			session = sessionFact.getCurrentSession(); //
			session.save(ciudad);
		}catch (HibernateException e) {
			throw new MyException("Error guardando Ciudad", e);
		}
	}
}

