package com.teamdelta.game.screens.startscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.Main;

/**
 * @author William Warnock
 */
public class StartScreenController extends InputAdapter {
    Main gameInstance;
    StartScreen startScreen;
    Vector3 input;

    public StartScreenController(StartScreen startScreen, Main gameInstance) {
        this.gameInstance = gameInstance;
        this.startScreen = startScreen;

        this.input = new Vector3();

        Gdx.input.setInputProcessor(this);

        startScreen.startScreenMusic.setVolume(0.25f);
        startScreen.startScreenMusic.play();
        startScreen.startScreenMusic.setPosition(1.8f);
    }

    // Override InputAdapter TouchUp
    public boolean touchUp(int screenX, int screenY, int pointer, int button){
        input.x = screenX;
        input.y = screenY;

        startScreen.playGameButton.selected = false;
        startScreen.aboutButton.selected = false;
        startScreen.rulesButton.selected = false;
        startScreen.exitButton.selected = false;

        gameInstance.camera.unproject(input);

        if(startScreen.playGameButton.colisionRect.contains(input.x, input.y)){
            startScreen.startScreenMusic.stop();
            gameInstance.router.changeScreen(gameInstance.gameScreen);
        } else if(startScreen.aboutButton.colisionRect.contains(input.x, input.y)){
            startScreen.startScreenMusic.stop();
            gameInstance.router.changeScreen(gameInstance.aboutScreen);
        } else if(startScreen.rulesButton.colisionRect.contains(input.x, input.y)){
            startScreen.startScreenMusic.stop();
            gameInstance.router.changeScreen(gameInstance.rulesScreen);
        } else if(startScreen.exitButton.colisionRect.contains(input.x, input.y)){
            startScreen.startScreenMusic.stop();
            gameInstance.router.exit();
        }

        return true;
    }

    // Override InputAdapter
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        input.x = screenX;
        input.y = screenY;

        gameInstance.camera.unproject(input);

        if(startScreen.playGameButton.colisionRect.contains(input.x, input.y)){
            gameInstance.clickSound.play();
            startScreen.playGameButton.selected = true;
        }else{
            startScreen.playGameButton.selected = false;
        }

        if(startScreen.aboutButton.colisionRect.contains(input.x, input.y)){
            gameInstance.clickSound.play();
            startScreen.aboutButton.selected = true;
        }else{
            startScreen.aboutButton.selected = false;
        }

        if(startScreen.rulesButton.colisionRect.contains(input.x, input.y)){
            gameInstance.clickSound.play();
            startScreen.rulesButton.selected = true;
        }else{
            startScreen.rulesButton.selected = false;
        }

        if(startScreen.exitButton.colisionRect.contains(input.x, input.y)){
            gameInstance.clickSound.play();
            startScreen.exitButton.selected = true;
        }else{
            startScreen.exitButton.selected = false;
        }

        return true;
    }

    // Override InputAdapter
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE) {
            Gdx.input.setCatchBackKey(false);
            Gdx.app.exit();
        }

        return true;
    }
}
