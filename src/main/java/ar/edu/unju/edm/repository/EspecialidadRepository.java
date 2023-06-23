package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository <Especialidad, Integer> {
	

	public List<Especialidad> findByEstado (Boolean estado);
	public Especialidad findByNombre (String nombre);
}
