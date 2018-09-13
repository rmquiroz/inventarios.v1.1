package mx.redts.adendas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
public class Privilege {

	private int permisoId;

	private String name;

	@Column(name = "nombre", nullable = false)
	public String getName() {
		return name;
	}

	@Id
	@Column(name = "permiso_id", unique = true, nullable = false)
	public int getPermisoId() {
		return permisoId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPermisoId(int permisoId) {
		this.permisoId = permisoId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Messages.getString("Privilege.0")); //$NON-NLS-1$
		builder.append(name);
		builder.append(Messages.getString("Privilege.1")); //$NON-NLS-1$
		return builder.toString();
	}

}
