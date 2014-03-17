package com.test.Android.TestView;

import com.test.Android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastViewDemo extends Activity {
	
  static Toast mToast=null;
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.toast_view_demo);	 
	   
	}
	
	public void defaltView(View v){
		
		Toast.makeText(getApplicationContext(), "这是默认样式", Toast.LENGTH_SHORT).show();
		
	}
	
    public void optionPosition(View v){
		mToast=Toast.makeText(getApplicationContext(), "这是自定义位置样式", Toast.LENGTH_SHORT);
		mToast.setGravity(Gravity.TOP|Gravity.CENTER, 10, 15);
		mToast.show();
	}
    
   public void optionView(View v){
	   ImageView img=new ImageView(this);
       img.setBackgroundResource(R.drawable.ic_launcher);
	   mToast=new Toast(this);
	   mToast.setDuration(Toast.LENGTH_SHORT);
	   mToast.setView(img);
    //   mToast.setText("这是自定义样式的toast");
       mToast.show();
	}
   
   public void imageToast(View v){

	   mToast=Toast.makeText(getApplicationContext(), "这是带图片的样式", Toast.LENGTH_SHORT);
       ImageView img=new ImageView(this);
       img.setBackgroundResource(R.drawable.ic_launcher);
       LinearLayout view=(LinearLayout)mToast.getView();
       view.addView(img);
       mToast.show();
	}

}
