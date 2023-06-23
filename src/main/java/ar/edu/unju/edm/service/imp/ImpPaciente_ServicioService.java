package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.service.Paciente_ServicioService;
import ar.edu.unju.edm.repository.Paciente_ServicioRepository;

@Service @Qualifier("servicioPaciente_Servicio")
public class ImpPaciente_ServicioService implements Paciente_ServicioService {
	// Inyeccion de Dependencias
	@Autowired
	private Paciente_ServicioRepository paciente_servicioRepository;
	
	// CREATE
	@Override
	public void cargarPaciente_Servicio(Paciente_Servicio nuevoPaciente_Servicio) {
		nuevoPaciente_Servicio.setEstado(true);
		paciente_servicioRepository.save(nuevoPaciente_Servicio);
	}
	
	// READ 1
	@Override
	public Paciente_Servicio mostrarPaciente_Servicio(Integer codigo) {
		Optional<Paciente_Servicio> auxiliar = Optional.of(new Paciente_Servicio());
		auxiliar = paciente_servicioRepository.findById(codigo);
		
		return auxiliar.get();
	}
	
	// READ ALL
	@Override
	public ArrayList<Paciente_Servicio> listarPaciente_Servicio() {
		return (ArrayList<Paciente_Servicio>) paciente_servicioRepository.findByEstado(true);
	}
	
	// UPDATE
	public void modificarPaciente_Servicio(Paciente_Servicio paciente_servicio) {
		Optional<Paciente_Servicio> paciente_servicioExistente = paciente_servicioRepository.findById(paciente_servicio.getId_paciente_servicio());
		
		if (paciente_servicioExistente.isPresent()) {
			Paciente_Servicio paciente_servicioActualizado = paciente_servicioExistente.get();
			
			paciente_servicioActualizado.setPaciente(paciente_servicio.getPaciente());
			paciente_servicioActualizado.setServicio(paciente_servicio.getServicio());
			paciente_servicioActualizado.setFecha(paciente_servicio.getFecha());
			
			paciente_servicioRepository.save(paciente_servicioActualizado);
		}
	}
	
	// DELETE
	@Override
	public void eliminarPaciente_Servicio(Integer codigo) {
		Optional<Paciente_Servicio> auxiliar = Optional.of(new Paciente_Servicio());
		auxiliar = paciente_servicioRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		paciente_servicioRepository.save(auxiliar.get());
	}
}