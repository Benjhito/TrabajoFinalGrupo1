package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Autentication implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	// Asigna un rol al usuario conectado
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Boolean tipoUsuario = false, tipoAdmin = false;
		Collection<?extends GrantedAuthority> autorizaciones = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority:autorizaciones) {
			if (grantedAuthority.getAuthority().equals("USUARIO")) {
				tipoUsuario = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("ADMIN")) {
					tipoAdmin = true;
					break;
				}
			}
		}
		
		if (tipoUsuario) {
			redirectStrategy.sendRedirect(request, response, "/index");
		} else {
			if (tipoAdmin) {
				redirectStrategy.sendRedirect(request, response, "/formMedico");
			}
		}
	}
}
