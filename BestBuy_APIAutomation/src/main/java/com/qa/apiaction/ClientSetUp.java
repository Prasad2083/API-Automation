package com.qa.apiaction;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.qa.baseclass.Baseclass;

public class ClientSetUp extends Baseclass {

	public ClientSetUp() throws IOException {
		super();
		
	}
	
	//**** GET Method ****//
	
	public CloseableHttpResponse GetMethod(String url, HashMap<String, String>getheaders) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		
		for(Map.Entry<String,String>getapigeaders: getheaders.entrySet()) {
			httpget.addHeader(getapigeaders.getKey(), getapigeaders.getValue());
			
		}
		
		CloseableHttpResponse response= httpclient.execute(httpget);
		return response;
		
	}
	
	
	// **** Delete Method ****//
	
	public CloseableHttpResponse DeleteMethod(String url, HashMap<String, String> deleteheaders) throws ClientProtocolException, IOException {
		
		CloseableHttpClient deleteclient= HttpClients.createDefault();
		
		HttpDelete bestbuyapidel= new HttpDelete(url);
		
		for(Map.Entry<String, String>deletemethod : deleteheaders.entrySet()) {
			bestbuyapidel.addHeader(deletemethod.getKey(), deletemethod.getValue());	
		}
		
		CloseableHttpResponse deleteresponse= deleteclient.execute(bestbuyapidel);
		return deleteresponse;
					
		
	}
	
	
	//  **** Post Method **** //
	
	public CloseableHttpResponse PostMethod(String url, String entity,HashMap<String, String>postheaders) throws ClientProtocolException, IOException {
		
		CloseableHttpClient postclient= HttpClients.createDefault();
		
		HttpPost httppost= new HttpPost(url);
		//httppost.setEntity(new StringEntity(newentity)); 
		
		httppost.setEntity(new StringEntity(entity));
		
		for(Map.Entry<String, String>setheaders : postheaders.entrySet()) {
			httppost.addHeader(setheaders.getKey(), setheaders.getValue());
		}
		
		CloseableHttpResponse postresponse = postclient.execute(httppost);
	
		return postresponse;
		
		
	}
	
	
	// **** Put Method **** //
	
	public CloseableHttpResponse PutMethod(String url, String putentity,HashMap<String, String>putheaders ) throws ClientProtocolException, IOException {
		CloseableHttpClient putclient= HttpClients.createDefault();
		HttpPut httpput = new HttpPut(url);
		httpput.setEntity(new StringEntity(putentity));
		for(Map.Entry<String, String>setheaders : putheaders.entrySet()) {
			httpput.addHeader(setheaders.getKey(), setheaders.getValue());
		}
		
		CloseableHttpResponse putresponse = putclient.execute(httpput);
	
		return putresponse;
		
	}

	

}
