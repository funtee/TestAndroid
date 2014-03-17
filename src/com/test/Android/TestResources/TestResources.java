package com.test.Android.TestResources;

import java.util.Timer;
import java.util.TimerTask;

import com.test.Android.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class TestResources extends Activity {

		
	@Override 
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resources);
			
	}
	public void resource(View v){
		Intent i=new Intent(this,ResourcesDemo.class);
		startActivity(i);
	}
	
	public void animation(View v){
		Intent i=new Intent(this,AnimationDemo.class);
		startActivity(i);
	}
	
	public void xmlTest(View v){
		Intent i=new Intent(this,Xmlparse.class);
		startActivity(i);
	}
	
	public void xmlmenu(View v){
		Intent i=new Intent(this,Xmlmenu.class);
		startActivity(i);
	}
	
	public void showOther(View v){
		Intent i=new Intent(this,OriginalResource.class);
		startActivity(i);
	}
	

}
