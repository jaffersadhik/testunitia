package test;

import java.util.Map;

import com.cloudhopper.commons.util.windowing.WindowFuture;
import com.cloudhopper.smpp.pdu.PduRequest;
import com.cloudhopper.smpp.pdu.PduResponse;


public class MTTempBean {
	
	WindowFuture<Integer, PduRequest, PduResponse> future;
	Handler eventHandler;
	Map<String, Object> dnMap;
	
	public WindowFuture<Integer, PduRequest, PduResponse> getFuture() {
		return future;
	}
	public void setFuture(WindowFuture<Integer, PduRequest, PduResponse> future) {
		this.future = future;
	}
	public Handler getEventHandler() {
		return eventHandler;
	}
	public void setEventHandler(Handler eventHandler) {
		this.eventHandler = eventHandler;
	}
	public Map<String, Object> getMTMap() {
		return dnMap;
	}
	public void setMTMap(Map<String, Object> dnMap) {
		this.dnMap = dnMap;
	}
	@Override
	public String toString() {
		return "DNTempBean [future=" + future + ", eventHandler="
				+ eventHandler + ", dnMap=" + dnMap + "]";
	}

}
