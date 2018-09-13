/**
 * 
 */
package mx.redts.adendas.dao;

import java.util.List;

import mx.redts.adendas.model.CClientes;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author
 * 
 */
public class ClientesDAO extends BaseDAO implements IClientesDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CClientes> getCClientesList() {

		return (List<CClientes>) createQuery(Messages
				.getString("ClientesDAO.1")); //$NON-NLS-1$
	}

}
