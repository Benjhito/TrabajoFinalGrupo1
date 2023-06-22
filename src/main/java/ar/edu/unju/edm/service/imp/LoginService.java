package ar.edu.unju.edm.service.imp;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.repository.PacienteRepository;

@Service
public class LoginService implements UserDetailsService {
	// Inyeccion de Dependencias
	@Autowired
	PacienteRepository pacienteRepository;
	
	// Busqueda del usuario y autenticacion
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Paciente pacienteEncontrado = pacienteRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuario Invalido"));
		
		List <GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(pacienteEncontrado.getTipo_usuario());
		tipos.add(grantedAuthority);
		
		UserDetails pacienteEnSesion = new User(email, pacienteEncontrado.getClave(), tipos);
		return pacienteEnSesion;
	}
}
