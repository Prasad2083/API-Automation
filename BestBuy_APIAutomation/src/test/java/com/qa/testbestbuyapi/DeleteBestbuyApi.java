package com.qa.testbestbuyapi;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.apiaction.ClientSetUp;
import com.qa.baseclass.Baseclass;

public class DeleteBestbuyApi extends Baseclass {
	
	ClientSetUp client;
	Baseclass base;
	String url;
	String uri;
	String api;
	CloseableHttpResponse response;

	public DeleteBestbuyApi() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		client= new ClientSetUp();
		base= new Baseclass();
		url=prop.getProperty("MainURL");
		uri=prop.getProperty("EndPoint");
		api=url+uri;	
	}
	
	@Test
	public void deletebest() throws ClientProtocolException, IOException {
		
		HashMap<String, String> addheaders=new HashMap<String, String>();
		addheaders.put("Accept", "application/json");
		
		response=client.DeleteMethod(api, addheaders);
		
		int statuscode=response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		
	}

}
