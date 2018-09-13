package mx.redts.adendas.dao;

import mx.redts.simoc.model.entities.OcfileOriginal;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 * 
 * OpenBravoDAO
 * 
 * @author Andres Cabrera
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
public class OrdenesCompraDAO extends BaseDAO implements IOrdenesCompraDAO {

	// Obtiene Orden de Compra
	public OcfileOriginal getXMLOC(String idOC) {
		System.out.println("####> Obteniendo Datos de Orden de Compra"); //$NON-NLS-1$
		Session sesion = this.getSession();
		OcfileOriginal ret = (OcfileOriginal) sesion
				.createSQLQuery(Messages.getString("OrdenesCompraDAO.0") //$NON-NLS-1$
						+ idOC + "' and estatus_orden_compra = 'OC Cargada')").addScalar(Messages.getString("OrdenesCompraDAO.1"), IntegerType.INSTANCE) //$NON-NLS-1$ //$NON-NLS-2$
				.addScalar(
						Messages.getString("OrdenesCompraDAO.2"), StringType.INSTANCE).setResultTransformer(new AliasToBeanResultTransformer(OcfileOriginal.class)).uniqueResult(); //$NON-NLS-1$

		sesion.close();

		return ret;

	}

}