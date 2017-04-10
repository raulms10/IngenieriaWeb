package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public Usuario obtenerUsuario(String login) throws MyException {
		Usuario usuario = new Usuario();
		Session session = null;
		try{
			session = DataSource.getInstanceDataSource().getSession();
			//Forma 1 de consultar Ciudad
			/*Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("login", login));
			usuario = (Usuario) criteria.uniqueResult();*/
			//Forma alternativa
			usuario = (Usuario) session.get(Usuario.class, login);			
		}catch (HibernateException e) {
			throw new MyException("Error consultando Usuario con su clave primaria", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		return usuario;
	}

}
