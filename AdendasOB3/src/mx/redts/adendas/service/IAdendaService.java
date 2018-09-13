package mx.redts.adendas.service;

import java.util.List;

import mx.redts.adendas.dao.IAdendaDAO;
import mx.redts.adendas.dto.FacturaDTO;
import mx.redts.adendas.exception.AdendaException;
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
public interface IAdendaService {

	public boolean existeFacturaByID(String id);

	public void exportaFactura(List<FeEncabezado> encabezado,
			List<FeLugarEntrega> lugarEntrega, List<FeSumario> sumario,
			List<FeDirReceptor> dirReceptor, List<FeDirFiscal> dirFiscal,
			List<FeDetalle> detalle) throws AdendaException;

	public IAdendaDAO getAdendaDAO();

	public FacturaDTO getFacturaByID(String id);

	public String getRepositorioAdendas();

	public void setAdendaDAO(IAdendaDAO adendaDAO);

	public void setRepositorioAdendas(String repositorioAdendas);
}