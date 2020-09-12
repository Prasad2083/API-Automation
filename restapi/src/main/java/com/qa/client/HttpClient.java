package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.qa.basetestapi.BaseTest;

public class HttpClient extends BaseTest {

	public HttpClient() throws IOException {
		super();
		
	}
	//******** GET METHOD ********//
	
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
	
	//******** GET METHOD ********//
	
	
	//******** POST METHOD ********//
	
	//Post Method with headers //
	
	public CloseableHttpResponse post(String url, String newentity, HashMap<String, String> hashmapheaders) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient= HttpClients.createDefault();
		
		HttpPost httppost= new HttpPost(url); // creating a url request
		httppost.setEntity(new StringEntity(newentity)); // Create a payload to post the data using new string entity
		// for headers same as GET 
		for(Map.Entry<String, String> headmap: hashmapheaders.entrySet()) {
			
			httppost.addHeader(headmap.getKey(),headmap.getValue());
			
			System.out.println("Values from java class post method hashmap :"+headmap.getKey()+ " "+ headmap.getValue());
		}
		CloseableHttpResponse httpPostResponse= httpclient.execute(httppost);
		return httpPostResponse;
		
	}
	
	
	
	//****** DELETE METHOD ******//
	
	public CloseableHttpResponse delete(String url, HashMap<String, String>deletehashmapheaders) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpDelete httpdelete = new HttpDelete(url);
		
		for(Map.Entry<String, String>deleteheadmap:deletehashmapheaders.entrySet()) {
			httpdelete.addHeader(deleteheadmap.getKey(), deleteheadmap.getValue());
		}
		
		CloseableHttpResponse httpdeleteresponse = httpClient.execute(httpdelete);
		return httpdeleteresponse;
		
		
	}
	
	
}