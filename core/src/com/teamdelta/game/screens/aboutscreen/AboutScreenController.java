package com.teamdelta.game.screens.aboutscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.Main;

/**
 * @author William Warnock
 */
public class AboutScreenController extends InputAdapter {
    AboutScreen aboutScreen;
    Main gameInstance;
    Vector3 input;

    AboutScreenController(AboutScreen aboutScreen, Main gameInstance) {
        this.aboutScreen  = aboutScreen;
        this.gameInstance = gameInstance;
        this.input        = new Vector3();

        Gdx.input.setInputProcessor(this);
    }

	@Override
	/**
	 * The touchDown method will hi-light the close button if mouse pointer is over top.
	 */
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		input.x = screenX;
		input.y = screenY;

		gameInstance.camera.unproject(input);

		if(aboutScreen.closeButton.colisionRect.contains(input.x, input.y)){
			gameInstance.clickSound.play();
            aboutScreen.closeButton.selected = true;
		}else{
            aboutScreen.closeButton.selected = false;
		}

		return true;
	}

	@Override
	/**
	 * ThetouchUp method will process the mouse click if mouse pointis is over top.
	 */
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		input.x = screenX;
		input.y = screenY;

		gameInstance.camera.unproject(input);
        aboutScreen.closeButton.selected = false;

		if(aboutScreen.closeButton.colisionRect.contains(input.x, input.y)){
            gameInstance.router.back();
		}

		return true;
	}
}
