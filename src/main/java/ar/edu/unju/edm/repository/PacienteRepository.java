package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository <Paciente, Integer> {
	
	public List<Paciente> findByEstado (Boolean estado);
	
}