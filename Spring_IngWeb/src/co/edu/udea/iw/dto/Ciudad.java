package co.edu.udea.iw.dto;

/** 
 * @author Raul Martinez Silgado
 * @version 1.0
 * 
 * */

public class Ciudad {
	private long codigo; 
	private String nombre;
	private String codigoArea; //código del area donde está ubicada la ciudad
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
}
