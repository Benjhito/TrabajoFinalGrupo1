package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Paciente_Servicio;

@Service
public interface Paciente_ServicioService {
	// CRUD
	public void cargarPaciente_Servicio(Paciente_Servicio nuevoPaciente_Servicio);
	public Paciente_Servicio mostrarPaciente_Servicio(Integer codigo);
	public ArrayList<Paciente_Servicio> listarPaciente_Servicios();
	public void modificarPaciente_Servicio(Paciente_Servicio paciente_servicio);
	public void eliminarPaciente_Servicio(Integer codigo);
}
