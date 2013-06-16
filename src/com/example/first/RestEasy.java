package com.example.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONException;
import org.json.JSONObject;

public class RestEasy {
	 
    public static String doPost(String url, HttpEntity entity) throws ClientProtocolException, IOException 
    {
        HttpPost request = new HttpPost(url);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        request.setEntity(entity);
        
        return internalTask(request);
    }
    
    public static String doPostRaw(String url, HttpEntity entity) throws ClientProtocolException, IOException 
    {
        HttpPost request = new HttpPost(url);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/octet-stream");
        request.setEntity(entity);
        
        return internalTask(request);
    }
    
    public static String doPut(String url, HttpEntity entity) throws ClientProtocolException, IOException
    {
    	HttpPut request = new HttpPut(url);
    	request.setHeader("Accept", "application/json");
        request.setEntity(entity);

        return internalTask(request);
    }
    
    public static String doDelete(String url) throws ClientProtocolException, IOException
    {	
    	HttpDelete request = new HttpDelete(url);
    	request.addHeader("Accept", "application/json");
    	
    	return internalTask(request);
    }
 
    public static JSONObject doGet(String url)
    {
    	JSONObject json = null;
    	
        HttpGet request = new HttpGet(url); 
        
        request.addHeader("Accept", "application/json");
        
        String result = internalTask(request);
        
        try {
        	json = new JSONObject(result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        
        return json;
    }
        
    // Convert Inputstream to string
    public static String convertStreamToString(HttpResponse response) {
    	
    	InputStream is = null;
		try {
			is = response.getEntity().getContent();
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if (is == null){
			return "";
		}
    	
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

	private static String internalTask(HttpRequestBase request) {
		
		HttpAsyncTask task = new HttpAsyncTask();
	    HttpResponse response = null;
	    
	    try {
	    	response = task.execute(request).get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
	    
	    return response == null ? "" :  convertStreamToString(response);
	}
}