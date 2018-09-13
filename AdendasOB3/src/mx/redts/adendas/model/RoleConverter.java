package mx.redts.adendas.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Role.class)
public class RoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String submittedValue) {
		// Convert String to MyObj.
		Role rol = new Role();
		// rol.setRoleId(Integer.parseInt(submittedValue));
		return rol;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object valueToRender) {
		return String.valueOf(((Role) valueToRender).getUsername());
		// Convert MyObj to its unique String representation.
	}

}