package com.clover.game.manager;

import android.graphics.Canvas;
import android.view.View;

import com.clover.game.entity.Player;

public class PlayerManager {


	private Player mPlayer;
	
	
//	public PlayerManager(Player mPlayer) {
//		this.mPlayer = mPlayer;
//	}

	public PlayerManager(View view) {
		mPlayer = new Player(view);
	}


	public void drawPlayer(Canvas canvas){
		mPlayer.drawSelf(canvas);
	}
	
	public void moveTo(int x, int y){
		mPlayer.moveTo(x, y);
	}
	
	public Player getPlayer(){
		return mPlayer;
	}
}
