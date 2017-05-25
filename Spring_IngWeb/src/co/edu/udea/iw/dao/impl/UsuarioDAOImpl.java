package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir los metodos que vamos a usar en el DAO
 * de Usuario
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
	
	/**
	 * Entrega el Usuario identificado con login ingresado como parámetro
	 * @param login
	 * @return Usuario
	 * @see co.edu.udea.iw.dao.impl.UsuarioDAOImpl#obtenerUsuario(String)
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	@Override
	public Usuario obtenerUsuario(String login) throws MyException {
		Usuario usuario = new Usuario();
		Session session = null;
		try{
			session = sessionFact.getCurrentSession();
			usuario = (Usuario) session.get(Usuario.class,login);
		}catch (HibernateException e) {
			System.out.println("Error: "+e.getMessage());
			throw new MyException("Error consultando usuario"+e.getMessage(), e);
			
		}
		return usuario;
	}

}
