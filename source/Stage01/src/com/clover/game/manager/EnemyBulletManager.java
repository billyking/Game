package com.clover.game.manager;

import android.graphics.Canvas;
import android.view.View;

import com.clover.game.entity.EnemyBullet;
import com.clover.game.entity.PlayerBullet;

public class EnemyBulletManager {
	private EnemyBullet[] ebs = new EnemyBullet[128];

	public EnemyBulletManager(View view) {
		for (int i = 0; i < ebs.length; i++) {
			ebs[i] = new EnemyBullet(view);
		}
	}
	
	public void drawEnemyBullet(Canvas canvas){
		for (EnemyBullet eb: ebs) {
			if (eb.isFlag()) {
				eb.move();
				eb.drawSelf(canvas);
			}
		}
	}
	
	public EnemyBullet getOneBullet(){
		for (EnemyBullet eb: ebs) {
			if (!eb.isFlag()) {
				eb.setFlag(true);
				return eb;
			}
		}
		return null;
	}
	
	public EnemyBullet[] getAllEnemyBullets(){
		return ebs;
	}
}
