package mx.redts.adendas.service;

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
 * User Service Interface
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
public interface IOBService {

	public List<FeDetalle> findDetalle(String idob3);

	public List<FeDirFiscal> findDirFiscal(String idob3);

	public List<FeDirReceptor> findDirReceptor(String idob3);

	public List<FeEncabezado> findFactHeaderBy(String org, String cliente,
			String folio, String tipoDoc, Date date, Date date2);

	public List<FeEncabezado> findFactHeaderByID(String idOb3);

	public List<FeLugarEntrega> findLugarEntrega(String idob3);

	public List<FeSumario> findSumario(String idob3);

}