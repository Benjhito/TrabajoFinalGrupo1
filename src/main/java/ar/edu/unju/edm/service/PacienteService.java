package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Paciente;

@Service
public interface PacienteService {
	// CRUD
	public void cargarPaciente(Paciente nuevoPaciente);
	public Paciente mostrarPaciente(Integer codigo);
	public ArrayList<Paciente> listarPacientes();
	public void modificarPaciente(Paciente paciente);
	public void eliminarPaciente(Integer codigo);
	
	public boolean existePaciente(Paciente paciente);
}