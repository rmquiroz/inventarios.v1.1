package mx.redts.adendas.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.redts.adendas.dto.UsuarioDTO;
import mx.redts.adendas.model.Role;
import mx.redts.adendas.model.User;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * User DAO
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */

// @Repository("userDao")
public class UserDAO extends BaseDAO implements IUserDAO {

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRole(Role rol) {
		this.getSession().save(rol);
	}

	/**
	 * Add User
	 * 
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user) {

		this.getSession().save(user);

	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUser(User user) {

		this.getSession().delete(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles() {

		return (List<Role>) createQuery(Messages.getString("UserDAO.3")); //$NON-NLS-1$

	}

	/**
	 * Get User
	 * 
	 * @param int User Id
	 * @return User
	 */

	public User getUserById(int id) {
		List<Integer> param = new ArrayList<Integer>();
		param.add(0, id);
		return (User) createQuery(Messages.getString("UserDAO.4"), param); //$NON-NLS-1$

	}

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioDTO> getUsers() {

		return (List<UsuarioDTO>) createQueryToBean(
				Messages.getString("UserDAO.5"), //$NON-NLS-1$
				UsuarioDTO.class);

	}

	@SuppressWarnings("unchecked")
	public List<Role> loadRolForUsername(final String username) {

		System.out.println(Messages.getString("UserDAO.6") + username); //$NON-NLS-1$
		Session ses = this.getSession();
		List<Role> roles = (List<Role>) ses
				.createQuery(Messages.getString("UserDAO.7")).setParameter(0, username.trim()).list(); //$NON-NLS-1$
		ses.close();
		System.out.println(Messages.getString("UserDAO.8") + roles.size()); //$NON-NLS-1$
		return roles;
	}

	public User loadUserByUsername(final String username) {

		System.out.println(Messages.getString("UserDAO.9") + username); //$NON-NLS-1$
		Session ses = this.getSession();
		User user = (User) ses
				.createQuery(Messages.getString("UserDAO.10")).setParameter(0, username.trim()).uniqueResult(); //$NON-NLS-1$
		ses.close();
		return user;
	}

	public void lockUser(String user) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(Messages.getString("UserDAO.11"), new Boolean(true)); //$NON-NLS-1$
		parametros.put(Messages.getString("UserDAO.12"), user.trim()); //$NON-NLS-1$
		System.out
				.println(Messages.getString("UserDAO.13") + parametros.toString()); //$NON-NLS-1$
		createUpdQry(Messages.getString("UserDAO.14"), parametros); //$NON-NLS-1$

	}

	public void updadePassword(String user, String password) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(Messages.getString("UserDAO.15"), password); //$NON-NLS-1$
		parametros.put(Messages.getString("UserDAO.16"), user.trim()); //$NON-NLS-1$
		System.out
				.println(Messages.getString("UserDAO.17") + parametros.toString()); //$NON-NLS-1$
		createUpdQry(Messages.getString("UserDAO.18"), parametros); //$NON-NLS-1$

	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */

	public void updateUser(UsuarioDTO user) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(
				Messages.getString("UserDAO.19"), (Boolean) user.isBloqueado()); //$NON-NLS-1$
		parametros
				.put(Messages.getString("UserDAO.20"), (Boolean) user.isHabilitado()); //$NON-NLS-1$
		parametros.put(
				Messages.getString("UserDAO.21"), user.getUsuario().trim()); //$NON-NLS-1$
		System.out
				.println(Messages.getString("UserDAO.22") + parametros.toString()); //$NON-NLS-1$
		createUpdQry(Messages.getString("UserDAO.23"), parametros); //$NON-NLS-1$

	}

}