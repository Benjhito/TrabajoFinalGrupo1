package ar.edu.unju.edm.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Paciente_Servicio;

@Repository
public interface Paciente_ServicioRepository extends CrudRepository<Paciente_Servicio, Integer> {
	
	public List<Paciente_Servicio> findByEstado (Boolean estado);

	public Paciente_Servicio findByFecha (LocalDate fecha);
}
