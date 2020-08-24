package com.qa.client;

import java.io.IOException;
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
	
	//Get Method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient= HttpClients.createDefault(); // create the connection to send request and response 
		HttpGet httpget=new HttpGet(url); // Creating method to get request response
		CloseableHttpResponse httpresponse= httpclient.execute(httpget); // hit the url to get the response
return httpresponse;
}
	
	
}