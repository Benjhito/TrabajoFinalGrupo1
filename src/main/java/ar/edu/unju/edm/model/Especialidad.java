package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Component
@Entity
public class Especialidad {
	// Atributos
	@Id
	@Positive
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_especialidad;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private Integer nombre;
	
	@Size(min = 0, max = 100)
	private Integer descripcion;
	
	@NotNull
	private Boolean estado;
	
	// Constructores
	public Especialidad() {
		// TODO Auto-generated constructor stub
	}
	
	public Especialidad(@Positive Integer id_especialidad, @NotBlank @Size(min = 1, max = 50) Integer nombre,
			@Size(min = 0, max = 100) Integer descripcion, @NotNull Boolean estado) {
		super();
		this.id_especialidad = id_especialidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	// Getters y Setters
	public Integer getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Integer id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public Integer getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
