package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.uuid.*;	
public class Json {

	public static void main(String args[]) throws UnsupportedEncodingException{
		
		UUID uuid = Generators.timeBasedGenerator(new EthernetAddress(System.currentTimeMillis())).generate();
		
		String uuidstr=uuid.toString();
		
		UUID UUID_1 
        = UUID 
              .fromString( 
            		  uuidstr); 
		 System.out.println("The timestamp value is: "
                 + new Date(UUID_1.timestamp())); 
		/*
		Map<String,Object>  data=new HashMap<String,Object>();
		
		data.put("username", "unitia");

		data.put("password", "unitia");
		
		List<Map<String,Object>> smslist=new ArrayList<Map<String,Object>>();
		
		data.put("smslist", smslist);

		Map<String,Object>  sms=new HashMap<String,Object>();

		smslist.add(sms);
		smslist.add(sms);

		sms.put("content", "Test Message");
	
		sms.put("from", "WECARE");
		
		sms.put("scheduletime", "2020/09/28/12/12");
		
		sms.put("param1", "param1 value");

		sms.put("param2", "param2 value");
		
		sms.put("param3", "param3 value");
		
		sms.put("param4", "param4 value");

		sms.put("templateid", "1234");

		sms.put("entityid", "1234");
		
		
		List<String> tolist=new ArrayList<String>();
		
		sms.put("tolist", tolist);

		tolist.add("919487660738");
		
*/

	}
	
	
	

	
	public static String toString(Object bean) {
		
		String jsonStr=null;
        ObjectMapper Obj = new ObjectMapper(); 
        
        try { 
        	  
            // get Oraganisation object as a json string 
        	jsonStr = Obj.writeValueAsString(bean); 
  
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        
        return jsonStr;
	}
}
