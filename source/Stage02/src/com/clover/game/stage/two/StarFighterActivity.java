package com.clover.game.stage.two;

import com.clover.game.stage.two.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class StarFighterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SFEngine.display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		setContentView(R.layout.splashscreen);
		new Handler().postDelayed(new Thread(){
			@Override
			public void run() {
				Intent intent = new Intent(StarFighterActivity.this, SFMainMemu.class);
				StarFighterActivity.this.startActivity(intent);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				StarFighterActivity.this.finish();
			}
		}, SFEngine.GAME_THREAD_DELAY);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.star_fighter, menu);
//		return true;
//	}

}
