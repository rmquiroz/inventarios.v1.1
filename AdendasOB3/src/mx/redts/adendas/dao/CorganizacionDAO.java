package mx.redts.adendas.dao;

import java.util.List;

import mx.redts.adendas.model.COrganizacion;

/**
 * 
 * User DAO
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */

// @Repository("userDao")
public class CorganizacionDAO extends BaseDAO implements IOrganizacionDAO {

	@SuppressWarnings("unchecked")
	public List<COrganizacion> getCOrganizacionList() {
		return (List<COrganizacion>) createQuery(Messages
				.getString("CorganizacionDAO.1")); //$NON-NLS-1$

	}

}