package ar.edu.unju.edm.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Servicio;

@Service
public interface ServicioService {
	// Prototipos
	public void cargarServicio(Servicio nuevoServicio);
	public void eliminarServicio(Integer codigo);
	public Servicio mostrarUnServicio(Integer codigo);
	public ArrayList<Servicio> listarServicios();
	public void modificarUnServicio(Servicio servicio);

	public boolean existeServicio(Servicio servicio);
}