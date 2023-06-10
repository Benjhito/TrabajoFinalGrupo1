package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Component
@Entity
public class Especialidad {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_especialidad;
	private Boolean estado;
	private int nombre;
	private int descripcion;
	
	// Constructores
	public Especialidad() {
		// TODO Auto-generated constructor stub
	} 
	 
	public Especialidad(Integer id_especialidad, Boolean estado, int nombre, int descripcion) {
		super();
		this.id_especialidad = id_especialidad;
		this.estado = estado;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	// Getters y Setters
	public Integer getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Integer id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
}
