package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.ServicioService;
import ar.edu.unju.edm.repository.ServicioRepository;

@Service @Qualifier("servicioServicio")
public class ImpServicioService implements ServicioService {
	// Inyeccion de Dependencias
	@Autowired
	private ServicioRepository servicioRepository;
	
	// CREATE
	@Override
	public void cargarServicio(Servicio nuevoServicio) {
		nuevoServicio.setEstado(true);
		servicioRepository.save(nuevoServicio);
	}
	
	// READ 1
	@Override
	public Servicio mostrarServicio(Integer codigo) {
		Optional<Servicio> auxiliar = Optional.of(new Servicio());
		auxiliar = servicioRepository.findById(codigo);
		
		return auxiliar.get();
	}
	
	// READ ALL
	@Override
	public ArrayList<Servicio> listarServicios() {
		return (ArrayList<Servicio>) servicioRepository.findByEstado(true);
	}
	
	// UPDATE
	public void modificarServicio(Servicio servicio) {
		Optional<Servicio> servicioExistente = servicioRepository.findById(servicio.getId_servicio());
		
		if (servicioExistente.isPresent()) {
			Servicio servicioActualizado = servicioExistente.get();
			
			servicioActualizado.setDescripcion(servicio.getDescripcion());
			servicioActualizado.setCosto(servicio.getCosto());
			servicioActualizado.setMedico(servicio.getMedico());
			
			servicioRepository.save(servicioActualizado);
		}
	}
	
	// DELETE
	@Override
	public void eliminarServicio(Integer codigo) {
		Optional<Servicio> auxiliar = Optional.of(new Servicio());
		auxiliar = servicioRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		servicioRepository.save(auxiliar.get());
	}
	
	// Busca un servicio segun su descripcion
	public boolean existeServicio(Servicio servicio) {
		Servicio servicioExistente = servicioRepository.findByDescripcion(servicio.getDescripcion());
		
		return servicioExistente != null;
	}
}
