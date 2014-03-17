package com.test.Android.TestActivity;


import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class LauncherActivityDemo extends  LauncherActivity {
     
	String[] array={"设置参数","查看游戏配置"};
	 Class<?>[] classes={PreferenceActivityDemo.class,ExpandableAvtivityDemo.class};
	 
	 @Override
	 public void onCreate(Bundle savedInstanceState){
		  super.onCreate(savedInstanceState);
		  ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
		  setListAdapter(adapter);
		  
	  }
	 
	 public Intent IntentForPosition(int position){
		 
		 return new Intent(LauncherActivityDemo.this,classes[position]);
	 }
}
