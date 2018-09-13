package mx.redts.adendas.service;

import java.util.Date;
import java.util.List;

import mx.redts.adendas.dao.IOpenBravoDAO;
import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;

/**
 * 
 * User Service
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
public class OBService implements IOBService {

	private IOpenBravoDAO openBravoDAO;

	public List<FeDetalle> findDetalle(String idob3) {
		return openBravoDAO.findDetalle(idob3);
	}

	@Override
	public List<FeDirFiscal> findDirFiscal(String idob3) {
		// TODO Auto-generated method stub
		return openBravoDAO.findDirFiscal(idob3);
	}

	@Override
	public List<FeDirReceptor> findDirReceptor(String idob3) {
		// TODO Auto-generated method stub
		return openBravoDAO.findDirReceptor(idob3);
	}

	@Override
	public List<FeEncabezado> findFactHeaderBy(String org, String cliente,
			String folio, String tipoDoc, Date fechaInicial, Date fechafinal) {
		// TODO Auto-generated method stub
		return openBravoDAO.findFactHeaderBy(org, cliente, folio, tipoDoc,
				fechaInicial, fechafinal);
	}

	public List<FeEncabezado> findFactHeaderByID(String idOb3) {
		// TODO Auto-generated method stub
		return openBravoDAO.findFactHeaderByID(idOb3);
	}

	@Override
	public List<FeLugarEntrega> findLugarEntrega(String idob3) {
		// TODO Auto-generated method stub
		return openBravoDAO.findLugarEntrega(idob3);
	}

	@Override
	public List<FeSumario> findSumario(String idob3) {
		// TODO Auto-generated method stub
		return openBravoDAO.findSumario(idob3);
	}

	/**
	 * @return the openBravoDAO
	 */
	public IOpenBravoDAO getOpenBravoDAO() {
		return openBravoDAO;
	}

	/**
	 * @param openBravoDAO
	 *            the openBravoDAO to set
	 */
	public void setOpenBravoDAO(IOpenBravoDAO openBravoDAO) {
		this.openBravoDAO = openBravoDAO;
	}

}