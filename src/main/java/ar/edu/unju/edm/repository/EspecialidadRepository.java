package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository <Especialidad, Integer> {
	// Lista de especialidades activas
	public List<Especialidad> findByEstado (Boolean estado);
	// Busqueda de una especialidad por su nombre
	public Especialidad findByNombre (String nombre);
}
