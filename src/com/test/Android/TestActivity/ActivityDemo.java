package com.test.Android.TestActivity;

import com.test.Android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDemo extends Activity {
    
	public final String TAG="activityLife";
	TextView showResult;

	@Override
	public void onCreate(Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
		setContentView(R.layout.activitytest);
		Toast.makeText(this,"TAG"+"create",10).show();
		showResult=(TextView)findViewById(R.id.showresult);		
	}
	
	//结束当前activity，例如返回按钮的功能
	public void finish(View v){	
		finish();
	}
	
	//activity的回调
	public void callback(View v){
		Intent i=new Intent(this,ActivityResult.class);
	    startActivityForResult(i,0);		
	}
	
	//实现回调方法 
	
	@Override 
	public void onActivityResult(int requesetCode,int resultCode,Intent intent){
		if(requesetCode==0&&resultCode==0){
			
			//intent=new Intent();
			Bundle date=intent.getExtras();
			showResult.setText("成功注册账号："+date.getString("name")+"，"+"密码为:"+date.getString("password"));
			
		}
		
	}
	
	/*activity的生命周期*/
    @Override 
	public void onStart(){
		super.onStart();
		Toast.makeText(this,"TAG"+"start",10).show();
	}
	
	@Override
	public void onRestart(){
		super.onRestart();
		Toast.makeText(this,"TAG"+"onRestart",10).show();
	}
	
	@Override
	public void onResume(){
		super.onResume();
		Toast.makeText(this,"TAG"+"onResume",10).show();
	}
	
	@Override
	public void onPause(){
		super.onPause();
		Toast.makeText(this,"TAG"+"onPause",10).show();
	}
	@Override
	public void onStop(){
		super.onStop();
		Toast.makeText(this,"TAG"+"onStop",10).show();
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Toast.makeText(this,"TAG"+"onDestroy",10).show();
	}
	
}
