package ar.edu.unju.edm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.repository.PacienteRepository;

@SpringBootApplication
public class TrabajoFinalGrupo1Application implements CommandLineRunner {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    Paciente paciente;

    public static void main(String[] args) {
        SpringApplication.run(TrabajoFinalGrupo1Application.class, args);
    }

    // Este método se ejecuta al iniciar la aplicación
    @Override
    public void run(String... args) throws Exception {
    	/*
    		Paciente paciente = new Paciente();
    		paciente.setId_paciente(0);
    		paciente.setNombres("Benjhito");
    		paciente.setApellidos("Benjhito");
    		paciente.setEmail("admin@example.com");
    		paciente.setClave("admin123");
    		paciente.setDni(10000000);
    		paciente.setTipo_usuario("ADMIN");
    		paciente.setEstado(true);
        
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
    		paciente.setClave(encoder.encode(paciente.getClave()));
        
    		pacienteRepository.save(paciente);
    		*/
    }
}