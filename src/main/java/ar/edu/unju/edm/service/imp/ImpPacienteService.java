package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.repository.PacienteRepository;

@Service @Qualifier("servicioPaciente")
public class ImpPacienteService implements PacienteService {
	// Inyeccion de Dependencias
	@Autowired
	private PacienteRepository pacienteRepository;
	
	// CREATE
	@Override
	public void cargarPaciente(Paciente nuevoPaciente) {
		nuevoPaciente.setEstado(true);
		nuevoPaciente.setTipo_usuario("ADMIN");
		
		String pw = nuevoPaciente.getClave();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		nuevoPaciente.setClave(encoder.encode(pw));

		pacienteRepository.save(nuevoPaciente);
	}
	
	// READ 1
	@Override
	public Paciente mostrarPaciente(Integer codigo) {
		Optional<Paciente> auxiliar = Optional.of(new Paciente());
		auxiliar = pacienteRepository.findById(codigo);
		
		return auxiliar.get();
	}
	
	// READ ALL
	@Override
	public ArrayList<Paciente> listarPacientes() {
		return (ArrayList<Paciente>) pacienteRepository.findByEstado(true);
	}
	
	// UPDATE
	public void modificarPaciente(Paciente paciente) {
		Optional<Paciente> pacienteExistente = pacienteRepository.findById(paciente.getId_paciente());
		
		if (pacienteExistente.isPresent()) {
			Paciente pacienteActualizado = pacienteExistente.get();
			
			pacienteActualizado.setNombres(paciente.getNombres());
			pacienteActualizado.setApellidos(paciente.getApellidos());
			pacienteActualizado.setDni(paciente.getDni());
			pacienteActualizado.setEmail(paciente.getEmail());
			pacienteActualizado.setTelefono(paciente.getTelefono());
			pacienteActualizado.setFecha_nacimiento(paciente.getFecha_nacimiento().toString());
			pacienteActualizado.setDomicilio(paciente.getDomicilio());
			
			pacienteRepository.save(pacienteActualizado);
		}
	}
	
	// DELETE
	@Override
	public void eliminarPaciente(Integer codigo) {
		Optional<Paciente> auxiliar = Optional.of(new Paciente());
		auxiliar = pacienteRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		pacienteRepository.save(auxiliar.get());
	}
	
	// Busca un paciente segun su DNI
	public boolean existePaciente(Paciente paciente) {
		Paciente pacienteExistente = pacienteRepository.findByDni(paciente.getDni());
		
		return pacienteExistente != null;
	}
}