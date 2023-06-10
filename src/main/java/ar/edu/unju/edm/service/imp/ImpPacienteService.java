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
@Qualifier("servicioEnMySQL")
public class ImpPacienteService implements PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;
	
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
	public void eliminarTodosLosPacientes() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Paciente modificarUnPaciente(Integer codigo) {
		return null;
	}
}