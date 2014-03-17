package com.test.Android.Threat;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;

public class AsyncDownload extends AsyncTask<String, Integer, String> {

	//onPreExecute方法在execute()后执行,可进行UI操作
    @Override  
    protected void onPreExecute() 
    {  
        
       
    }  
      
    //doInBackground方法内部执行后台任务,不能在里面更新UI，否则有异常。
    @Override  
    protected String doInBackground(String... params) 
    {  
       
        
        URL imageUrl=null;
        String fileName=null;
        try 
        {
            imageUrl=new URL(params[0]);
        } 
        catch (MalformedURLException e) 
        {
            e.printStackTrace();
          
        }
        try
        {
            //使用HttpURLConnection打开连接
            HttpURLConnection urlConn=(HttpURLConnection)imageUrl.openConnection();
            urlConn.setDoInput(true);
            urlConn.connect();
            //将得到的数据转化成InputStream
            InputStream is=urlConn.getInputStream();
            //将InputStream转换成Bitmap
          //  mDownLoadBtBitmap=BitmapFactory.decodeStream(is);
            //下载图片转化为bitmap
            Bitmap bitmap=BitmapFactory.decodeStream(is);
            is.close();
            fileName=new String(params[1]); //文件名字
            saveFile(bitmap,fileName); //保存文件
            //不能在这里更新UI,否则有异常******
            //mNetImageView.setImageBitmap(bitmap);
        }catch(IOException e)
        {
        	e.getMessage();
        	
        }
        
        return "ok";
    }  
      
    //onProgressUpdate方法用于更新进度信息  
    @Override  
    protected void onProgressUpdate(Integer... progresses) 
    {  
       

       
    }  
      
    //onPostExecute用于doInBackground执行完后，更新界面UI。
    //result是doInBackground返回的结果
    @Override  
    protected void onPostExecute(String result) 
    {  
        
      
    }  
      
    //onCancelled方法用于取消Task执行，更新UI
    @Override  
    protected void onCancelled() 
    {  
       
    } 
    
    public void saveFile(Bitmap bm, String fileName) throws IOException {  
    	  String ALBUM_PATH  
         = Environment.getExternalStorageDirectory() + "/poseimg/"; 
    	File dirFile = new File(ALBUM_PATH);  
        if(!dirFile.exists()){  
            dirFile.mkdir();  
        }  
        File myCaptureFile = new File(ALBUM_PATH + fileName);  
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));  
        bm.compress(Bitmap.CompressFormat.PNG, 90, bos); //png格式
      // bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);   //jpg格式
        bos.flush();  
        bos.close();  
    }  

}
