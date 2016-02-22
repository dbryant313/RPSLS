package com.teamdelta.game.screens.gamescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.common.AbstractScreen;
import com.teamdelta.game.common.Button;
import com.teamdelta.game.Main;

/**
 * 
 * @author Ismael Poteau - Rendering
 * @author Bill Warnock - Input Processing
 * @author Jake Herritt -  Game Logic
 * @author Jeff Kunert -  Initialization
 * @version 1.0.0.0
 * @since 2/9/16
 * 
 * The GameScreen class controls the game play and statistics display.
 * 
 * 2/9/16  - Fixed tieScore spelling errors - Dennis
 * 2/12/16 - Added non-image to buttons - Ismael
 * 2/15/16 - Fixed boolean set for winner - Dennis
 * 2/14/16 - calculate winner using new GameLogic class - warnock
 * 2/14/16 - refactored to set player choice to corresponding RPSLSEntity - warnock
 * 2/14/16 - added click sound to buttons - Warnock
 * 2/16/16 - repositioned CPU Player Indicator to align with Player Indicator position - Warnock
 * 2/16/16 - Added Images to placeholders - Warnock
 * 2/17/16 - Changed Font color to Black - Warnock
 * 2/17/16 - Added Background - Warnock
 * 2/17/16 - Repositioned score for CPU - Warnock
 * 2/18/16 - added delay for CPU turn - Ismael
 */
public class GameScreen extends AbstractScreen {
	Button rockButton;
	Button paperButton;
	Button scissorsButton;
	Button lizardButton;
	Button spockButton;
	Button aboutButton;
	Button rulesButton;
	Button closeButton;
	Button playAgainButton;

	BitmapFont font;
	Vector3 input;

	GameScreenController gameScreenController;
	
	public GameScreen(Main gameS) {
		super(gameS);

		input = new Vector3();
		font = new BitmapFont(Gdx.files.internal("calibrismall.fnt"));
		font.setColor(new Color(Color.BLACK));

		aboutButton = new Button(atlas.findRegion("ABOUTBUTTON"),
				atlas.findRegion("ABOUTBUTTONSELECTED"), new Rectangle(250, 30,
						100, 50));

		rulesButton = new Button(atlas.findRegion("RULESBUTTON"),
				atlas.findRegion("RULESBUTTONSELECTED"), new Rectangle(350, 30,
						100, 50));

		closeButton = new Button(atlas.findRegion("CLOSEBUTTON"),
				atlas.findRegion("CLOSEBUTTONSELECTED"), new Rectangle(450, 30,
						100, 50));
		//Ismael added playAgainButton
		
		playAgainButton = new Button(atlas.findRegion("PLAYBUTTON"),
				atlas.findRegion("PLAYBUTTONSELECTED"), new Rectangle(350, 155,
						100, 50));
		
		//Bill added placeholders
		rockButton 		= gameS.rockEntity.setButton(new Rectangle(50, 350, 100, 150));
		paperButton 	= gameS.paperEntity.setButton(new Rectangle(650, 350, 100, 150));
		scissorsButton 	= gameS.scissorsEntity.setButton(new Rectangle(50, 150, 100, 150));
		lizardButton 	= gameS.lizardEntity.setButton(new Rectangle(650, 150, 100, 150));
		spockButton 	= gameS.spockEntity.setButton(new Rectangle(350, 275, 100, 150));
	}

	@Override
	public void show() {
		gameScreenController = new GameScreenController(this, gameInstance);
	}

	@Override
	public void hide() {}

	@Override
	public void loadAssets() {}

	@Override
	public void render(float delta) {
		renderBackground();
		renderButtons();
		renderScores();
		renderFPS();

		gameScreenController.renderMessages();
		gameScreenController.player.skin.draw(batch);
		gameScreenController.cpu.skin.draw(batch);
	}

	void renderBackground() {
		batch.draw(atlas.findRegion("ROCK_BACKGROUND"), 0, 0);
	}

	void renderButtons() {
		rockButton.draw(batch);
		paperButton.draw(batch);
		scissorsButton.draw(batch);
		lizardButton.draw(batch);
		spockButton.draw(batch);
		aboutButton.draw(batch);
		rulesButton.draw(batch);
		closeButton.draw(batch);

		//Ismael added render playAgainButton when game is over
		if(gameScreenController.gameover){
			playAgainButton.draw(batch);
		}
	}

	void renderScores() {
		font.draw(batch, "Wins:  " + gameScreenController.player.winScore, 50, 560);
		font.draw(batch, "Losses:  " + gameScreenController.player.loseScore, 50, 540);
		font.draw(batch, "Ties:  " + gameScreenController.player.tieScore, 50, 520); //Jeff Added Tie Score for cpu

		font.draw(batch, "Wins:  " + gameScreenController.cpu.winScore, 650, 560);
		font.draw(batch, "Losses:  " + gameScreenController.cpu.loseScore, 650, 540);
		font.draw(batch, "Ties:  " + gameScreenController.cpu.tieScore, 650, 520); //Jeff Added Tie Score for cpu
	}

	void renderFPS() {
		//font.draw(batch, "FPS " + Gdx.graphics.getFramesPerSecond(), 700, 620);
	}

	@Override
	public void update(float timeSinceLastFrame) {
		gameScreenController.checkWinner(timeSinceLastFrame);
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}

	@Override
	public void disposeAssets() {}
}
