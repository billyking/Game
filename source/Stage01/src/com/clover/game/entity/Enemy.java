package com.clover.game.entity;

import java.io.IOException;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

import com.clover.game.ui.GameView;
import com.clover.game.util.RamCheck;
import com.clover.game.R;

/**
 * @author admin
 *
 */
/**
 * @author admin
 *
 */
public class Enemy {


	private int x, y;
	private Bitmap mEnemy;
	private int offX, offY;//ƫ���� 
	private boolean flag = true;//�л�������Ϊfalse
	
	private int width, height;
	private Random random;
	private int px;
	private GameView mGameView;
	private EnemyBullet mEnemyBullet;
	private int i;
	private int mEnemyWidth, mEnemyHeight;
	private MediaPlayer mPlayer;
	private Bitmap mExplodeBitmap;//��ըͼƬ
	private boolean mExplodeFlag;//�Ƿ�����ը
	private int mExplodeX, mExplodeY;//��ը������λ��
	public Enemy(View view){
		mGameView = (GameView) view;
		mPlayer = MediaPlayer.create(mGameView.getContext(), R.raw.ring);
		mExplodeBitmap = BitmapFactory.decodeResource(mGameView.getResources(), R.drawable.explored);
		try {
//			mPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		px = mGameView.getPlayerManager().getPlayer().getX();
		width = view.getWidth();
		height = view.getHeight();
		random = new Random();
		x = random.nextInt(width);
		y = random.nextInt(50) - 50;//��Χ��-50��0�����л�����Ļ�Ϸ����� 
		
		
		offY = random.nextInt(5) + 1;
		mEnemy = BitmapFactory.decodeResource(view.getResources(), R.drawable.enemy);
		mEnemyWidth = mEnemy.getWidth();
		mEnemyHeight = mEnemy.getHeight();
	}
	
	public void drawSelf(Canvas canvas){//û��12�Σ������ӵ�
//		if(i % 12 != 11)
//			i++;
//		else{
//			i = 0;
//			if (flag) {
//				fire();
//			}
//		}
		if(isFlag())
			canvas.drawBitmap(mEnemy,x, y, null);
		if (mExplodeFlag){
			for (int i = 0; i < 4; i++) {//��4�Σ������ӳ�
				canvas.drawBitmap(mExplodeBitmap,mExplodeX, mExplodeY, null);
			}
			mExplodeFlag = false;
		}
	}
	
	public void move(){
		px = mGameView.getPlayerManager().getPlayer().getX();
		if(px < x){
			offX = random.nextInt(3) - 3;
		}else if(px > x){
			offX = random.nextInt(3) + 1;
		}else
			offX = 0;
		
		x += offX;
		y += offY;
		
		if(!isFlag() | x < -mEnemy.getWidth() || x > width || y > height){
			x = random.nextInt(width);
			y = random.nextInt(50) - 50;
			setFlag(true);
		}
	}
	
	public void fire(){
		mEnemyBullet = mGameView.getEnemyBulletManager().getOneBullet();
		mEnemyBullet.setPostion(x + mEnemyWidth/2 - mEnemyBullet.getWidth()/2, y + mEnemyHeight);
		mEnemyBullet.setOffY(offY + 3);
	}
	
	/**
	 * ����ӵ���л��Ƿ�����ײ
	 */
	public void enemyRremCheck(){
		for(PlayerBullet bullet: mGameView.getPlayerBulletManager().getAllPlayerBullet()){
			if (isFlag() && bullet.isFlag() && RamCheck.ifRam(x, y, x + mEnemyWidth, y + mEnemyHeight, 
					bullet.getX(), bullet.getY(), bullet.getX() + bullet.getWidth(), bullet.getY() + bullet.getHeight())) {
				mPlayer.start();
//				mPlayer.stop();
//				mPlayer.release();
				setFlag(false);
				bullet.setFlag(false);
				mExplodeFlag = true;
				mExplodeX = x;
				mExplodeY = y;
				break;
			}
			
		}
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
