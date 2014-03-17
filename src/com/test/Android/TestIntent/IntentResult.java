package com.test.Android.TestIntent;

import com.test.Android.R;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class IntentResult extends Activity {
	
	TextView showInfo;
	@Override
	public void onCreate(Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
		setContentView(R.layout.intent);
		Toast.makeText(this,"TAG"+"create",10).show();
	    showInfo=(TextView)findViewById(R.id.showcomponent);
		ComponentName com=getIntent().getComponent();
		showInfo.setText(com.toString());
	}
	
}
