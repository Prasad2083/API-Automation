package com.qa.testapi;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetestapi.BaseTest;
import com.qa.client.HttpClient;

public class TestDelete extends BaseTest {
	BaseTest base;
	HttpClient clienttest;
	CloseableHttpResponse httpresponse;
	String url;
	String serviceurl;
	String uri;

	public TestDelete() throws IOException {
		super();
				
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		base= new BaseTest();
		url= prop.getProperty("URL");
		serviceurl=prop.getProperty("ServiceURL");
		uri= url+serviceurl; 
	}
	
	@Test
	public void httpdelete() throws IOException{
		
		clienttest=new HttpClient();
		
		HashMap<String, String> deleteheaders=new HashMap<String, String>();
		
		deleteheaders.put("Connection", "keep-alive");
		
		httpresponse= clienttest.delete(uri, deleteheaders);
		
		int statuscode=httpresponse.getStatusLine().getStatusCode();
		
		System.out.println(statuscode);
			
	}
	
	

}
