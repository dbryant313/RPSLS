package com.teamdelta.game.models;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.teamdelta.game.common.Button;

import java.util.ArrayList;

/**
 * @author William Warnock
 */
public class RPSLSEntity {
    private String name;
    private TextureRegion textureRegion;
    private ArrayList<RPSLSEntity> foes = new ArrayList<RPSLSEntity>();
    private Button button;

    public RPSLSEntity(String name, TextureRegion textureRegion) {
        this.name = name;
        this.textureRegion = textureRegion;
    }

    public String getName() {
        return name;
    }

    public TextureRegion getImage() {
        return textureRegion;
    }

    public Button getButton() {
        return button;
    }

    public Button setButton(Rectangle buttonRectangle) {
        button = new Button(textureRegion, textureRegion, buttonRectangle);

        return button;
    }

    public ArrayList<RPSLSEntity> getFoes() {
        return foes;
    }

    public void addFoe(RPSLSEntity foe) {
        foes.add(foe);
    }

    public boolean isFoe(RPSLSEntity possibleFoe) {
        return foes.contains(possibleFoe);
    }
}
