package com.clover.game.stage.two;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class SFMusic extends Service{

	public static boolean isRunning = false;
	MediaPlayer player;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		setMusicOption(SFEngine.context, SFEngine.LOOP_BACKGROUND_MUSIC, SFEngine.R_VOLUME, SFEngine.L_VOLUME, SFEngine.SPLASH_SCREEN_MUSIC);
	}

	public void setMusicOption(Context context, boolean isLooped, int rVolume, int lVolume, int soundFile){
		player = MediaPlayer.create(context, soundFile);
		player.setLooping(isLooped);
		player.setVolume(rVolume, lVolume);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		player.stop();
		player.release();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		player.stop();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		try {
			player.start();
			isRunning = true;
		} catch (Exception e) {
			player.stop();
			isRunning = false;
		}
		return 1;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}

	public void onStop(){
		isRunning = false;
	}
}
