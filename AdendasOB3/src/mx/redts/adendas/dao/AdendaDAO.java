package mx.redts.adendas.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import mx.redts.adendas.exception.AdendaException;
import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeExpedidoEn;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 * 
 * OpenBravoDAO
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */

public class AdendaDAO extends BaseDAO implements IAdendaDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<FeDetalle> consultaDetalleByID(String id) {

		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.14"), id); //$NON-NLS-1$

		return (List<FeDetalle>) createQueryList(
				Messages.getString("AdendaDAO.15"), parametros); //$NON-NLS-1$
	}

	public FeDirFiscal consultaDirFiscalByID(String id) {
		// TODO Auto-generated method stub

		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.16"), id); //$NON-NLS-1$

		return (FeDirFiscal) createQueryUnique(
				Messages.getString("AdendaDAO.17"), parametros); //$NON-NLS-1$

	}

	public FeDirReceptor consultaDirReceptorByID(String id) {
		// TODO Auto-generated method stub
		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.18"), id); //$NON-NLS-1$

		return (FeDirReceptor) createQueryUnique(
				Messages.getString("AdendaDAO.19"), parametros); //$NON-NLS-1$
	}

	public FeEncabezado consultaEncabezadoByID(String id) {
		// TODO Auto-generated method stub

		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.20"), id); //$NON-NLS-1$

		return (FeEncabezado) createQueryUnique(
				Messages.getString("AdendaDAO.21"), parametros); //$NON-NLS-1$
	}

	public FeExpedidoEn consultaExpedidaEnByID(String id) {
		// TODO Auto-generated method stub
		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.22"), id); //$NON-NLS-1$

		return (FeExpedidoEn) createQueryUnique(
				Messages.getString("AdendaDAO.23"), parametros); //$NON-NLS-1$
	}

	@Override
	public void consultaFactura() {
		// TODO Auto-generated method stub

	}

	public FeLugarEntrega consultaLugarEntregaByID(String id) {
		// TODO Auto-generated method stub
		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.24"), id); //$NON-NLS-1$

		return (FeLugarEntrega) createQueryUnique(
				Messages.getString("AdendaDAO.25"), parametros); //$NON-NLS-1$
	}

	public FeSumario consultaSumarioByID(String id) {
		// TODO Auto-generated method stub
		HashMap<String, String> parametros = new HashMap<String, String>();
		parametros.put(Messages.getString("AdendaDAO.26"), id); //$NON-NLS-1$

		return (FeSumario) createQueryUnique(
				Messages.getString("AdendaDAO.27"), parametros); //$NON-NLS-1$

	}

	public boolean existeFacturaByID(String id) {

		FeEncabezado f = this.consultaEncabezadoByID(id);

		if (f != null)
			return true;
		else
			return false;

	}

	@Override
	public void guardaFactura() {
		// TODO Auto-generated method stub

	}

	public void saveFactura(FeEncabezado encabezado, FeDirReceptor receptor,
			FeDirFiscal dirFiscal, FeExpedidoEn expedido, FeLugarEntrega lugar,
			FeSumario sumario, List<FeDetalle> detalle) throws AdendaException {
		Session sesion = this.getSession();

		Transaction tx = sesion.beginTransaction();
		try {
			if (encabezado != null) {
				sesion.save(encabezado);
			}

			if (receptor != null) {
				sesion.save(receptor);
			}

			if (dirFiscal != null) {
				sesion.save(dirFiscal);
			}

			if (expedido != null) {
				sesion.save(expedido);
			}

			if (lugar != null) {
				sesion.save(lugar);
			}

			if (sumario != null) {
				sesion.save(sumario);
			}

			if (detalle != null && detalle.size() > 0) {
				for (FeDetalle d : detalle) {
					sesion.save(d);
				}
			}

			tx.commit();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw new AdendaException(Messages.getString("AdendaDAO.28")); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			// TODO Auto-generated catch block
			throw new AdendaException(
					Messages.getString("AdendaDAO.29") + e.getMessage()); //$NON-NLS-1$
		} finally {
			sesion.disconnect();
		}
	}

}