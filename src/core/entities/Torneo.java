package core.entities;

import java.util.List;

public class Torneo {

	private int id;
	private String nombre;
	private List<Equipo> equipos;
	
	public Torneo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Torneo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	
}
