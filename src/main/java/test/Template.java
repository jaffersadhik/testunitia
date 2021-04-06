package test;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class Template {


	public static Connection getCOnnection(){
		//ui_dltrequests;		select username,senderid,entity_id,template_id,template_msg,template_sample_msg from ui_dltrequests
		Connection con=null;

		
		try{		

			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://Unitia-Mysql-cf63de58b07fd761.elb.ap-south-1.amazonaws.com:3306/core?useLegacyDatetimeCode=false&serverTimezone=Asia/Kolkata&useSSL=false","unitia","Unitia@123");
			}catch(Exception e){
				
			}finally{
				
			
				
			}
		
	    return con;

	}
	
	
	public static void check(){
	
		Map<String,Map<String,List<Map<String,String>>>> result=getData();
		
		Iterator itr=result.keySet().iterator();
		while(itr.hasNext()){
			
			String username=itr.next().toString();
			Map<String,List<Map<String,String>>> senderidmap=result.get(username);
			Iterator itr2=senderidmap.keySet().iterator();
			
			while(itr2.hasNext()){
				String senderid=itr2.next().toString();

				List<Map<String,String>> templatelist=senderidmap.get(senderid);
				
				for(int i=0;i<templatelist.size();i++){
					
					Map<String,String> data=templatelist.get(i);
					
					if(!isMatch(data.get("template_msg"), data.get("template_sample_msg"))){
						
						data.put("username", username);

						data.put("senderid", senderid);
						
						System.out.println(data);
					}
				}
			}
		}
	}
	public static Map<String,Map<String,List<Map<String,String>>>> getData(){
		
		Map<String,Map<String,List<Map<String,String>>>> result=new HashMap<String,Map<String,List<Map<String,String>>>>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultset=null;
		
		try{
			
			connection=getCOnnection();
			statement=connection.prepareStatement("select username,senderid,entity_id,template_id,template_msg,template_sample_msg from user_reports.ui_dltrequests");
			resultset=statement.executeQuery();
			
			
			while(resultset.next()){
				
				String username=resultset.getString("username");
				String senderid=resultset.getString("senderid");
				String entity_id=resultset.getString("entity_id");
				String template_id=resultset.getString("template_id");
				String template_msg=resultset.getString("template_msg");
				String template_sample_msg=resultset.getString("template_sample_msg");

				if(template_sample_msg==null||template_msg==null||template_id==null||entity_id==null||senderid==null||username==null){
					continue;
				}
				
				username=username.trim().toLowerCase();
				senderid=senderid.trim().toLowerCase();
				template_msg=template_msg.trim().toLowerCase();
				username=username.trim().toLowerCase();
				template_sample_msg=template_sample_msg.trim().toLowerCase();
				
				Map<String,List<Map<String,String>>> senderidmap=result.get(username);
				
				if(senderidmap==null){
					
					senderidmap=new HashMap<String,List<Map<String,String>>>();
					result.put(username, senderidmap);
					
				}
				
				List<Map<String,String>> templatelist=senderidmap.get(senderid);
				
				if(templatelist==null){
					templatelist=new ArrayList<Map<String,String>>();
					senderidmap.put(senderid, templatelist);
				}
				
				Map<String,String> data=new HashMap<String,String>();
				

				data.put("template_sample_msg", template_sample_msg);
				data.put("template_msg", template_msg);
				data.put("entity_id", entity_id);
				data.put("template_id", entity_id);
			
				templatelist.add(data);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			Close.close(resultset);
			Close.close(statement);
			Close.close(connection);
		}
		
		return result;
	}
	public static void main(String args[]) throws UnsupportedEncodingException{
	//	String template="Dear {#var#}, we are pleased to inform you that we have reduced our rates for the same coverage selected by you. We have initiated a partial refund of Rs {#var#}. Your new policy number is {#var#} against Order ID {#var#}. Download your policy certificate by clicking on {#var#} Please call 18002666 for queries";
		//String fullmsg="Dear test test, we are pleased to inform you that we have reduced our rates for the same coverage selected by you. We have initiated a partial refund of Rs 2000. Your new policy number is 222222 against Order ID 111111. Download your policy certificate by clicking on http:www.gmail.com Please call 18002666 for queries";
		String template ="Dear {#var#}, for issuance of a motor policy for Order ID {#var#}, your policy will not be generated until you fill the remaining details on {#var#} Your cover will not start tomorrow if you don't do so by 11:59 pm, tonight.";
		String fullmsg="Dear 11111, for issuance of a motor policy for Order ID 11111, your policy will not be generated until you fill the remaining details on 22222 Your cover will not start tomorrow if you don't do so by 11:59 pm, tonight.";

	//	String template="Dear {#var#}, for issuance of a motor policy for Order ID {#var#}, your policy will not be generated until you fill the remaining details on {#var#}";
	//	String fullmsg="Dear 111111, for issuance of a motor policy for Order ID 22222, your policy will not be generated until you fill the remaining details on 22222";
		
	//	String fullmsg="Dear Subscriber, \n\n   Please verify OTP for Password change for Bhima Riddhi App.. OTP for verification is 123456";
		//String template="Dear Subscriber, Please verify OTP for Password change for Bhima Riddhi App.. OTP for verification is Rs.{#var#}S ";

	//	String fullmsg ="Dear DC Reader, Greetings! Please click below to view and read your favourite DC http://dcnews.deccanchronicle.com/ATP20210307.html";
		//String template="Dear DC Reader, Greetings! Please click below to view and read your favourite DC {#var#}";
		//check();
	//	String fullmsg="Dear Praveen Your complaint is registered and your complaint ticket number is 22222 - Yokohama India";
		//String template="Dear {#var#} Your complaint is registered and your complaint ticket number is {#var#} - Yokohama India";
		//String fullmsg="Please share code 11111 with Sales Executive of MPS Jeep for conducting Test Drive. Please provide Test Drive Feedback - test test";
		//String template ="Please share code {#var#} with Sales Executive of MPS Jeep for conducting Test Drive.";
		//String fullmsg="Hi Livin Udyavara raw, Thank  you for purchasing and registering with Yokohama India Online warranty system through JAES WHEEL  Your Warranty Registration number is S486483. Please save this for all future references. 1 T&C* https://bit.ly/39KROPo";
		//String template="Hi {#var#}, Thank you for purchasing and registering with Yokohama India Online warranty system through {#var#} Your Warranty Registration number is {#var#} Please save this for all future references. {#var#}";
		System.out.println(isMatch(template, fullmsg));
	}
	
	
	public static boolean isMatch(String template,String fullmsg){
		
		String temp[]=StringUtils.split(template);
		String msg[]=StringUtils.split(fullmsg);

		if(temp.length==msg.length){
			
		
			return sameLength(temp,msg);

		
		}else if(temp.length<msg.length){
			
			int extravariabecount=msg.length-temp.length;
		
			if(extravariabecount==1){
			
				return extraLength1(temp,msg);
		
		
			}else{
				
				if(isEndWithVar(temp)){
					
					return extraLengthNWithEndwithVar(temp,msg);	

				}else{
					
					return extraLengthN(temp,msg);	
				}
				
			}
		}else{
		
			
			System.out.println("count miss match : temp "+temp.length+" msg "+msg.length);
			return false;
		}
	}


	private static boolean extraLengthNWithEndwithVar(String[] temp, String[] msg) {


		

		int msgpointer=0;
		
		for(int i=0;i<temp.length;i++){
			
			
			String m=msg[msgpointer];
			String t=temp[i];
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){

				

				String t1="";
				if((i+1)<temp.length){
					t1=temp[i+1];
				}
					
					
			if("{#var#}".equals(t1) || t1.indexOf("{#var#}")>-1 ){
						
				msgpointer++;
					
			}else{
				
				int lastmatchedindex=getLastMatchedIndexForEndwithVar(t,t1,msg,msgpointer+1,temp);

				if(lastmatchedindex==-1){
					System.out.println("Index Not Matched");
					return false;
				}else{
					msgpointer=lastmatchedindex;
				}
			}
					
			}else if(! m.equalsIgnoreCase(t)){
				return false;
			}else{
				
				msgpointer++;

			}
		
		} 
		
		return true;

	
	
	}


	private static int getLastMatchedIndexForEndwithVar(String t, String t1, String[] msg, int msgpointer,String[] temp) {

		
		int i=msgpointer;
		
		for(i=msgpointer;i<msg.length;i++){
			
			String m1=msg[i];
			
			if(m1.equalsIgnoreCase(t1)){
				
				return i;
			}
		}
		
		if(("{#var#}".equals(t) || t.indexOf("{#var#}")>-1)&&t1.equals("") ){
			
			StringBuffer sb=new StringBuffer();
			int j=msgpointer;
			while(j<msg.length){
				j++;
				if(j<msg.length){
				sb.append(msg[j]).append(" ");
				}
			}
			
			int varCount=getLastVarCount(temp);
			int totalmsglength=varCount*30;
			if(sb.toString().length()<(totalmsglength+1)){
				
			return msgpointer;
			
			}
		}


		return -1;
	
	}


	private static int getLastVarCount(String[] temp) {

		int count=0;
		for(int i=temp.length-1;i>-1;i--){
			
			String t=temp[i];
			
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1){
				
				count++;
			}else{
				
				return count;
			}
		}
		return count;
	}


	private static boolean isEndWithVar(String[] temp) {
		
		String t=temp[temp.length-1];
		
		if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){
			
			return true;
		}
		return false;
	}


	private static boolean extraLengthN(String[] temp, String[] msg) {

		System.out.println("extraLengthN");

		int msgpointer=0;
		
		for(int i=0;i<temp.length;i++){
			
			
			String m=msg[msgpointer];
			String t=temp[i];
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){

				

				String t1="";
				if((i+1)<temp.length){
					t1=temp[i+1];
				}
					
					
			if("{#var#}".equals(t1) || t1.indexOf("{#var#}")>-1 ){
						
				msgpointer++;
					
			}else{
				
				int lastmatchedindex=getLastMatchedIndex(t,t1,msg,msgpointer+1);

				if(lastmatchedindex==-1){
					System.out.println("Index Not Matched");
					return false;
				}else{
					msgpointer=lastmatchedindex;
				}
			}
					
			}else if(! m.equalsIgnoreCase(t)){
				return false;
			}else{
				
				msgpointer++;

			}
		
		} 
		
		if(msgpointer==msg.length){
			return true;

		}else{
			return false;
		}
	
	}


	private static int getLastMatchedIndex(String t,String t1, String[] msg, int msgpointer) {
		
		int i=msgpointer;
		
		for(i=msgpointer;i<msg.length;i++){
			
			String m1=msg[i];
			
			if(m1.equalsIgnoreCase(t1)){
				
				return i;
			}
		}
		
		if(("{#var#}".equals(t) || t.indexOf("{#var#}")>-1)&&t1.equals("") ){
			
			return msgpointer;
				
		}


		return -1;
	}


	private static boolean extraLength1(String[] temp, String[] msg) {
		
		int extravariabecount=msg.length-temp.length;

		int msgpointer=0;
		for(int i=0;i<temp.length;i++){
			
			
			String m=msg[msgpointer];
			
			String t=temp[i];
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){

				if(extravariabecount==1){
				
					try{
						String m1=msg[msgpointer+1];
						String t1=temp[i+1];
						
						if(! m1.equalsIgnoreCase(t1)){
							
							String m2=msg[msgpointer+2];
							
							if(! m2.equalsIgnoreCase(t1)){
							
								return false;
							}else{
								msgpointer=msgpointer+2;

							}
						}else{
							
							msgpointer++;

						}
						
						}catch(Exception e){
							
							
						}
					

				}
			}else if(! m.equalsIgnoreCase(t)){
				return false;
			}else{
				
				msgpointer++;

			}
		
		} 
		
		return true;

	}


	private static boolean sameLength(String[] temp,String[] msg ) {

		for(int i=0;i<temp.length;i++){
			
			String m=msg[i];
			String t=temp[i];
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){
				continue;
			}else if(! m.equalsIgnoreCase(t)){
				return false;
			}
			
			
		}
	
		return true;
	}
}

