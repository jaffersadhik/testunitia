
package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test extends Thread{
	
	private static Map map = new ConcurrentHashMap();

	private static long start=System.currentTimeMillis();

	private static List<String> url=new ArrayList<String>();
	
	private static int msgcount=1;
	
	private static int threadcount=1;

	static{
		
	//	url.add("http://103.212.205.85:8080/api/receiver?username=hu62ub_aab&password=rdqgga&mobile=9189487660738&message=test&senderid=tested");
	//	url.add("http://13.234.186.32:8001/send?username=trautoninja&password=LrBx9S&to=919487660738&from=WECARE&content="+URLEncoder.encode("test"))
		try {
			String text=URLEncoder.encode("Dear `Customer`, It’s our endeavor to serve you well test @ jaffer ~!@#$%^&*()_+=-0?><,./\":;{}|\\][","UTF-8");
			
	
			
			
			//System.out.println(text);
					url.add("http://api.unitiapro.com/send?username=trautoninja&password=LrBx9S&to=919487660738&from=WECARE&content="+text);
			//url.add("http://13.232.38.205:13013/cgi-bin/sendsms?username=test&password=pass123&from=WECARE&to=919487660738&text="+text);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public Test(int msgcount){
		
		this.msgcount=msgcount;
	}
	public void run(){
		
		for(int i=0;i<msgcount;i++){
			
		
			System.out.println(connectKannel(url.get(getCurrentIndex("RR",url.size()))));
		}
	}
	
	public String connectKannel(String sUrl) {

		String response = "";
		System.out.println(sUrl);
		BufferedReader in = null;
		try {
			int httpConnectionTimeout = 2000;
			int httpResponseTimeout = 2000;
			URL url = new URL(sUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setConnectTimeout(httpConnectionTimeout);
			connection.setReadTimeout(httpResponseTimeout);

			int iGetResultCode = connection.getResponseCode();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer decodedString = new StringBuffer();
			String temp = null;

			while ((temp = in.readLine()) != null) {
				decodedString.append(temp);
			}

		//	if (iGetResultCode == 200 || iGetResultCode == 202) {

				if (decodedString.toString().length() != 0)
					response = decodedString.toString().trim();
				return response;
		//	} else {
			//}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
		return response;
	}


	public static void main(String[] args) throws UnsupportedEncodingException {
		
//	System.out.println(setMsgType());
		
	
//		System.out.println(URLEncoder.encode("`","UTF-16"));

		for(int i=0;i<threadcount;i++){
				new Test(msgcount).start();
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
		
			public void run(){
				
				long timetaken=System.currentTimeMillis()-start;
				
				timetaken=timetaken/1000;
				
				int totalmsg=threadcount*msgcount;
				
			//	System.out.println(totalmsg/timetaken);
				
		}
		});
	}

	public static int getCurrentIndex(String key,int totalInstance)
	{
		Integer iobj = (Integer)map.get(key);
		if(iobj == null)
		{
			iobj = new Integer("0");
			map.put(key, iobj);
		}
		
		int i = iobj.intValue();
		if((i+1) >= totalInstance)	// Reset from begining
		{
			map.put(key, new Integer("0"));
		}
		else // Increment the index and update the map
		{
			String s = "" + (i+1);
			map.put(key, new Integer(s));
		}
		
		if(i >= totalInstance)	i=totalInstance-1;	// Just to make sure i doesnt exceed valid index(might occur during concurrency)
		
		return i;
	}
	
	
	 private static String setMsgType() throws UnsupportedEncodingException{
		 
		 	String msg="Dear ‘Customer’, It’s our endeavor to serve you well. ";
	    	String encode=URLEncoder.encode(msg,"US-ASCII");
	    	
	    	
	    	System.out.println(URLDecoder.decode(encode,"US-ASCII"));
	    	String [] msgarray=msg.split(" ");
	    	
	    	System.out.println(msgarray.length);
	    	
	    	if(msgarray.length==1){
	    		
	    	

	    		if(msgarray[0].matches("-?[0-9a-fA-F]+")){

	    			 return "UM";
	    		}else{
	    			for(int i=0;i<msgarray.length;i++){
	        			
	        			if(!isASCII(msgarray[i])){
	        				return "UM";
	        			}
	        		}
	    		}
	    		
	    	}else{
	    		
	    		for(int i=0;i<msgarray.length;i++){
	    			
	    			if(!isASCII(msgarray[i])){
	    				return "UM";
	    			}
	    		}
	    	}
	    	
	    	return "EM";
	    }
	    
	  private static boolean isASCII(String word) throws UnsupportedEncodingException{
		    for (char c: word.toCharArray()){
		    	  
		    	String encode=URLEncoder.encode(""+c,"UTF-16");
		    	encode=encode.replace("%", "");
		    	if(encode.startsWith("FEFF")){
		    		
		    		encode=encode.substring(4,encode.length());
		    	}
		    	System.out.println(c+" \t : "+ encode);

		    	if(!(encode.startsWith("00")||encode.startsWith("20")||encode.length()==1)){
		    	
		    		return false;
		    	}
		    	}
		    	return true;
		    }

}
