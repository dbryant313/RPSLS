package com.teamdelta.game.common;

import com.badlogic.gdx.Gdx;

/**
 * @author William Warnock
 */
public class Router {
    AbstractScreen currentScreen;
    AbstractScreen previousScreen;

    public Router() {}

    public AbstractScreen getScreen() {
        return currentScreen;
    }

    public void changeScreen(AbstractScreen targetScreen) {
        if(currentScreen == null && previousScreen == null) {
            currentScreen = targetScreen;
            previousScreen = targetScreen;
        }

        Gdx.input.setCatchBackKey(false);
        currentScreen.hide();

        previousScreen = currentScreen;
        currentScreen = targetScreen;

        currentScreen.show();
        Gdx.input.setCatchBackKey(true);
    }

    public void back() {
        currentScreen.hide();

        currentScreen = previousScreen;
        previousScreen = currentScreen;

        currentScreen.show();
    }

    public void exit() {
        Gdx.input.setCatchBackKey(false);
        currentScreen.dispose();
        Gdx.app.exit();
    }
}
