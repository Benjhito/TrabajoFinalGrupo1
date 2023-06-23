package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Servicio;

@Service
public interface ServicioService {
	// CRUD
	public void cargarServicio(Servicio nuevoServicio);
	public Servicio mostrarServicio(Integer codigo);
	public ArrayList<Servicio> listarServicios();
	public void modificarServicio(Servicio servicio);
	public void eliminarServicio(Integer codigo);
	
	public boolean existeServicio(Servicio servicio);
}