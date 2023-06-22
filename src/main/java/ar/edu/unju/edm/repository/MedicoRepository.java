package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Medico;

@Repository
public interface MedicoRepository extends CrudRepository <Medico, Integer> {
	
	public List<Medico> findByEstado (Boolean estado);
	public Medico findByLegajo (Integer legajo);
	
}
