package mx.redts.adendas.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import mx.redts.adendas.model.CClientes;
import mx.redts.adendas.model.COrganizacion;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.service.ICOrganizacionService;
import mx.redts.adendas.service.IClientesService;
import mx.redts.adendas.service.IOBService;

import org.springframework.dao.DataAccessException;

/**
 * 
 * User Managed Bean
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@ManagedBean(name = "consultasMB")
@RequestScoped
public class ConsultasManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{CorganizacionService}")
	ICOrganizacionService consultasOrgService;

	@ManagedProperty(value = "#{OBService}")
	IOBService OBService;

	private String tipoDoc;

	private String folio;
	List<COrganizacion> corganizacionList;
	private String cliente;
	private String clienteSeleccionado;
	private String orgSeleccionada;
	private Date fechaInicial;
	private Date fechaFinal;
	private List<CClientes> clientesList;
	@ManagedProperty(value = "#{CclientesService}")
	IClientesService consultaCliService;

	public List<COrganizacion> buscaFactura(ActionEvent actionEvent) {

		try {
			corganizacionList = new ArrayList<COrganizacion>();
			corganizacionList
					.addAll(consultasOrgService.getCOrganizacionList());
		} catch (DataAccessException e) {
			System.out
					.println(Messages.getString("ConsultasManagedBean.0") + e.getMessage()); //$NON-NLS-1$
			e.printStackTrace();
		}

		return corganizacionList;

	}

	public String getCliente() {
		return cliente;
	}

	public String getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public List<CClientes> getClientesList() {

		try {
			clientesList = new ArrayList<CClientes>();
			clientesList
					.add(new CClientes(
							1,
							Messages.getString("ConsultasManagedBean.1"), Messages.getString("ConsultasManagedBean.2"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							2,
							Messages.getString("ConsultasManagedBean.3"), Messages.getString("ConsultasManagedBean.4"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							3,
							Messages.getString("ConsultasManagedBean.5"), Messages.getString("ConsultasManagedBean.6"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							4,
							Messages.getString("ConsultasManagedBean.7"), Messages.getString("ConsultasManagedBean.8"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							5,
							Messages.getString("ConsultasManagedBean.9"), Messages.getString("ConsultasManagedBean.10"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							6,
							Messages.getString("ConsultasManagedBean.11"), Messages.getString("ConsultasManagedBean.12"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							7,
							Messages.getString("ConsultasManagedBean.13"), Messages.getString("ConsultasManagedBean.14"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							8,
							Messages.getString("ConsultasManagedBean.15"), Messages.getString("ConsultasManagedBean.16"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							9,
							Messages.getString("ConsultasManagedBean.17"), Messages.getString("ConsultasManagedBean.18"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							10,
							Messages.getString("ConsultasManagedBean.19"), Messages.getString("ConsultasManagedBean.20"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							11,
							Messages.getString("ConsultasManagedBean.21"), Messages.getString("ConsultasManagedBean.22"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							12,
							Messages.getString("ConsultasManagedBean.23"), Messages.getString("ConsultasManagedBean.24"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
					.add(new CClientes(
							12,
							Messages.getString("ConsultasManagedBean.25"), Messages.getString("ConsultasManagedBean.26"))); //$NON-NLS-1$ //$NON-NLS-2$
			clientesList
			.add(new CClientes(
					14,
					Messages.getString("ConsultasManagedBean.30"), Messages.getString("ConsultasManagedBean.31"))); //$NON-NLS-1$ //$NON-NLS-2$

			// clientesList.addAll(consultaCliService.getCClientesList());
		} catch (DataAccessException e) {
			System.out
					.println(Messages.getString("ConsultasManagedBean.27") + e.getMessage()); //$NON-NLS-1$
			e.printStackTrace();
		}
		return clientesList;
	}

	/**
	 * @return the consultaCliService
	 */
	public IClientesService getConsultaCliService() {
		return consultaCliService;
	}

	public ICOrganizacionService getConsultasOrgService() {
		return consultasOrgService;
	}

	public List<COrganizacion> getCOrganizacionList() {
		System.out.println(Messages.getString("ConsultasManagedBean.28")); //$NON-NLS-1$
		try {
			corganizacionList = new ArrayList<COrganizacion>();
			corganizacionList
					.addAll(consultasOrgService.getCOrganizacionList());
		} catch (DataAccessException e) {
			System.out
					.println(Messages.getString("ConsultasManagedBean.29") + e.getMessage()); //$NON-NLS-1$
			e.printStackTrace();
		}

		return corganizacionList;
	}

	public List<FeEncabezado> getFacturas() {

		return OBService
				.findFactHeaderBy(this.getOrgSeleccionada(),
						this.getClienteSeleccionado(), this.getFolio(),
						this.getTipoDoc(), this.getFechaInicial(),
						this.getFechaFinal());
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @return the oBService
	 */
	public IOBService getOBService() {
		return OBService;
	}

	public String getOrgSeleccionada() {
		return orgSeleccionada;
	}

	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc() {
		return tipoDoc;
	}

	/**
	 * Set User List
	 * 
	 * @param List
	 *            - User List
	 */

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setClienteSeleccionado(String clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}

	/**
	 * @param consultaCliService
	 *            the consultaCliService to set
	 */
	public void setConsultaCliService(IClientesService consultaCliService) {
		this.consultaCliService = consultaCliService;
	}

	/**
	 * @param consultasOrgService
	 *            the consultasOrgService to set
	 */
	public void setConsultasOrgService(ICOrganizacionService consultasOrgService) {
		this.consultasOrgService = consultasOrgService;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @param folio
	 *            the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @param oBService
	 *            the oBService to set
	 */
	public void setOBService(IOBService oBService) {
		this.OBService = oBService;
	}

	public void setOrganizacion(String organizacion) {
	}

	public void setOrgSeleccionada(String orgSeleccionada) {
		this.orgSeleccionada = orgSeleccionada;
	}

	/**
	 * @param tipoDoc
	 *            the tipoDoc to set
	 */
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

}
