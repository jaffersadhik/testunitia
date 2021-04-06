package test;

import java.util.regex.Pattern;

public class Character {

	public static void main(String args[]){
		
		
	 if(Pattern.compile("(.*\n){0,}.*", Pattern.CASE_INSENSITIVE).matcher("test \n \n \n test").matches()){
		 
		 
		 
		System.out.println("ok");	
	}
	

	}
	
	
	private static boolean isconversionRequired(String message){
	
		if(message.matches("-?[0-9a-fA-F]+")){
			
			if(message.length()%4==0){
				
				return true;
			}
		}
		
		return false;
	}
	
	public static String getMessage(String message) throws Exception{
		

		    String str = "";
		    for(int i=0;i<message.length();i+=4)
		    {
		        String s = message.substring(i, (i + 4));
		        int decimal = Integer.parseInt(s, 16);
		        str = str + (char) decimal;
		    }       
		    return str;
	}
	
	
	
}
