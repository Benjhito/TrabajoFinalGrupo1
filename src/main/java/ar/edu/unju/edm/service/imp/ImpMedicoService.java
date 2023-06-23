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
	MedicoRepository medicoRepository;
	
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
	public void eliminarTodosLosMedicos() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Medico modificarUnMedico(Integer codigo) {
		return null;
	}
}
