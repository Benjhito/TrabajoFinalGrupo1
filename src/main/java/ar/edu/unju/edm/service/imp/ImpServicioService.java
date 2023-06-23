package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.ServicioService;
import ar.edu.unju.edm.repository.ServicioRepository;

@Service
@Qualifier("servicioServicio")
public class ImpServicioService implements ServicioService {
	@Autowired
	ServicioRepository servicioRepository;
	
	@Override
	public void cargarServicio(Servicio nuevoServicio) {
		nuevoServicio.setEstado(true);
		servicioRepository.save(nuevoServicio);
	}
	
	@Override
	public void eliminarServicio(Integer codigo) {
		Optional<Servicio> auxiliar = Optional.of(new Servicio());
		auxiliar = servicioRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		servicioRepository.save(auxiliar.get());
	}
	
	@Override
	public Servicio mostrarUnServicio(Integer codigo) {
		Optional<Servicio> auxiliar = Optional.of(new Servicio());
		auxiliar = servicioRepository.findById(codigo);
		return auxiliar.get();
	}
	
	@Override
	public ArrayList<Servicio> listarServicios() {
		return (ArrayList<Servicio>) servicioRepository.findByEstado(true);
	}
	
	@Override
	public void modificarUnServicio(Servicio servicio) {
		   Optional<Servicio> servicioExistente = servicioRepository.findById(servicio.getId_servicio());
		    if (servicioExistente.isPresent()) {
		        Servicio servicioActualizado = servicioExistente.get();
		        servicioActualizado.setDescripcion(servicio.getDescripcion());
		        servicioActualizado.setCosto(servicio.getCosto());
		        servicioActualizado.setEstado(servicio.getEstado());
		        servicioActualizado.setMedico(servicio.getMedico());
		        servicioRepository.save(servicioActualizado);
		    } else {
		        // TODO Handle Exception
		    }
	}

	@Override
	public boolean existeServicio(Servicio servicio) {
		Servicio servicioExistente = servicioRepository.findByDescripcion(servicio.getDescripcion());
		return servicioExistente != null;
	}
}