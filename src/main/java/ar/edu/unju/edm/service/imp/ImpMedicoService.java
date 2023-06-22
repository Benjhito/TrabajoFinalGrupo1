package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.repository.MedicoRepository;

@Service
@Qualifier("servicioMedico")
public class ImpMedicoService implements MedicoService {
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public void cargarMedico(Medico nuevoMedico) {
		nuevoMedico.setEstado(true);
		medicoRepository.save(nuevoMedico);
	}
	
	@Override
	public void eliminarMedico(Integer codigo) {
		Optional<Medico> auxiliar = Optional.of(new Medico());
		auxiliar = medicoRepository.findById(codigo);
		auxiliar.get().setEstado(false);
		medicoRepository.save(auxiliar.get());
	}
	
	@Override
	public Medico mostrarUnMedico(Integer codigo) {
		Optional<Medico> auxiliar = Optional.of(new Medico());
		auxiliar = medicoRepository.findById(codigo);
		return auxiliar.get();
	}
	
	@Override
	public ArrayList<Medico> listarMedicos() {
		return (ArrayList<Medico>) medicoRepository.findByEstado(true);
	}
	
	@Override
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
	        medicoActualizado.setEstado(medico.getEstado());
	        medicoActualizado.setEspecialidad(medico.getEspecialidad());
	        medicoRepository.save(medicoActualizado);
	    } else {
	        // TODO Handle Exception
	    }
	}
	
	@Override
	public boolean existeMedico(Medico medico) {
		Medico medicoExistente = medicoRepository.findByLegajo(medico.getLegajo());
		return medicoExistente != null;
	}
}
