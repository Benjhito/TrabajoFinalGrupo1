package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Medico;

@Service
public interface MedicoService {
	public void cargarMedico (Medico nuevoMedico);
	public ArrayList<Medico> listarMedicos();
	public Medico mostrarUnMedico(Integer codigo);
	public Medico eliminarUnMedico(Integer codigo);
	public void eliminarTodosLosMedicos();
	public Medico modificarUnMedico(Integer codigo);
}
