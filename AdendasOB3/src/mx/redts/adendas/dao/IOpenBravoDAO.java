package mx.redts.adendas.dao;

import java.util.Date;
import java.util.List;

import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;

/**
 * 
 * User DAO Interface
 * 
 * @version 1.0.0
 * 
 */
public interface IOpenBravoDAO {

	public List<FeDetalle> findDetalle(String idob3);

	// public List<FeEncabezado> findFactHeaderBy(String folio, String tipoDoc,
	// Date fechaInicial, Date fechafinal);

	public List<FeDirFiscal> findDirFiscal(String idob3);

	public List<FeDirReceptor> findDirReceptor(String idob3);

	public List<FeEncabezado> findFactHeaderBy(String org, String cliente,
			String folio, String tipoDoc, Date fechaInicial, Date fechafinal);

	public List<FeEncabezado> findFactHeaderByID(String idob3);

	public List<FeLugarEntrega> findLugarEntrega(String idob3);

	public List<FeSumario> findSumario(String idob3);

	@SuppressWarnings("rawtypes")
	public List getFacturas();
}