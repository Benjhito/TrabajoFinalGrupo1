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
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Email;

@Component
@Entity
public class Medico {
	// Atributos
	@Id
	@Positive
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_medico;
	
	@NotBlank
	@Size(min = 1, max = 30)
	private String nombres;
	
	@NotBlank
	@Size(min = 1, max = 30)
	private String apellidos;
	
	@NotBlank
	@Size(min = 10, max = 50)
	private String clave;
	
	@NotNull
	@Min(value = 10000000)
	@Max(value = 99999999)
	private Integer dni;

	@NotNull
	@Min(value = 1)
	@Max(value = 9999)
	private Integer legajo;
	
	@Size(min = 0, max = 50)
	@Email
	private String email;
	
	@Size(min = 0, max = 20)
	private String telefono;
	
	@NotNull
	private LocalDate fecha_nacimiento;
	
	@NotNull
	private LocalDate fecha_ingreso;
	
	@Size(min = 0, max = 50)
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
	
	public Medico(@Positive Integer id_medico, @NotBlank @Size(min = 1, max = 30) String nombres,
			@NotBlank @Size(min = 1, max = 30) String apellidos, @NotBlank @Size(min = 10, max = 50) String clave,
			@NotNull @Min(10000000) @Max(99999999) Integer dni, @NotNull @Min(1) @Max(9999) Integer legajo,
			@Size(min = 0, max = 50) @Email String email, @Size(min = 0, max = 20) String telefono,
			@NotNull String fecha_nacimiento, @NotNull String fecha_ingreso,
			@Size(min = 0, max = 50) String domicilio, @NotNull Boolean estado, Especialidad especialidad) {
		super();
		this.id_medico = id_medico;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.clave = clave;
		this.dni = dni;
		this.legajo = legajo;
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

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
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
	
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public LocalDate getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = LocalDate.parse(fecha_ingreso);
	}
	
	public void setFecha_ingreso(LocalDate fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
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

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}	
}