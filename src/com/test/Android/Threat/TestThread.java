package com.test.Android.Threat;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.paipai.api.sdk.OpenApiException;
import com.paipai.api.sdk.PaiPaiOpenApiOauth;
import com.test.Android.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;


public class TestThread extends Activity {

	String appOAuthID = "700163031";
	String appOAuthkey = "AoQbYDVSuKPtLjmy";
	String accessToken = "cca4ead1573409eecbd29fea4b2ee81f";
	long  uin = 376272793;
	PaiPaiOpenApiOauth sdk=null;
	 
	
	
	
	
	
	ImageView show;
	TextView info;
	int count=10;
	 int Image[]={R.drawable.d_1_1,R.drawable.d_1_2,
			 R.drawable.d_1_3,R.drawable.d_1_4,R.drawable.d_1_5,			 
	 };
	 int cruentId=0;
	 Handler mHandler;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        sdk = new PaiPaiOpenApiOauth(appOAuthID, appOAuthkey, accessToken, uin);	
	    	sdk.setMethod("post");
	    	sdk.setCharset("utf-8");
	    	sdk.setFormat("json");
	    	HashMap<String, Object> params = sdk.getParams("/cps/cpsCommSearch.xhtml");
	    	params.put("userId",""+57204);
			params.put("zhongwen", "");
			params.put("keyWord", "避孕套");
			sdk.setHostName("api.paipai.com");
			
	        setContentView(R.layout.thread);
	        
	        show=(ImageView)findViewById(R.id.show); 
	        info=(TextView)findViewById(R.id.ori);
	        mHandler=new Handler(){
	        	@Override 
	        	public void handleMessage(Message msg){
	        		if(msg.what==1){
	        			try {
	        				String resp = sdk.invoke();
	        				System.out.println("\n\n------------result-------------\n\n"+resp);
	        				info.setText(resp);
	        			} catch (OpenApiException e) {
	        				System.out.printf("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e.getMessage());
	        				e.printStackTrace();
	        			}
	        			
	        			show.setImageResource(Image[cruentId++]);
	        			if(cruentId>4){
	        				cruentId=0;
	        			}
	        		}
	        	}
	        	
	        };
	        new Timer().schedule(new TimerTask(){
	        	@Override 
	        	public void run(){
	        		Message msg=new Message();
	        		msg.what=1;
	              mHandler.sendMessage(msg);  
	        	}
	        	
	        }, 0, 50000);
	    }
	 
//	 Runnable mRunnable=new Runnable(){
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			try {
//				String resp = sdk.invoke();
//				System.out.println("\n\n------------result-------------\n\n"+resp);
//				
//			} catch (OpenApiException e) {
//				System.out.printf("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e.getMessage());
//				e.printStackTrace();
//			}
//			count--;
//			if(count>0){
//				info.setText("倒计时"+count+"秒后关闭此界面");
//				mHandler.postDelayed(this, 1000);
//			}else 
//				finish();			
//		}
//		 		 
//	 };
}
