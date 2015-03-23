package com.clover.game.entity;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.clover.game.ui.GameView;
import com.clover.game.R;

public class PlayerBullet {


	private int x, y;
	private Bitmap mBullet;
	private int offX, offY;//Æ«ÒÆÁ¿ 
	private boolean flag = false;//×Óµ¯ÒÆ³ýÆÁÄ»Îªfalse
	
	private int width, height;
	private Random random;
	private int px;
	public PlayerBullet(View view){
		GameView gameView = (GameView) view;
		width = view.getWidth();
		height = view.getHeight();
		
//		offY = 5;
		offY = 8;
		mBullet = BitmapFactory.decodeResource(view.getResources(), R.drawable.bullet1);
	}
	public void setPostion(int x, int  y){
		this.x = x;
		this.y = y;
	}
	
	public void drawSelf(Canvas canvas){
//		if(flag)
			canvas.drawBitmap(mBullet,x, y, null);
	}
	
	public void move(){
		y -= offY;
		
		if(y < 0 - mBullet.getHeight()){
			flag = false;
		}
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public int getWidth(){
		return mBullet.getWidth();
	}
	
	public int getHeight(){
		return mBullet.getHeight();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
}
