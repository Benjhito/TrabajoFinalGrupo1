package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Especialidad;

@Service
public interface EspecialidadService {
	// CRUD
	public void cargarEspecialidad(Especialidad nuevaEspecialidad);
	public Especialidad mostrarEspecialidad(Integer codigo);
	public ArrayList<Especialidad> listarEspecialidades();
	public void modificarEspecialidad(Especialidad especialidad);
	public void eliminarEspecialidad(Integer codigo);
	
	public boolean existeEspecialidad(Especialidad especialidad);
}