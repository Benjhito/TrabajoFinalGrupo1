package ar.edu.unju.edm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.repository.PacienteRepository;

@SpringBootApplication
public class TrabajoFinalGrupo1Application implements CommandLineRunner {
	// Inyeccion de Dependencias
	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	PacienteService pacienteService;
	@Autowired
	Paciente paciente;
	
	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalGrupo1Application.class, args);
	}

	// Creacion de un usuario administrador 
	@Override
	public void run(String... args) throws Exception {
	    Paciente paciente = new Paciente();
	    paciente.setEmail("admin@example.com");
	    paciente.setClave("admin123");
	    paciente.setTipo_usuario("ADMIN");
	    paciente.setEstado(true);
	    pacienteService.cargarPaciente(paciente);
	}
}