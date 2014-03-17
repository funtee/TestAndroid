package com.test.Android.TestwebView;



import com.test.Android.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-19
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public class WebViewDemo extends Activity {

    public static final String EXTRA_WEBURL = "com.devspark.sidenavigation.cuzyAndroidDemo.extra.weburl";
    private ImageButton back;
	private TextView title;
    private ImageButton mPreviousButton;
	private ImageButton mNextButton;
	private ImageButton mRemoveTabButton;
    public ProgressBar progressBar = null;
    public WebView uiwebview;
    @SuppressLint("SetJavaScriptEnabled")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.webview);
        uiwebview = (WebView)findViewById(R.id.webView);
        uiwebview.setWebViewClient(new Callback());
        uiwebview.getSettings().setBuiltInZoomControls(true);
        uiwebview.getSettings().setJavaScriptEnabled(true); 
       
        uiwebview.getSettings().setDomStorageEnabled(true);
        uiwebview.getSettings().setRenderPriority(RenderPriority.HIGH);
        uiwebview.getSettings().setAllowFileAccess(true);
        uiwebview.getSettings().setPluginState(PluginState.ON);
		
        uiwebview.getSettings().setUseWideViewPort(true); 
        uiwebview.getSettings().setLoadWithOverviewMode(true);
        
        progressBar = (ProgressBar)findViewById(R.id.webview_progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads()
                .detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
       
        if (getIntent().hasExtra(EXTRA_WEBURL)) {
        	String title = getIntent().getStringExtra(EXTRA_WEBURL);        
            
            
           // uiwebview.addJavascriptInterface(new JavascriptInterface(this), "imagelistner");
            uiwebview.loadUrl(title);
           
        }else{
        	//String url="http://m.8783.com/gl/gl.php?c=378&ta=攻略技巧";
        	String url="http://www.umaoni.com/bbs/api/mbbs/threadview.php?fid=2&tid=5";
        	//String url="http://www.umaoni.com/bbs/api/mbbs/forumdisplay.php?fid=40";
        			//bbs/api/mbbs/forumdisplay.php?fid=2;
          // String url="http://item.taobao.com/item.htm?id=36963473091";
        	uiwebview.loadUrl(url);
            uiwebview.setWebViewClient(new Callback());
          	
        	
        }
        
//        mPreviousButton = (ImageButton) findViewById(R.id.PreviousBtn);
//    	mNextButton = (ImageButton) findViewById(R.id.NextBtn);
//    	
//    	mPreviousButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//            	if(uiwebview.canGoBack()){
//            		uiwebview.goBack();
//            	}else{
//            		finish();
//            	}
//            	
//            }          
//        });
//    	
//    	mNextButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//            	if(uiwebview.canGoForward()){
//            		uiwebview.goForward();
//            	}         	
//            }          
//        });
//        mRemoveTabButton = (ImageButton) findViewById(R.id.RemoveTabBtn);
//    	mRemoveTabButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//            	finish();
//            }          
//        });
//
   }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
//          
        	return super.shouldOverrideUrlLoading(view, url);
        }
        @Override
        public void onPageStarted(android.webkit.WebView view, java.lang.String url, android.graphics.Bitmap favicon){

            progressBar.setVisibility(View.VISIBLE);
         
        }
        @Override
        public void onPageFinished(android.webkit.WebView view, java.lang.String url) {
            progressBar.setVisibility(View.INVISIBLE);
//            if(url.contains("http://detail.tmall.com/"))
//            {
//                ///if it is a tmall link
//                String[] sArray = url.split("\\?|&");
//                String idString = sArray[1];
//                idString = idString.substring(3);///get rid of "id=";
//                idString = "http://a.m.tmall.com/i" + idString + ".htm";
//
//                uiwebview.loadUrl(idString);
//
//            }
            
            addImageClickListner();
        }
        
        @Override
        public void onReceivedError(android.webkit.WebView view, int errorCode, java.lang.String description, java.lang.String failingUrl){
            progressBar.setVisibility(View.INVISIBLE);
            Log.d("CuzyAdSDK","error " + failingUrl + " " + description);
        }
    }
    
    public void backToMain(View view){
		
		finish();
	}
    
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	
    }
    
    public class JavascriptInterface {

		private Context context;

		public JavascriptInterface(Context context) {
			this.context = context;
		}

		public void openImage(String img) {
			System.out.println(img);
			//
//			Intent intent = new Intent();
//			intent.putExtra("image", img);
//			intent.setClass(context, ShowWebImageActivity.class);
//			context.startActivity(intent);
			System.out.println(img);
			uiwebview.loadUrl(img);
		}
	}
    
    private void addImageClickListner() {
		// 这段js函数的功能就是，遍历所有的img几点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
    	
    	uiwebview.loadUrl("javascript:function() {"+
        "var hrefs = document.getElementsByTagName('a');"+
        "var myhref;"+
        "for(var i = 0; i<hrefs.length; i++){"+
        "if(hrefs[i].className=='btnBuy'){myhref = hrefs[i];break;}"+
        "}"+
      //  "window.location = myhref.href;"+
        "myhref.onclick=function()"+"{"+
        "        window.imagelistner.openImage(this.href);  "+
        "}" + 
		"})()");
//    	uiwebview.loadUrl("javascript:(function(){" +
//		"var objs = document.getElementsByTagName(\"img\"); " + 
//				"for(var i=0;i<objs.length;i++)  " + 
//		"{"
//				+ "    objs[i].onclick=function()  " + 
//		"    {  " 
//				+ "        window.imagelistner.openImage(this.src);  " + 
//		"    }  " + 
//		"}" + 
//		"})()");
	}

    
  
}
