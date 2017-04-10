package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

public class DataSource {
	
	/*
	 * Para dar sesiones activas a la base de datos
	 * brindar el objeto Connection a la BD
	 * 
	 * @author Raul Martinez Silgado
	 * @version 1.0
	 * 
	 * */
	
	private static DataSource mDataSource; //Instancia de la clase para implementar el patrón Singleton
	private SessionFactory factory = null; //Para manejar la Session a la base de datos(abrirla)
	private Configuration conf = new Configuration(); //Para leer el archivo de configuraciones de Hibernate
	
	//Constructor requerido para implementar el patrón Singleton
	private DataSource(){}
	
	//Implementación del Patrón Singleton
	public static DataSource getInstanceDataSource(){
		if(mDataSource == null){
			mDataSource = new DataSource();
		}
		return mDataSource;
	}
	

	/* @return Session a la BD
	 * Entrega una Session activa a la base datos construida con el SessionFactory
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public Session getSession() throws MyException{
		try{
			if(factory==null){
				conf.configure("co/edu/udea/iw/hibernate.cfg.xml"); //Leemos el archivo de configuración
				factory = conf.buildSessionFactory(); //Inicializamos el SessionFactory
			}
			return factory.openSession(); //Abrimos la Session a la BD
		}catch (HibernateException e) {
			throw new MyException("Error configurando la session", e);
		}
		
	}

}
