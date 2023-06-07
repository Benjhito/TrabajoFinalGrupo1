package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.util.Medicos;

@Service
public class ImpMedicoService implements MedicoService {
	@Override
	public void cargarMedico(Medico nuevoMedico) {
		
	}
	
	@Override
	public ArrayList<Medico> listarMedicos() {
		return null;
	}
	
	@Override
	public Medico mostrarUnMedico(Integer codigo) {
		return null;
	}
	
	@Override
	public Medico eliminarUnMedico(Integer codigo) {
		return null;
	}
	
	@Override
	public void eliminarTodosLosMedicos() {
		
	}
	
	@Override
	public Medico modificarUnMedico(Integer codigo) {
		return null;
	}
}
