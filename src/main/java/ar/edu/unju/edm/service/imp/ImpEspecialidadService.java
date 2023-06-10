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
@Qualifier("servicioEnMySQL")
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
	public void eliminarTodasLasEspecialidades() {
		// TODO Auto-generated method stub
	}

	@Override
	public Especialidad modificarUnaEspecialidad(Integer codigo) {
		return null;
	}
}
