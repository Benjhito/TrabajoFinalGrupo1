package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository <Paciente, Integer> {
	// Lista de pacientes activos
	public List<Paciente> findByEstado (Boolean estado);
	// Busqueda de un paciente por su DNI
	public Paciente findByDni (Integer dni);
	// Busqueda de un paciente por su e-mail
	public Optional<Paciente> findByEmail (String email);
}