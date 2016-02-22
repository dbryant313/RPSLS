package com.teamdelta.game.screens.startscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;
import com.teamdelta.game.common.AbstractScreen;
import com.teamdelta.game.common.Button;
import com.teamdelta.game.Main;

/**
 * 
 * @author Jeff Kunert
 * @version 1.0.0.0
 * @since 2/9/16
 * 
 * The GameScreen class controls the game play and statistics display.
 * 2/14/16 - added start screen music - warnock
 * 2/14/16 - added start screen image - warnock
 * 2/14/16 - added click sound - warnock
 * 2/18/16 - modified intro sound clip - Ismael
 * 2/19/16 - edit new start screen image - warnock
 */

public class StartScreen extends AbstractScreen {

	StartScreenController startScreenController;

	Music startScreenMusic; //added start screen music - warnock
	Button playGameButton;
	Button aboutButton;
	Button rulesButton;
	Button exitButton;


	public StartScreen(Main game) {
		super(game);
		loadAssets();
	}

	public void loadAssets() {
		startScreenMusic = Gdx.audio.newMusic(Gdx.files.internal("INTRO.ogg"));//--Ismael Changed to shorter intro clip

		playGameButton = new Button(atlas.findRegion("PLAYBUTTON"),
				atlas.findRegion("PLAYBUTTONSELECTED"),
				new Rectangle(gameInstance.WIDTH/2 - 60, 250, 140, 50));

		aboutButton = new Button(atlas.findRegion("ABOUTBUTTON"),
				atlas.findRegion("ABOUTBUTTONSELECTED"),
				new Rectangle(gameInstance.WIDTH/2 - 60, 175, 140, 50));

		rulesButton = new Button(atlas.findRegion("RULESBUTTON"),
				atlas.findRegion("RULESBUTTONSELECTED"),
				new Rectangle(gameInstance.WIDTH/2 - 60, 100, 140, 50));

		exitButton = new Button(atlas.findRegion("EXITBUTTON"),
				atlas.findRegion("EXITBUTTONSELECTED"),
				new Rectangle(gameInstance.WIDTH/2 - 60, 25, 140, 50));
	}

	@Override
	public void show() {
        startScreenController = new StartScreenController(this, gameInstance);
    }

	@Override
	public void render(float delta) {
		batch.draw(atlas.findRegion("START_SCREEN_IMAGE"), 0, 0);//added start screen image - warnock

		playGameButton.draw(batch);
		aboutButton.draw(batch);
		rulesButton.draw(batch);
		exitButton.draw(batch);
	}
	
	@Override
	public void update(float timeSinceLastFrame) {}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		gameInstance.assetMgr.dispose();
	}

	@Override
	public void disposeAssets() {}

}
