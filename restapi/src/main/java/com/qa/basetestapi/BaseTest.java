package com.qa.basetestapi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
	
	public Properties prop;
	
	
		public BaseTest() throws IOException {
			
			prop= new Properties();
			
			FileInputStream fis= new FileInputStream("C:\\Users\\varaprasad\\Documents\\eclipse-workspace\\restapi\\"
					+ "src\\main\\java\\com\\qa\\configproperties\\config.properties");
			prop.load(fis);
			
		}

}
