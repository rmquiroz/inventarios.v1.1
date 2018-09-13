package mx.redts.adendas.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * User Entity
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7548324988951288240L;
	// private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Boolean expired;
	private Boolean locked;
	private Boolean credentialExpired;
	private Boolean enabled;
	private String password;
	private String username;
	private Set<Role> perfils = new HashSet<Role>(0);

	public User() {
	}

	public User(int id, String username) {
		// this.id = id;
		this.username = username;
	}

	public User(String nombre, String apellidoPaterno, String apellidoMaterno,
			Boolean expired, Boolean locked, Boolean credentialExpired,
			Boolean enabled, String password, String username, Set<Role> perfils) {
		// this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.expired = expired;
		this.locked = locked;
		this.credentialExpired = credentialExpired;
		this.enabled = enabled;
		this.password = password;
		this.username = username;
		this.perfils = perfils;
	}

	// @Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "UsuarioSeq")
	// @SequenceGenerator(name = "UsuarioSeq", sequenceName = "usuario_seq",
	// allocationSize = 1)
	// @Column(name = "id", unique = true, nullable = false)
	// public int getId() {
	// return this.id;
	// }
	//
	// public void setId(int id) {
	// this.id = id;
	// }

	@Column(name = "accountnonlocked")
	public Boolean getAccountNonLocked() {
		// TODO Auto-generated method stub
		return locked;
	}

	@Column(name = "apellido_materno", length = 80)
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	@Column(name = "apellido_paterno", length = 80)
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "username")
	public Set<Role> getAuthorities() {
		return this.perfils;
	}

	@Column(name = "credential_expired")
	public Boolean getCredentialsNonExpired() {
		return this.credentialExpired;
	}

	@Column(name = "enabled")
	public Boolean getEnabled() {
		return this.enabled;
	}

	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	@Column(name = "password", length = 80)
	public String getPassword() {
		return this.password;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false)
	public String getUsername() {
		return this.username.trim();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return !expired;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return getCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return getEnabled();
	}

	public void setAccountNonExpired(Boolean x) {
		// TODO Auto-generated method stub
		expired = !x;
	}

	public void setAccountNonLocked(Boolean x) {
		// TODO Auto-generated method stub
		locked = !x;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public void setAuthorities(Set<Role> perfils) {
		this.perfils = perfils;
	}

	public void setCredentialsNonExpired(Boolean credentialExpired) {
		this.credentialExpired = credentialExpired;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
