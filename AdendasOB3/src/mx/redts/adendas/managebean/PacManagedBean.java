package mx.redts.adendas.managebean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import mx.redts.adendas.service.IAdendaService;

/**
 * The Class LoginBean.
 */
@ManagedBean(name = "pacMB")
@RequestScoped
public class PacManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{AdendaService}")
	private IAdendaService adendaService;

	// public void exportXXXXXXXXXX() {
	//
	// String idOb3 =
	// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("f");
	//
	// FacturaDTO factura = adendaService.getFacturaByID(idOb3);
	// System.setProperty("line.separator", "\r\n");
	//
	// try {
	// File archivoPAC = new File(adendaService.getRepositorioAdendas() +
	// File.separator +
	// Common.generateFileNamePAC(factura.getDirReceptor().get(0).getNombreReceptorCliente()));
	// System.out.println("##################> Creando archivo.....");
	// FileWriter out = new FileWriter(archivoPAC);
	// // fw.write(str);
	//
	// // archivoPAC.createNewFile();
	// // BufferedWriter out = new BufferedWriter(new
	// // OutputStreamWriter(new FileOutputStream(archivoPAC),
	// // "ISO-8859-1"));
	//
	// try {
	//
	// out.write(factura.getEncabezado().toString());
	// out.write("\n\r");
	// out.write(factura.getDirFiscal().toString());
	// out.write("\n\r");
	// out.write(factura.getExpedidoEn().toString());
	// out.write("\n\r");
	// out.write(factura.getDirReceptor().toString());
	// out.write("\n\r");
	// out.write(factura.getLugarEntrega().toString());
	//
	// for (FeDetalle det : factura.getDetalle()) {
	// out.write("\n\r");
	// out.write(det.toString());
	// }
	//
	// out.write("\n\r");
	// out.write(factura.getSumario().toString());
	//
	// } finally {
	// out.close();
	// }
	//
	// // FileWriter fw = new FileWriter(archivoPAC);
	// // fw.write(contenido.toString());
	// // fw.close();
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Archivo Emitido"));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Error : " +
	// e.getMessage()));
	// }
	//
	// }

	/**
	 * @return the adendaService
	 */
	public IAdendaService getAdendaService() {
		return adendaService;
	}

	/**
	 * @param adendaService
	 *            the adendaService to set
	 */
	public void setAdendaService(IAdendaService adendaService) {
		this.adendaService = adendaService;
	}

}