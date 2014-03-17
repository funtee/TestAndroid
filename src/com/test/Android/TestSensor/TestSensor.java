package com.test.Android.TestSensor;

import java.util.Random;

import com.test.Android.R;
import com.test.Android.TestSensor.ShakeListener.OnShakeListener;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TestSensor extends Activity {
    TextView show,lightValue;
    
    SensorManager sm;
    Sensor accelenss,lightss;
    SensorEventListener lis;
    Vibrator vibrator;
    ImageView mDice;
    Random r;
    //筛子的数组
    int diceImg[]={
    	R.drawable.n1,	
    	R.drawable.n2,
    	R.drawable.n3,
    	R.drawable.n4,
    	R.drawable.n5,
    	R.drawable.n6,
    };
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensor);	
		show=(TextView)findViewById(R.id.show);
		lightValue=(TextView)findViewById(R.id.light);
		sm=(SensorManager)getSystemService(SENSOR_SERVICE);
		accelenss=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		lightss=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
		vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE); 
		r=new Random(); //随机数 		
		mDice=(ImageView)findViewById(R.id.dice); 
		lis=new SensorEventListener(){

			@Override
			public void onAccuracyChanged(Sensor arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSensorChanged(SensorEvent e) {
				// TODO Auto-generated method stub
				if(e.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
					float newX = e.values[SensorManager.DATA_X];
					float newY = e.values[SensorManager.DATA_Y];
					float newZ = e.values[SensorManager.DATA_Z];
					show.setText("X轴:"+newX+"\n"+"Y轴:"+newY+"\n"+"Z轴:"+newZ+"\n");
				}else if(e.sensor.getType()==Sensor.TYPE_LIGHT){
				//	Toast.makeText(getApplicationContext(),"光线传感器感应",20).show();
					lightValue.setText("光线指数是："+e.values[0]);
					if(e.values[0]>3.0){						
						 vibrator.vibrate(100);
						
					}
				}
			}
						
		};
		
		sm.registerListener(lis,accelenss,SensorManager.SENSOR_DELAY_NORMAL);
		sm.registerListener(lis,lightss,SensorManager.SENSOR_DELAY_NORMAL);
		
		ShakeListener listen=new ShakeListener(this); //自定义摇动手机监听器
		listen.setOnShakeListener(new OnShakeListener(){

			@Override
			public void onShake() {
				// TODO Auto-generated method stub				
				mDice.setImageResource(diceImg[r.nextInt(6)]);
			}
			
			
		});
	}
	
	@Override 
	public void onResume(){
		super.onResume();
			
	}
	@Override 
	public void onDestroy(){
		super.onDestroy();
		sm.unregisterListener(lis,accelenss);
		sm.unregisterListener(lis,lightss);
		
	}
}
