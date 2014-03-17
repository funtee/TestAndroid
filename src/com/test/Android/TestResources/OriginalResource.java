package com.test.Android.TestResources;


import com.test.Android.R;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class OriginalResource extends Activity {
	
	MediaPlayer player1=null;
	MediaPlayer player2=null;
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.originalresource);
		player1=MediaPlayer.create(getApplicationContext(), R.raw.gun);
		AssetManager set=getAssets();
		try{
			//打开指定文件
			AssetFileDescriptor dis=set.openFd("start.mp3");
			player2=new MediaPlayer();
			//加载指定媒体文件
			player2.setDataSource(dis.getFileDescriptor());
			player2.prepare(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testRaw(View v){
		player1.start(); //播放raw文件
		
	}
	
	public void testAsset(View v){
		
		player2.start();
	}	

}
