package com.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Ict4Ag extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ict4_ag);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ict4_ag, menu);
		return true;
	}

}
