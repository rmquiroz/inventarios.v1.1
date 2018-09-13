package mx.redts.adendas.service;

import java.util.List;

import mx.redts.adendas.dao.IOrganizacionDAO;
import mx.redts.adendas.model.COrganizacion;

public class CorganizacionService implements ICOrganizacionService {

	// @Autowired
	IOrganizacionDAO organizacionDao;

	@Override
	public List<COrganizacion> getCOrganizacionList() {
		// TODO Auto-generated method stub
		return organizacionDao.getCOrganizacionList();
	}

	/**
	 * @return the organizacionDao
	 */
	public IOrganizacionDAO getOrganizacionDao() {
		return organizacionDao;
	}

	/**
	 * @param organizacionDao
	 *            the organizacionDao to set
	 */
	public void setOrganizacionDao(IOrganizacionDAO organizacionDao) {
		this.organizacionDao = organizacionDao;
	}

}