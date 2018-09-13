package mx.redts.adendas.dao;

import java.util.List;

import mx.redts.adendas.dto.UsuarioDTO;
import mx.redts.adendas.model.Role;
import mx.redts.adendas.model.User;

/**
 * 
 * User DAO Interface
 * 
 * @version 1.0.0
 * 
 */
public interface IUserDAO {

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
	 */
	public List<UsuarioDTO> getUsers();

	public List<Role> loadRolForUsername(final String username);

	public User loadUserByUsername(String username);

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