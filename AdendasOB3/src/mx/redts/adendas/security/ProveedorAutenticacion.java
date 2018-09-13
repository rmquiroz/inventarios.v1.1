package mx.redts.adendas.security;

import java.io.Serializable;
import java.util.Collection;

import mx.redts.adendas.model.User;
import mx.redts.adendas.service.IUserService;
import mx.redts.adendas.util.Common;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class ProveedorAutenticacion implements AuthenticationProvider,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1204397037459670827L;
	private IUserService userService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = Common.md5Crypt((String) authentication
				.getCredentials());

		System.out.println(Messages.getString("ProveedorAutenticacion.0")); //$NON-NLS-1$
		System.out
				.println(Messages.getString("ProveedorAutenticacion.1") + username); //$NON-NLS-1$

		User user = userService.loadUserByUsername(username);

		System.out
				.println(Messages.getString("ProveedorAutenticacion.2") + user); //$NON-NLS-1$

		if (user == null) {
			throw new BadCredentialsException(
					Messages.getString("ProveedorAutenticacion.3")); //$NON-NLS-1$
		}
		if (!user.isAccountNonLocked()) {
			throw new BadCredentialsException(
					Messages.getString("ProveedorAutenticacion.4")); //$NON-NLS-1$
		}
		if (!user.isEnabled()) {
			throw new BadCredentialsException(
					Messages.getString("ProveedorAutenticacion.5")); //$NON-NLS-1$
		}

		System.out
				.println(Messages.getString("ProveedorAutenticacion.6") + user.getUsername()); //$NON-NLS-1$
		System.out
				.println(Messages.getString("ProveedorAutenticacion.7") + user.getPassword()); //$NON-NLS-1$
		if (!password.equals(user.getPassword().trim())) {
			throw new BadCredentialsException(
					Messages.getString("ProveedorAutenticacion.8")); //$NON-NLS-1$
		}
		Collection<? extends GrantedAuthority> auth = userService
				.loadRolForUsername(user.getUsername());

		for (GrantedAuthority au : auth) {
			System.out
					.println(Messages.getString("ProveedorAutenticacion.9") + au.getAuthority()); //$NON-NLS-1$
		}
		System.out
				.println(Messages.getString("ProveedorAutenticacion.10") + user.getPassword()); //$NON-NLS-1$

		return new UsernamePasswordAuthenticationToken(username, password, auth);
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}