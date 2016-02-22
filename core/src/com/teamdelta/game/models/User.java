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
 * The User class controls the user game play.
 * 
 */

public class User extends AbstractEntity {
	
	public User(TextureAtlas atlas){
		skin = new Sprite(atlas.findRegion("green"));
		skin.setSize(100, 200);
		skin.setPosition(50, 600);
		turnToPlay = true;
	}
	@Override
	void render(float timeSinceLastFrame, SpriteBatch batch) {
		skin.draw(batch);
		
	}

	@Override
	void update(float timeSinceLastFrame) {
		
		
	}

}
