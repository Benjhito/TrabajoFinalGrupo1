package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Component @Entity
public class Paciente {
	// Atributos
	@Id	@Positive @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_paciente;
	@NotBlank @Size(min = 1, max = 30)
	private String nombres;
	@NotBlank @Size(min = 1, max = 30)
	private String apellidos;
	@Size(min = 10, max = 50)
	private String clave;
	@NotBlank @Min(value = 10000000) @Max(value = 99999999)
	private Integer dni;
	@Size(min = 0, max = 50)
	private String obra_social;
	@Size(min = 0, max = 50) @Email
	private String email;
	@Size(min = 0, max = 20)
	private String telefono;
	private LocalDate fecha_nacimiento;
	@Size(min = 0, max = 50)
	private String domicilio;
	private String tipo_usuario;
	@NotNull
	private Boolean estado;
	
	// Constructores
	public Paciente() {}
	
	public Paciente(@Positive Integer id_paciente, @NotBlank @Size(min = 1, max = 30) String nombres,
			@NotBlank @Size(min = 1, max = 30) String apellidos, @Size(min = 10, max = 50) String clave,
			@NotBlank @Min(10000000) @Max(99999999) Integer dni, @Size(min = 0, max = 50) String obra_social,
			@Size(min = 0, max = 50) @Email String email, @Size(min = 0, max = 20) String telefono,
			String fecha_nacimiento, @Size(min = 0, max = 50) String domicilio, String tipo_usuario,
			@NotNull Boolean estado) {
		super();
		this.id_paciente = id_paciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.clave = clave;
		this.dni = dni;
		this.obra_social = obra_social;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
		this.domicilio = domicilio;
		this.tipo_usuario = tipo_usuario;
		this.estado = estado;
	}

	// Getters y Setters
	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
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
	
	public String getObra_social() {
		return obra_social;
	}

	public void setObra_social(String obra_social) {
		this.obra_social = obra_social;
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

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}