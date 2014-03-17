package com.test.Android.TestView;

import com.test.Android.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class windowViewDemo extends Activity {
	
  
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		LinearLayout lay=new LinearLayout(this);
		LinearLayout.LayoutParams pas=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
	    lay.setOrientation(0);
		final TextView show=new TextView(this);
		Button bt1=new Button(this);
		bt1.setText("屏幕宽高");
	    lay.addView(show,pas);	    
		setContentView(lay);
		bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//获取屏幕宽和高
				DisplayMetrics dm = new DisplayMetrics();
				 //获取屏幕信息
				        getWindowManager().getDefaultDisplay().getMetrics(dm);
				 
				        int screenWidth = dm.widthPixels;
				 
			           int screenHeigh = dm.heightPixels;
			           show.setText("屏幕宽为："+screenWidth+"\n"+"屏幕高为："+screenHeigh+"\n");
			}
			
		});
	}
	
	

}
