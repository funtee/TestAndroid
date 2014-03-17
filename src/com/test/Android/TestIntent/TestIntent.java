package com.test.Android.TestIntent;

import com.test.Android.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TestIntent extends Activity {
	TextView showInfo;
	public static  String Action="com.test.Android.OptionAction";
	public static  String Category="com.test.Android.optionCategory";
	@Override
	public void onCreate(Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
		setContentView(R.layout.intent);
		Toast.makeText(this,"TAG"+"create",10).show();
	    showInfo=(TextView)findViewById(R.id.showcomponent);
		ComponentName com=getIntent().getComponent();
		showInfo.setText(com.toString());
	}	
	public void action(View v){
		Intent i=new Intent();
		i.setAction(Action);
//		i.addCategory(Category);
		startActivity(i);
	}
	
	//启动action View
	public void actionView(View v){
		Intent i=new Intent();
		i.setAction(Intent.ACTION_VIEW);
	//	i.setType("");
		startActivity(i);
	}
	//回到手机桌面的intent
	public void actionHome(View v){
		Intent i=new Intent();
		i.setAction(Intent.ACTION_MAIN);
		i.addCategory(Intent.CATEGORY_HOME);
		startActivity(i);
	}
}
