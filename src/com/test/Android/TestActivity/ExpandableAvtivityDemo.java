package com.test.Android.TestActivity;

import com.test.Android.R;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableAvtivityDemo extends ExpandableListActivity {
    
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ExpandableListAdapter adapter=new BaseExpandableListAdapter(){
			
			int[] logos=new int[]{
					R.drawable.d_1_3,R.drawable.d_1_4,R.drawable.d_1_5	
					
			};
			
			String[] armType=new String[]{
					
				"神族兵种","虫族兵种","兽族兵种"	
			};
			String[][] arms=new String[][]{
					{"狂战士","龙战士","黑暗圣堂","圣电兵"},{"","","",""}	
					
			};
			
			//获取指定组位置，指定子列表项下的列表项目
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return arms[groupPosition][childPosition];
			}
            
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}
              private TextView getTextView(){
            	  AbsListView.LayoutParams p1=new  AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,64);
            	  TextView textView =new TextView(ExpandableAvtivityDemo.this);
            	  textView.setLayoutParams(p1);
            	  textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
            	  textView.setPadding(36,0,0,0);
            	  textView.setTextSize(20);           	  
				return textView;		
			 }
          	//该方法决定每个子选项的外观
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView textView=getTextView();
				textView.setText(getChild(groupPosition,childPosition).toString());
				return textView;
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return arms[groupPosition].length;
			}
			
			
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return armType[groupPosition];
			}

			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return armType.length;
			}

			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}
            
		
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout l1=new LinearLayout(ExpandableAvtivityDemo.this);
				l1.setOrientation(0);
				ImageView logo=new ImageView(ExpandableAvtivityDemo.this);
				logo.setImageResource(logos[groupPosition]);
				l1.addView(logo);
				TextView textView= getTextView();
				textView.setText(getGroup(groupPosition).toString());
				l1.addView(textView);
				return l1;
			}

			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
			
				
	} ;
	setListAdapter(adapter);
 }
}
