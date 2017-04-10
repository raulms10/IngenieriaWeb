package co.edu.udea.iw.dto;

public class Direccion {
	private DireccionId id;
	private String direccion;
	
	private String Telefono;
	private Ciudad ciudad;
	private Boolean preferida;
	public DireccionId getId() {
		return id;
	}
	public void setId(DireccionId id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Boolean getPreferida() {
		return preferida;
	}
	public void setPreferida(Boolean preferida) {
		this.preferida = preferida;
	}
	
	
}
