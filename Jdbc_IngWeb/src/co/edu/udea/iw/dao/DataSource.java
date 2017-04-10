package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/*
 * Para dar conexiones activas a la base de datos
 * brindar el objeto Connection a la BD
 * 
 * @author Raul Martinez Silgado
 * @version 1.1
 * 
 * */

public class DataSource {
	
	private static DataSource mDataSource;
	
	private DataSource(){}
	
	public static DataSource getInstanceDataSource(){
		if(mDataSource == null){
			mDataSource = new DataSource();
		}
		return mDataSource;
	}
	
	
	/* @return El objeto de conexión a la BD
	 * @throws Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	public Connection getConnection() throws MyException{
		Connection con = null; //Definimos el objeto 'con' para hacer la conexión a la BD
		try { 
			Class.forName("com.mysql.jdbc.Driver"); //Cargar la clase del Driver de la BD en el cardload
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingweb","root","root"); //Creamos(abrimos) la conexion a la BD con su Url, User y password
		}catch (ClassNotFoundException e) {//Puede que al cargar la clase del Driver no exista
			throw new MyException("Driver no en contrado", e);//Lanzamos en un nuevo hilo nuestra excepción
		}catch (SQLException e){
			throw new MyException("No se pudo establecar la conexión", e);//Lanzamos en un nuevo hilo nuestra excepción
		}	
		return con; //Retornamos la conexión	
	} 
}
