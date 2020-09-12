package com.qa.testapi;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.basetestapi.BaseTest;
import com.qa.client.HttpClient;
import com.qa.payloaddata.UserData;

public class PostTestApiClass extends BaseTest  {
	
	BaseTest base;
	HttpClient clienttest;
	CloseableHttpResponse httpresponse;
	String url;
	String serviceurl;
	String uri;

	public PostTestApiClass() throws IOException {
		
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
	
	public void post() throws IOException {
		
		clienttest= new HttpClient();
		
		HashMap<String, String> headermap= new HashMap<String, String>();
		
		headermap.put("Connection", "keep-alive");
		headermap.put("User-Agent", "somekey");
		
		// Jackson API
			
		ObjectMapper map= new ObjectMapper();
		
		UserData data = new UserData("Checkwww","Engineer233"); // here creating a object to UserData class--a java class
		
		// Now use the object mapper class to convert javaclass to json object
		//map.writeValue(new File("C:/Users/varaprasad/Documents/eclipse-workspace/restapi/src/main/java/com/qa/payloaddata/users.json"), data);
		
		// Now Object to Json in String---- Here the above created Json Object converted to String
		
		String jsonstring=map.writeValueAsString(data);
		
		System.out.println("Values------"+jsonstring);
		
		httpresponse=clienttest.post(uri, jsonstring, headermap);
		
		//Validate the API
		int statuscode=httpresponse.getStatusLine().getStatusCode();
		
		System.out.println("Status-----"+statuscode);
		
		//get the json string
		
		String stringjson=EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
		System.out.println(stringjson);
		
		//String utils=EntityUtils.toString(httpresponse.getEntity(),"UFT-8");
		//System.out.println(utils);
		JSONObject jsonObject= new JSONObject(stringjson);
		System.out.println(jsonObject);
		UserData datausers=map.readValue(stringjson, UserData.class);
		System.out.println(datausers);
		System.out.println(datausers.getName());
		System.out.println(datausers.getJob());
		System.out.println(datausers.getId());
		
	}
	
	
 
}
