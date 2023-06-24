package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class Autentication implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    // Esta función se llama cuando el usuario se autentica correctamente
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        // Se inicializan variables booleanas para determinar el rol del usuario
        Boolean tipoUsuario = false;
        Boolean tipoAdmin = false;

        // Se obtienen las autorizaciones del usuario
        Collection<?extends GrantedAuthority> autorizaciones = authentication.getAuthorities();

        // Se recorren las autorizaciones del usuario para determinar su rol
        for (GrantedAuthority grantedAuthority : autorizaciones) {
            if (grantedAuthority.getAuthority().equals("USUARIO")) {
                tipoUsuario = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                tipoAdmin = true;
                break;
            }
        }

        // Si el usuario es un usuario común, se redirige a la página /index
        if (tipoUsuario) {
            redirectStrategy.sendRedirect(request, response, "/index");
        } else if (tipoAdmin) {
            // Si el usuario es un administrador, también se redirige a la página /index
            redirectStrategy.sendRedirect(request, response, "/index");
        }
    }
}