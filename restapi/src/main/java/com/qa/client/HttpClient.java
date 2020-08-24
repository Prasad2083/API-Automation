package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.qa.basetestapi.BaseTest;

public class HttpClient extends BaseTest {

	public HttpClient() throws IOException {
		super();
		
	}
	
	//Get Method without headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient= HttpClients.createDefault(); // create the connection to send request and response 
		HttpGet httpget=new HttpGet(url); // Creating method to get request response
		CloseableHttpResponse httpresponse= httpclient.execute(httpget); // hit the url to get the response
return httpresponse;
}
	
	//Get Method with headers
	
	public CloseableHttpResponse get(String url,HashMap<String,String>hashmapheaders) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		
		for(Map.Entry<String, String> headmap: hashmapheaders.entrySet()) {
		
	     httpget.addHeader(headmap.getKey(), headmap.getValue());
	     
	     System.out.println("Value from java class hashmap :"+headmap.getKey()+ " "+ headmap.getValue());
		
		}
		CloseableHttpResponse httpresponse= httpClient.execute(httpget);
		
		
		return httpresponse;
	}
	
	
}