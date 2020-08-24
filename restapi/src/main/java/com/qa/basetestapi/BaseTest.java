package com.qa.basetestapi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
	
	public Properties prop;
	
	public int Response_200=200;
	public int Response_404=404;
	public int Response_201=201;
	public int Response_400=400;
	public int Response_203=203;
	public int Response_501=501;

		public BaseTest() throws IOException {
			
			prop= new Properties();
			
			FileInputStream fis= new FileInputStream("C:\\Users\\varaprasad\\Documents\\eclipse-workspace\\restapi\\"
					+ "src\\main\\java\\com\\qa\\configproperties\\config.properties");
			prop.load(fis);
			
		}

}
