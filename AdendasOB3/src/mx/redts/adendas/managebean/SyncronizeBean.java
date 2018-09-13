package mx.redts.adendas.managebean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * The Class LoginBean.
 */
@ManagedBean(name = "syncMBean")
@RequestScoped
public class SyncronizeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean sync = false;

	public boolean getSincronizaOB3() {
		return sync;
	}

	public void setSincronizaOB3(boolean proc) {

		sync = true;
	}

}