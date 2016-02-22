package com.teamdelta.game.screens.rulesscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.teamdelta.game.common.AbstractScreen;
import com.teamdelta.game.common.Button;
import com.teamdelta.game.Main;

/**
 * 
 * @author Dennis Bryant
 * @version 1.0.0.0
 * @since 2/8/16
 * 
 * The RulesScreen class displays the rules for the game.
 * 
 * 2/13/16 - Corrected spelling of strings in atlas.findRegion() methods - Ismael 
 */

public class RulesScreen extends AbstractScreen {
	Button closeButton;
	Button rockButton;
	Button paperButton;
	Button scissorsButton;
	Button lizardButton;
	Button spockButton;

	BitmapFont smallFont;
	BitmapFont bigFont;

	TextureRegion greenHighlight;
	TextureRegion redHighlight;
	
	//Added Sound Files
	Sound explanation;
	Sound rockClick;
	Sound paperClick;
	Sound scissorsClick;
	Sound lizardClick;
	Sound spockClick;

	RulesScreenController rulesScreenController;

	public RulesScreen(Main game) {
		super(game);

		loadSound();

		greenHighlight = atlas.findRegion("green");
		redHighlight = atlas.findRegion("red");

		bigFont = new BitmapFont(Gdx.files.internal("calibri.fnt"));
		smallFont = new BitmapFont(Gdx.files.internal("calibrismall.fnt"));

		closeButton = new Button(atlas.findRegion("CLOSEBUTTON"),
				atlas.findRegion("CLOSEBUTTONSELECTED"), new Rectangle(
						340, 50, 120, 40));

		//--Corrected spelling of strings
		rockButton 		= game.rockEntity.getButton();
		paperButton 	= game.paperEntity.getButton();
		scissorsButton 	= game.scissorsEntity.getButton();
		lizardButton 	= game.lizardEntity.getButton();
		spockButton 	= game.spockEntity.getButton();
	}

	@Override
	public void show() {
		explanation.play();
		rulesScreenController = new RulesScreenController(this, gameInstance);
	}

	void renderBackground() {
		batch.draw(atlas.findRegion("ROCK_BACKGROUND"), 0, 0);
	}
	
	//loadSound added for loading the sounds
	void loadSound(){
		//Loading assets for sound on Rules Screen
		explanation 	= Gdx.audio.newSound(Gdx.files.internal("ShortExp.mp3"));
		rockClick 		= Gdx.audio.newSound(Gdx.files.internal("Rock_Click.mp3"));
		paperClick 		= Gdx.audio.newSound(Gdx.files.internal("Paper_Click.mp3"));
		scissorsClick 	= Gdx.audio.newSound(Gdx.files.internal("Scissors_Click.mp3"));
		lizardClick 	= Gdx.audio.newSound(Gdx.files.internal("Lizard_Click.mp3"));
		spockClick = Gdx.audio.newSound(Gdx.files.internal("Spock_Click.mp3"));
	}

	@Override
	public void render(float delta) {
		renderBackground();
		renderMessage();

		bigFont.setColor(new Color(Color.BLACK));
		smallFont.setColor(new Color(Color.BLACK));

		rulesScreenController.highlightSelected();

		closeButton.draw(batch);
	}
	
	void renderMessage(){
		bigFont.draw(batch, "----RULES----", 300, 620);
		bigFont.draw(batch, "Click and hold a character to check how it wins", 200, 580);

		rulesScreenController.showSelectedMessage();
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {
		Gdx.input.setCatchBackKey(false);
	}

	@Override
	public void dispose() {}

	@Override
	public void loadAssets() {}

	@Override
	public void disposeAssets() {}

	@Override
	public void update(float timeSinceLastFrame) {}
}
