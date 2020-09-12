package com.qa.baseclass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Baseclass {
	
	
	public static int Response_200=200;
	public static int Response_404=404;
	public static int Response_201=201;
	public int Response_400=400;
	public int Response_203=203;
	public int Response_501=501;
	
	public static Properties prop;
	
	public Baseclass() throws IOException {
		
		
		prop= new Properties();
		
		FileInputStream apifile= new FileInputStream("C:\\Users\\varaprasad\\Documents\\eclipse-workspace\\BestBuy_APIAutomation\\src"
				+ "\\main\\java\\com\\qa\\configproperties\\config.properties");
		
		prop.load(apifile);
		
	}
	
	
	

}
