package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.qa.basetestapi.BaseTest;

public class HttpClient extends BaseTest {

	public HttpClient() throws IOException {
		super();
		
	}
	
	//Get Method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient= HttpClients.createDefault(); // create the connection to send request and response 
		HttpGet httpget=new HttpGet(url); // Creating method to get request response
		CloseableHttpResponse httpresponse= httpclient.execute(httpget); // hit the url to get the response
		Integer statuscode =httpresponse.getStatusLine().getStatusCode(); // To get a response code for particular url request
		System.out.println(statuscode);
	
		String response=EntityUtils.toString(httpresponse.getEntity()); // to get the entire response we are using EntityUtils
		                                                                 //responsestored(httpresponse).get
		
		System.out.println(response);
		
		
		JSONObject jsonobject = new JSONObject(response);// we are getting response in string format convert to json
		
		
		System.out.println(jsonobject);
		
		
		Header[] headers=httpresponse.getAllHeaders(); // to validate headers in the response we use this method
		
		HashMap<String, String> allheaders = new HashMap<String, String>(); // Store all the headers in hashmap
		
		for(Header responseheaders:headers) { // for each loop--- is used
			
			allheaders.put(responseheaders.getName(), responseheaders.getValue());
			
		}
		
		System.out.println("Hashmapheaders"+ allheaders);
		httpresponse.close();
	}

}
