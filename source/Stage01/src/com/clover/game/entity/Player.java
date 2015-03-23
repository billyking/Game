package com.clover.game.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.clover.game.ui.GameView;
import com.clover.game.R;

public class Player {


	private int x, y;
	private Bitmap mPlayer;
	private int i;
	private int width, height;
	
	private GameView mGameView;
	private PlayerBullet mPlayerBullet;
	public Player(View view){
		mGameView = (GameView) view;
		mPlayer = BitmapFactory.decodeResource(view.getResources(), R.drawable.player);
		width = mPlayer.getWidth();
		height = mPlayer.getHeight();
		x = (view.getWidth() - width) / 2;
		y = view.getHeight() - height;
	}
	
	public void drawSelf(Canvas canvas){//没隔3次，发射子弹
		if(i % 3 != 2)
			i++;
		else{
			i = 0;
//			mPlayerBullet = mGameView.getPlayerBulletManager().getOneBullet();
//			mPlayerBullet.setPostion(x + width/2 - mPlayerBullet.getWidth()/2, y - mPlayerBullet.getHeight());
			fire();
		}
		
		canvas.drawBitmap(mPlayer,x, y, null);
	}
	
	public void moveTo(int x, int y){
		this.x = x - width / 2 ;
		this.y = y - height;
	}
	
	public void fire(){
		mPlayerBullet = mGameView.getPlayerBulletManager().getOneBullet();
		mPlayerBullet.setPostion(x + width/2 - mPlayerBullet.getWidth()/2, y - mPlayerBullet.getHeight());
	}
	public int getX(){
		return x;
	}
}
