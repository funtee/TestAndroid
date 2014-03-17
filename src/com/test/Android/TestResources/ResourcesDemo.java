package com.test.Android.TestResources;

import com.test.Android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ResourcesDemo extends Activity {
	String[] texts={
			"write","black",
			"light_gray",
			"gray",
			"red",
			"blue"
	};
	
	int[] colors={
		R.color.write,
		R.color.black,
		R.color.light_gray,
		R.color.gray,
		R.color.red,
		R.color.blue,
	};
	@Override 
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testresource);
	
	BaseAdapter adapter=new BaseAdapter(){

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return colors.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return getResources().getColor(colors[position]);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View contentView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			TextView mText=new TextView(ResourcesDemo.this);
//			Resources res=ResourcesDemo.this.getResources();
//			mText.setWidth((int)res.getDimension(R.dimen.cell_width));
//			mText.setWidth((int)res.getDimension(R.dimen.cell_height));
			mText.setText(texts[position]);
			mText.setBackgroundResource(colors[position]);
			return mText;
		}
		
	};
	GridView grid=(GridView)findViewById(R.id.grid);
	grid.setAdapter(adapter);
	}	
}
