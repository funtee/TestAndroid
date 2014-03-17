package com.test.Android.TestNetWork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.test.Android.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SocketClientDemo extends Activity {
	  TextView text;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        text=(TextView)findViewById(R.id.info);
	        setContentView(R.layout.socket_client_demo);
	        Handler mHandler =new Handler() ;

	 }
	 
	 Runnable mRunnable =new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				
	        	Socket s=new Socket("192.168.3.176",9000);
	        	BufferedReader reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
	        	String info=reader.readLine();	        
	        	text.setText("服务器收到的消息："+info);        	
	        reader.close();
	        s.close();
	        }catch(Exception e){
	        	e.printStackTrace();
//	        	System.out.print(c);
	        //	text.setText("出错了"); 
	        }
		}
		 
	 };
}
