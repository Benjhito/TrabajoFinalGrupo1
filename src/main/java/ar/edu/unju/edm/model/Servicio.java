package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Component
@Entity
public class Servicio {
	// Atributos
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio;
    
    @NotBlank
    @Size(min = 0, max = 50)
    private String descripcion;
    
    @NotNull
    @Min(value = 0)
    private Float costo;
	
    @NotNull
    private Boolean estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico")
    private Medico medico;
    
    // Constructores
    public Servicio() {
		// TODO Auto-generated constructor stub
	}

	public Servicio(@Positive Integer id_servicio, @NotBlank @Size(min = 0, max = 50) String descripcion,
			@NotNull @Min(0) Float costo, @NotNull Boolean estado, Medico medico) {
		super();
		this.id_servicio = id_servicio;
		this.descripcion = descripcion;
		this.costo = costo;
		this.estado = estado;
		this.medico = medico;
	}

	// Getters y Setters
	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}