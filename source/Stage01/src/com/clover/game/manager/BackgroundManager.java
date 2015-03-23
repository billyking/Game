package com.clover.game.manager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

import com.clover.game.R;

public class BackgroundManager {

	private Bitmap mBitmap;
	private Rect srcRect, desRect, desRect1;
	private int dy/*, dy1 = -800*/;
	private int dy1;
	private int mScreenWidth, mScreenHeight;  
	public BackgroundManager(View view) {
		Display display = ((Activity)view.getContext()).getWindowManager().getDefaultDisplay();
		mScreenWidth = display.getWidth();
		mScreenHeight = display.getHeight();
		dy1 = -mScreenHeight;
		
//		srcRect = new Rect(0, 0, 240, 366);  
		srcRect = new Rect(0, 0, 240, 240);  
		desRect = new Rect(0, dy, mScreenWidth, mScreenHeight);
		desRect1 = new Rect(0, dy1, mScreenWidth, 0);
//		mBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.background2);
		mBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.background);
	}
	
	public void drawBackground(Canvas canvas){
		dy += 40;
		dy1 += 40;
		desRect.set(0, dy, mScreenWidth, mScreenHeight + dy);
		desRect1.set(0, dy1, mScreenWidth, mScreenHeight + dy1);
		canvas.drawBitmap(mBitmap, srcRect, desRect, null);
		canvas.drawBitmap(mBitmap, srcRect, desRect1, null);
		if(dy >= 800) dy = -mScreenHeight;
		if(dy1 >= 800) dy1 = -mScreenHeight;
	}
	
}
