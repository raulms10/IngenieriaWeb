package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
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

public class CiudadDAOImpl implements CiudadDAO{

	@Override
	public List<Ciudad> obtenerCiudad() throws MyException {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try{
			session = DataSource.getInstanceDataSource().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();
		}catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		}
		return lista;
	}

	@Override
	public Ciudad obtenerCiudad(Long codigo) throws MyException {
		Ciudad ciudad = new Ciudad();
		Session session = null;
		try{
			session = DataSource.getInstanceDataSource().getSession();
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

	@Override
	public void guardarCiudad(Ciudad ciudad) throws MyException {
		Transaction tx = null;
		Session session = null;
		try{
			session = DataSource.getInstanceDataSource().getSession();
			tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
		}catch (HibernateException e) {
			throw new MyException("Error guardando Ciudad", e);
		}
	}
}

