package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class XMLPost {

	public static void main(String args[]){
		
	//	System.out.print(getMessage());
		
	


	}
	
	public static String getMessage(){
		
		
		StringBuffer sb=new StringBuffer();
		
		
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<message>");
		sb.append("<submit>");
		sb.append("<da><number>91487660737</number></da>");
		sb.append("<oa><number>WECARE</number></oa>");
		sb.append("Test Message</ud>");
		//sb.append("<udh>user data header (udh)</udh>");
		//sb.append("<meta-data>meta-data</meta-data>");
	//	sb.append("<dcs>");
		//sb.append("<mclass>mclass</mclass>");
	//	sb.append("<coding>coding</coding>");
		//sb.append("<alt-dcs>alt-dcs</alt-dcs>");
		//sb.append("</dcs>");
		//sb.append("<statusrequest>");
		//sb.append("<dlr-mask>dlr-mask</dlr-mask>");
		//sb.append("<dlr-url>dlr-url</dlr-url>");
		//sb.append("</statusrequest>");

		sb.append("<from>");
		sb.append("<user>test</user>");
		sb.append("<pass>pass123</pass>");
		sb.append("</from>");
		sb.append("<to>unitia</to>");

	
		sb.append("</submit>");
		sb.append("</message>");

		return sb.toString();
	}
}
