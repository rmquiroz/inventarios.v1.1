package mx.redts.adendas.service;

import java.util.List;

import mx.redts.adendas.dao.IUserDAO;
import mx.redts.adendas.dto.UsuarioDTO;
import mx.redts.adendas.model.Role;
import mx.redts.adendas.model.User;
import mx.redts.adendas.util.Common;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * User Service
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
// @Service("userService")
// @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserService implements IUserService {

	// @Autowired
	IUserDAO userDao;

	@Transactional(readOnly = false)
	@Override
	public void addRole(Role rol) {
		userDao.addRole(rol);
	}

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	public List<Role> getRoles() {
		return userDao.getRoles();
	}

	/**
	 * Get User
	 * 
	 * @param int User Id
	 */
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public IUserDAO getUserDAO() {
		return userDao;
	}

	/**
	 * Get User List
	 * 
	 */
	@Override
	public List<UsuarioDTO> getUsers() {
		return userDao.getUsers();
	}

	public List<Role> loadRolForUsername(final String username) {
		return userDao.loadRolForUsername(username);
	}

	public User loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		return userDao.loadUserByUsername(username);
	}

	public void lockUser(String user) {
		userDao.lockUser(user);
	}

	public void setUserDAO(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public void updadePassword(String user, String password) {

		userDao.updadePassword(user, Common.md5Crypt(password));
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */

	public void updateUser(UsuarioDTO user) {
		userDao.updateUser(user);
	}
}