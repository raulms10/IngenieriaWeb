package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.ClienteJersey;
import co.edu.udea.iw.exception.MyException;

@Path("cliente")
@Component
public class ClienteWS {
	
	@Autowired
	ClienteBL clienteBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public void guardar(@QueryParam("cc")String cedula, 
			@QueryParam("nombres")String nombres, 
			@QueryParam("apellidos")String apellidos, 
			@QueryParam("correo")String email, 
			@QueryParam("user")String usuario) throws RemoteException{
		try{
			clienteBL.guardarCliente(cedula, nombres, apellidos, email, usuario);
		}catch (MyException e) {
			throw new RemoteException("Error creando usuario");
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteJersey> obtenerClientes() throws RemoteException{
		List<ClienteJersey> respuesta = new ArrayList<ClienteJersey>();
		try{
			for(Cliente cliente: clienteBL.obtenerClientes()){
				ClienteJersey clienteJersey = new ClienteJersey(cliente.getCedula(), cliente.getNombres(), cliente.getApellidos(), cliente.getEmail());
				
				respuesta.add(clienteJersey);
			}
		}catch (MyException e) {
			throw new RemoteException("Problema consultando");
		}
		return respuesta;
	}

}
