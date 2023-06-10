package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Component
@Entity
public class Medico {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_medico;
	private Integer legajo;
	private String nombres;
	private String apellidos;
	private Integer dni;
	private String email;
	private String telefono;
	private LocalDate fecha_nacimiento;
	private LocalDate fecha_ingreso;
	private String domicilio;
	private Boolean estado;
	private Integer id_especialidad;
	
	// Constructores
	public Medico() {
		// TODO Auto-generated constructor stub
	}

	public Medico(Integer id_medico, Integer legajo, String nombres, String apellidos, Integer dni, String email, String telefono,
			String fecha_nacimiento, String fecha_ingreso, String domicilio, Boolean estado,
			Integer id_especialidad) {
		super();
		this.id_medico = id_medico;
		this.legajo = legajo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
		this.fecha_ingreso = LocalDate.parse(fecha_ingreso);
		this.domicilio = domicilio;
		this.estado = estado;
		this.id_especialidad = id_especialidad;
	}

	// Getters y Setters
	public Integer getId_medico() {
		return id_medico;
	}

	public void setId_medico(Integer id_medicos) {
		this.id_medico = id_medicos;
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

	public Integer getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Integer id_especialidad) {
		this.id_especialidad = id_especialidad;
	}
}
