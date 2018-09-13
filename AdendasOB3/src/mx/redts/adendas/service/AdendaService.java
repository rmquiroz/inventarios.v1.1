package mx.redts.adendas.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
import mx.redts.adendas.util.Common;

/**
 * 
 * User Service
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
public class AdendaService implements IAdendaService {

	private IAdendaDAO adendaDAO;
	private String repositorioAdendas;

	@Override
	public boolean existeFacturaByID(String id) {
		// TODO Auto-generated method stub
		return adendaDAO.existeFacturaByID(id);
	}

	public void exportaFactura(List<FeEncabezado> encabezado,
			List<FeLugarEntrega> lugarEntrega, List<FeSumario> sumario,
			List<FeDirReceptor> dirReceptor, List<FeDirFiscal> dirFiscal,
			List<FeDetalle> detalle) throws AdendaException {

		if (encabezado != null && encabezado.size() > 0) {

			try {

				String idOb3 = encabezado.get(0).getOb3id();

				// TODO Auto-generated method stub

				System.out
						.println(Messages.getString("AdendaService.0") + idOb3); //$NON-NLS-1$

				FeDirFiscal fdirfisc = dirFiscal.get(0);

				if (Messages
						.getString("AdendaService.1").equals(dirReceptor.get(0).getNombreReceptorCliente().toUpperCase())) { //$NON-NLS-1$
					fdirfisc.setGln(Messages.getString("AdendaService.2")); //$NON-NLS-1$
				}

				dirFiscal.set(0, fdirfisc);

				FacturaDTO factura = new FacturaDTO(
						encabezado,
						dirFiscal,
						dirReceptor,
						null,
						(lugarEntrega != null && lugarEntrega.size() > 0 ? lugarEntrega
								.get(0) : null), (sumario != null
								&& sumario.size() > 0 ? sumario.get(0) : null),
						detalle);

				// FacturaDTO factura = getFacturaByID(idOb3);
				StringBuilder contenido = new StringBuilder();

				contenido
						.append(factura.getEncabezado().get(0))
						.append(Messages.getString("AdendaService.3")).append(factura.getDirFiscal().get(0)).append(Messages.getString("AdendaService.4")).append(factura.getExpedidoEn()).append(Messages.getString("AdendaService.5")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						.append(factura.getDirReceptor().get(0))
						.append(Messages.getString("AdendaService.6")).append(factura.getLugarEntrega()).append(Messages.getString("AdendaService.7")); //$NON-NLS-1$ //$NON-NLS-2$

				for (FeDetalle det : factura.getDetalle())
					contenido.append(det).append(
							Messages.getString("AdendaService.8")); //$NON-NLS-1$

				contenido.append(factura.getSumario());

				String nomOrgDir = factura
						.getDirFiscal()
						.get(0)
						.getNombreEmisorVende()
						.toUpperCase()
						.replaceAll(
								Messages.getString("AdendaService.9"), Messages.getString("AdendaService.10")).replaceAll(Messages.getString("AdendaService.11"), Messages.getString("AdendaService.12")).replaceAll(Messages.getString("AdendaService.13"), Messages.getString("AdendaService.14")).replaceAll(Messages.getString("AdendaService.15"), Messages.getString("AdendaService.16")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
						.replaceAll(
								Messages.getString("AdendaService.17"), Messages.getString("AdendaService.18")).replaceAll(Messages.getString("AdendaService.19"), Messages.getString("AdendaService.20")).replaceAll(Messages.getString("AdendaService.21"), Messages.getString("AdendaService.22")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$

				// -- Previo
				File dirRepo = new File(getRepositorioAdendas()
						+ File.separator + nomOrgDir);
				if (!dirRepo.exists())
					dirRepo.mkdirs();

				if (dirRepo.isDirectory() && dirRepo.canWrite()) {

					// -- Previo

					File archivoPAC = new File(dirRepo.getAbsolutePath()
							+ File.separator
							+ Common.generateFileNamePAC(factura
									.getDirReceptor().get(0)
									.getNombreReceptorCliente()));

					archivoPAC.createNewFile();
					FileWriter fw = new FileWriter(archivoPAC);
					fw.write(contenido.toString());
					fw.close();

					adendaDAO
							.saveFactura(
									(encabezado != null
											&& encabezado.size() > 0 ? encabezado
											.get(0) : null),
									(dirReceptor != null
											&& dirReceptor.size() > 0 ? dirReceptor
											.get(0) : null),
									(dirFiscal != null && dirFiscal.size() > 0 ? dirFiscal
											.get(0) : null),
									null,
									(lugarEntrega != null
											&& lugarEntrega.size() > 0 ? lugarEntrega
											.get(0) : null),
									(sumario != null && sumario.size() > 0 ? sumario
											.get(0) : null), detalle);

				} else {
					throw new AdendaException(
							Messages.getString("AdendaService.23") + dirRepo); //$NON-NLS-1$
				}
			} catch (AdendaException e) {
				e.printStackTrace();

				throw e;
			} catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
				throw new AdendaException(
						Messages.getString("AdendaService.24") + e.getMessage()); //$NON-NLS-1$
			} finally {

			}
		} else {
			throw new AdendaException(Messages.getString("AdendaService.25")); //$NON-NLS-1$
		}

	}

	/**
	 * @return the adendaDAO
	 */
	public IAdendaDAO getAdendaDAO() {
		return adendaDAO;
	}

	@Override
	public FacturaDTO getFacturaByID(String id) {
		// TODO Auto-generated method stub

		System.out.println(Messages.getString("AdendaService.26") + id); //$NON-NLS-1$
		// return null;
		ArrayList<FeEncabezado> e = new ArrayList<FeEncabezado>();
		ArrayList<FeDirFiscal> f = new ArrayList<FeDirFiscal>();
		ArrayList<FeDirReceptor> r = new ArrayList<FeDirReceptor>();
		e.add(adendaDAO.consultaEncabezadoByID(id));
		f.add(adendaDAO.consultaDirFiscalByID(id));
		r.add(adendaDAO.consultaDirReceptorByID(id));
		return new FacturaDTO(e, f, r, adendaDAO.consultaExpedidaEnByID(id),
				adendaDAO.consultaLugarEntregaByID(id),
				adendaDAO.consultaSumarioByID(id),
				adendaDAO.consultaDetalleByID(id));

	}

	/**
	 * @return the repositorioAdendas
	 */
	public String getRepositorioAdendas() {
		return repositorioAdendas;
	}

	// @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// public void saveFactura(FeEncabezado encabezado, FeDirReceptor receptor,
	// FeDirFiscal dirFiscal, FeExpedidoEn expedido, FeLugarEntrega lugar,
	// FeSumario sumario, List<FeDetalle> detalle) {
	// // TODO Auto-generated method stub
	// adendaDAO.saveFactura(encabezado, receptor, dirFiscal, expedido, lugar,
	// sumario, detalle);
	// }

	/**
	 * @param adendaDAO
	 *            the adendaDAO to set
	 */
	public void setAdendaDAO(IAdendaDAO adendaDAO) {
		this.adendaDAO = adendaDAO;
	}

	/**
	 * @param repositorioAdendas
	 *            the repositorioAdendas to set
	 */
	public void setRepositorioAdendas(String repositorioAdendas) {
		this.repositorioAdendas = repositorioAdendas;
	}

}