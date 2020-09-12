package com.qa.testapi;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetestapi.BaseTest;
import com.qa.client.HttpClient;
import com.qa.testutilsapi.TestUtils;

public class TestApiClass extends BaseTest {
	String uri;
	String url;
	String serviceurl;
	BaseTest base;
	HttpClient clienttest;
	CloseableHttpResponse httpresponse;
	Integer statuscode;
	String response;
	JSONObject jsonobject;
	public TestApiClass() throws IOException {
		
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		 base= new BaseTest();
		 clienttest= new HttpClient();
		url= prop.getProperty("URL");
		serviceurl=prop.getProperty("ServiceURL");
		 uri= url+serviceurl; 
		
	}
	
	@Test
	public void geturl() throws ClientProtocolException, IOException {
		
		
		    httpresponse=clienttest.get(uri);
		
		    statuscode =httpresponse.getStatusLine().getStatusCode(); // To get a response code for particular url request
			System.out.println(statuscode);
		
			response=EntityUtils.toString(httpresponse.getEntity()); // to get the entire response we are using EntityUtils
			                                                                 //responsestored(httpresponse).get
			
			System.out.println(response);
			
			
		    jsonobject = new JSONObject(response);// we are getting response in string format convert to json
			
			
			System.out.println(jsonobject);
			
			// Single Value fetching from Json
			// Can fetch values from json any single value from json
			
			//String jsonvalue=TestUtils.getjsonvalue(jsonobject, "/per_page");
			
			//System.out.println("Value of Json Path-----------"+jsonvalue);
			
			//Assert.assertEquals(Integer.parseInt(jsonvalue), 6,"Value not found");
			
			// Array type fetching from Json
			// Fetching json values from array type data in json
			
			String jsonarrayvalue= TestUtils.getjsonvalue(jsonobject, "/data[2]/email");
			String jsonarrayvalue1= TestUtils.getjsonvalue(jsonobject, "/data[2]/id");
			String jsonarrayvalue2= TestUtils.getjsonvalue(jsonobject, "/data[2]/first_name");
			String jsonarrayvalue3= TestUtils.getjsonvalue(jsonobject, "/data[2]/last_name");
			System.out.println("Value of jasonarray"+" "+jsonarrayvalue+
					" "+jsonarrayvalue1+" "+jsonarrayvalue2+" "+jsonarrayvalue3);
			Header[] headers=httpresponse.getAllHeaders(); // to validate headers in the response we use this method
			
			HashMap<String, String> allheaders = new HashMap<String, String>(); // Store all the headers in hashmap
			// We need to use hashmap because the headers have key value pairs....Storing everything in key value format
			
			for(Header responseheaders:headers) { // for each loop--- is used
				
				allheaders.put(responseheaders.getName(), responseheaders.getValue());
				
			}
			//To get the value of the key in headers and added assertion to validate
			//System.out.println(allheaders.get("Transfer-Encoding"));
			System.out.println("Hashmapheaders size---------"+ allheaders);
			String header1=allheaders.get("Transfer-Encoding");
			Assert.assertEquals(header1, "chunked","Value not found");
			httpresponse.close();
		}
	
	
	
	
	
	@Test
	public void geturlwithheader() throws ClientProtocolException, IOException {
		
		HashMap< String, String> headerhash= new HashMap<String, String>();
		
	    	headerhash.put("Connection", "keep-alive");
	    	headerhash.put("User-Agent", "somekey");
		
		    httpresponse=clienttest.get(uri,headerhash);
		
		    statuscode =httpresponse.getStatusLine().getStatusCode(); // To get a response code for particular url request
			System.out.println(statuscode);
		
			response=EntityUtils.toString(httpresponse.getEntity()); // to get the entire response we are using EntityUtils
			                                                                 //responsestored(httpresponse).get
			
			System.out.println(response);
			
			
		    jsonobject = new JSONObject(response);// we are getting response in string format convert to json
			
			
			System.out.println(jsonobject);
			
			// Single Value fetching from Json
			// Can fetch values from json any single value from json
			
			String jsonvalue=TestUtils.getjsonvalue(jsonobject, "/per_page");
			
			System.out.println("Value of Json Path-----------"+jsonvalue);
			
			Assert.assertEquals(Integer.parseInt(jsonvalue), 6,"Value not found");
			
			// Array type fetching from Json
			// Fetching json values from array type data in json
			
			String jsonarrayvalue= TestUtils.getjsonvalue(jsonobject, "/data[2]/email");
			String jsonarrayvalue1= TestUtils.getjsonvalue(jsonobject, "/data[2]/id");
			String jsonarrayvalue2= TestUtils.getjsonvalue(jsonobject, "/data[2]/first_name");
			String jsonarrayvalue3= TestUtils.getjsonvalue(jsonobject, "/data[2]/last_name");
			System.out.println("Value of jasonarray"+" "+jsonarrayvalue+
					" "+jsonarrayvalue1+" "+jsonarrayvalue2+" "+jsonarrayvalue3);
			Header[] headers=httpresponse.getAllHeaders(); // to validate headers in the response we use this method
			
			HashMap<String, String> allheaders = new HashMap<String, String>(); // Store all the headers in hashmap
			// We need to use hashmap because the headers have key value pairs....Storing everything in key value format
			
			for(Header responseheaders:headers) { // for each loop--- is used
				
				allheaders.put(responseheaders.getName(), responseheaders.getValue());
				
			}
			//To get the value of the key in headers and added assertion to validate
			//System.out.println(allheaders.get("Transfer-Encoding"));
			System.out.println("Hashmapheaders size---------"+ allheaders);
			String header1=allheaders.get("Transfer-Encoding");
			Assert.assertEquals(header1, "chunked","Value not found");
			httpresponse.close();
		}
	
	
		
	@Test
	public void statuscode() {
		assertEquals(String.valueOf(statuscode), String.valueOf(Response_200),"Status Code is not matched");
		
	}
	
	
	@Test
	public void wrongurlvalidate() throws ClientProtocolException, IOException {
		String urix=uri+"22222222222222";
		clienttest.get(urix);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
