package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
/*
 * Para definir los metodos que vamos a usar en el DAO
 * de la Usuario
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * **/
public class UsuarioDAOImpl implements UsuarioDAO{
	
	SessionFactory sessionFact;


	public SessionFactory getSessionFact() {
		return sessionFact;
	}

	public void setSessionFact(SessionFactory sessionFact) {
		this.sessionFact = sessionFact;
	}
	
	@Override
	public Usuario obtenerUsuario(String login) throws MyException {
		Usuario usuario = new Usuario();
		Session session = null;
		try{
			session = sessionFact.getCurrentSession();
			usuario = (Usuario) session.get(Usuario.class,login);
		}catch (HibernateException e) {
			throw new MyException("Error consultando usuario", e);
		}
		return usuario;
	}

}
