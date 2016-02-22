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
 * The AbstractEntity class defines controls for the player game play.
 * 
 */

public abstract class AbstractEntity {
	public String name;
	public Sprite skin;
	public boolean turnToPlay;
	public int winScore;
	public int loseScore;
	public int tieScore; //Edited by Jeff Kunert
	public RPSLSEntity choice;//removed enum and made choice RPSLSEntity
	public TextureAtlas atlas;
	
	abstract void render(float timeSinceLastFrame, SpriteBatch bath);
	abstract void update(float timeSinceLastFrame);
}
