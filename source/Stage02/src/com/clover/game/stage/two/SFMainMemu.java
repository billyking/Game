package com.clover.game.stage.two;

import com.clover.game.stage.two.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class SFMainMemu extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SFEngine.musicThread = new Thread(){
			@Override
			public void run() {
				Intent bgmusic = new Intent(getApplicationContext(), SFMusic.class);
				startService(bgmusic);
				SFEngine.context = getApplicationContext();
			}
		};
		SFEngine.musicThread.start();
		final SFEngine engine = new SFEngine();
		
//		ImageButton start = (ImageButton) findViewById(R.id.btnStart);
//		ImageButton exit = (ImageButton) findViewById(R.id.btnExit);
		Button start = (Button) findViewById(R.id.btnStart);
		Button exit = (Button) findViewById(R.id.btnExit);
//		start.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
//		start.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);
//		exit.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
//		exit.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SFMainMemu.this, SFGame.class);
				startActivity(intent);
			}
		});
		
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean clean = false;
				clean = engine.onExit(v);
				if (clean) {
					int pid = Process.myPid();
					Process.killProcess(pid);
				}
			}
		});
	}

}
