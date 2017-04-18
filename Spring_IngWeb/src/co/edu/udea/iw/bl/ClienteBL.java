package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/*
 * Para definir la lógica de negocio del Cliente
 * 
 * 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public class ClienteBL {
	
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	
	public void guardarCliente(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws MyException{
		
		if (cedula == null || "".equals(cedula)) {
			throw new MyException("Error: La cedula no puede estar vacía");
		}
		if (nombres == null || "".equals(nombres)) {
			throw new MyException("Error: El nombre no puede estar vacío");
		}
		if (apellidos == null || "".equals(apellidos)) {
			throw new MyException("Error: El apellido no puede estar vacío");
		}
		if (email == null || "".equals(email)) {
			throw new MyException("Error: El email no puede estar vacío");
		}
		if (usuarioCrea == null || "".equals(usuarioCrea)) {
			throw new MyException("Error: El campo usuarioCrea no puede estar vacío");
		}
		
		Usuario usuario = getUsuarioDAO().obtenerUsuario(usuarioCrea);
		if(usuario == null){
			throw new MyException("Error: El UsuarioCrea no existe, verifique");
		}
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		getClienteDAO().guardarCliente(cliente);		
		
	}
	
	public List<Cliente> obtener() throws MyException{
		return clienteDAO.obtenerClientes();
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
