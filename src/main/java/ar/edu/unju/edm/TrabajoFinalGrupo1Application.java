package ar.edu.unju.edm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabajoFinalGrupo1Application {

	PacienteService pacienteService;
	@Autowired
	Paciente paciente;
	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalGrupo1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
	}

}