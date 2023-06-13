package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@Entity
public class Paciente {
	// Atributos
	@Id
	@Positive
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_paciente;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String nombres;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String apellidos;
	
	@NotBlank
	private Integer dni; 
	
	@Size(min = 0, max = 50)
	private String email;
	
	@Size(min = 0, max = 20)
	private String telefono;
	
	@NotNull
	private LocalDate fecha_nacimiento;
	
	@Size(min = 0, max = 100)
	private String domicilio;
	
	@NotNull
	private Boolean estado;
	
	// Consctructores
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente(@Positive Integer id_paciente, @NotBlank @Size(min = 1, max = 50) String nombres,
			@NotBlank @Size(min = 1, max = 50) String apellidos, @NotBlank Integer dni,
			@Size(min = 0, max = 50) String email, @Size(min = 0, max = 20) String telefono,
			@NotNull String fecha_nacimiento, @Size(min = 0, max = 100) String domicilio, @NotNull Boolean estado) {
		super();
		this.id_paciente = id_paciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
		this.domicilio = domicilio;
		this.estado = estado;
	}

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
}