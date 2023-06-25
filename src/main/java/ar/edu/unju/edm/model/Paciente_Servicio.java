package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Component @Entity
public class Paciente_Servicio {
	// Atributos
	@Id @Positive @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_paciente_servicio;
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_paciente")
	private Paciente paciente;	
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_servicio")
	private Servicio servicio;	
	@NotNull
	private LocalDate fecha;
	@NotNull
	private Boolean estado;
	
	// Constructores
	public Paciente_Servicio() {}

	public Paciente_Servicio(@Positive Integer id_paciente_servicio, Paciente paciente, Servicio servicio,
			@NotNull String fecha, @NotNull Boolean estado) {
		super();
		this.id_paciente_servicio = id_paciente_servicio;
		this.paciente = paciente;
		this.servicio = servicio;
		this.fecha = LocalDate.parse(fecha);
		this.estado = estado;
	}

	// Getters y Setters
	public Integer getId_paciente_servicio() {
		return id_paciente_servicio;
	}

	public void setId_paciente_servicio(Integer id_paciente_servicio) {
		this.id_paciente_servicio = id_paciente_servicio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = LocalDate.parse(fecha);
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}