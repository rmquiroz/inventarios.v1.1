package mx.redts.adendas.dto;

public class UsuarioDTO {

	// private int id;
	private String usuario;
	private String nombre;
	private String rol;
	private boolean bloqueado;
	private boolean habilitado;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @return the id
	 */
	// public int getId() {
	// return id;
	// }
	// /**
	// * @param id the id to set
	// */
	// public void setId(int id) {
	// this.id = id;
	// }
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @return the bloqueado
	 */
	public boolean isBloqueado() {
		return bloqueado;
	}

	/**
	 * @return the habilitado
	 */
	public boolean isHabilitado() {
		return habilitado;
	}

	/**
	 * @param bloqueado
	 *            the bloqueado to set
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	/**
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param rol
	 *            the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
