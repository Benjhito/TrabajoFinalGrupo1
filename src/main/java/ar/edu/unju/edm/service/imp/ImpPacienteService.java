package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.repository.PacienteRepository;

@Service
@Qualifier("servicioPaciente")
public class ImpPacienteService implements PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public void cargarPaciente(Paciente nuevoPaciente) {
		nuevoPaciente.setEstado(true);
		pacienteRepository.save(nuevoPaciente);
	}
	
	@Override
	public void eliminarPaciente(Integer codigo) {
		Optional<Paciente> auxiliar = Optional.of(new Paciente());
		auxiliar = pacienteRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		pacienteRepository.save(auxiliar.get());
	}
	
	@Override
	public Paciente mostrarUnPaciente(Integer codigo) {
		Optional<Paciente> auxiliar = Optional.of(new Paciente());
		auxiliar = pacienteRepository.findById(codigo);
		return auxiliar.get();
	}
	
	@Override
	public ArrayList<Paciente> listarPacientes() {
		return (ArrayList<Paciente>) pacienteRepository.findByEstado(true);
	}
	
	@Override
	public void modificarPaciente(Paciente paciente) {
	    Optional<Paciente> pacienteExistente = pacienteRepository.findById(paciente.getId_paciente());
	    if (pacienteExistente.isPresent()) {
	        Paciente pacienteActualizado = pacienteExistente.get();
	        pacienteActualizado.setNombres(paciente.getNombres());
	        pacienteActualizado.setApellidos(paciente.getApellidos());
	        pacienteActualizado.setDni(paciente.getDni());
	        pacienteActualizado.setEmail(paciente.getEmail());
	        pacienteActualizado.setTelefono(paciente.getTelefono());
	        pacienteActualizado.setFecha_nacimiento(paciente.getFecha_nacimiento());
	        pacienteActualizado.setDomicilio(paciente.getDomicilio());
	        pacienteActualizado.setEstado(paciente.getEstado());
	        pacienteRepository.save(pacienteActualizado);
	    } else {
	        // TODO Handle Exception
	    }
	}
}