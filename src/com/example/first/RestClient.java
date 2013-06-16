package com.example.first;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

//  TODO: Obsolete class, do not use.
public class RestClient {

	public static String get(String host, int port, String path, String postBody) throws IOException {
		
		HttpHost target = new HttpHost(host, port);
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(path);
		HttpEntity results = null;
		
		try {
			HttpResponse response = client.execute(target, get);
			results = response.getEntity();
			return EntityUtils.toString(results);
		} catch (Exception e) {
			
		throw new RuntimeException("Web Service Failure");
		} finally {
			if (results!=null)
				try {
					results.consumeContent();
					} catch (IOException e) {
					// empty, Checked exception but don't care
					}
				}
		}
}