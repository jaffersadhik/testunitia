package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class kannel {

	static Map<String ,Map<String,Map<String,String>>> result=new HashMap<String ,Map<String,Map<String,String>>>();
	
	public static void main(String args[]) throws Exception{
		
		
		System.out.println(getVersion("http://Unitia-8042041824a6b544.elb.ap-south-1.amazonaws.com:13000/status.xml"));
		result.put("kannel1", getStatusV2("http://Unitia-8042041824a6b544.elb.ap-south-1.amazonaws.com:13000/status.xml"));
	//	result.put("kannel2", getStatus("http://13.234.186.32:13020/status.xml"));

		System.out.println(result);
	}
	
	
	
	public static Map<String,Map<String,String>> getStatusV2(String url) throws Exception{
		
		
		  HashMap<String, String> values = new HashMap<String, String>();
	        String xmlString = getStringXML(url);
	        xmlString= xmlString.replaceAll("online ", "online_");
	        Document xml = convertStringToDocument(xmlString);
	        Node user = xml.getFirstChild();
	        NodeList childs = user.getChildNodes();
	        Node child;
	        for (int i = 0; i < childs.getLength(); i++) {
	            child = childs.item(i);
	             values.put(child.getNodeName(), child.getTextContent());
	        }

		
	     Iterator itr=values.keySet().iterator();
	     
	     while(itr.hasNext()){
	    	 
	 		System.out.println(itr.next());

	     }
	     
	 		System.out.println(values.get("smscs"));

	     StringTokenizer st=new StringTokenizer(values.get("smscs"),"\t");
	     
	     Map<String,Map<String,String>> result=new HashMap<String,Map<String,String>>();
	     
	     System.out.println(st.nextToken());
	     
	     int i=0;
	     while(st.hasMoreTokens()){

		     System.out.println("#####################################################");

	    	 System.out.println(++i);
		    
		     System.out.println(st.nextToken());
		     String smscid=st.nextToken();
		     
		     Map<String,String> data=result.get(smscid);
		     
		     if(data==null){
		    	 
		    	 data=getMap();
		    	 
		    	 result.put(smscid, data);
		    	 
		     }
		     System.out.println(st.nextToken());
		     String status=st.nextToken();

		     if(status.startsWith("online")){
		    	 data.put("status","up");
		     }else{
		    	 continue;
		     }
		 
		     String received=st.nextToken();
		     received=received.substring(1);
		     
		     
		     try{
		    	 
		    	 int iF=Integer.parseInt(received);
		    	 iF=iF+Integer.parseInt(data.get("received"));
		    	 data.put("received", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		     String sent=st.nextToken();
		     sent=sent.substring(0, sent.length()-1);
		     try{
		    	 
		    	 int iF=Integer.parseInt(sent);
		    	 iF=iF+Integer.parseInt(data.get("sent"));
		    	 data.put("sent", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		       String failed=st.nextToken();
	     
	     try{
	    	 
	    	 int iF=Integer.parseInt(failed);
	    	 iF=iF+Integer.parseInt(data.get("failed"));
	    	 data.put("failed", ""+iF);
	     }catch(Exception e){
	    	 
	     }
	     
	     
	     String queued=st.nextToken();
	     
	     try{
	    	 
	    	 int iF=Integer.parseInt(queued);
	    	 iF=iF+Integer.parseInt(data.get("queued"));
	    	 data.put("queued", ""+iF);
	     }catch(Exception e){
	    	 
	     }
	    
	     
		     System.out.println("#####################################################");
		     
	     }
	     
	     return result;
	}

	private static String getVersion(String url) throws Exception {

		 String xmlString = getStringXML(url);
	        
		return xmlString.substring(xmlString.indexOf("<version>")+9, xmlString.indexOf("</version>")).split(" ")[3];
	}
	public static Map<String,Map<String,String>> getStatus(String url) throws Exception{
		
		
		  HashMap<String, String> values = new HashMap<String, String>();
	        String xmlString = getStringXML(url);
	        xmlString= xmlString.replaceAll("online ", "online_");
	        Document xml = convertStringToDocument(xmlString);
	        Node user = xml.getFirstChild();
	        NodeList childs = user.getChildNodes();
	        Node child;
	        for (int i = 0; i < childs.getLength(); i++) {
	            child = childs.item(i);
	             values.put(child.getNodeName(), child.getTextContent());
	        }

		
	     Iterator itr=values.keySet().iterator();
	     
	     while(itr.hasNext()){
	    	 
	 		System.out.println(itr.next());

	     }
	     
	 		System.out.println(values.get("smscs"));

	     StringTokenizer st=new StringTokenizer(values.get("smscs"),"\t");
	     
	     Map<String,Map<String,String>> result=new HashMap<String,Map<String,String>>();
	     
	     System.out.println(st.nextToken());
	     
	     int i=0;
	     while(st.hasMoreTokens()){

		     System.out.println("#####################################################");

	    	 System.out.println(++i);
		     
		     System.out.println(st.nextToken());
		     String smscid=st.nextToken();
		     
		     Map<String,String> data=result.get(smscid);
		     
		     if(data==null){
		    	 
		    	 data=getMap();
		    	 
		    	 result.put(smscid, data);
		    	 
		     }
		     System.out.println(st.nextToken());
		     String status=st.nextToken();

		     if(status.startsWith("online")){
		    	 data.put("status","up");
		     }
		     
		     String failed=st.nextToken();
		     
		     try{
		    	 
		    	 int iF=Integer.parseInt(failed);
		    	 iF=iF+Integer.parseInt(data.get("failed"));
		    	 data.put("failed", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		     
		     
		     String queued=st.nextToken();
		     
		     try{
		    	 
		    	 int iF=Integer.parseInt(queued);
		    	 iF=iF+Integer.parseInt(data.get("queued"));
		    	 data.put("queued", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		     System.out.println(st.nextToken());
		     String sent=st.nextToken();
		     
		     try{
		    	 
		    	 int iF=Integer.parseInt(sent);
		    	 iF=iF+Integer.parseInt(data.get("sent"));
		    	 data.put("sent", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		     System.out.println(st.nextToken());
		     
		     String senttps=st.nextToken();
		     
		     try{
		    	 
		    	 double iF=Double.parseDouble(senttps);
		    	 iF=iF+Double.parseDouble(data.get("senttps"));
		    	 data.put("senttps", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		     String received=st.nextToken();
		     
		     try{
		    	 
		    	 int iF=Integer.parseInt(received);
		    	 iF=iF+Integer.parseInt(data.get("received"));
		    	 data.put("received", ""+iF);
		     }catch(Exception e){
		    	 
		     }
		     
		     System.out.println(st.nextToken());
		 	
		    
		     String receicvedtps=st.nextToken();
		     
		     
	     try{
		    	 
		    	 double iF=Double.parseDouble(receicvedtps);
		    	 iF=iF+Double.parseDouble(data.get("receicvedtps"));
		    	 data.put("receicvedtps", ""+iF);
		     }catch(Exception e){
		    	 
		     }
	     System.out.println(st.nextToken());

	     
		     System.out.println("#####################################################");
		     
	     }
	     
	     return result;
	}
	
	
	private static Map<String, String> getMap() {

		Map<String,String> data=new HashMap<String,String>();
		data.put("status", "down");
		data.put("queued", "0");
		data.put("sent", "0");
		data.put("senttps", "0.0");

		data.put("failed", "0");
		data.put("received", "0");	
		data.put("receivedtps", "0.0");		

		return data;
	}


	public static String getStringXML(String url) throws Exception{
		
		String xml=connectKannel(url);
		
		return xml;
	}
	

	public static String connectKannel(String sUrl)  throws Exception{

		String response = "";

		BufferedReader in = null;
		try {
			int httpConnectionTimeout = 300000;
			int httpResponseTimeout = 300000;
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

			if (iGetResultCode == 200 || iGetResultCode == 202) {

				if (decodedString.toString().length() != 0){
					response = decodedString.toString().trim();
				}
				return response;
			} else {
				

						}

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

	

	 private static Document convertStringToDocument(String xmlStr) {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder;
	        try {
	            builder = factory.newDocumentBuilder();
	            Document doc = builder.parse(new InputSource(new StringReader(
	                    xmlStr)));
	            return doc;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}

