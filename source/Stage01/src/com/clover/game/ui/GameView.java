package com.clover.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.clover.game.manager.BackgroundManager;
import com.clover.game.manager.EnemyBulletManager;
import com.clover.game.manager.EnemyManager;
import com.clover.game.manager.PlayerBulletManager;
import com.clover.game.manager.PlayerManager;

/**
 * @author admin
 *
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable{

	private SurfaceHolder sh;
	private boolean isRunning = true;
	private Canvas canvas;
	private Bitmap mBitmap;//±³¾°
	private PlayerManager mPlayerManager;
	private BackgroundManager mBackgroundManager;
	private EnemyManager mEnemyManager;
	private PlayerBulletManager mPlayerBulletManager;
	private EnemyBulletManager mEnemyBulletManager;
	public GameView(Context context) {
		super(context);
		sh = getHolder();
		sh.addCallback(this);
		setFocusable(true);
		
		
		
	}
	@Override
	public void run() {
		while(isRunning){
			drawView();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void drawView(){
		try {
			if (sh != null) {
				canvas = sh.lockCanvas();
				canvas.drawColor(Color.BLACK);
//				canvas.setDrawFilter(new PaintFlagsDrawFilter(0	, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
//				mPlayer.drawSelf(canvas, posX, posY);
				mBackgroundManager.drawBackground(canvas);
				mPlayerManager.drawPlayer(canvas);
				mEnemyManager.drawEnemy(canvas);
				mPlayerBulletManager.drawPlayerBullet(canvas);
				mEnemyBulletManager.drawEnemyBullet(canvas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(canvas != null)
				sh.unlockCanvasAndPost(canvas);
		}
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mPlayerManager = new PlayerManager(this);
		mBackgroundManager = new BackgroundManager(this);
		mEnemyManager = new EnemyManager(this);
		mPlayerBulletManager = new PlayerBulletManager(this);
		mEnemyBulletManager = new EnemyBulletManager(this);
		
		new Thread(this).start();
		isRunning = true;
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		isRunning = false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		mPlayerManager.moveTo((int)event.getX(), (int)event.getY());
		return super.onTouchEvent(event);
	}
	public PlayerManager getPlayerManager() {
		return mPlayerManager;
	}
	public PlayerBulletManager getPlayerBulletManager() {
		return mPlayerBulletManager;
	}
	public EnemyBulletManager getEnemyBulletManager() {
		return mEnemyBulletManager;
	}
}
