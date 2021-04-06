package test;

import org.apache.commons.lang.StringUtils;

public class T1 {

	public static void main(String args[]){
		
		T1 obj=new T1();
		System.out.println("======true=========");
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m4(); 
		obj.m5();
		obj.m6();
		obj.n1();
		obj.n3();
		obj.n4();

		obj.m7();

		obj.m8();

		System.out.println("======false=========");
		obj.m9();
		obj.m10();
		obj.n2();

	}

	
private void n4() {
		

		String fullmsg ="ATM ID: S1BW001716113, Dispenser Error @ Apr  5 2021 10:43AM. SBI ATM – HOTEL AMARPREET BUILDING. Ticket generated with reference number 1770702. For further assistance pls contact 18001024811/18001237973 – CMS INFO";
		String template="ATM ID: {#var#}, {#var#} @ {#var#}. SBI {#var#} – {#var#}. Ticket generated with reference number {#var#}. For further assistance pls contact {#var#} – CMS INFO";
		
	System.out.println(isMatch(template,fullmsg));

		
	}
private void n3() {
		

		String fullmsg="test test test test test test test test test test test test at test test test test! Offer test test test test test test test test test test test test test test test test test test test test at test test test test sharp. No extension. test test test test test test test test test test T&C, Powered by Winggz";
		String template="{#var#}{#var#}{#var#}{#var#}{#var#}{#var#} at {#var#}{#var#}! Offer {#var#}{#var#}{#var#}{#var#}{#var#}{#var#}{#var#}{#var#}{#var#}{#var#} at {#var#}{#var#} sharp. No extension. {#var#}{#var#}{#var#}{#var#}{#var#} T&C, Powered by Winggz";
		
	System.out.println(isMatch(template,fullmsg));

		
	}

	private void n1() {
		

		String fullmsg="test: SVANidhi se Samriddhi programme, you are eligible for test test test test test test test test -MoHUA";
		String template="{#var#}: SVANidhi se Samriddhi programme, you are eligible for {#var#}{#var#}{#var#}{#var#}{#var#}{#var#}{#var#}{#var#} -MoHUA";
		
	System.out.println(isMatch(template,fullmsg));

		
	}
	
private void n2() {
		

		String fullmsg="Your one-time password (OTP) is: 1287. Please enter this code on KHATA Powered by KHATA BUSINESS";
		String template="Your one-time password (OTP) is: {#var#}. Please enter this code on {#var#} Powered by KHATA";
		
	System.out.println(isMatch(template,fullmsg));

		
	}

	private  void m10() {
		String fullmsg="Dear test test, we are pleased to inform you that we have reduced our rates for the same coverage selected by you. We have initiated a partial refund of Rs 2000. Your new policy number is 222222 against Order ID 111111. Download your policy certificate by clicking on http:www.gmail.com Please call 18002666 for queries";
		String template="dear {#var#}, your new policy number is {#var#} against order id {#var#}. download your policy certificate by clicking on {#var#} please call 18002666 for queries";
		
	System.out.println(isMatch(template,fullmsg));
}
	private  void m9() {
		String fullmsg="Dear test test, we are pleased to inform you that we have reduced our rates for the same coverage selected by you. We have initiated a partial refund of Rs 2000. Your new policy number is 222222 against Order ID 111111. Download your policy certificate by clicking on http:www.gmail.com Please call 18002666 for queries* https://bit.ly/39KROPo";
		String template="Dear {#var#}, your new policy number is {#var#} against Order ID {#var#}. Download your policy certificate by clicking on {#var#} Please call 18002666 for queries";
		
	System.out.println(isMatch(template,fullmsg));
}
	private  void m8() {
		String fullmsg="Hi Livin Udyavara raw, Thank  you for purchasing and registering with Yokohama India Online warranty system through JAES WHEEL  Your Warranty Registration number is S486483. Please save this for all future references. 1 T&C* https://bit.ly/39KROPo";
		String template="Hi {#var#}, Thank you for purchasing and registering with Yokohama India Online warranty system through {#var#} Your Warranty Registration number is {#var#} Please save this for all future references. {#var#}";
		
	System.out.println(isMatch(template,fullmsg));
}	
	private  void m7() {
		String fullmsg="Please share code 11111 with Sales Executive of MPS Jeep for conducting Test Drive. Please provide Test Drive Feedback - test test";
		String template ="Please share code {#var#} with Sales Executive of MPS Jeep for conducting Test Drive. Please provide Test Drive Feedback - {#var#}";
	
	System.out.println(isMatch(template,fullmsg));
}

	private  void m6() {
			String fullmsg="Dear Praveen Your complaint is registered and your complaint ticket number is 22222 - Yokohama India";
		String template="Dear {#var#} Your complaint is registered and your complaint ticket number is {#var#} - Yokohama India";

		System.out.println(isMatch(template,fullmsg));
	}
	
	private  void m5() {
		String fullmsg ="Dear DC Reader, Greetings! Please click below to view and read your favourite DC http://dcnews.deccanchr";
		String template="Dear DC Reader, Greetings! Please click below to view and read your favourite DC {#var#}";

		System.out.println(isMatch(template,fullmsg));
	}
	private  void m4() {
		String fullmsg="Dear Subscriber, \n\n   Please verify OTP for Password change for Bhima Riddhi App.. OTP for verification is 123456";
		String template="Dear Subscriber, Please verify OTP for Password change for Bhima Riddhi App.. OTP for verification is Rs.{#var#}S ";

		System.out.println(isMatch(template,fullmsg));
	}
	private  void m1() {
		String template="Dear {#var#}, we are pleased to inform you that we have reduced our rates for the same coverage selected by you. We have initiated a partial refund of Rs {#var#}. Your new policy number is {#var#} against Order ID {#var#}. Download your policy certificate by clicking on {#var#} Please call 18002666 for queries";
		String fullmsg="Dear test test, we are pleased to inform you that we have reduced our rates for the same coverage selected by you. We have initiated a partial refund of Rs 2000. Your new policy number is 222222 against Order ID 111111. Download your policy certificate by clicking on http:www.gmail.com Please call 18002666 for queries";

		System.out.println(isMatch(template,fullmsg));
	}
	
	
	private  void m2() {
		String template ="Dear {#var#}, for issuance of a motor policy for Order ID {#var#}, your policy will not be generated until you fill the remaining details on {#var#} Your cover will not start tomorrow if you don't do so by 11:59 pm, tonight.";
		String fullmsg="Dear 11111, for issuance of a motor policy for Order ID 11111, your policy will not be generated until you fill the remaining details on 22222 Your cover will not start tomorrow if you don't do so by 11:59 pm, tonight.";

		System.out.println(isMatch(template,fullmsg));
	}
	
	private  void m3() {
			String template="Dear {#var#}, for issuance of a motor policy for Order ID {#var#}, your policy will not be generated until you fill the remaining details on {#var#}";
			String fullmsg="Dear 111111, for issuance of a motor policy for Order ID 22222, your policy will not be generated until you fill the remaining details on 22222";

		System.out.println(isMatch(template,fullmsg));
	}
public  boolean isMatch(String template,String fullmsg){
		
		String temp[]=StringUtils.split(template);
		String msg[]=StringUtils.split(fullmsg);

		int msgpointer=0;

		for(int i=0;i<temp.length;i++){
			
			if(msgpointer>=msg.length){
				
				return  false;
			}
			String m=msg[msgpointer];
			String t=temp[i];
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){
				int lastTempPointer=getLastTempPointer(temp,i);
				int maxVarCharCount=getMaxVarcharCount(lastTempPointer,temp);
				int upcomingmsgpointer=getUpcomingMsgPointer(lastTempPointer,temp,msg,msgpointer);
				int varcharcount=getVarcharCount(msg,msgpointer,upcomingmsgpointer);
	/*		
				System.out.println(" lastTempPointer "+ lastTempPointer);
				System.out.println(" maxVarCharCount "+ maxVarCharCount);
				System.out.println(" upcomingmsgpointer "+ upcomingmsgpointer);
				System.out.println(" varcharcount "+ varcharcount);
*/
				if(maxVarCharCount>varcharcount){
					msgpointer=upcomingmsgpointer;
				}else{
					return false;
				}
			}else if(! m.equalsIgnoreCase(t)){
				return false;
			}else{
				msgpointer++;
			}

			
		
		} 
/*
		System.out.println(" msgpointer "+ msgpointer);
		System.out.println(" msg.length "+ msg.length);
		System.out.println(" temp.length "+ temp.length);
*/
		if(msg.length==temp.length){
			
			return true;
			
		}else if(msg.length>temp.length){
			
			
			String t=temp[temp.length-1];
			if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){
			
				if(msgpointer==msg.length-1){
					
					return true;

				
				
				}else{
					
					return false;
				}
			}else{
		
			if(msgpointer==msg.length){
		
				return true;

			
			
			}else{
				
				return false;
			}
			
			}
		}else{
			
			return true;
		}
		
}

private int getVarcharCount(String[] msg, int msgpointer, int upcomingmsgpointer) {
	
	StringBuffer sb=new StringBuffer();
	for(int i=msgpointer;i<upcomingmsgpointer;i++){
		
		sb.append(msg[i]).append(" ");
		
	}
	
	//System.out.println(sb.toString());
	return sb.toString().trim().length();
}

private int getUpcomingMsgPointer(int lastTempPointer, String[] temp, String[] msg, int msgpointer) {
	
	int temppointer=lastTempPointer;
	
	
	temppointer++;
	
	if(temppointer==temp.length){
		
		return msg.length-1;
	}
	
	if(temppointer<temp.length){
		
		String t=temp[temppointer];
		
		for(int i=msgpointer;i<msg.length;i++){
			
			String m=msg[i];
			
			if(m.equalsIgnoreCase(t)){
				
				return i;
			}
		}
	}
		
		return msg.length-1;
	
	
}

private int getMaxVarcharCount(int lastTempPointer, String[] temp) {

	int pointer=lastTempPointer;
	int count=getCount(temp[pointer]);
	while(pointer>-1){
		
		pointer--;
		
		if(pointer==-1){
			
			return (count*30)+1;
		}
		
		String t=temp[pointer];
		if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){
			count=count+getCount(t);
		}else{
			return (count*30)+1;
		}
	}

	return (count*30)+1;

	
}

private int getCount(String keyword) {
	String var="{#var#}";
	int count=0;
	while(keyword!=null&&keyword.length()>0){
		
		int index=keyword.indexOf(var);
		if(index > -1){
		keyword=keyword.substring(index+7);
		count++;
		}else{
			
			break;
		}
	}
	
	return count;
}

private int getLastTempPointer(String[] temp, int i) {

	int pointer=i;
	int count=0;
	while(pointer<temp.length){
		
		pointer++;
		
		if(pointer==temp.length){
			
			return i+count;
		}
		
		String t=temp[pointer];
		if("{#var#}".equals(t) || t.indexOf("{#var#}")>-1 ){
			count++;
		}else{
			return count+i;
		}
	}

	return count+i;
}


}
