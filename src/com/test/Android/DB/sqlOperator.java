package com.test.Android.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlOperator extends SQLiteOpenHelper{
	
	private String tableName;
	 private static final int VERSION=1;

	public sqlOperator(Context context, String dataBaseName) {
		
		super(context,dataBaseName,null,VERSION);
		//super(context, name, factory, version);
		
		 
		// TODO Auto-generated constructor stub
	}
	
	public void setTable(String tableName){
		this.tableName=tableName;
	}
     
	

	//创建表
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}
	
    //更新表
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
