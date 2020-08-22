package com.qa.testapi;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetestapi.BaseTest;
import com.qa.client.HttpClient;

public class TestApiClass extends BaseTest {
	String uri;
	String url;
	String serviceurl;
	BaseTest base;
	
	public TestApiClass() throws IOException {
		
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		 base= new BaseTest();
		url= prop.getProperty("URL");
		serviceurl=prop.getProperty("ServiceURL");
		 uri= url+serviceurl;
		
	}
	
	@Test
	public void geturl() throws ClientProtocolException, IOException {
		HttpClient clienttest= new HttpClient();
		clienttest.get(uri);
	}
	
	

}
