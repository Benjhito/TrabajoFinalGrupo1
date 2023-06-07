package ar.edu.unju.edm.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Especialidad;

@Service
public interface EspecialidadService {
	public void cargarEspecialidad (Especialidad nuevoEspecialidad);
	public ArrayList<Especialidad> listarEspecialidades();
	public Especialidad mostrarUnaEspecialidad(Integer codigo);
	public Especialidad eliminarUnaEspecialidad(Integer codigo);
	public void eliminarTodasLasEspecialidades();
	public Especialidad modificarUnaEspecialidad(Integer codigo);
}
