package com.teamdelta.game.common;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * 
 * @author Bill Warnock
 * @version 1.0.0.0
 * @since 2/9/16
 * 
 * The Button class controls the display of buttons.
 * 
 */

public class Button {
	TextureRegion textureRegion;
	TextureRegion textureRegionSelected;
	public boolean selected;
	public Rectangle colisionRect;
	
	public Button(){
		textureRegion = new TextureRegion();
		textureRegionSelected = new TextureRegion();
		colisionRect = new Rectangle();
	}
	public Button(TextureRegion tR, TextureRegion tRs, Rectangle colRect) {
		textureRegion = tR;
		textureRegionSelected = tRs;
		colisionRect = colRect;
	}
	
	public void draw(SpriteBatch batch){
		if(!selected){
			batch.draw(textureRegion, colisionRect.x, colisionRect.y, colisionRect.width, colisionRect.height);
		}else{
			batch.draw(textureRegionSelected, colisionRect.x, colisionRect.y, colisionRect.width, colisionRect.height);
		}
	}
}
