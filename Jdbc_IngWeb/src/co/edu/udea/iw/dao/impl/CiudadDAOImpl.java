package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;


/*
 * Para definir los metodos que vamos a usar en el DAO
 * de la ciudad
 * 
 * @author Raul Martinez Silgado
 * @version 1.1
 * 
 * */

public class CiudadDAOImpl implements CiudadDAO {
	
	/* @return Lista de las ciudades que existan en la BD ordenadas por nombre
	 * @throws Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	@Override
	public List<Ciudad> obtenerCiudad() throws MyException {
		Connection conn = null; //Definimos el objeto 'con' para hacer la conexión a la BD
		PreparedStatement ps = null; //Definimos el objeto 'ps' para preparar la consulta a la BD 
		ResultSet rs = null; //Definimos el objeto 'rs' para almacenar los resultados de la consulta 'ps' en la BD
		List<Ciudad> lista = new ArrayList<Ciudad>(); //Definimos la lista de Ciudades
		DataSource data = null;//Inicializamos con null
		try{
			data = DataSource.getInstanceDataSource();//Obtenemos la instancia del DataSource
			conn = data.getConnection();////Creamos(abrimos) la conexion a la BD con la instancia del DataSource
			ps = conn.prepareStatement("select * from ciudades"); //Creamos la consulta que se hará a la BD
			rs = ps.executeQuery(); //Realizamos la consulta a la BD
			Ciudad ciudad = null; //Definimos el objeto que se añadirá a la lista de ciudades
			while(rs.next()){
				ciudad = new Ciudad(); //Inicializamos el objeto que se añadirá a la lista de ciudades
				ciudad.setCodigo(rs.getLong("codigo")); //Modificamos el codigo al objeto(ciudad) de cada ciudad 
				ciudad.setNombre(rs.getString("Nombre")); //Modificamos el nombre al objeto(ciudad) de cada ciudad
				ciudad.setCodigoArea(rs.getString("codigoArea")); //Modificamos el codigo de Area(ciudad) de cada ciudad 
				lista.add(ciudad); //Añadimos el objeto a la lista de ciudades
			}
			
		}catch (SQLException e) {
			throw new MyException("Error al consultar la lista de Ciudades", e);
		}finally { //Cerramos las conexiones y los objetos que utilizamos
			try{
				if(rs != null)//Verificamos que se haya inicializado el ResultSet
					rs.close();//Cerramos el ResultSet
				if(ps != null)//Verificamos que se haya inicializado el PreparedStatement
					ps.close();//Cerramos el PreparedStatement
				if(conn != null)//Verificamos que se haya inicializado el Connection
					conn.close();//Cerramos el Connect
			}catch (SQLException e) {
				throw new MyException("Error cerrando las conexiones", e);
			}
		}
		return lista; //Retornamos la lista de ciudades
	}
	
	
	/* @return la Ciudad que exista en la BD con el código pasado como parámetro
	 * @throws Lanzamos nuestra propia exception para manejarla en una capa superior
	 * */
	@Override
	public Ciudad obtenerCiudad(Long codigo) throws MyException {
		Connection conn = null; //Definimos el objeto 'con' para hacer la conexión a la BD
		PreparedStatement ps = null; //Definimos el objeto 'ps' para preparar la consulta a la BD 
		ResultSet rs = null; //Definimos el objeto 'rs' para almacenar los resultados de la consulta 'ps' en la BD
		Ciudad ciudad = null; //Definimos el objeto que alacenará la ciudad que se obtendrá en la consulta
		DataSource data = null;//Inicializamos con null
		try{
			data = DataSource.getInstanceDataSource();//Obtenemos la instancia del DataSource
			conn = data.getConnection();////Creamos(abrimos) la conexion a la BD
			ps = conn.prepareStatement("select * from ciudades where codigo = ?"); //Creamos la consulta que se hará a la BD
			ps.setLong(1, codigo); //Pasamos el parámetro del código a la consulta
			rs = ps.executeQuery(); //Realizamos la consulta a la BD
			if(rs.next()){//Comprobamos que haya alguna ciudad con en la BD
				ciudad = new Ciudad(); //Inicializamos el objeto ciudad que vamos a retornar
				ciudad.setCodigo(rs.getLong("codigo")); //Le modificamos el código
				ciudad.setNombre(rs.getString("nombre")); //Le modificamos el nombre 
				ciudad.setCodigoArea(rs.getString("codigoArea"));//Le modificamos el codigo de area
			}
		}catch (SQLException e) {
			throw new MyException("Error al consultar la lista de Ciudades", e);
		}finally { //Cerramos las conexiones y los objetos que utilizamos
			try{
				if(rs != null)//Verificamos que se haya inicializado el ResultSet
					rs.close();//Cerramos el ResultSet
				if(ps != null)//Verificamos que se haya inicializado el PreparedStatement
					ps.close();//Cerramos el PreparedStatement
				if(conn != null)//Verificamos que se haya inicializado el Connection
					conn.close();//Cerramos el Connect
			}catch (SQLException e) {
				throw new MyException("Error cerrando las conexiones", e);
			}
		}
		return ciudad;
	}

}
