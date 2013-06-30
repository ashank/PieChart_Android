 
//**************************************************************//
//  Created by Ali Erbaş 										//
//  Copyright (c) 2012 info@erbasali.com. All rights reserved.	//
//																//
//**************************************************************//

package com.example.piecharclass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
 
public class PieChart extends View {
  
 Paint paint;
 Path path;
 Context mContext;
 
public int datas[] = {1000,200,0};
//ilk MAVƒ∞ ikinci TURUNCU √º√ß√ºnc√º KIRMIZI
public int color[] = {Color.parseColor("#29ABE0"),Color.parseColor("#F15A24"),Color.parseColor("#C1272D")};
 

 public PieChart(Context context) {
  super(context);
  mContext = context;
  init();
 }
 
 
 public PieChart(Context context, AttributeSet attrs) {
  super(context, attrs);
  init();
 }
 
 public PieChart(Context context, AttributeSet attrs, int defStyle) {
  super(context, attrs, defStyle);
  init();
 }
  
 private void init(){
 }
 

 @SuppressLint("DrawAllocation")
@Override
 protected void onDraw(Canvas canvas) {
  super.onDraw(canvas);
  
  int toplam = 0;
 
  for (int i = 0; i < datas.length; i++) {
	  toplam +=datas[i];
  }
  

  final RectF oval = new RectF();
  paint = new Paint();
  
  paint.setStyle(Paint.Style.FILL);
  paint.setFlags(Paint.ANTI_ALIAS_FLAG);
  oval.set(0, 0, 300, 300);
  
  int i=0;
  
  float offset = 0;
  
  	while (i<=2) {
 
  	  float angle = (float) ( (int)datas[i] / (float)toplam * (float)(2*3.14) );
	 
  	  angle = (float)(angle*57.3);
  	  
  	  paint.setColor(color[i]);
	 
  	  
 	 Paint text = new Paint();
     text.setColor(Color.BLACK);
     text.setFlags(Paint.ANTI_ALIAS_FLAG);
   
     //int pie = Math.min(300,300) - 30;

//  	  float y = (float) (150+150 * Math.cos(angle-360));
//	  float x = (float) (150+150 * Math.sin(angle-360));
	  
	  float x = (float) (75 * Math.cos(angle * Math.PI / 180F)) + 150;
      float y = (float) (75 * Math.sin(angle * Math.PI / 180F)) + 150;

	  offset += angle;
	  

	  if(i == 0){
		  canvas.drawArc(oval,0,angle, true, paint);
	  }else{
		  canvas.drawArc(oval,offset-angle,angle, true, paint);
	  }
	  
	  
	  canvas.drawText(""+datas[i], x, y, text);

	  i++;
  	} 
  	
 
  	 
  	
   
  	
  	
  	
 }
 
 
 
}