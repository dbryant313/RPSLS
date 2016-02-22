package com.teamdelta.game.screens.gamescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.Main;
import com.teamdelta.game.models.CPU;
import com.teamdelta.game.models.EntityNames;
import com.teamdelta.game.models.User;

/**
 * @author William Warnock
 */
public class GameScreenController extends InputAdapter {
    GameScreen gameScreen;
    Main gameInstance;
    Vector3 input;
    User player;
    CPU cpu;

    boolean playerTookTurn, cpuTookTurn, gameover, isGameTied, isPlayerWin, isCPUWin;
    float cpuTurnTimer;//--Ismael added delay timer for CPU

    GameScreenController(GameScreen gameScreen, Main gameInstance) {
        this.gameScreen   = gameScreen;
        this.gameInstance = gameInstance;
        this.input = new Vector3();
        this.player = new User(gameScreen.atlas);
        this.cpu = new CPU(gameScreen.atlas);

        Gdx.input.setInputProcessor(this);
    }

    /**
     * Check for a winner and update the model/view
     * @param timeSinceLastFrame
     */
    void checkWinner(float timeSinceLastFrame) {
        if (playerTookTurn && cpuTookTurn && !gameover) {
            int winnerValue = gameInstance.gameLogic.determineWinner(player.choice, cpu.choice);

            isGameTied = false;
            isCPUWin = false;
            isPlayerWin = false;

            gameover = true;

            if(winnerValue == -1) {
                isGameTied = true;
                cpu.tieScore ++;
                player.tieScore ++;
            } else if(winnerValue == 0) {
                isCPUWin= true;
                cpu.winScore++;
                player.loseScore++;
                isCPUWin = true;
            } else if(winnerValue == 1) {
                isPlayerWin = true;
                cpu.loseScore++;
                player.winScore++;
                isPlayerWin = true;
            }
        }

        if (playerTookTurn && cpu.turnToPlay && !cpuTookTurn) {
            cpuTurnTimer += timeSinceLastFrame; // --Delay timer

            if(cpuTurnTimer >= 0.5){
                cpu.choice = gameInstance.gameLogic.getEntity();
                cpuTookTurn = true;
                cpu.turnToPlay = false;
                cpuTurnTimer = 0; //--Reset timer
            }
        }
    }

    /**
     * Determine what messages to render on the view and update accordingly
     */
    void renderMessages() {
        if(player.turnToPlay){
            gameScreen.font.draw(gameScreen.batch, "Your Turn", 350, 600);
        } else if(cpu.turnToPlay){
            gameScreen.font.draw(gameScreen.batch, "CPU's Turn", 350, 600);
        }

        if(playerTookTurn){
            gameScreen.font.draw(gameScreen.batch, "You chose: " + player.choice.getName(), 180, 500); //-- Adjusted Positioning - Ismael
        } else if(cpuTookTurn){
            gameScreen.font.draw(gameScreen.batch, "CPU chose: " + cpu.choice.getName(), 470, 500); //-- Adjusted Positioning - Ismael
        }

        if(gameover){
            gameScreen.font.draw(gameScreen.batch, "Play Again?", 355, 230);//Ismael added play again message when game is over

            if(isGameTied){
                gameScreen.batch.draw(gameScreen.atlas.findRegion("tied"),  320, 400);// Dennis added graphic for tie game.
            } else if(isPlayerWin){
                gameScreen.batch.draw(gameScreen.atlas.findRegion("winner"),  250, 400);	// Dennis added graphic for winner.
            } else if(isCPUWin){
                gameScreen.batch.draw(gameScreen.atlas.findRegion("cpu"),  320, 400);	// Dennis added graphic for cpu winner.
            }
        }
    }

    private void resetGameState() {
        gameover = false;
        player.turnToPlay = true;
        cpu.turnToPlay = false;
        playerTookTurn = false;
        cpuTookTurn = false;
        isCPUWin = false;
        isGameTied = false;
        isPlayerWin = false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        input.x = screenX;
        input.y = screenY;

        gameScreen.aboutButton.selected = false;
        gameScreen.rulesButton.selected = false;
        gameScreen.closeButton.selected = false;
        gameScreen.playAgainButton.selected = false;

        gameInstance.camera.unproject(input);

        if (gameScreen.aboutButton.colisionRect.contains(input.x, input.y)) {
            gameInstance.router.changeScreen(gameInstance.aboutScreen);
        } else if (gameScreen.rulesButton.colisionRect.contains(input.x, input.y)) {
            gameInstance.router.changeScreen(gameInstance.rulesScreen);
        } else if (gameScreen.closeButton.colisionRect.contains(input.x, input.y)) {
            gameInstance.router.changeScreen(gameInstance.startScreen);
        }

        //Ismael added functionality to playAgainButton to reset game state
        if(gameover){
            if (gameScreen.playAgainButton.colisionRect.contains(input.x, input.y)) {
                resetGameState();
            }
        }

        if(player.turnToPlay) {
            if (gameScreen.rockButton.colisionRect.contains(input.x, input.y)) {
                player.choice = gameInstance.gameLogic.getEntity(EntityNames.ROCK);
            } else if(gameScreen.paperButton.colisionRect.contains(input.x, input.y)) {
                player.choice = gameInstance.gameLogic.getEntity(EntityNames.PAPER);
            } else if(gameScreen.scissorsButton.colisionRect.contains(input.x, input.y)) {
                player.choice = gameInstance.gameLogic.getEntity(EntityNames.SCISSORS);
            } else if(gameScreen.lizardButton.colisionRect.contains(input.x, input.y)) {
                player.choice = gameInstance.gameLogic.getEntity(EntityNames.LIZARD);
            } else if(gameScreen.spockButton.colisionRect.contains(input.x, input.y)) {
                player.choice = gameInstance.gameLogic.getEntity(EntityNames.SPOCK);
            } else {
                return true;
            }

            playerTookTurn = true;
            player.turnToPlay = false;
            cpu.turnToPlay = true;
        }

        return true;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        input.x = screenX;
        input.y = screenY;

        gameInstance.camera.unproject(input);

        if (gameScreen.aboutButton.colisionRect.contains(input.x, input.y)) {
            gameInstance.clickSound.play();
            gameScreen.aboutButton.selected = true;
        } else {
            gameScreen.aboutButton.selected = false;
        }

        if (gameScreen.rulesButton.colisionRect.contains(input.x, input.y)) {
            gameInstance.clickSound.play();
            gameScreen.rulesButton.selected = true;
        } else {
            gameScreen.rulesButton.selected = false;
        }

        if (gameScreen.closeButton.colisionRect.contains(input.x, input.y)) {
            gameScreen.closeButton.selected = true;
            gameInstance.clickSound.play();
        } else {
            gameScreen.closeButton.selected = false;
        }

        if (gameScreen.playAgainButton.colisionRect.contains(input.x, input.y)) {
            gameScreen.playAgainButton.selected = true;
            gameInstance.clickSound.play();
        } else {
            gameScreen.playAgainButton.selected = false;
        }

        return true;
    }
}
