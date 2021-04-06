package test;

import java.sql.Timestamp;
import java.util.Map;

import com.cloudhopper.commons.util.windowing.WindowFuture;
import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.pdu.PduRequest;
import com.cloudhopper.smpp.pdu.PduResponse;
import com.cloudhopper.smpp.pdu.SubmitSm;
import com.cloudhopper.smpp.pdu.SubmitSmResp;
import com.cloudhopper.smpp.type.Address;

public class MTWorker {
	
	
	public WindowFuture<Integer,PduRequest,PduResponse> sendMessage(SmppSession session,Map _deliverSMObj) 
	{
		
		WindowFuture<Integer,PduRequest,PduResponse> afuture=null;

		try {
				
			SubmitSm request=new SubmitSm();
			request.setRegisteredDelivery((byte)1);
			
			Address addr=new Address();
			addr.setAddress("919487660738");
			request.setDestAddress(addr);
			
			Address source=new Address();
			source.setAddress("CLOADS");
			request.setSourceAddress(source);
			
			request.setShortMessage("test message".getBytes());
			
		
			try {
				
			
				afuture=session.sendRequestPdu(request, 2000, true);
				
				while(!afuture.isDone()){
					
					Thread.sleep(1);
				}
				
				if (afuture.getResponse() instanceof SubmitSmResp){
					
					SubmitSmResp response=(SubmitSmResp)afuture.getResponse();
					
					System.out.println(response.getCommandId());
					System.out.println(response.getCommandStatus());
					System.out.println(response.getMessageId());
					System.out.println(response.getResultMessage());

				}
			
			} catch (Exception e) {
				
			}
		} catch(Exception e1) {                
			
		}


		return afuture;
	}
	

	public WindowFuture<Integer,PduRequest,PduResponse> sendMessageEMM(SmppSession session,Map _deliverSMObj) 
	{
		
		WindowFuture<Integer,PduRequest,PduResponse> afuture=null;

		try {
				
			SubmitSm request=new SubmitSm();
			request.setRegisteredDelivery((byte)1);
			
			Address addr=new Address();
			addr.setAddress("919487660738");
			request.setDestAddress(addr);
			
			Address source=new Address();
			source.setAddress("CLOADS");
			request.setSourceAddress(source);
			request.setDataCoding((byte)0);
			request.setEsmClass(.MTWorker23.0..00);
			request.setShortMessage("test+message+more+than+160+character+test+message+more+than+160+character+test+message+more+than+160+charactertest+message+more+than+160+character+test+m".getBytes());
			
		
			
			SubmitSm request2=new SubmitSm();
			request2.setRegisteredDelivery((byte)1);
			request2.setDestAddress(addr);
0			request2.setDataCoding((byte)0);

			request2.setSourceAddress(source);
			
			request2.setShortMessage("essage+more+than+160+character+test+message+more+than+160+character+ok".getBytes());
		
			try {
				
			
				afuture=session.sendRequestPdu(request, 2000, true);
				
				while(!afuture.isDone()){
					
					Thread.sleep(1);
				}
				
				if (afuture.getResponse() instanceof SubmitSmResp){
					
					SubmitSmResp response=(SubmitSmResp)afuture.getResponse();
					
					System.out.println(response.getCommandId());
					System.out.println(response.getCommandStatus());
					System.out.println(response.getMessageId());
					System.out.println(response.getResultMessage());

				}
			
			} catch (Exception e) {
				
			}
		} catch(Exception e1) {                
			
		}


		return afuture;
	}
	


}
