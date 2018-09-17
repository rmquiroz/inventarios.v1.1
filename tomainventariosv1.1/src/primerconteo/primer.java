package primerconteo;

public class primer {
	
	private String Codigo;
	private String Cantidad;
	private String Marbete;

	public primer(String Codigo, String Cantidad,String Marbete ) {

		this.Codigo = Codigo;
		this.Cantidad = Cantidad;
		this.Marbete = Marbete;

	}
	
	public primer() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String Codigo) {
		this.Codigo = Codigo;
	}
	
	
	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String Cantidad) {
		this.Cantidad = Cantidad;
	}
	
	public String getMarbete() {
		return Marbete;
	}

	public void setMarbete(String Marbete) {
		this.Marbete = Marbete;
	}
	
}
