package mx.redts.simoc.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * User Entity
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Entity
@Table(name = "USUARIOS")
public class User {

	private int id;
	private String name;
	private String surname;

	/**
	 * Get User Id
	 *
	 * @return int - User Id
	 */
	@Id
	@Column(name = "clave", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	/**
	 * Get User Name
	 *
	 * @return String - User Name
	 */
	@Column(name = "nombre", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Get User Surname
	 *
	 * @return String - User Surname
	 */
	@Column(name = "apellido", unique = true, nullable = false)
	public String getSurname() {
		return surname;
	}

	/**
	 * Set User Id
	 *
	 * @param int - User Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set User Name
	 *
	 * @param String
	 *            - User Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set User Surname
	 *
	 * @param String
	 *            - User Surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/*
	 * public String toString() { StringBuffer strBuff = new StringBuffer();
	 * strBuff.append("id : ").append(getId());
	 * strBuff.append(", name : ").append(getName());
	 * strBuff.append(", surname : ").append(getSurname()); return
	 * strBuff.toString(); }
	 */
}
