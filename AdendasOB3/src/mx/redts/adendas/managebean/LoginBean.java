package mx.redts.adendas.managebean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.redts.adendas.service.IUserService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * The Class LoginBean.
 */
@ManagedBean(name = "loginMgmtBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6126997136957069471L;

	/** The user name. */
	private String userName = null;

	/** The password. */
	private String password = null;

	private String role;

	private int intento;

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;

	@ManagedProperty(value = "#{UserService}")
	IUserService userService;

	/**
	 * Cancel.
	 * 
	 * @return the string
	 */
	public String cancel() {
		return null;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {

		return userName;
	}

	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Login.
	 * 
	 * @return the string
	 */
	public String login() {
		try {
			Authentication request = new UsernamePasswordAuthenticationToken(
					this.getUserName(), this.getPassword());

			System.out.println(Messages.getString("LoginBean.0")); //$NON-NLS-1$
			Authentication result = authenticationManager.authenticate(request);

			for (GrantedAuthority auth : result.getAuthorities()) {
				role = auth.getAuthority();
			}
			System.out.println(Messages.getString("LoginBean.1")); //$NON-NLS-1$
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (BadCredentialsException e) {
			e.printStackTrace();

			if (!e.getMessage().contains(Messages.getString("LoginBean.2"))) { //$NON-NLS-1$
				intento++;
				if (intento > 6) {
					userService.lockUser(this.getUserName());
				}
			} else
				intento = 0;

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return Messages.getString("LoginBean.3"); //$NON-NLS-1$
		} catch (AuthenticationException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(Messages.getString("LoginBean.4"))); //$NON-NLS-1$
			return Messages.getString("LoginBean.5"); //$NON-NLS-1$
		}
		return Messages.getString("LoginBean.6"); //$NON-NLS-1$
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Sets the user name.
	 * 
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}