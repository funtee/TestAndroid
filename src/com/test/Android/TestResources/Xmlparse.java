package com.test.Android.TestResources;

import com.test.Android.R;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Xmlparse extends Activity {
    TextView show; 
	
	@Override
	public void onCreate(Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
		setContentView(R.layout.xml);
		show=(TextView)findViewById(R.id.show);
			
	}
	
	public void xmlTest(View v){
		//获取xml解析器实例
		XmlResourceParser xpr=getResources().getXml(R.xml.xmltest);
		try{
			StringBuilder sb=new StringBuilder(); //定义显示解析结果的字符串
			//while循环判断是否文件解析完毕
			while(xpr.getEventType()!=XmlResourceParser.END_DOCUMENT){
				//如果遇到开始标签
				if(xpr.getEventType()==XmlResourceParser.START_TAG){
					String tagName=xpr.getName(); //获取标签名字
					if(tagName.equals("book")){  
						String bookPrice=xpr.getAttributeValue(null, "price");
						sb.append("价格 ：");
						sb.append(bookPrice);
						String bookTime=xpr.getAttributeValue(1);
						sb.append("出版日期：");
						sb.append(bookTime);
						sb.append("书名：");
						sb.append(xpr.nextText()); //获取文字节点的值				
					}
					sb.append("\n");
				}
				xpr.next();
			}
			show.setText(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
