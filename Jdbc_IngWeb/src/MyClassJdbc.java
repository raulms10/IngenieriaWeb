import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	/*
	 * @author Raul Martinez Silgado
	 * @version 1.0
	 * 
	 */

public class MyClassJdbc {
	/* Consulta la las ciudades existentes en la BD y las muestra en pantalla
	 * */
	public static void consultarCiudades(){
		Connection con = null; //Definimos el objeto 'con' para hacer la conexión a la BD
		PreparedStatement ps = null; //Definimos el objeto 'ps' para preparar la consulta a la BD 
		ResultSet rs = null; //Definimos el objeto 'rs' para almacenar los resultados de la consulta 'ps' en la BD
		try { 
			Class.forName("com.mysql.jdbc.Driver"); //Cargar la clase del Driver de la BD en el cardload
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingweb","root","root"); //Creamos(abrimos) la conexion a la BD con su Url, User y password
			ps = con.prepareStatement("select * from ciudades"); //Creamos la consulta que se hará a la BD
			rs = ps.executeQuery(); //Realizamos la consulta a la BD
			while(rs.next()){
				System.out.println(rs.getString("codigo")+ " : " + rs.getString("Nombre"));//Mostramos los resultados en consola
			}
		} catch (ClassNotFoundException e) {//Puede que al cargar la clase del Driver no exista
			e.printStackTrace();
		} catch (SQLException e) {//Puede que la BD no exista
			e.printStackTrace();
		}finally {
			try {
				rs.close(); //Cerramos el resultado de la consulta
				ps.close(); //Cerramos la consulta
				con.close(); //Cerramos la conexión a la BD
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		consultarCiudades();		
	}

}
