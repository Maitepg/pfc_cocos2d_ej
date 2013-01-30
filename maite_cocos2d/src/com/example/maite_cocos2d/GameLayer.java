package com.example.maite_cocos2d;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.instant.CCCallFuncN;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor4B;

import android.content.Context;
import android.view.MotionEvent;

public class GameLayer extends CCColorLayer {

    // ===========================================================
    // Constants
    // ===========================================================
    static final int CAMERA_WIDTH = 480;
    static final int CAMERA_HEIGHT = 854;
	
    // ===========================================================
    // Fields
    // ===========================================================
    
	CCSprite flower1;
	CCSprite flower2;
	CCSprite flower3;
	CCSprite flower4;
	CCSprite flower5;
	CCSprite flower6;
	
	private final float centerX;
	private final float centerY;
	
	
	public static CCScene scene(){
		
		CCScene scene = CCScene.node();
		CCLayer layer = new GameLayer(ccColor4B.ccc4 ( 255 , 255 , 255 , 255 ));
		
		scene.addChild(layer);
		
		return scene;
	}
	
	
	protected GameLayer(ccColor4B color)
	{
		super(color);
		this.setIsTouchEnabled(true);
		
	    CGSize winSize = CCDirector.sharedDirector().displaySize();
	    flower1 = CCSprite.sprite("flower1.png");
	    flower2 = CCSprite.sprite("flower2.png");
	    flower3 = CCSprite.sprite("flower3.png");
	   /* flower4 = CCSprite.sprite("flower4.png");
	    flower5 = CCSprite.sprite("flower5.png");
	    flower6 = CCSprite.sprite("flower6.png");*/
	    
	    centerX = (CAMERA_WIDTH - flower1.getContentSize().width) / 2;
	    centerY = (CAMERA_HEIGHT - flower1.getContentSize().height) / 2;
	    
	    flower1.setPosition(centerX, centerY);
	    flower2.setPosition(centerX, centerY+centerY/2);
	    flower3.setPosition(centerX, centerY-centerY/2);
	    
	    addChild(flower1);
	    addChild(flower2);
	    addChild(flower3);
	  /*  addChild(flower4);
	    addChild(flower5);
	    addChild(flower6);*/
	   
	}
	
	@Override
	public boolean ccTouchesMoved(MotionEvent event) {

		 CGPoint location;
		 location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(event.getX(), event.getY()));
		 if(flower1.getBoundingBox().contains(location.x, location.y)){
	         flower1.setPosition(location);	
		 }else if(flower2.getBoundingBox().contains(location.x, location.y)){
	         flower2.setPosition(location);	
		 }else if(flower3.getBoundingBox().contains(location.x, location.y)){
	         flower3.setPosition(location);	
		 }/*else if(flower4.getBoundingBox().contains(location.x, location.y)){
	         flower4.setPosition(location);	
		 }else if(flower5.getBoundingBox().contains(location.x, location.y)){
	         flower5.setPosition(location);	
		 }else if(flower6.getBoundingBox().contains(location.x, location.y)){
	         flower6.setPosition(location);	
		 }*/		
        	
	    return super.ccTouchesMoved(event);
	}	
	
	
}	