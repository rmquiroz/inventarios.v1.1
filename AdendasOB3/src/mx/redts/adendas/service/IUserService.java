package mx.redts.adendas.service;

import java.util.List;

import mx.redts.adendas.dto.UsuarioDTO;
import mx.redts.adendas.model.Role;
import mx.redts.adendas.model.User;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * User Service Interface
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
public interface IUserService {

	public void addRole(Role rol);

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	public void addUser(User user);

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	public void deleteUser(User user);

	public List<Role> getRoles();

	/**
	 * Get User
	 * 
	 * @param int User Id
	 */
	public User getUserById(int id);

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<UsuarioDTO> getUsers();

	public List<Role> loadRolForUsername(final String username);

	/**
	 * Verifica usuario
	 * 
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public User loadUserByUsername(final String username)
			throws UsernameNotFoundException;

	public void lockUser(String user);

	public void updadePassword(String user, String password);

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	public void updateUser(UsuarioDTO user);
}