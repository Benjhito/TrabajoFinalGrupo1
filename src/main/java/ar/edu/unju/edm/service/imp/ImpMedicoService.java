package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.util.Medicos;

@Service
@Qualifier("servicioEnLista")
public class ImpMedicoService implements MedicoService {
	@Override
	public void cargarMedico(Medico nuevoMedico) {
		nuevoMedico.setEstado(true);
		Medicos.getListadoDeMedicos().add(nuevoMedico);
	}
	
	@Override
	public ArrayList<Medico> listarMedicos() {
		return Medicos.getListadoDeMedicos();
	}
	
	@Override
	public Medico mostrarUnMedico(Integer codigo) {
		return null;
	}
	
	@Override
	public void eliminarUnMedico(Integer codigo) {
		for(int i = 0; i < Medicos.getListadoDeMedicos().size(); i++) {
			if (Medicos.getListadoDeMedicos().get(i).getId_medicos() == codigo) {
				Medicos.getListadoDeMedicos().remove(i);
			}
		}
	}
	
	@Override
	public void eliminarTodosLosMedicos() {
		
	}
	
	@Override
	public Medico modificarUnMedico(Integer codigo) {
		return null;
	}
}
