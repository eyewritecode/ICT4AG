package com.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;

public class Ict4Ag extends Activity {
	
	String msg;
	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.ict4_ag);
		start = (Button) findViewById(R.id.start);
		Uri sms = Uri.parse("content://sms/inbox");		
		Cursor cur = getContentResolver().query(sms, null, null, null, null);
		
		if(cur.moveToNext())
		{
			 msg = cur.getString(cur.getColumnIndex("body"));
			 verify(msg);
		}
		
	}
	public String verify(String str)
	{	String result = str.trim().substring(0,1);
	
		if(result == "1")
		{
			Toast.makeText(this.getBaseContext(), "ikibazo", Toast.LENGTH_SHORT).show();
		}else if(result == "2")
		{
			Toast.makeText(this.getBaseContext(), "umusaruro", Toast.LENGTH_SHORT).show();
		}
		return result;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ict4_ag, menu);
		return true;
	}

}
