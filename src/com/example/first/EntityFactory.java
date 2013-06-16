package com.example.first;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.json.JSONObject;

public class EntityFactory {
	
	public static HttpEntity createStringEntity (JSONObject json){
		
		StringEntity entity = null;
		try {
			entity = new StringEntity(json.toString());
			entity.setContentEncoding("UTF-8");
	        entity.setContentType("application/json");
	        return entity;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return entity;
	}
	
	public static HttpEntity createGenericMultipartEntity(String name, ContentBody contentBody){
		
		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		entity.addPart(name, contentBody);
		return entity;
	}
	
	public static HttpEntity createFileEntity(String filePath){
		
		File image = new File(filePath);
		FileEntity fileEntity = new FileEntity(image, "application/octet-stream");
		return fileEntity;
		
//		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
//		FileBody fileBody = new FileBody(image, filePath, "images/jpeg");
//		if (fileBody.getContentLength() == 0){
//			return null;
//		}
//		entity.addPart("image", fileBody);
//		return entity;
	}
}
