package com.qa.testbestbuyapi;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.apiaction.ClientSetUp;
import com.qa.baseclass.Baseclass;
import com.qa.testdata.DataforPutMethod;


public class PostMethodTestAPI extends Baseclass {
	
	Baseclass base;
	CloseableHttpResponse presponse;
	ClientSetUp client;
	String uri;
	String url;
	String api;

	public PostMethodTestAPI() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException {
		base= new Baseclass();
		client= new ClientSetUp();
		uri=prop.getProperty("MainURL");
		url=prop.getProperty("EndPoint");
		api=uri+url;	
	}
	
	@Test
	public void postmethodapi() throws ClientProtocolException, IOException {
		HashMap<String, String>getpostheaders=new HashMap<String, String>();
		getpostheaders.put("Content-Type", "application/json");
		
		// Implament Jackson API
		
		ObjectMapper postmap = new ObjectMapper();
		DataforPutMethod postdata = new DataforPutMethod("harshith", "Foodstoremontreal", "2555", "244555", "ghhhh",
				"Caada", "inetrnational", "8unsj", "mail", "mnahg");
		
		// Proper Implemantation of Jackson API
		
		postmap.writeValue(new File("C:/Users/varaprasad/Documents/eclipse-workspace/BestBuy_APIAutomation/"
				+ "src/main/java/com/qa/testdata/post.json"), postdata);
		
		String postdataintourl=postmap.writeValueAsString(postdata);
		
		System.out.println(postdataintourl);
		
		presponse= client.PostMethod(api, postdataintourl, getpostheaders);
		
        int statuscode=presponse.getStatusLine().getStatusCode();
        
        assertEquals(statuscode,Baseclass.Response_201 );
        
        System.out.println(statuscode);
        
        String stringjson=EntityUtils.toString(presponse.getEntity(),"UTF-8");
		//System.out.println(stringjson);
		
		//String utils=EntityUtils.toString(httpresponse.getEntity(),"UFT-8");
		//System.out.println(utils);
		JSONObject jsonObject= new JSONObject(stringjson);
		System.out.println(jsonObject);
		
		//DataforPutMethod getvalues= postmap.readValue(stringjson, DataforPutMethod.class);
		//System.out.println(getvalues.getDescription());
		
	}

}
