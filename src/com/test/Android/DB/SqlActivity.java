package com.test.Android.DB;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.test.Android.Threat.AsyncDownload;



import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SqlActivity extends Activity{
	final sqlOperator sqlop=new sqlOperator(SqlActivity.this,"content");
	private ArrayList<PoseBd> mData;
	SQLiteDatabase sqlreaddatabase,sqlwritedatabase,db=null;
	private Cursor cursor = null;
	
	 private ImageLoader imageLoader=  null;
	    DisplayImageOptions options;
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	  // TODO Auto-generated method stub
	  super.onCreate(savedInstanceState);
	  //setContentView(R.layout.sqllayout);
	  AssetsDatabaseManager.initManager(getApplication()); 
	// 获取管理对象，因为数据库需要通过管理对象才能够获取  
	  AssetsDatabaseManager mg = AssetsDatabaseManager.getManager();  
	  // 通过管理对象获取数据库  
	   db = mg.getDatabase("content.db");  
	  // 对数据库进行操作  
	   initUi();
	   Log.i("db", ""+db); 
	   
	 
	}
	
	public static DisplayImageOptions getDefaultDisplayOptions(int resId) {
  		return new DisplayImageOptions.Builder()//
  				.resetViewBeforeLoading(true)//
  				.showStubImage(resId)//
  				.showImageForEmptyUri(resId)//
  				.showImageOnFail(resId)//
  				.cacheInMemory(true)//
  				.cacheOnDisc(true)//
  				.bitmapConfig(Bitmap.Config.RGB_565)//
  				.displayer(new FadeInBitmapDisplayer(300))//
  				.build();
  	}
	
	public void initUi(){
		imageLoader=ImageLoader.getInstance();
		 options=getDefaultDisplayOptions(com.test.Android.R.drawable.ic_launcher);
		LinearLayout lay=new LinearLayout(this);
		LinearLayout.LayoutParams pas=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
	    lay.setOrientation(0);
		final TextView show=new TextView(this);
		Button bt1=new Button(this);
		bt1.setText("获取list");
		Button bt2=new Button(this);
		bt2.setText("下载");
	    lay.addView(show,pas);
	    lay.addView(bt1,pas);
	    lay.addView(bt2,pas);
		setContentView(lay);
		bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				getList();
				
			}
			
		});
		
		bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				if(mData.size()!=0){
					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								for(int i=0;i<mData.size();i++){
									Log.i("imgnum", "共"+mData.size()+"第"+i+"张");
									PoseBd abd=mData.get(i);
									URL imageUrl=new URL(abd.imgUrl);
									HttpURLConnection urlConn=(HttpURLConnection)imageUrl.openConnection();
						            urlConn.setDoInput(true);
						            urlConn.connect();
						            //将得到的数据转化成InputStream
						            InputStream is=urlConn.getInputStream();
						            //将InputStream转换成Bitmap
						          //  mDownLoadBtBitmap=BitmapFactory.decodeStream(is);
						            //下载图片转化为bitmap
						            Bitmap bit=BitmapFactory.decodeStream(is);
						            
						            is.close();
									//Bitmap bit=imageLoader.loadImageSync(abd.imgUrl, options);
									String file=abd.imgUrl.substring(abd.imgUrl.lastIndexOf("/"));
									Log.i("imgdir",file);
										saveFile(bit,file);
									
								} 
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
						
					}).start();
					
				}
			}
			
		});
		
		
//		bt2.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				if(mData.size()!=0){
//					new Thread(new Runnable() {
//						
//						@Override
//						public void run() {
//							try {
//								for(int i=0;i<mData.size();i++){
//									PoseBd abd=mData.get(i);
//									Bitmap bit=imageLoader.loadImageSync(abd.imgUrl, options);
//									
//										saveFile(bit,abd.imgUrl);
//									
//							} 
//							catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//							
//						
//							
//							}			
//						}).start();
//					
////						AsyncDownload down=new AsyncDownload();
////						// TODO Auto-generated method stub
////						down.execute(abd.imgUrl,abd.poseId);
//					}
//				}
//			}	
//			});
			
	}
		
	
	
	//保存文件到sd卡
	 public void saveFile(Bitmap bm, String fileName) throws IOException {  
   	  String ALBUM_PATH  
        = Environment.getExternalStorageDirectory() + "/poseimg/"; 
   	File dirFile = new File(ALBUM_PATH);  
       if(!dirFile.exists()){  
           dirFile.mkdir();  
       }  
       File myCaptureFile = new File(ALBUM_PATH + fileName);  
       BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));  
       Log.i("saveimg", ""+myCaptureFile);
       bm.compress(Bitmap.CompressFormat.PNG, 90, bos); //png格式
     // bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);   //jpg格式
       bos.flush();  
       bos.close();  
   } 
	 
	
	public  ArrayList<PoseBd> getList(){
		//sqlreaddatabase = SQLiteDatabase.openOrCreateDatabase(config.f, null);
		try { 
			mData=new ArrayList<PoseBd>();
			// 获取管理对象，因为数据库需要通过管理对象才能够获取  
			 AssetsDatabaseManager mg = AssetsDatabaseManager.getManager();  
			SQLiteDatabase db2=	mg.getDatabase("content.db"); 	
		    cursor = db2.query("pose_image", new String[]{}, null, null, null, null, null);
		    Log.i("db", ""+cursor);
		 while(cursor.moveToNext()){
			 PoseBd db=new PoseBd();
             String url = cursor.getString(cursor.getColumnIndex("url"));
             String id= cursor.getString(cursor.getColumnIndex("poseId"));
             Log.i("db", ""+id+url);
             db.setImgUrl(url);
             db.setPoseId(id);
             mData.add(db);
         }
		}catch (Exception e) {
            // TODO: handle exception
            Log.i("opendatabase", e.toString());
        }
		 
		return mData;
	}
	
	
	
	
	public String query(int id)
	 {
	  String str=null;
	  //这边也可以使用getWritableDatabase，可读可写。
	  //getReadableDatabase会在close或getWritableDatabase调用后无效。
	  sqlreaddatabase = sqlop.getReadableDatabase(); 
	  /*Cursor cursor = sqlreaddatabase.query("userTable", new String[] { "id",
	  "name" }, "id=?", new String[] {String.valueOf(id)}, null, null, null);*/
	  
	  Cursor cursor = sqlreaddatabase.rawQuery("select * from pose_image"
	    + " where id=?", new String[] { String.valueOf(id) });  
	  
	  if(cursor.getCount()>0)
	  {
	   str=cursor.getString(cursor.getColumnIndex("url"));
	  }
	  sqlreaddatabase.close();
	  cursor.close();
	  return str;
	 }
}
