package com.hackathon;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsListener extends BroadcastReceiver{
	//public static final String SMS_EXTRA_NAME = "pdus";
	public static final String BODY = "body";
	String title,descr,body,address,link =""; 
	//String link = "http://10.0.2.2/farmers/post.php";
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		 String messages = "";
         	
		 if (bundle != null)
	        {
	            // Get received SMS array
	            Object[] smsExtra = (Object[]) bundle.get("pdus");
	                                     
	            for ( int i = 0; i < smsExtra.length; ++i )
	            {
	                SmsMessage sms = SmsMessage.createFromPdu((byte[])smsExtra[i]);
	                 
	                body = sms.getMessageBody().toString();
	                address = sms.getOriginatingAddress();
	                 
	                messages += "SMS from " + address + " :\n result after verification ";                   
	                messages += verify(body) + "\n";
	                new PostSms().execute();
	                //and here comes the magic
	                
	                
	            }
	             
	            // Display SMS message
	            Toast.makeText( context, messages, Toast.LENGTH_SHORT ).show();
	        }
         	
	    }
	public String verify(String str)
	{	String result, check;
		check = str.trim();
			
		if(check.substring(0, 1).equals("1"))
		{
			link = "http://10.0.2.2/api_android/post_question.php";
			//link = "http://192.168.0.156/api_android/post_question.php";
			result = check.substring(1,check.length());
			//Toast.makeText(Ict4Ag.this, result, Toast.LENGTH_SHORT).show();
		
		}else if(check.substring(0, 1).equals("2"))
		{
			//link = "http://192.168.0.156/api_android/post_update.php";
			link = "http://10.0.2.2/api_android/post_update.php";
			result = check.substring(1, check.length());
			
			//Toast.makeText(Ict4Ag.this, result, Toast.LENGTH_SHORT).show();
		}else if(check.substring(0, 1).equals("3"))
		{
			link = "http://10.0.2.2/api_android/post_project.php";
			result = check.substring(1, check.length());
			
			//Toast.makeText(Ict4Ag.this, result, Toast.LENGTH_SHORT).show();
		}else if(check.substring(0, 1).equals("4"))
		{
			link = "http://10.0.2.2/api_android/post_op.php";
			result = check.substring(1, check.length());
			
			//Toast.makeText(Ict4Ag.this, result, Toast.LENGTH_SHORT).show();
		}else
		{
			result = "UNKNOWN COMMAND :/";
			//Toast.makeText(Ict4Ag.this, result, Toast.LENGTH_SHORT).show();
		}
			
		return result;
		
	}
	class PostSms extends AsyncTask<String, String, String>
	{
	@Override
	protected String doInBackground(String... args) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		//HttpPost url = new HttpPost("http://10.0.2.2/farmers/post.php");
		//HttpPost url = new HttpPost("http://192.168.0.156/farmers/post.php");
		HttpPost url = new HttpPost(link);
		title = address;
		descr = verify(body);
		try
		{
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("title", title));
			params.add(new BasicNameValuePair("descr", descr));
			url.setEntity(new UrlEncodedFormEntity(params));
			Log.d("Create Response", url.toString());
			httpclient.execute(url);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	}
}


