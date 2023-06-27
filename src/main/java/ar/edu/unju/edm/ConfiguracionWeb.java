package ar.edu.unju.edm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.edm.service.imp.LoginService;

@Configuration @EnableWebSecurity
public class ConfiguracionWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    private Autentication autenticacion;

    // Se definen los recursos que se pueden acceder sin autenticación
    String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**", "/webjars/**"};

    // Se configura la seguridad de la aplicación
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/", "/index", "/home", "/listaMedicos", "/listaEspecialidades", "/listaServicios", "/formPaciente_servicio").permitAll()
                .antMatchers("/formMedico", "/formPaciente", "/formServicio", "/formEspecialidad", "/formPaciente", "/listaPacientes", "/listaPaciente_Servicios").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(autenticacion)
                .failureUrl("/login")
                .usernameParameter("email")
                .passwordParameter("clave")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/home");
    }

    // Se configura el encriptador de contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Autowired
    LoginService userDetailsService;

    // Se define el servicio de autenticación
    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("***Inicio del Usuario***");
        auth.userDetailsService(userDetailsService);
    }
}