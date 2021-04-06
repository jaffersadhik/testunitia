package test;

import java.util.HashMap;

import com.cloudhopper.smpp.SmppBindType;
import com.cloudhopper.smpp.SmppClient;
import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.SmppSessionConfiguration;
import com.cloudhopper.smpp.impl.DefaultSmppClient;
import com.cloudhopper.smpp.type.SmppBindException;
import com.cloudhopper.smpp.type.SmppChannelException;
import com.cloudhopper.smpp.type.SmppTimeoutException;
import com.cloudhopper.smpp.type.UnrecoverablePduException;


public class SC1 {

	public static void main(String args[]){
		
		SmppClient client=new DefaultSmppClient();
		
		SmppSessionConfiguration config=new SmppSessionConfiguration();
		config.setHost("Unitia-8042041824a6b544.elb.ap-south-1.amazonaws.com");
		config.setPassword("jaffer");
		config.setPort(2775);
		config.setSystemId("jaffer");
		config.setRequestExpiryTimeout(30000);
		config.setBindTimeout(30000);
		config.setConnectTimeout(30000);
		config.setWindowSize(10);
		config.setType(SmppBindType.TRANSCEIVER);
		SmppSession session=null;
		
		Handler handler=new Handler("queuename","smscid","systemid","kannelid");
		
		
		try {
			session=client.bind(config,handler );
			new MTWorker().sendMessage(session, new HashMap());
		} catch (SmppBindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmppTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmppChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverablePduException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
