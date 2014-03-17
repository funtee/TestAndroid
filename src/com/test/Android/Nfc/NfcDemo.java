/*
 *在Android NFC 应用中，Android手机通常是作为通信中的发起者，也就是作为各种NFC卡的读写器。Android对NFC的支持主要在 android.nfc 和android.nfc.tech 两个包中。
 android.nfc 包中主要类如下：
NfcManager 可以用来管理Android设备中指出的所有NFCAdapter，但由于大部分Android设备只支持一个NFC Adapter，所以一般直接调用getDefaultAapater来获取手机中的Adapter。
NfcAdapter 相当于一个NFC适配器，类似于电脑装了网络适配器才能上网，手机装了NfcAdapter才能发起NFC通信。
 NDEF: NFC Data Exchange Format，即NFC数据交换格式。
NdefMessage 和NdefRecord NDEF 为NFC forum 定义的数据格式。
Tag 代表一个被动式Tag对象，可以代表一个标签，卡片等。当Android设备检测到一个Tag时，会创建一个Tag对象，将其放在Intent对象，然后发送到相应的Activity。 
 * 
 * */
package com.test.Android.Nfc;


import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.nfc.Tag; 

public class NfcDemo extends Activity {
	NfcAdapter nfcAdapter;  
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        LinearLayout lay=new LinearLayout(this);
        LinearLayout.LayoutParams pas=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        TextView show=new TextView(this);
        lay.addView(show,pas);
        setContentView(lay);   
        // 获取默认的NFC控制器  
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);  
        if (nfcAdapter == null) {  
        	show.setText("设备不支持NFC！");  
            finish();  
            return;  
        }  
        if (!nfcAdapter.isEnabled()) {  
        	show.setText("请在系统设置中先启用NFC功能！");  
            finish();  
            return;  
        }  
    } 
	
	 @Override  
	    protected void onResume() {  
	        super.onResume();  
	        //得到是否检测到ACTION_TECH_DISCOVERED触发  
	        if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(getIntent().getAction())) {  
	            //处理该intent  
	            processIntent(getIntent());  
	        }  
	    }
	 
	 /** 
	     * Parses the NDEF Message from the intent and prints to the TextView 
	     */  
	    private void processIntent(Intent intent) {  
	        //取出封装在intent中的TAG  
	        Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);  
	        for (String tech : tagFromIntent.getTechList()) {  
	            System.out.println(tech);  
	        }
	  }
}    
