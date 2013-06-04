package com.example.first;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public class EntityFactory {
	public static StringEntity CreateStringEntity (JSONObject json){
		StringEntity entity;
		try {
			entity = new StringEntity(json.toString());
			entity.setContentEncoding("UTF-8");
	        entity.setContentType("application/json");
	        return entity;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
