package mx.redts.adendas.dao;

import mx.redts.simoc.model.entities.OcfileOriginal;

/**
 * 
 * User DAO Interface
 * 
 * @version 1.0.0
 * 
 */
public interface IOrdenesCompraDAO {

	public OcfileOriginal getXMLOC(String idOC);
}