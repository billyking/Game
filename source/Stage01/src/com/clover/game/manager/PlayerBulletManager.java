package com.clover.game.manager;

import android.graphics.Canvas;
import android.view.View;

import com.clover.game.entity.PlayerBullet;

public class PlayerBulletManager {
	private PlayerBullet[] pbs = new PlayerBullet[128];

	public PlayerBulletManager(View view) {
		for (int i = 0; i < pbs.length; i++) {
			pbs[i] = new PlayerBullet(view);
		}
	}
	
	public void drawPlayerBullet(Canvas canvas){
		for (PlayerBullet pb: pbs) {
			if (pb.isFlag()) {
				pb.move();
				pb.drawSelf(canvas);
			}
		}
	}
	
	public PlayerBullet getOneBullet(){
		for (PlayerBullet pb: pbs) {
			if (!pb.isFlag()) {
				pb.setFlag(true);
				return pb;
			}
		}
		return null;
	}
	
	public PlayerBullet[] getAllPlayerBullet(){
		return pbs;
	}
}
