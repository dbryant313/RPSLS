package com.teamdelta.game.common;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.teamdelta.game.Main;

/**
 * 
 * @author Ismael Poteau 
 * @version 1.0.0.0
 * @since 2/9/16
 * 
 * The AbstractScreen class defines the screens for the game.
 * 
 */

public abstract class AbstractScreen implements Screen {
	public Main gameInstance;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public TextureAtlas atlas;
	public boolean paused;
	
	public AbstractScreen(Main game) {
		gameInstance = game;
		batch = game.batch;
		camera = game.camera;
		atlas = gameInstance.assetMgr.get("game.pack", TextureAtlas.class);
	}

	public abstract void loadAssets();
	public abstract void disposeAssets();

	public abstract void update(float timeSinceLastFrame);
}
