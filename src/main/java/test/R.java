package test;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class R
{

	public static final String  S_CNT            = "SUCCESS_COUNT";
    
    public static final String  T_CNT            = "TOTAL_COUNT";
    
	 
	private static R singleton = new R();

	
	private Map history=new HashMap();
	
	private R()
	{
		
	}
	
	public static R getInstance()
	{
		return singleton;
	}
	


	
	

	public synchronized Map getHistory(String username){
		
		Map result=null;
		if(history.containsKey(username)){
			result=(Map)history.get(username);
		}else{
			result=new HashMap();
			result.put(S_CNT, "0");
			result.put(T_CNT, "1");
			history.put(username, result);
		}
		return result;
			
	}
	
	public synchronized void incrementHistory(String username,boolean isSuccess){
		
		try{
		if(history.containsKey(username)){
			Map result=(Map)history.get(username);
			
			long scnt=Long.parseLong(result.get(S_CNT).toString());
			long tcnt=Long.parseLong(result.get(T_CNT).toString());
			tcnt++;
			if(isSuccess){
			scnt++;
			}
			if(tcnt==0){
				tcnt=1;
				scnt=0;
			}
			result.put(S_CNT, ""+scnt);
			result.put(T_CNT, ""+tcnt);
			history.put(username, result);
		}else{
			

			Map result=new HashMap();

			if(isSuccess){
				result.put(S_CNT, "1");
			}else{
				result.put(S_CNT, "0");
			}
			result.put(T_CNT, "1");
			history.put(username, result);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public synchronized void incrementHistoryForSuccess(String username) {
		
		Map result=(Map)history.get(username);
		
		long scnt=Long.parseLong(result.get(S_CNT).toString());
		
		scnt++;
		
		result.put(S_CNT, ""+scnt);
		
	}

	public void resetHistory() {
		
		history=new HashMap();
		
	}
	
	
	private static void doSuccessMasking() {
		
    		
    		boolean  isSuccess=false;
    		
    		R.getInstance().incrementHistory("x", isSuccess);
    	
    	
    		if(!isSuccess){
    			
    				
    				 boolean result = false;
    			        
    			        
    			        Map history = R.getInstance().getHistory("x");
    			        
    			        double scntD = Double.parseDouble(history.get(R.S_CNT).toString());
    			        double tcntD = Double.parseDouble(history.get(R.T_CNT).toString());
    			        
    			        result = (Math.floor((90  * tcntD)/100)) > Math.floor((scntD));
    			        
    			        if(result){
    			        	
    			        	
    			        	R.getInstance().incrementHistoryForSuccess("x");
    			        }
    			
    		}
    	
		
	}


	public static void main(String args[]) throws UnsupportedEncodingException{
		String test="Wonder Car%3A Hi RUSHIKESH NANDKISHOR INGLE%2C we can%27t reach you for Paid Service 20 of your car MH27BZ0295 due on Aug 17%2C 2020. To book%2C call 8669605638";
		
		System.out.print(URLDecoder.decode(test,"UTF-8"));
		}
	}

