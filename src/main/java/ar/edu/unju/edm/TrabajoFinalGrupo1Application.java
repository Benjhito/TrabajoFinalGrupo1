package ar.edu.unju.edm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;

@SpringBootApplication
public class TrabajoFinalGrupo1Application implements CommandLineRunner {
	// Inyeccion de Dependencias
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
		paciente.setId_paciente(0);
		paciente.setEmail("benjhito112@gmail.com");
		paciente.setClave("root");
		paciente.setTipo_usuario("Admin");
		paciente.setEstado(true);
	}
}