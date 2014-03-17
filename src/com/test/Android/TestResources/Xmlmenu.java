package com.test.Android.TestResources;


import com.test.Android.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/*注意：从android4.0以上的设备，不再具有menu键*/

@SuppressLint("ResourceAsColor")
public class Xmlmenu extends Activity {
	
	TextView text;
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xmlmenu);
		text=(TextView)findViewById(R.id.text);
		registerForContextMenu(text);	 //注册上下文菜单
	}
	
	//为text添加上下文菜单
	public boolean onCreateOptionMenu(Menu menu){
		MenuInflater inflater=new MenuInflater(this);
		inflater.inflate(R.menu.context, menu); //将R.menu.context 绑定并添加
		
		return super.onCreateOptionsMenu(menu);
				
	}
	//上下文菜单被单机后的处理
    @SuppressLint("ResourceAsColor")
    public boolean  OnContextItemSlected(MenuItem mi){
    	
    	switch(mi.getItemId()){
    	    case R.id.blue:
    	    	mi.setChecked(true);
    	    	text.setBackgroundColor(R.color.blue);
    	    	break;
    	    case R.id.red:
    	    	mi.setChecked(true);
    	    	text.setBackgroundColor(R.color.red);
    	        break;
    	    case R.id.yellow:
    	    	mi.setChecked(true);
    	    	text.setBackgroundColor(R.color.black);
    	        break;
    	}
    	
    	return true;
    }
    
    public boolean OnOptionItemSlected(MenuItem mi){
		
    	switch(mi.getItemId()){
    	 case R.id.meun1:
    		 text.setText("menu1被点击");
    	     break;
    	 case R.id.meun2:
    		 text.setText("menu2被点击");
    	     break;  
    	 case R.id.meun3:
    		 text.setText("menu3被点击");
    	     break;
    	 case R.id.meun4:
    		 text.setText("menu4被点击");
    	     break; 
    	 case R.id.menu5:
    		 text.setText("menu5被点击");
    	     break; 
    	 case R.id.meun6:
    		 text.setText("menu6被点击");
    		 mi.setChecked(true);
    	     break; 
    	 case R.id.meun7:
    		 text.setText("menu7被点击");
    		 mi.setChecked(true);
    	     break;     
    	 case R.id.meun8:
    		 text.setText("menu8被点击");
    		 mi.setChecked(true);
    	     break;     
    	 case R.id.meun9:
    		 text.setText("menu9被点击");
    		 mi.setChecked(true);
    	     break;      
    	}     
    	
    	
    	return true;
    	
    	
    }

}
