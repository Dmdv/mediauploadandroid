package com.example.first;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button buttonGetImage = (Button)findViewById(R.id.buttonGetImage);
        buttonGetImage.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		SampleRequest.GetImage();
        	}
        });
        
        Button buttonUploadImage = (Button)findViewById(R.id.buttonUploadImage);
        buttonUploadImage.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		SampleRequest.UploadImage();
        	}
        });

        Button buttonCreateUser = (Button)findViewById(R.id.buttonCreateUser);
        buttonCreateUser.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		SampleRequest.CreateUser();
        	}
        });
        
        Button buttonCreateDevice = (Button)findViewById(R.id.buttonCreateDevice);
        buttonCreateDevice.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		SampleRequest.CreateDevice();
        	}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	}
}
