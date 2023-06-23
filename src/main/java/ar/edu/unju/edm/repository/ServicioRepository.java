package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository <Servicio, Integer> {
	
	public List<Servicio> findByEstado (Boolean estado);
	public Servicio findByDescripcion (String descripcion);
}
