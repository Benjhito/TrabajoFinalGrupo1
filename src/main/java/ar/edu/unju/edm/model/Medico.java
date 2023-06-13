package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Component
@Entity
public class Medico {
	// Atributos
	@Id
	@Positive
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_medico;
	
	@NotNull
	private Integer legajo;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String nombres;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String apellidos;
	
	@NotBlank
	@Size(min = 10, max = 50)
	private String clave;
	
	@NotNull
	private Integer dni;
	
	@Size(min = 0, max = 50) 
	private String email;
	
	@Size(min = 0, max = 20)
	private String telefono;
	
	@NotNull
	private LocalDate fecha_nacimiento;
	
	@NotNull
	private LocalDate fecha_ingreso;
	
	@Size(min = 0, max = 100)
	private String domicilio;
	
	@NotNull
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especialidad")
	private Especialidad especialidad;
	
	// Constructores
	public Medico() {
		// TODO Auto-generated constructor stub
	}
	
	public Medico(@Positive Integer id_medico, @NotNull Integer legajo,
			@NotBlank @Size(min = 1, max = 50) String nombres, @NotBlank @Size(min = 1, max = 50) String apellidos,
			@NotBlank @Size(min = 10, max = 50) String clave, @NotNull Integer dni,
			@Size(min = 0, max = 50) String email, @Size(min = 0, max = 20) String telefono,
			@NotNull String fecha_nacimiento, @NotNull String fecha_ingreso,
			@Size(min = 0, max = 100) String domicilio, @NotNull Boolean estado, Especialidad especialidad) {
		super();
		this.id_medico = id_medico;
		this.legajo = legajo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.clave = clave;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
		this.fecha_ingreso = LocalDate.parse(fecha_ingreso);
		this.domicilio = domicilio;
		this.estado = estado;
		this.especialidad = especialidad;
	}

	// Getters y Setters
	public Integer getId_medico() {
		return id_medico;
	}

	public void setId_medico(Integer id_medico) {
		this.id_medico = id_medico;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
	}

	public LocalDate getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = LocalDate.parse(fecha_ingreso);
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Especialidad getId_especialidad() {
		return especialidad;
	}

	public void setId_especialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
}
