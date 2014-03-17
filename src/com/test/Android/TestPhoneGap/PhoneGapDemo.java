package com.test.Android.TestPhoneGap;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

import com.test.Android.R;

import android.os.Bundle;

public class PhoneGapDemo extends DroidGap{

	
	    @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        // Set by <content src="index.html" /> in config.xml
	       // super.setIntegerProperty("splashscreen", R.drawable.launch); //设置启动页
	       // super.loadUrl(Config.getStartUrl(), 5000);  //带启动页的加载方式
	      //普通加载方式  super.loadUrl(Config.getStartUrl());
	        super.loadUrl("file:///android_asset/www/gamedemo/index.html");
	    }
	
}
