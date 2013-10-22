package com.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ict4Ag extends Activity{
	
	String ip,msg="";
	Button start, save;
	EditText ipAddress;
	String returnString,keyword=SmsListener.BODY;
	String smsNoToSend, smsBody;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		        super.onCreate(savedInstanceState);
		
		setContentView(R.layout.ict4_ag);
		start = (Button) findViewById(R.id.start);
		save = (Button) findViewById(R.id.save);
		ipAddress = (EditText) findViewById(R.id.ip);
		ip = ipAddress.getText().toString();
		Intent intent = new Intent();
		intent.putExtra("Ip_Adress", ip);
				
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
		     
		         } 
			
		});
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.d("saved", "");
				//new PostSms().execute();
				
			}
		});
	}
	
	
}
