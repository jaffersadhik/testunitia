package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.fasterxml.jackson.databind.ObjectMapper;


public class App extends AbstractHandler
{
    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException,
        ServletException
    {
    	try{
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);

        String uri=request.getRequestURI();
        if(uri.startsWith("/sendjson")){
       String msg=getRequestFromBody(request);
       System.out.println(msg);
       response.getWriter().println(toMap(msg));

        }
        baseRequest.setHandled(true);
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}
    	}

    public final static String getRequestFromBody(HttpServletRequest aRequest)

    {

    BufferedReader br = null;

    StringBuffer sb = new StringBuffer();

    String reqString = null;

     

     int bytesRead = -1;

      try

    {

      char[] charBuffer = new char[1024];

      br = new BufferedReader(new InputStreamReader(aRequest.getInputStream()));

     

     while ((bytesRead = br.read(charBuffer)) > 0)

    {

      sb.append(charBuffer, 0, bytesRead);

    }

      reqString = sb.toString();

    }

      catch (Exception e)

    {

      e.printStackTrace();

    }

      finally

    {

      try

    {

      if (br != null)

      br.close();

    }

      catch (Exception ex)

    {

      // ignore it

    }

    }

      return reqString;

    }
    private boolean isASCII(String word){
    for (char c: word.toCharArray()){
    	  if (((int)c)>127){
    	    return false;
    	  } 
    	}
    	return true;
    }
    public static void main(String[] args) throws Exception
    {
    	
    
        Server server = new Server(8080);
        server.setHandler(new App());

        server.start();
        server.join();
   
      }
    

public static Map<String, Object> toMap(String jsonstring) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		   try { 
	        	  
	        	return  mapper.readValue(jsonstring, Map.class);
	  
	        } 
	  
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
		return null;
		
		
		
	}
}

