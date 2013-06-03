package com.example.first;

public class RestCommand
{
	private static String UserManager = "/Service.svc/UserManager";
	private static String DeviceManager = "/Service.svc/MediaRepositoryService";
	
	public static String get_Host(){
		return "http://mediaupload.cloudapp.net";
	}

	public static String CreateUser(){
		return UserManager + "/create/user";
	}

	public static String IsUserExists(){
		return UserManager + "/isuserexists";
	}

	public static String CreateDevice(){
		return DeviceManager + "/create/device";
	}

	public static String UploadOriginal(){
		return DeviceManager + "/uploadoriginal/{filename}/{deviceid}";
	}

	public static String UploadPreview(){
		return DeviceManager + "/uploadpreview/{filename}/{deviceid}";
	}
}