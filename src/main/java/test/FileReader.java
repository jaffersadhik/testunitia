package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class FileReader {

	public Properties getProperties(String fileName){
		
		Properties prop=new Properties();
		
		
		File configfile=new File("/"+fileName);
		
		InputStream inputStream=null;
		
		try{
			
			inputStream=new FileInputStream(configfile);
			prop.load(inputStream);
		}catch(Exception e){
			
			e.printStackTrace();
			
			return null;
		}
		
		if(prop.size()<1){
			
			return null;
		}
		
		return prop;
	}
	
	
	
	
	public List<String> readFile(String filename){
		

		 List<String> lines=null;
		try {
			lines = Files.readAllLines(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        return lines;
	}
	
	}
