package com.test.Android.TestView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
//自定义类，用来绘制小球
public class MyView extends View{
	
 public	float currentX=40;
 public float currentY=50;

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		//创建画笔
		Paint p=new Paint();
		//设置画笔风格
				p.setStyle(Paint.Style.FILL);
				//设置画笔颜色
			     p.setColor(Color.RED);
		
		//绘制小球
		canvas.drawCircle(currentX, currentX, 15, p);
		//绘制矩形
		canvas.drawRect(10,80,90,90, p);
		//绘制圆角矩形
		RectF ret=new RectF(10,200,70,300);
		canvas.drawRoundRect(ret, 20, 30, p);
		//绘制椭圆
		canvas.drawOval(ret, p);
		//定义一个Path对象，封闭为一个三角形 
		Path path1=new Path();
		path1.moveTo(10, 340);
		path1.lineTo(70, 340);
		path1.lineTo(40, 290);
		path1.close();
		//根据path绘制三角形
		canvas.drawPath(path1,p);
		
		
		
	}
		
}
