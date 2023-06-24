package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.EspecialidadService;
import ar.edu.unju.edm.repository.EspecialidadRepository;

@Service @Qualifier("servicioEspecialidad")
public class ImpEspecialidadService implements EspecialidadService {
	// Inyeccion de Dependencias
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	// CREATE
	@Override
	public void cargarEspecialidad(Especialidad nuevaEspecialidad) {
	    if (!existeEspecialidad(nuevaEspecialidad)) {
	        nuevaEspecialidad.setEstado(true);
	        especialidadRepository.save(nuevaEspecialidad);
	    }
	}
	
	// READ 1
	@Override
	public Especialidad mostrarEspecialidad(Integer codigo) {
		Optional<Especialidad> auxiliar = Optional.of(new Especialidad());
		auxiliar = especialidadRepository.findById(codigo);
		
		return auxiliar.get();
	}
	
	// READ ALL
	@Override
	public ArrayList<Especialidad> listarEspecialidades() {
		return (ArrayList<Especialidad>) especialidadRepository.findByEstado(true);
	}
	
	// UPDATE
	public void modificarEspecialidad(Especialidad especialidad) {
		Optional<Especialidad> especialidadExistente = especialidadRepository.findById(especialidad.getId_especialidad());
		
		if (especialidadExistente.isPresent()) {
			Especialidad especialidadActualizada = especialidadExistente.get();
			
			especialidadActualizada.setNombre(especialidad.getNombre());
			especialidadActualizada.setDescripcion(especialidad.getDescripcion());
	
			especialidadRepository.save(especialidadActualizada);
		}
	}
	
	// DELETE
	@Override
	public void eliminarEspecialidad(Integer codigo) {
		Optional<Especialidad> auxiliar = Optional.of(new Especialidad());
		auxiliar = especialidadRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		especialidadRepository.save(auxiliar.get());
	}
	
	// Busca una especialidad segun su nombre
	public boolean existeEspecialidad(Especialidad especialidad) {
		Especialidad especialidadExistente = especialidadRepository.findByNombre(especialidad.getNombre());
		
		return especialidadExistente != null;
	}
}