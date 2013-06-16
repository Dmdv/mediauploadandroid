package com.example.first;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.AsyncTask;

public class HttpAsyncTask extends AsyncTask<HttpRequestBase, Void, HttpResponse> {

	@Override
	protected HttpResponse doInBackground(HttpRequestBase... requests) {
		
		HttpRequestBase request = requests[0];
		
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;
        
        try{        	        	
        	response = httpclient.execute(request);
        	
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                throw new IOException("Invalid response from server: " + status.toString());
            }
        }
        catch (Exception e){
        	e.printStackTrace();
        }
        
        httpclient.getConnectionManager().shutdown();
        
		return response;
	}
}
