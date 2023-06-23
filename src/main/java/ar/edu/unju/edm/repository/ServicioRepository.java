package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository <Servicio, Integer> {
	// Lista de servicios activos
	public List<Servicio> findByEstado (Boolean estado);
	// Busqueda de un servicio por su descripcion
	public Servicio findByDescripcion (String descripcion);
}
