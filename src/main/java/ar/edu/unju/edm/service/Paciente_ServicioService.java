package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Paciente_Servicio;

@Service
public interface Paciente_ServicioService {
	// Prototipos
	public void cargarPaciente_Servicio(Paciente_Servicio nuevoPaciente_Servicio);
	public void eliminarPaciente_Servicio(Integer codigo);
	public Paciente_Servicio mostrarPaciente_Servicio(Integer codigo);
	public ArrayList<Paciente_Servicio> listarRegistros();
	public void eliminarTodosLosRegistros();
	public Paciente_Servicio modificarPaciente_Servicio(Integer codigo);
}
