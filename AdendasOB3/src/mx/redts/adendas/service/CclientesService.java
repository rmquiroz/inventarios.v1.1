package mx.redts.adendas.service;

import java.util.List;

import mx.redts.adendas.dao.IClientesDAO;
import mx.redts.adendas.model.CClientes;

public class CclientesService implements IClientesService {

	IClientesDAO clientesDao;

	@Override
	public List<CClientes> getCClientesList() {
		// TODO Auto-generated method stub
		return clientesDao.getCClientesList();
	}

	/**
	 * @return the clientesDao
	 */
	public IClientesDAO getClientesDao() {
		return clientesDao;
	}

	/**
	 * @param clientesDao
	 *            the clientesDao to set
	 */
	public void setClientesDao(IClientesDAO clientesDao) {
		this.clientesDao = clientesDao;
	}

}
