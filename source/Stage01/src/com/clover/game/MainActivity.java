package com.clover.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.clover.game.ui.GameView;

public class MainActivity extends Activity {

	private GameView mGameView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGameView = new GameView(this);
		setContentView(mGameView);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		mGameView.onKeyDown(keyCode, event);
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mGameView.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

}
