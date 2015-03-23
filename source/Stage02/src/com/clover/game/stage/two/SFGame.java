package com.clover.game.stage.two;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class SFGame extends Activity {

	private SFGameView gameView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		gameView = new SFGameView(this);
		gameView.setEGLConfigChooser(8 , 8, 8, 8, 16, 0);
		gameView.setGameRender(); 
		setContentView(gameView);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		gameView.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		gameView.onPause();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		int height = SFEngine.display.getHeight() / 4;
		int playableArea = SFEngine.display.getHeight() - height;
		if (y > playableArea) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (x < SFEngine.display.getWidth() / 2) {
					SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_LEFT_1;
				}else{
					SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_RIGHT_1;
				}
				break;
			case MotionEvent.ACTION_UP:
				SFEngine.playerFlightAction = SFEngine.PLAYER_RELEASE;
				break;
			default:
				break;
			}
		}
		return false;
	}
}
