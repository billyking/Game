package com.clover.game.stage.two;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class SFGameView extends GLSurfaceView {

	private SFGameRenderer render;
	public SFGameView(Context context) {
		super(context);
//		render = new SFGameRenderer();
//		setRenderer(render);
	}

	public void setGameRender(){
		render = new SFGameRenderer();
		setRenderer(render);
	}
}
