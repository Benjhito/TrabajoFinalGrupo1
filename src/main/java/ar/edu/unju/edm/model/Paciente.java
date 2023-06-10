/*Nota: El constructor y los getters reciben la fecha como String y la transforman a LocalDate.*/
package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Component
@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pacientes;
	private Integer legajo;
	private String nombres;
	private String apellidos;
	private Integer dni; 
	private String email;
	private String telefono;
	private LocalDate fecha_nacimiento;
	private String domicilio;
	private Boolean estado;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente(Integer id_pacientes, Integer legajo, String nombres, String apellidos, Integer dni, String email, String telefono,
			String fecha_nacimiento, String domicilio, Boolean estado) {
		super();
		this.id_pacientes = id_pacientes;
		this.legajo = legajo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
		this.domicilio = domicilio;
		this.estado = estado;
	}

	public Integer getId_pacientes() {
		return id_pacientes;
	}

	public void setId_pacientes(Integer id_pacientes) {
		this.id_pacientes = id_pacientes;
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