package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.repository.MedicoRepository;

@Service @Qualifier("servicioMedico")
public class ImpMedicoService implements MedicoService {
	// Inyeccion de Dependencias
	@Autowired
	private MedicoRepository medicoRepository;
	
	// CREATE
	@Override
	public void cargarMedico(Medico nuevoMedico) {
		nuevoMedico.setEstado(true);
		medicoRepository.save(nuevoMedico);
	}
	
	// READ 1
	@Override
	public Medico mostrarMedico(Integer codigo) {
		Optional<Medico> auxiliar = Optional.of(new Medico());
		auxiliar = medicoRepository.findById(codigo);
		
		return auxiliar.get();
	}
	
	// READ ALL
	@Override
	public ArrayList<Medico> listarMedicos() {
		return (ArrayList<Medico>) medicoRepository.findByEstado(true);
	}
	
	// UPDATE
	public void modificarMedico(Medico medico) {
		Optional<Medico> medicoExistente = medicoRepository.findById(medico.getId_medico());
		
		if (medicoExistente.isPresent()) {
			Medico medicoActualizado = medicoExistente.get();
			
			medicoActualizado.setNombres(medico.getNombres());
			medicoActualizado.setApellidos(medico.getApellidos());
			medicoActualizado.setDni(medico.getDni());
			medicoActualizado.setLegajo(medico.getLegajo());
			medicoActualizado.setEmail(medico.getEmail());
			medicoActualizado.setTelefono(medico.getTelefono());
			medicoActualizado.setFecha_nacimiento(medico.getFecha_nacimiento());
			medicoActualizado.setFecha_ingreso(medico.getFecha_ingreso());
			medicoActualizado.setDomicilio(medico.getDomicilio());
			medicoActualizado.setEspecialidad(medico.getEspecialidad());
			
			medicoRepository.save(medicoActualizado);
		}
	}
	
	// DELETE
	@Override
	public void eliminarMedico(Integer codigo) {
		Optional<Medico> auxiliar = Optional.of(new Medico());
		auxiliar = medicoRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		medicoRepository.save(auxiliar.get());
	}
	
	// Busca un medico segun su DNI
	public boolean existeMedico(Medico medico) {
		Medico medicoExistente = medicoRepository.findByLegajo(medico.getLegajo());
		
		return medicoExistente != null;
	}
}
