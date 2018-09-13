package mx.redts.adendas.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeExpedidoEn;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;
import mx.redts.adendas.util.Common;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
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
public class OpenBravoDAO extends BaseDAO implements IOpenBravoDAO {

	// D
	public List<FeDetalle> findDetalle(String idob3) {
		System.out.println(Messages.getString("ObDAO802")); //$NON-NLS-1$
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeDetalle> ret = sesion
				.createSQLQuery(
						Messages.getString("ObDAO803") //$NON-NLS-1$
								+ Messages.getString("ObDAO804") //$NON-NLS-1$
								+ Messages.getString("ObDAO805") //$NON-NLS-1$
								+ Messages.getString("ObDAO806") //$NON-NLS-1$
								+ Messages.getString("ObDAO807") //$NON-NLS-1$
								+ Messages.getString("ObDAO808") //$NON-NLS-1$
								+ Messages.getString("ObDAO809") //$NON-NLS-1$
								+ Messages.getString("ObDAO810") //$NON-NLS-1$
								+ Messages.getString("ObDAO811") //$NON-NLS-1$
								+ Messages.getString("ObDAO812") //$NON-NLS-1$
								+ Messages.getString("ObDAO813") //$NON-NLS-1$
								+ Messages.getString("ObDAO814") //$NON-NLS-1$
								+ Messages.getString("ObDAO815") //$NON-NLS-1$
								+ Messages.getString("ObDAO816") //$NON-NLS-1$
								+ Messages.getString("ObDAO817") //$NON-NLS-1$
								+ Messages.getString("ObDAO818") //$NON-NLS-1$
								+ Messages.getString("ObDAO819") //$NON-NLS-1$
								+ Messages.getString("ObDAO820") //$NON-NLS-1$
								+ Messages.getString("ObDAO821") //$NON-NLS-1$
								+ Messages.getString("ObDAO822") //$NON-NLS-1$
								+ Messages.getString("ObDAO823") //$NON-NLS-1$
								+ Messages.getString("ObDAO824") //$NON-NLS-1$
								+ Messages.getString("ObDAO825") //$NON-NLS-1$
								+ Messages.getString("ObDAO826") + idob3 + Messages.getString("ObDAO827")) //$NON-NLS-1$ //$NON-NLS-2$
				.addScalar(Messages.getString("ObDAO828"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO829"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO830"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO831"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO832"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO833"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO834"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO835"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO836"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO837"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO838"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO839"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO840"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO841"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO842"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO843"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO844"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO845"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO846"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO847"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO848"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO849"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO850"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO851"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO852"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO853"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO854"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO855"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO856"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO857"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO858"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO859"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO860"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO861"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO862"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO863"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO864"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO865"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO866"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO867"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO868"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO869"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO870"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO871"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO872"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO873"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO874"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO875"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO876"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO877"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO878"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO879"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO880"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO881"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO882"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO883"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO884"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO885"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO886"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO887"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO888"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO889"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO890"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO891"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO892"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO893"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO894"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO895"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO896"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO897"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO898"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO899"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO900"), StringType.INSTANCE) //$NON-NLS-1$
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeDetalle.class))
				.list();

		sesion.close();

		return ret;

	}

	// H2
	public List<FeDirFiscal> findDirFiscal(String idob3) {
		System.out.println(Messages.getString("ObDAO611")); //$NON-NLS-1$
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeDirFiscal> ret = sesion
				.createSQLQuery(
						Messages.getString("ObDAO612") //$NON-NLS-1$
								+ Messages.getString("ObDAO613") //$NON-NLS-1$
								+ Messages.getString("ObDAO614") //$NON-NLS-1$
								+ Messages.getString("ObDAO615") //$NON-NLS-1$
								+ Messages.getString("ObDAO616") //$NON-NLS-1$
								+ Messages.getString("ObDAO617") //$NON-NLS-1$
								+ Messages.getString("ObDAO618") //$NON-NLS-1$
								+ Messages.getString("ObDAO619") //$NON-NLS-1$
								+ Messages.getString("ObDAO620") //$NON-NLS-1$
								+ Messages.getString("ObDAO621") //$NON-NLS-1$
								+ Messages.getString("ObDAO622") //$NON-NLS-1$
								+ Messages.getString("ObDAO623") //$NON-NLS-1$
								+ Messages.getString("ObDAO624") //$NON-NLS-1$
								+ Messages.getString("ObDAO625") //$NON-NLS-1$
								+ Messages.getString("ObDAO626") + idob3 + Messages.getString("ObDAO627")) //$NON-NLS-1$ //$NON-NLS-2$
				.addScalar(Messages.getString("ObDAO628"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO629"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO630"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO631"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO632"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO633"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO634"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO635"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO636"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO637"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO638"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO639"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO640"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO641"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO642"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO643"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO644"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO645"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO646"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO647"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO648"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO649"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO650"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO651"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO652"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO653"), StringType.INSTANCE) //$NON-NLS-1$
				.setMaxResults(1)
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeDirFiscal.class))
				.list();

		sesion.close();

		return ret;

	}

	// H4
	public List<FeDirReceptor> findDirReceptor(String idob3) {
		System.out.println(Messages.getString("ObDAO654")); //$NON-NLS-1$
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeDirReceptor> ret = sesion
				.createSQLQuery(
						Messages.getString("ObDAO655") //$NON-NLS-1$
								+ Messages.getString("ObDAO656") //$NON-NLS-1$
								+ Messages.getString("ObDAO657") //$NON-NLS-1$
								+ Messages.getString("ObDAO658") //$NON-NLS-1$
								+ Messages.getString("ObDAO659") //$NON-NLS-1$
								+ Messages.getString("ObDAO660") //$NON-NLS-1$
								+ Messages.getString("ObDAO661") //$NON-NLS-1$
								+ Messages.getString("ObDAO662") //$NON-NLS-1$
								+ Messages.getString("ObDAO663") //$NON-NLS-1$
								+ Messages.getString("ObDAO664") //$NON-NLS-1$
								+ Messages.getString("ObDAO665") //$NON-NLS-1$
								+ Messages.getString("ObDAO666") //$NON-NLS-1$
								+ Messages.getString("ObDAO667") //$NON-NLS-1$
								+ Messages.getString("ObDAO668") //$NON-NLS-1$
								+ Messages.getString("ObDAO669") + idob3 + Messages.getString("ObDAO670")) //$NON-NLS-1$ //$NON-NLS-2$
				.addScalar(Messages.getString("ObDAO671"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO672"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO673"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO674"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO675"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO676"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO677"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO678"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO679"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO680"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO681"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO682"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO683"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO684"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO685"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO686"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO687"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO688"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO689"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO690"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO691"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO692"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO693"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO694"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO695"), StringType.INSTANCE) //$NON-NLS-1$
				.setMaxResults(1)
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeDirReceptor.class))
				.list();

		sesion.close();

		return ret;

	}

	// H3
	public List<FeExpedidoEn> findExpedidoEn(String idob3) {
		 System.out.println("#############> Expedido en");
		 Session sesion = this.getSession();
		 @SuppressWarnings("unchecked")
		 List<FeExpedidoEn> retorna = sesion
		 .createSQLQuery(
		 "SELECT fact.c_invoice_id as ob3id, ' ' as nombreEmisorVende,' ' as rfc,' ' as gln, "
		 +
		 "'Autopista Chamapa - Lechería KM 2.5 Parque CPA Logistic Center ' as calle,' ' as noExterior, "
		 +
		 "'' as noInterior,'Edificio B-013 Plataforma J-1 ' as colonia,'' as localidad, "
		 +
		 "'' as referencia,'San Martín Obispo' as municipio,'Mexico' as estado,'Mexico' as pais,54769 as cp, "
		 +
		 "'' as regimenFiscalDelEmisor,'' as telefono,'' as etiqueta1, "
		 +
		 "'' as etiqueta2,'' as etiqueta3,'' as etiqueta4,'' as etiqueta5,'' as etiqueta6, "
		 +
		 "'' as etiqueta7,'' as etiqueta8,'' as noDeCuenta,'' as etiqueta10 "
		 +
		 "FROM c_invoice as fact,ad_org as org,ad_orginfo as orgi,c_location as loc,c_country as pais, "
		 + "c_region as region "
		 + "WHERE fact.ad_org_id=org.ad_org_id "
		 + "AND org.ad_org_id=orgi.ad_org_id "
		 + "AND orgi.c_location_id=loc.c_location_id "
		 + "AND loc.c_country_id=pais.c_country_id "
		 + "AND loc.c_region_id=region.c_region_id "
		 + "AND fact.c_invoice_id='" + idob3 + "'")
		 .addScalar("ob3id", StringType.INSTANCE)
		 .addScalar("nombreEmisorVende", StringType.INSTANCE)
		 .addScalar("rfc", StringType.INSTANCE)
		 .addScalar("gln", StringType.INSTANCE)
		 .addScalar("calle", StringType.INSTANCE)
		 .addScalar("noExterior", StringType.INSTANCE)
		 .addScalar("noInterior", StringType.INSTANCE)
		 .addScalar("colonia", StringType.INSTANCE)
		 .addScalar("localidad", StringType.INSTANCE)
		 .addScalar("referencia", StringType.INSTANCE)
		 .addScalar("municipio", StringType.INSTANCE)
		 .addScalar("estado", StringType.INSTANCE)
		 .addScalar("pais", StringType.INSTANCE)
		 .addScalar("cp", StringType.INSTANCE)
		 .addScalar("regimenFiscalDelEmisor", StringType.INSTANCE)
		 .addScalar("telefono", StringType.INSTANCE)
		 .addScalar("etiqueta1", StringType.INSTANCE)
		 .addScalar("etiqueta2", StringType.INSTANCE)
		 .addScalar("etiqueta3", StringType.INSTANCE)
		 .addScalar("etiqueta4", StringType.INSTANCE)
		 .addScalar("etiqueta5", StringType.INSTANCE)
		 .addScalar("etiqueta6", StringType.INSTANCE)
		 .addScalar("etiqueta7", StringType.INSTANCE)
		 .addScalar("etiqueta8", StringType.INSTANCE)
		 .addScalar("noDeCuenta", StringType.INSTANCE)
		 .addScalar("etiqueta10", StringType.INSTANCE)
		 .setMaxResults(1)
		 .setResultTransformer(
		 new AliasToBeanResultTransformer(FeExpedidoEn.class))
		 .list();
		
		 sesion.close();
		
		 return retorna;

	}

	@Override
	public List<FeEncabezado> findFactHeaderBy(String org, String cliente,
			String folio, String tipoDoc, Date fechaInicial, Date fechafinal) {
		System.out.println(Messages.getString("ObDAO533")); //$NON-NLS-1$
		Session sesion = this.getSession();
		String addWhere = Common.getStrEnc(Messages.getString("ObDAO534")); //$NON-NLS-1$
		SimpleDateFormat format = new SimpleDateFormat(
				Messages.getString("ObDAO535")); //$NON-NLS-1$

		if (folio != null && !Messages.getString("ObDAO536").equals(folio)) { //$NON-NLS-1$
			addWhere += Common.getStrEnc(Messages.getString("ObDAO537")) + folio //$NON-NLS-1$
					+ Messages.getString("ObDAO538"); //$NON-NLS-1$
		}

		/*if (tipoDoc != null && !Messages.getString("ObDAO539").equals(tipoDoc)) { //$NON-NLS-1$
			addWhere += Common.getStrEnc(Messages.getString("ObDAO540")) + tipoDoc + Messages.getString("ObDAO541"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			addWhere += Common.getStrEnc(Messages.getString("ObDAO542")); //$NON-NLS-1$

		}*/

		if (fechaInicial != null
				&& !Messages.getString("ObDAO543").equals(fechaInicial)) { //$NON-NLS-1$
			addWhere += Common.getStrEnc(Messages.getString("ObDAO544")) //$NON-NLS-1$
					+ format.format(fechaInicial)
					+ Messages.getString("ObDAO545"); //$NON-NLS-1$
		}

		if (fechafinal != null
				&& !Messages.getString("ObDAO546").equals(fechafinal)) { //$NON-NLS-1$
			addWhere += Common.getStrEnc(Messages.getString("ObDAO547")) //$NON-NLS-1$
					+ format.format(fechafinal)
					+ Messages.getString("ObDAO548"); //$NON-NLS-1$
		}

		if (org != null && !Messages.getString("ObDAO549").equals(org)) { //$NON-NLS-1$
			addWhere += Common.getStrEnc(Messages.getString("ObDAO550")) + org + Messages.getString("ObDAO551"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (cliente != null
				&& !Messages.getString("ObDAO552").equals(cliente) && !Messages.getString("OpenBravoDAO.478").equals(cliente)) { //$NON-NLS-1$ //$NON-NLS-2$
			addWhere += Common.getStrEnc(Messages.getString("ObDAO553")) + cliente + Messages.getString("ObDAO554"); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (Messages.getString("OpenBravoDAO.479").equals(cliente)) { //$NON-NLS-1$
			addWhere += Common
					.getStrEnc("QU5EIGZhY3QuY19icGFydG5lcl9pZCBub3QgaW4gKCcyOTcwM0RGODJCM0E0REFCQkRCRDRENDk2NEFDN0I2MCcsJzRDN0E0QkIyMkM1QjRBRjJCMEI1RkE4QzdDRjlEQzg4JywnQUEzMjNGNzJGQTA0NEJCRUJEQTk4M0E3QUFFNDU1RUUnLCdBOERGMTc0NzJDN0Y0RjUxOTc2NkJEM0JCMDIwRkJDOScsJ0YxOTJDOUVBMUNCNDQxRTRCMTYzMjcwNDQxMjk4ODdBJywnMkZCRUU1MEU4RjNDNEU2NUE2NzcyRDNBRjg5NDk3RDYnLCc5Q0Y1RENGQzEzMjI0NkZFQThDNUY4RDQ1NEY1OUJCOScsJzM0MjI2M0FEMjYwNTRGM0M4NjFFMUJDOUQ2RTU4NUNFJywnNzdFOEMxMjQwNUExNDVFMzhFQkEzMjM1RDYzRjUzOUMnLCc4NEFENzk5RjQwNTQ0REY5QTM0MUE5MkQxMTVGQUZCQicsJzI0ODBGODMwRkM0RDRDOEU4RTRFNDk2MDQ0QzMzNzgxJywnNEQ1MEZCMTYyNDM1NDk5N0E5NDIwNUUzMDg2QzA2RkQnKSA="); //$NON-NLS-1$ //$NON-NLS-2$

		} else {
			addWhere += Common.getStrEnc(Messages.getString("ObDAO555")); //$NON-NLS-1$
		}

		@SuppressWarnings("unchecked")
		List<FeEncabezado> ret = sesion
		.createSQLQuery(
						Common.getStrEnc(Messages.getString("ObDAO556")) //$NON-NLS-1$
								+ addWhere
								+ Common.getStrEnc(Messages
										.getString("ObDAO557"))) //$NON-NLS-1$

		
		.addScalar("cliid", StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO558"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO559"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO560"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO561"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO562"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO563"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO564"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO565"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO566"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO567"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO568"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO569"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO570"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO571"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO572"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO573"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO574"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO575"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO576"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO577"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO578"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO579"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO580"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO581"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO582"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO583"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO584"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO585"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO586"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO587"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO588"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO589"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO590"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO591"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO592"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO593"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO594"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO595"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO596"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO597"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO598"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO599"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO600"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO601"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO602"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO603"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO604"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO605"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO606"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO607"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO608"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO609"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO610"), StringType.INSTANCE) //$NON-NLS-1$
				.setMaxResults(100)
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeEncabezado.class))
				.list();

		sesion.close();

		return ret;

	}

	// H1
	/*public List<FeEncabezado> findFactHeaderByID(String idob3) {
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeEncabezado> ret = sesion
				.createSQLQuery(
						Common.getStrEnc(Messages.getString("ObDAO478")) + idob3 + Common.getStrEnc(Messages.getString("ObDAO479"))) //$NON-NLS-1$ //$NON-NLS-2$ */
	public List<FeEncabezado> findFactHeaderByID(String idob3) {
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeEncabezado> ret = sesion
				.createSQLQuery(
"SELECT fact.c_invoice_id ob3id, " 
+"SUBSTRING(fact.documentno,'[A-Z]+') as serie, "
+"substring(fact.documentno,'[0-9]+') as folio, "
+" '' as noAprobacion, "
+"to_char(fact.dateinvoiced,'YYYY-MM-DD')||'T'||to_char(fact.dateinvoiced,'HH24:MI:SS') as fechaCfd, "
+"CASE WHEN fact.c_bpartner_id='A8DF17472C7F4F519766BD3BB020FBC9' then fact.poreference||'-05' else fact.poreference end as referenciaDeDocume, "
+"to_char(fact.dateinvoiced,'YYYY-MM-DD')||'T'||to_char(fact.dateinvoiced,'HH24:MI:SS') as fechaReferenciaDe, "
+"'PAGO EN UNA SOLA EXHIBICION' as formaDePago,substring(pago.name,'[0-9]+') diasDePago,'ORIGINAL' as funcion, "
+"case when tipo.name similar to '%(AR Invoice|Factura Cliente Global)%' and fact.c_bpartner_id not like 'A8DF17472C7F4F519766BD3BB020FBC9' then 'FACTURA COMERCIAL' when tipo.name similar to '%(AR Invoice|Factura Cliente Global)%' and fact.c_bpartner_id='A8DF17472C7F4F519766BD3BB020FBC9' then 'FACTURA-01' when tipo.name='AR Credit Memo' OR tipo.name='Return Material Sales Invoice' OR tipo.name='AR Nota de Credito Global' OR tipo.name='Return Material Sales Invoice Global'  "
+"then 'NOTA DE CREDITO' when tipo.name='AR Debit Memo' OR tipo.name='AR Nota de Debito Global' then 'NOTA DE DEBITO' end as tipoDeDocumento, "
+"CASE WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' "
+"   THEN  '0' "
+"WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN '0' " //ID DE SAN FRANCISCO DE ASIS DESCUENTO 0
+"WHEN fact.c_bpartner_id= 'FE9506EAB612494798377809F6B9FAA9' THEN '0' " //ID HEMSA
+"WHEN fact.c_bpartner_id= '27158C23083F43C7A903EF82A223DF64' THEN '5' " //ID WALDOS
+"   ELSE '' "
+"END as porcenDescuento1,CASE WHEN fact.c_bpartner_id= 'FE9506EAB612494798377809F6B9FAA9' THEN '0'  WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN 'AJ' WHEN fact.c_bpartner_id= '27158C23083F43C7A903EF82A223DF64' THEN 'DISTRIBUCION'  ELSE '' END  as tipoDescuento1, case when fact.c_bpartner_id= '27158C23083F43C7A903EF82A223DF64' THEN ( SELECT factl.linenetamt*-1 from c_invoice as fact,c_invoiceline as factl where factl.c_invoice_id=fact.c_invoice_id and factl.c_invoice_discount_id is not null and fact.c_invoice_id='" + idob3 + "') else 0 end as montoDeDescuento1,CASE WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN '0' ELSE '' END as porcenDescuento2, "
+"CASE WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN 'AJ' ELSE '' END as tipoDescuento2,CASE WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN '0' ELSE '' END as montoDeDescuento2,CASE WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN '0' ELSE '' END  as porcenDescuento3,CASE WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN 'AJ' ELSE '' END as tipoDescuento3, "
+"CASE WHEN fact.c_bpartner_id= '56B50C94D2AE404E85092F711001E9F6' THEN '0' ELSE '' END as montoDeDescuento3,'' as anioAprobacion,case when fact.c_bpartner_id='A8DF17472C7F4F519766BD3BB020FBC9' then substring(fact.documentno,'[0-9]+')  else fact.documentno end as numeroInterno,'' as areaInterna, "
+"'' as representanteLegal, "
+"CASE WHEN fact.c_bpartner_id = '29703DF82B3A4DABBDBD4D4964AC7B60' " // WALMART
+"    THEN  split_part(fact.description, '~', 4) "
+"    WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' "  // HEB
+"    THEN  '8105' "
+"    WHEN fact.c_bpartner_id = '4C7A4BB22C5B4AF2B0B5FA8C7CF9DC88' " //CHEDRAUI
+"    THEN  '0000033225' "
+"     WHEN fact.c_bpartner_id = '9CF5DCFC132246FEA8C5F8D454F59BB9' "//COMERCIAL MEX
+"     THEN  '895497' "
+"     WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  '389486' " 
+"     WHEN fact.c_bpartner_id = '77E8C12405A145E38EBA3235D63F539C' "//FARM GUADALAJARA
+"     THEN  '1796' "
+"     WHEN fact.c_bpartner_id = '342263AD26054F3C861E1BC9D6E585CE' "//SUPER PRECIO
+"     THEN  '1000117' "
+"     WHEN fact.c_bpartner_id = 'AA323F72FA044BBEBDA983A7AAE455EE' "//COPPEL
+"     THEN  '37206' "
+"     WHEN fact.c_bpartner_id = '2480F830FC4D4C8E8E4E496044C33781' " //COTSCO
+"     THEN  '57222' "
+"     WHEN fact.c_bpartner_id = '56B50C94D2AE404E85092F711001E9F6' " //SAN FRANCISCO DE ASIS
+"     THEN  '191' "
+"     WHEN fact.c_bpartner_id = 'FE9506EAB612494798377809F6B9FAA9' " //HEMSA
+"     THEN  '3551' "
+"     WHEN fact.c_bpartner_id = '805F0FB2F9D143418A1941F3B8AA2962' " //CITYFRESKO
+"     THEN  '895497' "
+"     WHEN fact.c_bpartner_id = 'BECBAC91557E40F282B77E8D2C3B7F30' " //CALIMAX
+"     THEN  '101778' "
+"     WHEN fact.c_bpartner_id = 'A8DF17472C7F4F519766BD3BB020FBC9' " //CASA LEY
+"     THEN  '0001013060' "
+"   ELSE '' "
+"END as noProveedor, "
+"imp.rate as tasaGlobalDeIva, "
+"CASE WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' " //HEB
+"     THEN  '2160' "
+"     WHEN fact.c_bpartner_id = '4C7A4BB22C5B4AF2B0B5FA8C7CF9DC88' " //CHEDRAUI
+"     THEN  '00402' "
+"     WHEN fact.c_bpartner_id = '9CF5DCFC132246FEA8C5F8D454F59BB9' "//COMERCIAL MEX
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  '5542' "
+"     WHEN fact.c_bpartner_id = '77E8C12405A145E38EBA3235D63F539C' " //FARM GUADALAJARA
+"     THEN  '99' "
+"     WHEN fact.c_bpartner_id = '342263AD26054F3C861E1BC9D6E585CE' "//SUPER PRECIO
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = 'AA323F72FA044BBEBDA983A7AAE455EE' "//COPPEL
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '2480F830FC4D4C8E8E4E496044C33781' "//COTSCO
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '56B50C94D2AE404E85092F711001E9F6' "//SAN FRANCISCO DE ASIS
+"     THEN  '31' "
+"     WHEN fact.c_bpartner_id = '805F0FB2F9D143418A1941F3B8AA2962' "//CITY FRESKO
+"     THEN  '280' "
+"     WHEN fact.c_bpartner_id = 'A8DF17472C7F4F519766BD3BB020FBC9' "//CASA LEY
+"     THEN  '4080' "
+"   ELSE '' "
+"END as numeroDeTienda, "
+"CASE WHEN fact.c_bpartner_id='56B50C94D2AE404E85092F711001E9F6' then '0' WHEN fact.c_bpartner_id = 'A8DF17472C7F4F519766BD3BB020FBC9' then lpad(CAST(fact.poreference AS TEXT), 10, '0')  else '' end as frm,case when fact.c_bpartner_id='A8DF17472C7F4F519766BD3BB020FBC9' then to_char(fact.dateinvoiced,'YYYY-MM-DD')||'T'||to_char(fact.dateinvoiced,'HH24:MI:SS') else '' end as fechaDeFrm, " //SAN FRANCISCO DE ASIS 0 //casa ley oc
+"CASE WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' "//HEB
+"    THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = '4C7A4BB22C5B4AF2B0B5FA8C7CF9DC88' "//CHEDRAUI
+"     THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = '9CF5DCFC132246FEA8C5F8D454F59BB9' "//COMERCIAL MEX
+"     THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = '77E8C12405A145E38EBA3235D63F539C' "//FARM GUADALAJARA
+"     THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = '342263AD26054F3C861E1BC9D6E585CE' "//SUPER PRECIO
+"     THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = 'AA323F72FA044BBEBDA983A7AAE455EE' "//COPPEL
+"     THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = '2480F830FC4D4C8E8E4E496044C33781' "//COTSCO
+"    THEN  'EDO DE MEXICO' "
+"     WHEN fact.c_bpartner_id = 'FE9506EAB612494798377809F6B9FAA9' "//HEMSA
+"    THEN  'MEXICO DF' "
+"     WHEN fact.c_bpartner_id = '56B50C94D2AE404E85092F711001E9F6' " //SAN FRANCISCO DE ASIS
+"    THEN 'MEXICO DF' "
+"     WHEN fact.c_bpartner_id = '805F0FB2F9D143418A1941F3B8AA2962' " //CITY FRESKO
+"    THEN 'MEXICO DF' "
+"   ELSE coun.name "
+"END as lugarDeExpedicion,CASE WHEN substring(metodo.name,'[0-9]+')  is null then replace(metodo.name,'-','') else split_part(metodo.name,'-',1) end as metodoDePago, "
+"CASE WHEN fact.c_bpartner_id='FE9506EAB612494798377809F6B9FAA9' then 'PESOS' else curr.iso_code end as moneda,case when fact.c_bpartner_id='FE9506EAB612494798377809F6B9FAA9' then '1' else '' end as tipoDeCambio,'' as fechaDeEntregaAct, CASE WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' " //HEB
+"    THEN  'ALFONSO CORTES' "
+"     WHEN fact.c_bpartner_id = '4C7A4BB22C5B4AF2B0B5FA8C7CF9DC88' "//CHEDRAUI
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '9CF5DCFC132246FEA8C5F8D454F59BB9' "//COMERCIAL MEX
+"     THEN  '' " 
+"     WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '77E8C12405A145E38EBA3235D63F539C' "//FARM GUADALAJARA
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '342263AD26054F3C861E1BC9D6E585CE' "//SUPER PRECIO
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = 'AA323F72FA044BBEBDA983A7AAE455EE' "//COPPEL
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '2480F830FC4D4C8E8E4E496044C33781' "//COTSCO
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '56B50C94D2AE404E85092F711001E9F6' "//SAN FRANCISCO DE ASIS
+"     THEN  'ERIC FRANCISCO MONTERO AVILA' "
+"     WHEN fact.c_bpartner_id = 'A8DF17472C7F4F519766BD3BB020FBC9' "//CASA LEY
+"     THEN  'URIEL CRUZ PENA CERVANTES' "
+"   ELSE '' "
+"END as contactoDeCompras, "
+" CASE WHEN fact.c_bpartner_id = '29703DF82B3A4DABBDBD4D4964AC7B60' "
+"     THEN  split_part(fact.description, '~', 3) "
+"     WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' "//HEB
+"     THEN  '99' "
+"     WHEN fact.c_bpartner_id = '4C7A4BB22C5B4AF2B0B5FA8C7CF9DC88' "//CHEDRAUI
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '9CF5DCFC132246FEA8C5F8D454F59BB9' "//COMERCIAL MEX
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '77E8C12405A145E38EBA3235D63F539C' "//FARM GUADALAJARA
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '342263AD26054F3C861E1BC9D6E585CE' "//SUPER PRECIO
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = 'AA323F72FA044BBEBDA983A7AAE455EE' "//COPPEL
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '2480F830FC4D4C8E8E4E496044C33781' "//COTSCO
+"     THEN  '20' "
+"     WHEN fact.c_bpartner_id = '56B50C94D2AE404E85092F711001E9F6' "//SAN FRANCISCO DE ASIS
+"     THEN  '1' "
+"     WHEN fact.c_bpartner_id = 'FE9506EAB612494798377809F6B9FAA9' "//HEMSA
+"     THEN  '97' "
+"     WHEN fact.c_bpartner_id='805F0FB2F9D143418A1941F3B8AA2962' then split_part(fact.description, '~', 3) " //CITY FRESKO
+"   ELSE '' "
+"END as departamentoDelCon,'' as observaciones1come,'' as observaciones2come,'' as observaciones3come, "
+"'' as observaciones4come,'' as observaciones5come,'' as noAvisoAnticipado,'' as fechaAvisoAnticipa, "
+"fact.grandtotal as importeConLetra,'' as tipoImpresion,'P' as tipoDeEnvio,'' as codigoIeps, "
+"CASE WHEN fact.c_bpartner_id = 'F192C9EA1CB441E4B16327044129887A' "//HEB
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '4C7A4BB22C5B4AF2B0B5FA8C7CF9DC88' " //CHEDRAUI
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '9CF5DCFC132246FEA8C5F8D454F59BB9' "//COMERCIAL MEX
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  '1' "
+"     WHEN fact.c_bpartner_id = '77E8C12405A145E38EBA3235D63F539C' "//FARM GUADALAJARA
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = '342263AD26054F3C861E1BC9D6E585CE' "//SUPER PRECIO
+"     THEN  '1' "
+"     WHEN fact.c_bpartner_id = 'AA323F72FA044BBEBDA983A7AAE455EE' "//COPPEL
+"     THEN  '2' "
+"     WHEN fact.c_bpartner_id = '2480F830FC4D4C8E8E4E496044C33781' "//COTSCO
+"     THEN  '' "
+"     WHEN fact.c_bpartner_id = 'FE9506EAB612494798377809F6B9FAA9' "//HEMSA
+"     THEN  'DI' "	
+"   ELSE '' "
+"END as etiqueta1, "
+"CASE WHEN fact.c_bpartner_id = '2FBEE50E8F3C4E65A6772D3AF89497D6' "//SORIANA
+"     THEN  (SELECT sum(factline.qtyinvoiced) FROM c_invoiceline as factline WHERE   factline.c_invoice_id=fact.c_invoice_id) "
+"   ELSE 0 "
+"END as etiqueta2,'' as etiqueta3,'' as etiqueta4,'' as etiqueta5, "
+" CASE  WHEN fact.c_bpartner_id = 'BECBAC91557E40F282B77E8D2C3B7F30' THEN 'P' else '' end as etiqueta6 "  //CALIMAX
+" FROM c_invoice as fact,c_bpartner as cli,c_paymentterm as pago,c_doctype as tipo,c_invoicetax as factax, "
+"c_tax as imp,ad_org as org,ad_orginfo as orgi,c_location as loc,c_country as coun, "
+"fin_paymentmethod as metodo,c_currency as curr , c_doctype doctype "
+"WHERE "
+"fact.c_paymentterm_id=pago.c_paymentterm_id AND fact.c_bpartner_id=cli.c_bpartner_id "
+"AND fact.c_doctype_id=tipo.c_doctype_id  "
+"AND factax.c_invoice_id=fact.c_invoice_id "
+"AND factax.c_tax_id=imp.c_tax_id "
+"AND fact.ad_org_id=org.ad_org_id "
+"AND org.ad_org_id=orgi.ad_org_id "
+"AND orgi.c_location_id=loc.c_location_id "
+"AND loc.c_country_id=coun.c_country_id "
+"AND fact.fin_paymentmethod_id=metodo.fin_paymentmethod_id "
+"AND fact.c_currency_id=curr.c_currency_id "
+"AND TRIM(fact.docstatus) = 'CO' "
+"AND tipo.name in ('AR Invoice', 'AR Credit Memo', 'Return Material Sales Invoice','AR Debit Memo','Factura Cliente Global','AR Nota de Credito Global','Return Material Sales Invoice Global' ) "
+"AND doctype.c_doctype_id = fact.c_doctype_id "
+"AND fact.c_invoice_id='" + idob3 + "'")
	
				.addScalar(Messages.getString("ObDAO480"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO481"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO482"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO483"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO484"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO485"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO486"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO487"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO488"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO489"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO490"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO491"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO492"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO493"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO494"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO495"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO496"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO497"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO498"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO499"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO500"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO501"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO502"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO503"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO504"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO505"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO506"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO507"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO508"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO509"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO510"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO511"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO512"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO513"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO514"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO515"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO516"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO517"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO518"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO519"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO520"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO521"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO522"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO523"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO524"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO525"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO526"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO527"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO528"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO529"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO530"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO531"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO532"), StringType.INSTANCE) //$NON-NLS-1$ 
				.setMaxResults(1)
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeEncabezado.class))
				.list();

		sesion.close();

		return ret;

	}

	// H5
	public List<FeLugarEntrega> findLugarEntrega(String idob3) {
		System.out.println(Messages.getString("ObDAO696")); //$NON-NLS-1$
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeLugarEntrega> ret = sesion
				.createSQLQuery(
						Messages.getString("ObDAO697") + //$NON-NLS-1$
								Messages.getString("ObDAO698") + //$NON-NLS-1$
								Messages.getString("ObDAO699") + //$NON-NLS-1$
								Messages.getString("ObDAO700") + //$NON-NLS-1$
								Messages.getString("ObDAO701") + //$NON-NLS-1$
								Messages.getString("ObDAO702") + //$NON-NLS-1$
								Messages.getString("ObDAO703") + //$NON-NLS-1$
								Messages.getString("ObDAO704") + //$NON-NLS-1$
								Messages.getString("ObDAO705") + //$NON-NLS-1$
								Messages.getString("ObDAO706") + //$NON-NLS-1$
								Messages.getString("ObDAO707") + //$NON-NLS-1$
								Messages.getString("ObDAO708") + //$NON-NLS-1$
								Messages.getString("ObDAO709") + //$NON-NLS-1$
								Messages.getString("ObDAO710") + //$NON-NLS-1$
								Messages.getString("ObDAO711") + //$NON-NLS-1$
								Messages.getString("ObDAO712") + //$NON-NLS-1$
								Messages.getString("ObDAO713") + //$NON-NLS-1$
								Messages.getString("ObDAO714") + //$NON-NLS-1$
								Messages.getString("ObDAO715") + idob3 + Messages.getString("ObDAO716")) //$NON-NLS-1$ //$NON-NLS-2$
				.addScalar(Messages.getString("ObDAO717"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO718"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO719"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO720"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO721"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO722"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO723"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO724"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO725"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO726"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO727"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO728"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO729"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO730"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO731"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO732"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO733"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO734"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO735"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO736"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO737"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO738"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO739"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO740"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO741"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO742"), StringType.INSTANCE) //$NON-NLS-1$

				.setMaxResults(1)
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeLugarEntrega.class))
				.list();

		sesion.close();

		return ret;

	}

	// H5
	public List<FeSumario> findSumario(String idob3) {
		System.out.println(Messages.getString("ObDAO743")); //$NON-NLS-1$
		Session sesion = this.getSession();
		@SuppressWarnings("unchecked")
		List<FeSumario> ret = sesion
				.createSQLQuery(Messages.getString("ObDAO744") + idob3  //$NON-NLS-1$
						+ Messages.getString("jjfarias") //$NON-NLS-1$
						+ Messages.getString("ObDAO745") //$NON-NLS-1$
						+ Messages.getString("ObDAO746")+idob3 //$NON-NLS-1$
						+ Messages.getString("jjfarias1") //$NON-NLS-1$
						+ Messages.getString("ObDAO747") //$NON-NLS-1$
						+ Messages.getString("ObDAO748") //$NON-NLS-1$
						+ Messages.getString("ObDAO749") //$NON-NLS-1$
						+ Messages.getString("ObDAO750") //$NON-NLS-1$
						+ Messages.getString("ObDAO751") //$NON-NLS-1$
						+ Messages.getString("ObDAO752") //$NON-NLS-1$
						+ Messages.getString("ObDAO753") +idob3 //$NON-NLS-1$
						+ Messages.getString("jjfarias2")+idob3 //$NON-NLS-1$
						+ Messages.getString("jjfarias3") //$NON-NLS-1$
						+ Messages.getString("ObDAO754") //$NON-NLS-1$
						+ Messages.getString("ObDAO755") //$NON-NLS-1$
						+ Messages.getString("ObDAO756") //$NON-NLS-1$
						+ Messages.getString("ObDAO757") //$NON-NLS-1$
						+ Messages.getString("ObDAO758") //$NON-NLS-1$
						+ Messages.getString("ObDAO759") //$NON-NLS-1$
						+ idob3 + Messages.getString("ObDAO760") //$NON-NLS-1$
						+ Messages.getString("ObDAO761")) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO762"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO763"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO764"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO765"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO766"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO767"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO768"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO769"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO770"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO771"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO772"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO773"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO774"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO775"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO776"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO777"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO778"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO779"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO780"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO781"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO782"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO783"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO784"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO785"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO786"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO787"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO788"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO789"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO790"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO791"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO792"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO793"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO794"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO795"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO796"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO797"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO798"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO799"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO800"), StringType.INSTANCE) //$NON-NLS-1$
				.addScalar(Messages.getString("ObDAO801"), StringType.INSTANCE) //$NON-NLS-1$
				.setMaxResults(1)
				.setResultTransformer(
						new AliasToBeanResultTransformer(FeSumario.class))
				.list();

		sesion.close();

		return ret;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getFacturas() {
		// TODO Auto-generated method stub

		// Obten encabezados
		// con.prepareStatement(sql)
		// Obten direccion fiscal
		// Obten direccion expedido en
		// Obten direccion receptor
		// Obten direccion lugar de entrega
		// Obten Detalle
		// Obten Sumario

		return null;
	}

}