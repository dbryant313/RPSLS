package com.teamdelta.game.screens.rulesscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.Main;

/**
 * @author William Warnock
 */
public class RulesScreenController extends InputAdapter {
    RulesScreen rulesScreen;
    Main gameInstance;
    Vector3 input;

    RulesScreenController(RulesScreen rulesScreen, Main gameInstance) {
        this.rulesScreen  = rulesScreen;
        this.gameInstance = gameInstance;
        this.input = new Vector3();

        Gdx.input.setInputProcessor(this);
    }

    void showSelectedMessage() {
        if(rulesScreen.rockButton.selected){
            rulesScreen.bigFont.draw(rulesScreen.batch, "Rock:", 350, 210);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Crushes Lizard", 350, 180);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Crushes Scissors", 350, 160);
        }
        else if(rulesScreen.paperButton.selected){
            rulesScreen.bigFont.draw(rulesScreen.batch, "Paper:", 350, 210);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Covers Rock", 350, 180);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Dispproves Spock", 350, 160);
        }
        else if(rulesScreen.scissorsButton.selected){
            rulesScreen.bigFont.draw(rulesScreen.batch, "Scissors:", 350, 210);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Cuts Paper", 350, 180);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Decapitates Lizard", 350, 160);
        }
        else if(rulesScreen.lizardButton.selected){
            rulesScreen.bigFont.draw(rulesScreen.batch, "Lizard", 350, 210);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Poisons Spock", 350, 180);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Eats Paper", 350, 160);
        }
        else if(rulesScreen.spockButton.selected){
            rulesScreen.bigFont.draw(rulesScreen.batch, "Spock:", 350, 210);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Smashes Scissors", 350, 180);
            rulesScreen.smallFont.draw(rulesScreen.batch, "Vaporizes Rock", 350, 160);
        }
    }

    void highlightSelected() {
        if (rulesScreen.rockButton.selected) {
            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.scissorsButton.colisionRect.x,
                rulesScreen.scissorsButton.colisionRect.y,
                rulesScreen.scissorsButton.colisionRect.width,
                rulesScreen.scissorsButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.lizardButton.colisionRect.x,
                rulesScreen.lizardButton.colisionRect.y,
                rulesScreen.lizardButton.colisionRect.width,
                rulesScreen.lizardButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.greenHighlight,
                rulesScreen.rockButton.colisionRect.x,
                rulesScreen.rockButton.colisionRect.y,
                rulesScreen.rockButton.colisionRect.width,
                rulesScreen.rockButton.colisionRect.height
            );

            rulesScreen.rockButton.draw(rulesScreen.batch);
        }

        if (rulesScreen.paperButton.selected) {
            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.rockButton.colisionRect.x,
                rulesScreen.rockButton.colisionRect.y,
                rulesScreen.rockButton.colisionRect.width,
                rulesScreen.rockButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.spockButton.colisionRect.x,
                rulesScreen.spockButton.colisionRect.y,
                rulesScreen.spockButton.colisionRect.width,
                rulesScreen.spockButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.greenHighlight,
                rulesScreen.paperButton.colisionRect.x,
                rulesScreen.paperButton.colisionRect.y,
                rulesScreen.paperButton.colisionRect.width,
                rulesScreen.paperButton.colisionRect.height
            );

            rulesScreen.paperButton.draw(rulesScreen.batch);
        }

        if (rulesScreen.scissorsButton.selected) {
            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.paperButton.colisionRect.x,
                rulesScreen.paperButton.colisionRect.y,
                rulesScreen.paperButton.colisionRect.width,
                rulesScreen.paperButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.lizardButton.colisionRect.x,
                rulesScreen.lizardButton.colisionRect.y,
                rulesScreen.lizardButton.colisionRect.width,
                rulesScreen.lizardButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.greenHighlight,
                rulesScreen.scissorsButton.colisionRect.x,
                rulesScreen.scissorsButton.colisionRect.y,
                rulesScreen.scissorsButton.colisionRect.width,
                rulesScreen.scissorsButton.colisionRect.height
            );

            rulesScreen.scissorsButton.draw(rulesScreen.batch);
        }

        if (rulesScreen.lizardButton.selected) {
            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.spockButton.colisionRect.x,
                rulesScreen.spockButton.colisionRect.y,
                rulesScreen.spockButton.colisionRect.width,
                rulesScreen.spockButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.paperButton.colisionRect.x,
                rulesScreen.paperButton.colisionRect.y,
                rulesScreen.paperButton.colisionRect.width,
                rulesScreen.paperButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.greenHighlight,
                rulesScreen.lizardButton.colisionRect.x,
                rulesScreen.lizardButton.colisionRect.y,
                rulesScreen.lizardButton.colisionRect.width,
                rulesScreen.lizardButton.colisionRect.height
            );

            rulesScreen.lizardButton.draw(rulesScreen.batch);
        }

        if (rulesScreen.spockButton.selected) {
            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.scissorsButton.colisionRect.x,
                rulesScreen.scissorsButton.colisionRect.y,
                rulesScreen.scissorsButton.colisionRect.width,
                rulesScreen.scissorsButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.redHighlight,
                rulesScreen.rockButton.colisionRect.x,
                rulesScreen.rockButton.colisionRect.y,
                rulesScreen.rockButton.colisionRect.width,
                rulesScreen.rockButton.colisionRect.height
            );

            rulesScreen.batch.draw(
                rulesScreen.greenHighlight,
                rulesScreen.spockButton.colisionRect.x,
                rulesScreen.spockButton.colisionRect.y,
                rulesScreen.spockButton.colisionRect.width,
                rulesScreen.spockButton.colisionRect.height
            );

            rulesScreen.spockButton.draw(rulesScreen.batch);
        }

        rulesScreen.rockButton.draw(rulesScreen.batch);
        rulesScreen.paperButton.draw(rulesScreen.batch);
        rulesScreen.scissorsButton.draw(rulesScreen.batch);
        rulesScreen.lizardButton.draw(rulesScreen.batch);
        rulesScreen.spockButton.draw(rulesScreen.batch);
    }

    @Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		input.x = screenX;
		input.y = screenY;

		gameInstance.camera.unproject(input);

		if (rulesScreen.closeButton.colisionRect.contains(input.x, input.y)) {
            rulesScreen.closeButton.selected = true;
			gameInstance.clickSound.play();
		} else if (rulesScreen.rockButton.colisionRect.contains(input.x, input.y)) {
            rulesScreen.rockButton.selected = true;
			rulesScreen.rockClick.play();
		} else if (rulesScreen.paperButton.colisionRect.contains(input.x, input.y)) {
            rulesScreen.paperButton.selected = true;
			rulesScreen.paperClick.play();
		} else if (rulesScreen.scissorsButton.colisionRect.contains(input.x, input.y)) {
            rulesScreen.scissorsButton.selected = true;
			rulesScreen.scissorsClick.play();
		} else if (rulesScreen.lizardButton.colisionRect.contains(input.x, input.y)) {
            rulesScreen.lizardButton.selected = true;
			rulesScreen.lizardClick.play();
		} else if (rulesScreen.spockButton.colisionRect.contains(input.x, input.y)) {
            rulesScreen.spockButton.selected = true;
			rulesScreen.spockClick.play();
		}

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		input.x = screenX;
		input.y = screenY;

		gameInstance.camera.unproject(input);

		rulesScreen.closeButton.selected    = false;
		rulesScreen.rockButton.selected     = false;
		rulesScreen.paperButton.selected    = false;
		rulesScreen.scissorsButton.selected = false;
		rulesScreen.lizardButton.selected   = false;
		rulesScreen.spockButton.selected    = false;

		if (rulesScreen.closeButton.colisionRect.contains(input.x, input.y)) {
            gameInstance.router.back();
		}

		return true;
	}
}
