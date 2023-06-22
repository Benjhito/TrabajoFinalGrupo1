package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Especialidad;

@Service
public interface EspecialidadService {
	// Prototipos
	public void cargarEspecialidad (Especialidad nuevoEspecialidad);
	public void eliminarEspecialidad(Integer codigo);
	public Especialidad mostrarUnaEspecialidad(Integer codigo);
	public ArrayList<Especialidad> listarEspecialidades();
	public void modificarUnaEspecialidad(Especialidad especialidad);

	public boolean existeEspecialidad(Especialidad especialidad);
}
