package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;

@Component
@Entity
public class Paciente_Servicio {
	// Atributos
	@Id
	@Positive
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pacienteservicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servicio")
	private Servicio servicio;
	
	@NotNull
	private LocalDate fecha;
	
	@NotNull
	private Boolean estado;
	
	// Constructores
	public Paciente_Servicio() {
		// TODO Auto-generated constructor stub
	}

	public Paciente_Servicio(@Positive Integer id_pacienteservicio, Paciente paciente, Servicio servicio,
			@NotNull String fecha, @NotNull Boolean estado) {
		super();
		this.id_pacienteservicio = id_pacienteservicio;
		this.paciente = paciente;
		this.servicio = servicio;
		this.fecha = LocalDate.parse(fecha);
		this.estado = estado;
	}

	public Integer getId_pacienteservicio() {
		return id_pacienteservicio;
	}

	public void setId_pacienteservicio(Integer id_pacienteservicio) {
		this.id_pacienteservicio = id_pacienteservicio;
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
