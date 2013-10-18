package com.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.net.Uri;

public class Ict4Ag extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ict4_ag);
		Uri sms = Uri.parse("content://sms/inbox");		
		Cursor cur = getContentResolver().query(sms, null, null, null, null);
		
		if(cur.moveToNext())
		{
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ict4_ag, menu);
		return true;
	}

}
