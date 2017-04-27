package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Para definir la lógica de negocio del Cliente
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */
@Transactional
public class ClienteBL {
	
	private ClienteDAO clienteDAO; //La inicialización de está variable la hace automáticamente Spring por medio del bean clienteBL
	private UsuarioDAO usuarioDAO; //La inicialización de está variable la hace automáticamente Spring por medio del bean clienteBL
	
	/**
	 * Creamos un nuevo Cliente con los datos enviados como parámetros para guardarlo en la base de datos
	 * @param cedula
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param usuarioCrea
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public void guardarCliente(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws MyException{
		
		if (cedula == null || "".equals(cedula)) { //Verificamos que la cédula no esté vacía
			throw new MyException("Error: La cedula no puede estar vacía");
		}
		if (nombres == null || "".equals(nombres)) { //Verificamos que el nombre no esté vacío
			throw new MyException("Error: El nombre no puede estar vacío");
		}
		if (apellidos == null || "".equals(apellidos)) { //Verificamos que los apellidos no estén vacíos
			throw new MyException("Error: El apellido no puede estar vacío");
		}
		if (email == null || "".equals(email)) { //Verificamos que el email no esté vacío
			throw new MyException("Error: El email no puede estar vacío");
		}
		if (usuarioCrea == null || "".equals(usuarioCrea)) { //Verificamos que el usuarioCrea no esté vacío
			throw new MyException("Error: El campo usuarioCrea no puede estar vacío");
		}
		
		Usuario usuario = getUsuarioDAO().obtenerUsuario(usuarioCrea); //Obtenemos los datos del UsuarioCrea de la BD 
		if(usuario == null){ //Verificamos que el usuario crea si exista en la BD
			throw new MyException("Error: El UsuarioCrea no existe, verifique");
		}
		
		Cliente cliente = new Cliente(); //Creamos el cliente
		//Editamos los datos del cliente
		cliente.setCedula(cedula); 
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
				
		getClienteDAO().guardarCliente(cliente); //Guardamos el Cliente en la BD con el método de la clase ClienteDAOImpl
	}
	
	/**
	 * Entrega todos los clientes que existan el la BD
	 * @return Lista de Clientes
	 * @throws MyException
	 * Lanzamos nuestra propia exception para manejarla en una capa superior
	 */
	public List<Cliente> obtenerClientes() throws MyException{
		return clienteDAO.obtenerClientes(); //Retornaoms la lista de Clientes con el método de la clase ClienteDAOImpl
	}
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
