package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Medico;

@Service
public interface MedicoService {
	public void cargarMedico(Medico nuevoMedico);
	public void eliminarMedico(Integer codigo);
	public Medico mostrarUnMedico(Integer codigo);
	public ArrayList<Medico> listarMedicos();
	public void modificarMedico(Medico medico);
	
	public boolean existeMedico(Medico medico);
}
