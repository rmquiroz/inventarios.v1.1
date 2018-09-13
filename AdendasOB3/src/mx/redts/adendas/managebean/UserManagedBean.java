package mx.redts.adendas.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import mx.redts.adendas.dto.UsuarioDTO;
import mx.redts.adendas.model.Role;
import mx.redts.adendas.model.User;
import mx.redts.adendas.service.IUserService;
import mx.redts.adendas.util.Common;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * User Managed Bean
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@ManagedBean(name = "userMB")
@ViewScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = Messages
			.getString("UserManagedBean.0"); //$NON-NLS-1$
	private static final String ERROR = Messages.getString("UserManagedBean.1"); //$NON-NLS-1$

	// Spring User Service is injected...
	@ManagedProperty(value = "#{UserService}")
	IUserService userService;

	List<UsuarioDTO> userList;

	private int id;
	private String name;
	private String surname;
	private String mname;
	private String username;
	private String rol;
	// private UsuarioDTO userSel;
	// private UsuarioDTO userSelected;
	private Integer editHabilitado;
	private Integer editBloqueado;

	private String password1;
	private String password2;

	/**
	 * Add User
	 * 
	 * @return String - Response Message
	 */
	public String addUser() {

		if (Messages.getString("UserManagedBean.2").equals(getRol()) || getRol() == null) { //$NON-NLS-1$
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					Messages.getString("UserManagedBean.3"), null); //$NON-NLS-1$
			FacesContext.getCurrentInstance().addMessage(null, message);
			return ERROR;
		} else {
			User u = getUserService().loadUserByUsername(getUsername());
			System.out.println(Messages.getString("UserManagedBean.4") + u); //$NON-NLS-1$
			if (u == null) {
				try {
					User user = new User();
					// user.setId(getId());
					user.setNombre(getName());
					user.setApellidoPaterno(getSurname());
					user.setApellidoMaterno(getMname());
					user.setAccountNonExpired(false);
					user.setAccountNonLocked(false);
					user.setCredentialsNonExpired(false);
					user.setEnabled(true);
					user.setUsername(getUsername());
					user.setPassword(Common.md5Crypt(getUsername()));
					// List<Role> rol = new ArrayList<Role>();
					// // Role or = new Role();
					// // or.setRoleId(getRol());
					//
					// System.out.println("#############> ROL : " + getRol());
					// rol.add(getRol());
					// user.setAuthorities(rol);
					// rol.

					getUserService().addUser(user);

					Role rol = new Role();
					rol.setUsername(user.getUsername());
					rol.setAuthority(getRol());

					getUserService().addRole(rol);

					FacesMessage message = new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							Messages.getString("UserManagedBean.5"), null); //$NON-NLS-1$
					FacesContext.getCurrentInstance().addMessage(null, message);
					setName(Messages.getString("UserManagedBean.6")); //$NON-NLS-1$
					setSurname(Messages.getString("UserManagedBean.7")); //$NON-NLS-1$
					setMname(Messages.getString("UserManagedBean.8")); //$NON-NLS-1$
					setUsername(Messages.getString("UserManagedBean.9")); //$NON-NLS-1$
					setRol(Messages.getString("UserManagedBean.10")); //$NON-NLS-1$
					return SUCCESS;
				} catch (DataAccessException e) {
					e.printStackTrace();
				}

			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						Messages.getString("UserManagedBean.11"), null); //$NON-NLS-1$
				FacesContext.getCurrentInstance().addMessage(null, message);

				return ERROR;
			}

		}

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
				Messages.getString("UserManagedBean.12"), null); //$NON-NLS-1$
		FacesContext.getCurrentInstance().addMessage(null, message);
		return ERROR;
	}

	public String altausuarioview() {
		return Messages.getString("UserManagedBean.13"); //$NON-NLS-1$
	}

	public void cambiaPassword() {

		FacesMessage msg = null;
		if (!this.getPassword1().equals(this.getPassword2())) {
			msg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					Messages.getString("UserManagedBean.14"), Messages.getString("UserManagedBean.15")); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			userService.updadePassword(this.getUserlogged(),
					this.getPassword1());
			msg = new FacesMessage(
					Messages.getString("UserManagedBean.16"), Messages.getString("UserManagedBean.17")); //$NON-NLS-1$ //$NON-NLS-2$

		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// public boolean getLocked(){
	// return (userSelected != null?userSelected.isBloqueado():null);
	// }

	public Integer getEnabled() {
		return editHabilitado;
	}

	/**
	 * Get User Id
	 * 
	 * @return int - User Id
	 */
	public int getId() {
		return id;
	}

	public Integer getLocked() {
		return editBloqueado;
	}

	public String getMname() {
		return mname;
	}

	/**
	 * Get User Name
	 * 
	 * @return String - User Name
	 */
	public String getName() {
		return name;
	}

	public List<Boolean> getOptions() {
		List<Boolean> x = new ArrayList<Boolean>();
		x.add(true);
		x.add(false);
		return x;
	}

	public String getPassword1() {
		return password1;
	}

	public String getPassword2() {
		return password2;
	}

	public String getRol() {
		return rol;
	}

	public String getRolelogged() {
		String rol = Messages.getString("UserManagedBean.18"); //$NON-NLS-1$

		for (GrantedAuthority ga : SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities()) {
			rol = ga.getAuthority();
		}

		return rol;
	}

	public List<Role> getRoles() {
		return userService.getRoles();
	}

	/**
	 * Get User Surname
	 * 
	 * @return String - User Surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<UsuarioDTO> getUserList() {
		userList = new ArrayList<UsuarioDTO>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}

	public String getUserlogged() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public String getUsername() {
		return username;
	}

	/**
	 * Get User Service
	 * 
	 * @return IUserService - User Service
	 */
	public IUserService getUserService() {
		return userService;
	}

	public List<UsuarioDTO> getUsuarios() {
		return userService.getUsers();
	}

	public void onLockChange(AjaxBehaviorEvent event) {
		System.out
				.println(Messages.getString("UserManagedBean.19") + ((UIOutput) event.getSource()).getValue()); //$NON-NLS-1$

	}

	// public void selUsrBlocked() {
	//
	// userSel.setBloqueado(!userSel.isBloqueado());
	// userService.updateUser(userSel);
	// FacesContext.getCurrentInstance().addMessage(
	// null,
	// new FacesMessage(
	// "Usuario "
	// + (userSel.isBloqueado() ? "Bloqueado"
	// : "Desbloqueado")));
	// }

	// public void selUsrEnabled() {
	// // String summary = value2 ? "Checked" : "Unchecked";
	// userSel.setHabilitado(!userSel.isHabilitado());
	// userService.updateUser(userSel);
	//
	// FacesContext.getCurrentInstance().addMessage(
	// null,
	// new FacesMessage("Usuario "
	// + (userSel.isHabilitado() ? "Habilidado"
	// : "Deshabilitado")));
	// }

	// public void setSelectedUser(UsuarioDTO usrsel) {
	// System.out.println("###########################> Usuaro Seleccionado ;"
	// + usrsel);
	// userSel = usrsel;
	// }

	// public void onRowEdit(UsuarioDTO event) {
	// System.out.println("###########################> EDITANDO USUARIO");
	// userSel = event;
	// //userService.updateUser(userSel);
	//
	// FacesMessage msg = new FacesMessage("Editando Usuario : ",
	// userSel.getUsuario());
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	//
	// // public void onCompleteRowEdit(RowEditEvent event) {
	// // System.out.println("###########################> EDITANDO USUARIO");
	// // userSel = ((UsuarioDTO) event.getObject());
	// // FacesMessage msg = new FacesMessage("User Edited",
	// userSel.getUsuario());
	// // FacesContext.getCurrentInstance().addMessage(null, msg);
	// // }
	//
	// public void onRowCancel(RowEditEvent event) {
	// System.out.println("###########################> CANCELANDO EDICION");
	// userSel = ((UsuarioDTO) event.getObject());
	// FacesMessage msg = new FacesMessage("Edit Cancelled",
	// userSel.getUsuario());
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	//
	//

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage(
				Messages.getString("UserManagedBean.20") + ((UsuarioDTO) event.getObject()).getUsuario() + Messages.getString("UserManagedBean.21"), Messages.getString("UserManagedBean.22")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEdit(CellEditEvent event) {

		FacesContext context = FacesContext.getCurrentInstance();
		UsuarioDTO entity = context.getApplication().evaluateExpressionGet(
				context,
				Messages.getString("UserManagedBean.23"), UsuarioDTO.class); //$NON-NLS-1$

		if (editBloqueado != null && editBloqueado == 1)
			entity.setBloqueado(true);

		if (editBloqueado != null && editBloqueado == 2)
			entity.setBloqueado(false);

		if (editHabilitado != null && editHabilitado == 1)
			entity.setHabilitado(true);

		if (editHabilitado != null && editHabilitado == 2)
			entity.setHabilitado(false);
		userService.updateUser(entity);
		FacesMessage msg = new FacesMessage(
				Messages.getString("UserManagedBean.24") + entity.getUsuario() + Messages.getString("UserManagedBean.25"), Messages.getString("UserManagedBean.26")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		FacesContext.getCurrentInstance().addMessage(null, msg);
		editBloqueado = null;
		editHabilitado = null;
	}

	// public void onCellEdit(CellEditEvent event) {
	// Object oldValue = event.getOldValue();
	// Object newValue = event.getNewValue();
	//
	// if (newValue != null && !newValue.equals(oldValue)) {
	// FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
	// "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	// }

	// public void rowEditorForItem(UsuarioDTO item) {
	// System.out.print("$$$$$$$$ > Usuario ; " + item.getNombre());
	// userSelected = item;
	// }

	// public void setEnabled(boolean value){
	// userSelected.setHabilitado(value);
	// }

	// public void setLocked(boolean value){
	// userSelected.setBloqueado(value);
	// }

	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setId(0);
		this.setName(Messages.getString("UserManagedBean.27")); //$NON-NLS-1$
		this.setSurname(Messages.getString("UserManagedBean.28")); //$NON-NLS-1$
	}

	public void setEnabled(Integer x) {
		editHabilitado = x;
		System.out.println(Messages.getString("UserManagedBean.29") + x); //$NON-NLS-1$
	}

	/**
	 * Set User Id
	 * 
	 * @param int - User Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public void setLocked(Integer x) {
		editBloqueado = x;

		System.out.println(Messages.getString("UserManagedBean.30") + x); //$NON-NLS-1$

	}

	public void setMname(String mname) {
		this.mname = mname;
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

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	/**
	 * Set User List
	 * 
	 * @param List
	 *            - User List
	 */
	public void setUserList(List<UsuarioDTO> userList) {
		this.userList = userList;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Set User Service
	 * 
	 * @param IUserService
	 *            - User Service
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}