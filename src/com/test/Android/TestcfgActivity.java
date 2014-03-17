package com.test.Android;

import java.util.Timer;
import java.util.TimerTask;

import com.test.Android.TestActivity.LauncherActivityDemo;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TestcfgActivity extends Activity {
    /** Called when the activity is first created. */
	TextView nav,ori,screen,touch,local;
	 Configuration mCfg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testcfg);
        nav=(TextView)findViewById(R.id.nav);
        ori=(TextView)findViewById(R.id.ori);
        screen=(TextView)findViewById(R.id.screen);
        touch=(TextView)findViewById(R.id.touch);
        local=(TextView)findViewById(R.id.local);
    }
    
    
    
      public void function(View v){    	  
    	  mCfg=getResources().getConfiguration();
    	 String  mNav= mCfg.orientation==Configuration.ORIENTATION_LANDSCAPE?"����":"����";
    	 ori.setText(mNav);
    	 String mOri=mCfg.orientation==Configuration.NAVIGATION_NONAV?"û�з������":
    		 mCfg.orientation==Configuration.NAVIGATION_WHEEL?"���ֿ���":
    			 mCfg.orientation==Configuration.NAVIGATION_DPAD?"�������":"�켣�����";
    	 nav.setText(mOri);
    	 String mTouch=mCfg.touchscreen==Configuration.TOUCHSCREEN_NOTOUCH?"����Ļ����":
    		 mCfg.touchscreen==Configuration.TOUCHSCREEN_STYLUS?"������":"��ָ����";
    	 touch.setText(mTouch);
    	 String mnc =mCfg.mnc+"";
    	 screen.setText(mnc);
    	 String scale=mCfg.locale+"";
    	 local.setText(scale);   	 
      }
      public void changeCfg(View v){
    	  mCfg=getResources().getConfiguration();
    	  if(mCfg.orientation==Configuration.ORIENTATION_LANDSCAPE){
    		  TestcfgActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    	  }else if(mCfg.orientation==Configuration.ORIENTATION_PORTRAIT){
    		  TestcfgActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    	  }
      }
     
      public void ConfigurationChanged(Configuration newConfig ){
    	  mCfg=newConfig;
    	  super.onConfigurationChanged(mCfg);    	  
    	  String  mNav= mCfg.orientation==Configuration.ORIENTATION_LANDSCAPE?"����":"����";
    	  Toast.makeText(TestcfgActivity.this,"��Ļ���"+mNav,Toast.LENGTH_SHORT);
    	  
      } 
      
      public void TestActivity(View v){
    	 Intent i=new Intent(this,LauncherActivityDemo.class);
    	 startActivity(i);
      }
    
}