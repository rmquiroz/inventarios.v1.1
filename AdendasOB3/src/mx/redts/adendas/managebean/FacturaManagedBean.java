package mx.redts.adendas.managebean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mx.redts.adendas.dto.FacturaDTO;
import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;
import mx.redts.adendas.service.IAdendaService;
import mx.redts.adendas.service.IOBService;

import org.hibernate.exception.ConstraintViolationException;

@ManagedBean(name = "facturaMB")
@ViewScoped
public class FacturaManagedBean {

	@ManagedProperty(value = "#{OBService}")
	IOBService OBService;
	private List<FeEncabezado> encabezado;
	private List<FeDirFiscal> dirFiscal;
	private List<FeDirReceptor> dirReceptor;
	private List<FeDetalle> detalle;
	private List<FeLugarEntrega> lugarEntrega;
	private List<FeSumario> sumario;
	private Boolean emitida = null;
	private FacturaDTO facturaEmitida;

	@ManagedProperty(value = "#{AdendaService}")
	private IAdendaService adendaService;

	public void export() {

		// FacesContext context = FacesContext.getCurrentInstance();

		if (encabezado != null && encabezado.size() > 0) {

			if (!adendaService.existeFacturaByID(encabezado.get(0).getOb3id())) {

				try {
					// lugarEntrega =
					// OBService.findLugarEntrega(encabezado.get(0).getOb3id());

					sumario = OBService.findSumario(encabezado.get(0)
							.getOb3id());

					adendaService.exportaFactura(encabezado, lugarEntrega,
							sumario, dirReceptor, dirFiscal, detalle);

					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_INFO,
											Messages.getString("FacturaManagedBean.0"), Messages.getString("FacturaManagedBean.1"))); //$NON-NLS-1$ //$NON-NLS-2$
				} catch (ConstraintViolationException e) {
					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_FATAL,
											Messages.getString("FacturaManagedBean.2"), Messages.getString("FacturaManagedBean.3"))); //$NON-NLS-1$ //$NON-NLS-2$
				} catch (Exception e) {
					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_FATAL,
											Messages.getString("FacturaManagedBean.4"), Messages.getString("FacturaManagedBean.5") + e.getMessage())); //$NON-NLS-1$ //$NON-NLS-2$
				}
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										Messages.getString("FacturaManagedBean.6"), Messages.getString("FacturaManagedBean.7"))); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									Messages.getString("FacturaManagedBean.8"), Messages.getString("FacturaManagedBean.9"))); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

	/**
	 * @return the adendaService
	 */
	public IAdendaService getAdendaService() {
		return adendaService;
	}

	public List<FeDetalle> getDetalle() {

		if (!getEmitida()) {
			if (detalle == null)
				detalle = OBService.findDetalle(FacesContext
						.getCurrentInstance().getExternalContext()
						.getRequestParameterMap()
						.get(Messages.getString("FacturaManagedBean.10"))); //$NON-NLS-1$
		} else {
			detalle = facturaEmitida.getDetalle();
		}

		return detalle;
	}

	// public FacturaDTO getFactura() {
	// if (factura == null) {
	//
	//
	// System.out.println("############## Datos Factura ; " + factura);
	//
	// }
	// return factura;
	// }

	public List<FeDirFiscal> getDirFiscal() {

		if (!getEmitida()) {
			if (dirFiscal == null)
				dirFiscal = OBService.findDirFiscal(FacesContext
						.getCurrentInstance().getExternalContext()
						.getRequestParameterMap()
						.get(Messages.getString("FacturaManagedBean.11"))); //$NON-NLS-1$
		} else {
			dirFiscal = facturaEmitida.getDirFiscal();
		}
		return dirFiscal;

	}

	public List<FeDirReceptor> getDirReceptor() {

		if (!getEmitida()) {
			if (dirReceptor == null)
				dirReceptor = OBService.findDirReceptor(FacesContext
						.getCurrentInstance().getExternalContext()
						.getRequestParameterMap()
						.get(Messages.getString("FacturaManagedBean.12"))); //$NON-NLS-1$
		} else {
			dirReceptor = facturaEmitida.getDirReceptor();
		}
		return dirReceptor;
	}

	public boolean getEmitida() {

		if (emitida == null) {
			facturaEmitida = adendaService.getFacturaByID(FacesContext
					.getCurrentInstance().getExternalContext()
					.getRequestParameterMap()
					.get(Messages.getString("FacturaManagedBean.13"))); //$NON-NLS-1$

			if (facturaEmitida != null) {
				if (facturaEmitida.getEncabezado() != null
						&& facturaEmitida.getEncabezado().size() > 0) {
					FeEncabezado f = facturaEmitida.getEncabezado().get(0);
					if (f != null
							&& !Messages
									.getString("FacturaManagedBean.14").equals(f.getOb3id()) && f.getOb3id() != null) { //$NON-NLS-1$
						emitida = true;
					} else
						emitida = false;

				} else {
					emitida = false;
				}
			} else {
				emitida = false;
			}

		}

		return emitida;

	}

	public List<FeEncabezado> getEncabezado() {

		if (!getEmitida()) {
			if (encabezado == null)
				encabezado = OBService.findFactHeaderByID(FacesContext
						.getCurrentInstance().getExternalContext()
						.getRequestParameterMap()
						.get(Messages.getString("FacturaManagedBean.15"))); //$NON-NLS-1$
		} else {
			encabezado = facturaEmitida.getEncabezado();
		}

		return encabezado;
	}

	public List<FeLugarEntrega> getLugarEntrega() {

		if (!getEmitida()) {
			if (lugarEntrega == null)
				lugarEntrega = OBService.findLugarEntrega(FacesContext
						.getCurrentInstance().getExternalContext()
						.getRequestParameterMap()
						.get(Messages.getString("FacturaManagedBean.16"))); //$NON-NLS-1$
		} else {
			List<FeLugarEntrega> l = new ArrayList<FeLugarEntrega>();
			l.add(facturaEmitida.getLugarEntrega());
			lugarEntrega = l;
		}

		return lugarEntrega;
	}

	/**
	 * @return the oBService
	 */
	public IOBService getOBService() {
		return OBService;
	}

	/**
	 * @param adendaService
	 *            the adendaService to set
	 */
	public void setAdendaService(IAdendaService adendaService) {
		this.adendaService = adendaService;
	}

	/**
	 * @param oBService
	 *            the oBService to set
	 */
	public void setOBService(IOBService oBService) {
		OBService = oBService;
	}

}
