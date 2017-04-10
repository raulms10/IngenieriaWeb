package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOImplTest {

	@Test
	public void testObtenerClientes() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		try{
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.obtenerClientes();
			for(Cliente c: resultado){
				System.out.println("Cliente: " + c.getNombres() +" Cedula: "+c.getCedula());
				Set<Direccion> dir = c.getDirecciones();
				for(Direccion d: dir){
					System.out.println("Nombre: "+ c.getNombres() + " Dirección: "+d.getDireccion());
				}
			}
			assertTrue(resultado.size() > 0);			
		}catch (MyException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void guardarCliente(){
		ClienteDAO clienteDAO = null; //Defino los objetos del tipo de la interfaz
		Cliente cliente = null; //Defino el objeto para almacenar el cliente
		Usuario usuario = null;
		//Editar datos del cliente
		/*
		.setCodigo(57L);
		ciudad.setCodigoArea("4q");
		ciudad.setNombre("Buena Nueva");
		*/
		try{
			cliente = new Cliente();
			cliente.setCedula("782");
			cliente.setNombres("Ana");
			cliente.setApellidos("Regino");
			cliente.setEmail("a@r.com");
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			
			clienteDAO = new ClienteDAOImpl(); //Y los inicializo con el constructor de la implementación de la interfaz
			clienteDAO.guardarCliente(cliente); //Consulto la lista de ciudades
			assertTrue(cliente != null);//Verifico que la haya por lo menos una ciudad
		}catch (MyException e) {
			e.printStackTrace();//Mostrar más información si ocurre un error, se debería mostar en un logger
			fail(e.getMessage());//Ha ocurrido un error consultando las ciudades
		}
	}

}
