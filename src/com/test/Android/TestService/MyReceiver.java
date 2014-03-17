package com.test.Android.TestService;

import com.test.Android.Main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
	
	final String START_SELF="com.testAndroid.demo.start";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action=intent.getAction();
		
		if(action.equals("android.intent.action.BOOT_COMPLETED")){
			
			Intent i=new Intent(context,Main.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
			
		}else if(action.equals("android.intent.action.POWER_DISCONNECTED")){
			
			Toast.makeText(context, "电源断开", Toast.LENGTH_SHORT).show();
		}
	}

}
