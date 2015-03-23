package com.clover.game.manager;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.view.View;

import com.clover.game.entity.Enemy;

public class EnemyManager {

	ArrayList<Enemy> enemys = new ArrayList<Enemy>();

	public EnemyManager(View view) {
//		for(int i = 0; i < 5; i++){
		for(int i = 0; i < 8; i++){
			enemys.add(new Enemy(view));
		}
	}
	
	private int i;
	public void drawEnemy(Canvas canvas){
		for(Enemy enemy: enemys){
			enemy.move();
			enemy.drawSelf(canvas);
			if(enemy.isFlag()){
//				if(i % 12 != 11)
				if(i % 15 != 14)
					i++;
				else{
					i = 0;
					enemy.fire();
				}
				enemy.enemyRremCheck();
			}
			
		}
	}
	
	public void fire(){
		
	}
}
