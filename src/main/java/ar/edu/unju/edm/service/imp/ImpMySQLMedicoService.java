package ar.edu.unju.edm.service.imp;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.repository.MedicoRepository;
import ar.edu.unju.edm.service.MedicoService;

@Service
@Qualifier("servicioEnMySQL")
public class ImpMySQLMedicoService implements MedicoService {
	@Autowired
	MedicoRepository medicoRepository;
	
	private static final Log GRUPO1 = LogFactory.getLog(ImpMySQLMedicoService.class);
	
	@Override
	public void cargarMedico(Medico nuevoMedico ) {
		nuevoMedico.setEstado(true);
		medicoRepository.save(nuevoMedico);
	}
	
	@Override
	public ArrayList<Medico> listarMedicos() {
		return (ArrayList<Medico>) medicoRepository.findByEstado(true);
	}
	
	@Override
	public Medico mostrarUnMedico(Integer codigo) {
		Optional<Medico> auxiliar = Optional.of(new Medico());
		auxiliar = medicoRepository.findById(codigo);
		return auxiliar.get();
	}
	
	@Override
	public void eliminarTodosLosMedicos() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Medico modificarUnMedico(Integer codigo) {
		return null;
	}
	
	@Override
	public void eliminarUnMedico(Integer codigo) {
		Optional<Medico> auxiliar = Optional.of(new Medico());
		auxiliar = medicoRepository.findById(unCodigo);
		auxiliar.get().setEstado(false);
		medicoRepository.save(auxiliar.get());
	}
}
