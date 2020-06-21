package pageFile;

import java.io.Serializable;

public class bean implements Serializable {

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private static final long serialVersionUID = 1L;
	private String orderId = null;

	private static bean myobj = null;

	public static bean getInstance() {
		if (myobj == null) {
			myobj = new bean();
		}
		return myobj;
	}

	public bean() {
	}

}
