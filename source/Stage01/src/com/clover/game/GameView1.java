package com.clover.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

/**
 * @author admin
 *
 */
public class GameView1 extends View {

	private Paint mPaint;
	private SurfaceHolder sh;
	private boolean isRunning = true;
	private int cx,cy = 50;
	private int cx1,cy1 = 100;
	private int radius = 8;
	private BallThread ballThread1, ballThread2;
	public GameView1(Context context) {
		super(context);
		mPaint = new Paint();
		setFocusable(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPaint.setColor(Color.BLUE);
		if(ballThread1 != null)
			canvas.drawCircle(ballThread1.x, cy, radius, mPaint);
		if(ballThread2 != null)
			canvas.drawCircle(cx1, cy1, radius, mPaint);
	}
	
	class BallThread extends Thread{
		int x;
		@Override
		public void run() {
			while (isRunning) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x += 10;
				postInvalidate();
			}
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
			ballThread1 = new BallThread();
			ballThread1.start();
			ballThread2 = new BallThread();
			ballThread2.start();
			break;
		case KeyEvent.KEYCODE_BACK:
			isRunning = false;
			return super.onKeyDown(keyCode, event);
		}
		return true;
		
	}
}
