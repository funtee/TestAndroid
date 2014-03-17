package com.test.Android.TestActivity;

import com.test.Android.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

@SuppressLint("ResourceAsColor")
public class ActivityResult extends Activity {
	String mName;
	String mPassword;
	
	@SuppressLint("ResourceAsColor")
	public void onCreate(Bundle SavedInstanceState){
		
		super.onCreate(SavedInstanceState);
		LinearLayout l1=new LinearLayout(this);
		l1.setBackgroundColor(R.color.write);
		LinearLayout.LayoutParams ly=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		EditText name=new EditText(this);
		name.setTextColor(R.color.write);
		name.setTextSize(20);
		 mName=name.getText().toString();
		EditText password=new EditText(this);
		password.setTextColor(R.color.write);
		password.setTextSize(20);
		 mPassword=name.getText().toString();
		Button submit=new Button(this);
		submit.setText("提交");
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(ActivityResult.this,ActivityDemo.class);
				Bundle date=new Bundle();
				date.putString("name", mName);
				date.putString("password", mPassword);
				i.putExtras(date);
				ActivityResult.this.setResult(0,i);
				finish();			
			}
			
		});
		l1.addView(name,ly);
		l1.addView(password,ly);
		l1.addView(submit,ly);
		setContentView(l1);
		
	}

}
