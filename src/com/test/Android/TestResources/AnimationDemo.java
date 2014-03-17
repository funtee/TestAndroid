package com.test.Android.TestResources;

import java.util.Timer;
import java.util.TimerTask;

import com.test.Android.R;
import com.test.Android.R.anim;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationDemo extends Activity {
	 ImageView clip,loading;
	AnimationDrawable animation1;
	Animation animation2;
	@Override 
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation);
		clip=(ImageView)findViewById(R.id.clipImage);
		loading=(ImageView)findViewById(R.id.loading);
		//定义裁剪的drawable对象
		final ClipDrawable drawable=(ClipDrawable)clip.getDrawable();
		 animation1=(AnimationDrawable)loading.getBackground();
		 animation2=AnimationUtils.loadAnimation(this,R.anim.animation);
		//更新裁剪图片的线程
		final Handler mHandler=new Handler(){
			
			@Override
			public void handleMessage(Message msg){
				if(msg.what==0){
					drawable.setLevel(drawable.getLevel()+200);
				}
				
			}
			
		};
		//更新裁剪图片的定时器
		final Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				Message msg=new Message();
				msg.what=0;
				mHandler.sendMessage(msg);
				if(drawable.getLevel()>=10000){
					
					timer.cancel();
				}
				
			}
			}
		,0,300);
	}
	
	//启动逐帧动画
    public void animation(View v){		
    	clip.startAnimation(animation2);
	}
	
	//启动逐帧动画
    public void start(View v){		
    	animation1.start();
	}
    
  //停止逐帧动画
    public void stop(View v){		
    	animation1.stop();
	}
    
}
