package mx.redts.adendas.dao;

import java.util.List;

import mx.redts.adendas.exception.AdendaException;
import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeExpedidoEn;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;

/**
 * 
 * User DAO Interface
 * 
 * @version 1.0.0
 * 
 */
public interface IAdendaDAO {

	public List<FeDetalle> consultaDetalleByID(String id);

	public FeDirFiscal consultaDirFiscalByID(String id);

	public FeDirReceptor consultaDirReceptorByID(String id);

	public FeEncabezado consultaEncabezadoByID(String id);

	public FeExpedidoEn consultaExpedidaEnByID(String id);

	public void consultaFactura();

	public FeLugarEntrega consultaLugarEntregaByID(String id);

	public FeSumario consultaSumarioByID(String id);

	public boolean existeFacturaByID(String id);

	public void guardaFactura();

	public void saveFactura(FeEncabezado encabezado, FeDirReceptor receptor,
			FeDirFiscal dirFiscal, FeExpedidoEn expedido, FeLugarEntrega lugar,
			FeSumario sumario, List<FeDetalle> detalle) throws AdendaException;

}