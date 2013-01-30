package com.example.maite_cocos2d;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class SimpleFlower extends Activity {
	
	protected CCGLSurfaceView _glSurfaceView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	 
	    _glSurfaceView = new CCGLSurfaceView(this);
	 
	    setContentView(_glSurfaceView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public void onStart(){
		//es ponerse
		//parte para que el miguel motivbe a la maite xD^^
		//falta el touch
		super.onStart();
		 
	    CCDirector.sharedDirector().attachInView(_glSurfaceView);  
	    /*animación SOLA*/
	  //  CCDirector.sharedDirector().setDisplayFPS(true);
	 //   CCDirector.sharedDirector().setAnimationInterval(1.0f / 60.0f);
		
	    CCScene scene = GameLayer.scene();
	    CCDirector.sharedDirector().runWithScene(scene);
	}
	
	@Override
	public void onPause()
	{
	    super.onPause();
	 
	    CCDirector.sharedDirector().pause();
	}
	 
	@Override
	public void onResume()
	{
	    super.onResume();
	 
	    CCDirector.sharedDirector().resume();
	}
	 
	@Override
	public void onStop()
	{
	    super.onStop();
	 
	    CCDirector.sharedDirector().end();
	}

}
