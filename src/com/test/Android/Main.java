package com.test.Android;

import com.fl.gamehelper.base.info.GameInfo;
import com.flgame.minisdk.MiniSDKManager;
import com.flgame.minisdk.TestClass;
import com.flsdk.minisdk.FLMiniSdkFunctionInit;
import com.test.Android.DB.SqlActivity;
import com.test.Android.Nfc.NfcDemo;
import com.test.Android.TestActivity.ActivityDemo;
import com.test.Android.TestActivity.ExpandableAvtivityDemo;
import com.test.Android.TestActivity.LauncherActivityDemo;
import com.test.Android.TestIntent.TestIntent;
import com.test.Android.TestNetWork.SocketClientDemo;
import com.test.Android.TestPhoneGap.PhoneGapDemo;
import com.test.Android.TestResources.TestResources;
import com.test.Android.TestSensor.TestSensor;
import com.test.Android.TestView.TestView;
import com.test.Android.TestwebView.WebViewDemo;
import com.test.Android.Threat.TestThread;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	TextView mInfo;
    
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);	
		mInfo=(TextView)findViewById(R.id.info);
		long millis = System.currentTimeMillis();
		mInfo.setText(millis+"");
	}
	
	public void testCfg(View v){
		Intent i=new Intent(Main.this,TestcfgActivity.class);
		startActivity(i);
	}
	
	public void testActivity(View v){
		Intent i=new Intent(Main.this,ActivityDemo.class);
		startActivity(i);
	}
	
	public void testThread(View v){
		Intent i=new Intent(Main.this,TestThread.class);
		startActivity(i);
	}
	
	public void testSentor(View v){
		Intent i=new Intent(Main.this,TestSensor.class);
		startActivity(i);
	}
	
	public void testIntent(View v){
		Intent i=new Intent(Main.this,TestIntent.class);
		startActivity(i);
	}
	public void testResources(View v){
		Intent i=new Intent(Main.this,TestResources.class);
		startActivity(i);
	}
	
	public void testView(View v){
		Intent i=new Intent(Main.this,TestView.class);
		startActivity(i);	
	}
	
	public void testDb(View view){
		Intent i=new Intent(Main.this,SqlActivity.class);
		startActivity(i);	
	}
	
	public void testNet(View v){
		Intent i=new Intent(Main.this,WebViewDemo.class);
		startActivity(i);	
		
	}
	
	public void testHtml(View v){
		Intent i=new Intent(Main.this,PhoneGapDemo.class);
		startActivity(i);	
	}	
	public void testNfc(View v){
//		FLMiniSdkFunctionInit init=new FLMiniSdkFunctionInit();
//		FREObject ob=new FREObject();
		try{
		      String appId =  "20002";
		      String appKey =  "803F7323-F71E-3918-80D4-E3C1F187AE86";
		      String comPanyId =  "100021";
		      String subCoopId = "444666";
		    // Toast.makeText(context.getActivity(), "init with context"+context.getActivity()+"\n"+"appId"+appId+"comPanyId="+comPanyId, Toast.LENGTH_SHORT).show();
		      
		      GameInfo info=new GameInfo(Main.this);
		      info.setAppId(appId);
		      info.setAppKey(appKey);
		      info.setCompanyId(comPanyId);
		      info.setCoopId(subCoopId);
		      
		   //  Toast.makeText(context.getActivity(), "init with gameInfo"+info+"\n"+"appKey"+appKey+"comPanyId="+comPanyId, Toast.LENGTH_SHORT).show();
		    
		     // MiniSDKManager.getInstance().initMiniSDK(Main.this, Main.this);
		      TestClass.getInstance().initMiniSDK(Main.this, info);
		    
		     
		       }catch (Exception e) {
		    	   
		    	   e.printStackTrace();
		    	   Toast.makeText(Main.this, "init error"+e, Toast.LENGTH_SHORT).show();
		    	   
		       }
		
		
//		Intent i=new Intent(Main.this,NfcDemo.class);
//		startActivity(i);	
	}
}
