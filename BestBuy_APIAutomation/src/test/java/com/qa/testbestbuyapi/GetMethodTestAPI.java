package com.qa.testbestbuyapi;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.apiaction.ClientSetUp;
import com.qa.baseclass.Baseclass;

public class GetMethodTestAPI extends Baseclass{
	
	
	String url = null;
	String uri = null;
	String api;
	CloseableHttpResponse response;
	ClientSetUp setclient;
	String entityresponse;
	Baseclass base;

	public GetMethodTestAPI() throws IOException{
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException {
		base=new Baseclass();
		setclient=new ClientSetUp();
		url=prop.getProperty("MainURL");
		uri=prop.getProperty("EndPoint");
		api = url+uri;
		
	}
	@Test
	public void getmethodtest() throws ClientProtocolException, IOException{
		HashMap<String, String > gethead= new HashMap<String, String>();
		gethead.put("Accept", "application/json");
		response= setclient.GetMethod(api, gethead);
		int status=response.getStatusLine().getStatusCode();
		System.out.println(status);
		
		entityresponse= EntityUtils.toString(response.getEntity());
		
		System.out.println(entityresponse);
		
		
		JSONObject obj= new JSONObject(entityresponse);
		
		System.out.println("Final Json out put"+ obj);
		
	}
	
		
	}
	
	
	


