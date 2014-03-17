package com.test.Android.TestView;

import com.test.Android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class OptionView extends Activity {
	
	float beginX;
	float endX;
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.option_view);	 
	    LinearLayout lay=(LinearLayout)findViewById(R.id.view);
	    final MyView myView=new MyView(this);
	    myView.setMinimumWidth(100);
	    myView.setMinimumHeight(100);
	    myView.setOnTouchListener(new OnTouchListener(){
	   
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				myView.currentX=event.getX();
				myView.currentY=event.getY();
				//组件重新绘制
				myView.invalidate();
				return true;
			}
	    	
	    });
	    
	    lay.addView(myView);
	}

}
