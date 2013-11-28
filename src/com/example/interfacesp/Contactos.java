//Contactos
//as
package com.example.interfacesp;
public class Contactos {

	private int id;
	private String nombre;
	private int telefono;
	private String email;
	
	
	
	public Contactos(int id, String nombre, int telefono, String email) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	
	public String getNOMBRE() {
		return nombre;
	}
	public void setNOMBRE(String nombre) {
		this.nombre = nombre;
	}
	
	
	public int getTELEFONO() {
		return telefono;
	}
	public void setTELEFONO(int telefono) {
		this.telefono = telefono;
	}
	
	
	public String getEMAIL() {
		return email;
	}
	public void setEMAIL(String email) {
		this.email = email;
	}
}
