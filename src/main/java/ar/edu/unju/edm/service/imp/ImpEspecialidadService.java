package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.service.EspecialidadService;
import ar.edu.unju.edm.repository.EspecialidadRepository;

@Service
@Qualifier("servicioEspecialidad")
public class ImpEspecialidadService implements EspecialidadService{
	@Autowired
	EspecialidadRepository especialidadRepository;
	
	@Override
	public void cargarEspecialidad(Especialidad nuevaEspecialidad) {
		nuevaEspecialidad.setEstado(true);
		especialidadRepository.save(nuevaEspecialidad);
	}
	
	@Override
	public void eliminarEspecialidad(Integer codigo) {
		Optional<Especialidad> auxiliar = Optional.of(new Especialidad());
		auxiliar = especialidadRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		especialidadRepository.save(auxiliar.get());
	}
	
	@Override
	public Especialidad mostrarUnaEspecialidad(Integer codigo) {
		Optional<Especialidad> auxiliar = Optional.of(new Especialidad());
		auxiliar = especialidadRepository.findById(codigo);
		return auxiliar.get();
	}
	
	@Override
	public ArrayList<Especialidad> listarEspecialidades() {
		return (ArrayList<Especialidad>) especialidadRepository.findByEstado(true);
	}
	
	@Override
	public void modificarUnaEspecialidad(Especialidad especialidad) {
		  Optional<Especialidad> especialidadExistente = especialidadRepository.findById(especialidad.getId_especialidad());
		    if (especialidadExistente.isPresent()) {
		        Especialidad especialidadActualizado = especialidadExistente.get();
		        especialidadActualizado.setNombre(especialidad.getNombre());
		        especialidadActualizado.setDescripcion(especialidad.getDescripcion());
		        especialidadActualizado.setEstado(especialidad.getEstado());
		        especialidadRepository.save(especialidadActualizado);
		    } else {
		        // TODO Handle Exception
		    }
	}
	
	@Override
	public boolean existeEspecialidad(Especialidad especialidad) {
		Especialidad especialidadExistente = especialidadRepository.findByNombre(especialidad.getNombre());
		return especialidadExistente != null;
	}
}
