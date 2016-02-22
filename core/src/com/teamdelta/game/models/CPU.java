package com.teamdelta.game.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * 
 * @author Jake Herritt
 * @version 1.0.0.0
 * @since 2/9/16
 * 
 * The CPU class controls CPU game play.
 * 
 */

public class CPU extends AbstractEntity {
	
	public CPU(TextureAtlas atlas){
		skin = new Sprite(atlas.findRegion("red"));
		skin.setSize(100, 200);
		skin.setPosition(650, 600);
	}

	@Override
	void render(float timeSinceLastFrame, SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update(float timeSinceLastFrame) {
		
	}

}
