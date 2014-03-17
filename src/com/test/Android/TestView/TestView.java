package com.test.Android.TestView;


import com.test.Android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestView extends Activity {
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
			setContentView(R.layout.viewdemo);		
	}
	
	public void optionView(View v){
		Intent i=new Intent(this,OptionView.class);
		startActivity(i);
		
	}
	
	public void toastView(View v){
		Intent i=new Intent(this,ToastViewDemo.class);
		startActivity(i);
		
	}
	
	public void windwoView(View v){
		Intent i=new Intent(this,windowViewDemo.class);
		startActivity(i);
		
	}

}
