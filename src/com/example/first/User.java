package com.example.first;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;


public class User implements IJsonConverter {
	
	private String _userId;
	private String _name;
	private String _password;
	
	public User(UUID uuid, String name, String password){
		_userId = uuid.toString();
		_name = name;
		_password = password;
	}
		
	public String get_UserId() {
		return _userId;
	}
	
	public String get_Name() {
		return _name;
	}

	public String get_Password() {
		return _password;
	}
	
	public JSONObject toJsonObject(){
		
		 JSONObject json = new JSONObject();
         try
         {
        	 json.put("userId", _userId);
        	 json.put("name", _name);
             json.put("password", _password);                 
         }
         catch (JSONException e)
         {
        	 e.printStackTrace();
         }
         
         return json;
	}
}