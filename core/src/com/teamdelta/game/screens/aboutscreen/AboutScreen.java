package com.teamdelta.game.screens.aboutscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.common.AbstractScreen;
import com.teamdelta.game.common.Button;
import com.teamdelta.game.Main;

/**
 * 
 * @author Dennis Bryant
 * @version 1.0.0.0
 * @since 2/8/16
 * 
 * The AboutScreen class create the credit screen for the application.
 * 
 */
public class AboutScreen extends AbstractScreen {
	Texture credits;
	Texture background;
	public BitmapFont bigFont;
	public BitmapFont smallFont;
	public Button closeButton;
	//Added in sound for an audio clip crediting Sam Kass
	public Sound mention;
	Vector3 input;

	AboutScreenController aboutScreenController;
	
	/**
	 * The contructor to create the about screen.
	 * @param game
	 */
	public AboutScreen(Main game) {
		super(game);

		input = new Vector3();
		loadSound();

		closeButton = new Button(atlas.findRegion("CLOSEBUTTON"),
				atlas.findRegion("CLOSEBUTTONSELECTED"),
				new Rectangle(gameInstance.WIDTH/2 - 60, 55, 120, 40));
		
		bigFont = new BitmapFont(Gdx.files.internal("calibri.fnt"));
		smallFont = new BitmapFont(Gdx.files.internal("calibrismall.fnt"));
	}

	@Override
	public void show() {
		aboutScreenController = new AboutScreenController(this, gameInstance);
		mention.play(); //plays clip on entrance of about screen
	}

	/**
	 * The render method paints the screen. Set all needed fields.
	 * 
	 * @Update 2/17/16 
	 * Jacob added developer history and 
	 * modified current version and layout
	 * 
	 * 
	 */
	
	void renderBackground() {
		batch.draw(atlas.findRegion("ROCK_BACKGROUND"), 0, 0);
		
		//background = new Texture(Gdx.files.internal("Slate_Background.png"));
		//**^^The above code for slate background causes RAM to 
		//****sky-rocket until machine freezes.
		//batch.draw(background,  0,  0);
	}
	
	void loadSound(){
		mention = Gdx.audio.newSound(Gdx.files.internal("About_mention.mp3"));
	}
	
	@Override
	public void render(float delta) {
		
		//Jacob Added Background image 2/18/16
		renderBackground();
		
		bigFont.setColor(new Color(Color.BLACK));
		smallFont.setColor(new Color(Color.BLACK));
		
		bigFont.draw(batch, "Rock, Paper, Scissors, Lizard, Spock", 220, 600);
		bigFont.draw(batch, "Developed by Team Delta", 245, 570);
		
		smallFont.draw(batch, "Team Lead: ", 150, 500-20);
		smallFont.draw(batch, "Jeffrey Kunert", 150, 480-20);
		smallFont.draw(batch, "Project Manager: ", 150, 440-20);
		smallFont.draw(batch, "Dennis Bryant", 150, 420-20);
		smallFont.draw(batch, "Programming Lead: ", 150, 380-20);
		smallFont.draw(batch, "Ismael Poteau", 150, 360-20);
		smallFont.draw(batch, "UI design and QA", 150, 320-20);
		smallFont.draw(batch, "Jacob Herritt", 150, 300-20);
		smallFont.draw(batch, "William Warnock", 150, 280-20);
		smallFont.draw(batch, "Version 2.0.0.0",  150, 240-20);
		
		smallFont.draw(batch, "Rock Paper Scissors Lizard Spock is a game", 400, 500-20);
		smallFont.draw(batch, "created by Sam Kass and Karen Bryla in order", 400, 480-20);
		smallFont.draw(batch, "to reduce the probability that the game would", 400, 460-20);
		smallFont.draw(batch, "result in a tie.", 400, 440-20);
		smallFont.draw(batch, "The new spin on this well-known game provides", 400, 400-20);
		smallFont.draw(batch, "players with more options to enhance this", 400, 380-20);
		smallFont.draw(batch, "classic game.", 400, 360-20);
		
		
		closeButton.draw(batch);
		
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}

	public void loadAssets() {}

	public void update(float timeSinceLastFrame) {}

	@Override
	public void disposeAssets() {}
}
