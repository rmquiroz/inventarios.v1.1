package mx.redts.adendas.dto;

import java.util.ArrayList;
import java.util.List;

import mx.redts.adendas.model.FeDetalle;
import mx.redts.adendas.model.FeDirFiscal;
import mx.redts.adendas.model.FeDirReceptor;
import mx.redts.adendas.model.FeEncabezado;
import mx.redts.adendas.model.FeExpedidoEn;
import mx.redts.adendas.model.FeLugarEntrega;
import mx.redts.adendas.model.FeSumario;

public class FacturaDTO {

	private List<FeEncabezado> encabezado;
	private List<FeDirFiscal> dirFiscal;
	private List<FeDirReceptor> dirReceptor;
	private FeExpedidoEn expedidoEn;
	private FeLugarEntrega lugarEntrega;
	private FeSumario sumario;
	private List<FeDetalle> detalle;

	public FacturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public FacturaDTO(List<FeEncabezado> encabezado,
			List<FeDirFiscal> dirFiscal, List<FeDirReceptor> dirReceptor,
			FeExpedidoEn expedidoEn, FeLugarEntrega lugarEntrega,
			FeSumario sumario, List<FeDetalle> detalle) {
		super();
		this.encabezado = encabezado;
		this.dirFiscal = dirFiscal;
		this.dirReceptor = dirReceptor;
		this.expedidoEn = expedidoEn;
		this.lugarEntrega = lugarEntrega;
		this.sumario = sumario;
		this.detalle = detalle;
	}

	public List<FeDetalle> getDetalle() {
		return (detalle == null ? new ArrayList<FeDetalle>() : detalle);
	}

	public List<FeDirFiscal> getDirFiscal() {
		return (dirFiscal == null ? new ArrayList<FeDirFiscal>() : dirFiscal);
	}

	public List<FeDirReceptor> getDirReceptor() {
		return (dirReceptor == null ? new ArrayList<FeDirReceptor>()
				: dirReceptor);
	}

	public List<FeEncabezado> getEncabezado() {
		return (encabezado == null ? new ArrayList<FeEncabezado>() : encabezado);
	}

	public FeExpedidoEn getExpedidoEn() {
		return (expedidoEn == null ? new FeExpedidoEn() : expedidoEn);
	}

	public FeLugarEntrega getLugarEntrega() {
		return (lugarEntrega == null ? new FeLugarEntrega() : lugarEntrega);
	}

	public FeSumario getSumario() {
		return (sumario == null ? new FeSumario() : sumario);
	}

	public void setDetalle(List<FeDetalle> detalle) {
		this.detalle = detalle;
	}

	public void setDirFiscal(List<FeDirFiscal> dirFiscal2) {
		this.dirFiscal = dirFiscal2;
	}

	public void setDirReceptor(List<FeDirReceptor> dirReceptor2) {
		this.dirReceptor = dirReceptor2;
	}

	public void setEncabezado(List<FeEncabezado> encabezado2) {
		this.encabezado = encabezado2;
	}

	public void setExpedidoEn(FeExpedidoEn expedidoEn) {
		this.expedidoEn = expedidoEn;
	}

	public void setLugarEntrega(FeLugarEntrega lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}

	public void setSumario(FeSumario sumario) {
		this.sumario = sumario;
	}

}
