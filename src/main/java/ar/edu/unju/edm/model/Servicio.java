package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Component
@Entity
public class Servicio {
	// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio;
    private String consulta;
    private String descripcion;
	private Boolean estado;

	// Constructores
    public Servicio() {
		//TODO Auto-generated constructor stub
	}

	public Servicio(Integer codigo, String consulta, String descr, Boolean estado) {
		super();
		this.id_servicio = codigo;
		this.consulta = consulta;
		this.descripcion = descr;
		this.estado = estado;
	}

	// Getters y Setters
	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer codigo) {
		this.id_servicio = codigo;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
