package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Paciente;

@Service
public interface PacienteService {
	public void cargarPaciente(Paciente nuevoPaciente);
	public void eliminarPaciente(Integer codigo);
	public Paciente mostrarUnPaciente(Integer codigo);
	public ArrayList<Paciente> listarPacientes();
	public void modificarPaciente(Paciente paciente);
	
	public boolean existePaciente(Paciente paciente);
}