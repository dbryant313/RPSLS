package com.teamdelta.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.teamdelta.game.screens.aboutscreen.AboutScreen;
import com.teamdelta.game.screens.gamescreen.GameScreen;
import com.teamdelta.game.screens.rulesscreen.RulesScreen;
import com.teamdelta.game.screens.startscreen.StartScreen;

import com.teamdelta.game.common.*;
import com.teamdelta.game.models.*;

/**
 * 
 * @author Ismael Poteau
 * @author Bill Warnock
 * @author Jake Herritt
 * @author Jeff Kunert
 * @author Dennis Bryant
 * @version 1.0.0.0
 * @since 2/9/16
 * 
 * The Game class controls the game.
 * 2/18/16 - added sound assets - Ismael
 */

public class Main extends Game {
	//--
	public SpriteBatch batch;
	public OrthographicCamera camera;
	Viewport viewport;
	public AssetManager assetMgr;

	//--GameLogic
	public GameLogic gameLogic;

	//Screen Router
	public Router router;

	//--Screens
	public StartScreen startScreen;
	public GameScreen gameScreen;
	public AboutScreen aboutScreen;
	public RulesScreen rulesScreen;

	//--Game assets
	public TextureAtlas gameAtlas;
	public Music clickSound;//changed Sound to Music - Warnock
	//Sounds played for winner of round - Ismael
	public Sound rockCrushesLizard;
	public Sound rockCrushesScissors;
	public Sound paperCoversRock;
	public Sound paperDisprovesSpock;
	public Sound scissorsDecapitateLizard;
	public Sound scissorsCutPaper;
	public Sound lizardEatsPaper;
	public Sound lizardPoisonsSpock;
	public Sound spockVaporizesRock;
	public Sound spockSmashesScissors;
	public Sound tie;

	//--Entity Information - warnock
	public RPSLSEntity rockEntity;
	public RPSLSEntity paperEntity;
	public RPSLSEntity scissorsEntity;
	public RPSLSEntity lizardEntity;
	public RPSLSEntity spockEntity;

	float delta;
	//
	public final int WIDTH = 800;
	public final int HEIGHT = 640;
	
	@Override
	public void create() {
		assetMgr = new AssetManager();
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		camera.update();
		viewport = new StretchViewport(WIDTH, HEIGHT, camera);
		
		assetMgr.load("game.pack", TextureAtlas.class);
		assetMgr.finishLoading();

		//loaded assets and button click sound - Warnock
		gameAtlas = assetMgr.get("game.pack", TextureAtlas.class);
		clickSound = Gdx.audio.newMusic(Gdx.files.internal("buttonClick.mp3"));
		clickSound.setVolume(0.15f);
		rockCrushesLizard =  Gdx.audio.newSound(Gdx.files.internal("ROCKLIZARD.ogg"));
		rockCrushesScissors = Gdx.audio.newSound(Gdx.files.internal("ROCKSCISSORS.ogg"));
		paperCoversRock = Gdx.audio.newSound(Gdx.files.internal("PAPERROCK.ogg"));
		paperDisprovesSpock = Gdx.audio.newSound(Gdx.files.internal("PAPERSPOCK.ogg"));
		scissorsDecapitateLizard = Gdx.audio.newSound(Gdx.files.internal("SCISSORSLIZARD.ogg"));
		scissorsCutPaper = Gdx.audio.newSound(Gdx.files.internal("SCISSORSPAPER.ogg"));
		lizardEatsPaper = Gdx.audio.newSound(Gdx.files.internal("LIZARDPAPER.ogg"));
		lizardPoisonsSpock = Gdx.audio.newSound(Gdx.files.internal("LIZARDSPOCK.ogg"));
		spockVaporizesRock = Gdx.audio.newSound(Gdx.files.internal("SPOCKROCK.ogg"));
		spockSmashesScissors = Gdx.audio.newSound(Gdx.files.internal("SPOCKSCISSORS.ogg"));
		tie = Gdx.audio.newSound(Gdx.files.internal("Tie.ogg"));
		

		createEntities();

		//created new instance of GameLogic - Warnock
		gameLogic = new GameLogic(this);
		startScreen = new StartScreen(this);
		gameScreen = new GameScreen(this);
		aboutScreen = new AboutScreen(this);
		rulesScreen = new RulesScreen(this);
		router = new Router();

		router.changeScreen(startScreen);
	}

	@Override
	public void dispose(){
		router.getScreen().dispose();
		assetMgr.dispose();
		batch.dispose();
	}
	
	@Override
	public void pause() {
		router.getScreen().pause();
	}

	@Override
	public void resume() {
		router.getScreen().resume();
		System.out.println("Main Resume");
	}

	@Override
	public void render(){
		delta = Gdx.graphics.getDeltaTime();
		camera.update();
		viewport.apply();
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		router.getScreen().render(delta);
		batch.end();
		if(!router.getScreen().paused){
			router.getScreen().update(delta);
		}
		
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width, height);
		viewport.apply();
	}

	//create entities - Warnock
	public void createEntities() {
		String rock = EntityNames.ROCK.toString();
		String paper = EntityNames.PAPER.toString();
		String scissors = EntityNames.SCISSORS.toString();
		String lizard = EntityNames.LIZARD.toString();
		String spock = EntityNames.SPOCK.toString();

		//Create RPSLSEntities
		rockEntity 		= new RPSLSEntity(rock, gameAtlas.findRegion(rock));
		paperEntity 	= new RPSLSEntity(paper, gameAtlas.findRegion(paper));
		scissorsEntity 	= new RPSLSEntity(scissors, gameAtlas.findRegion(scissors));
		lizardEntity 	= new RPSLSEntity(lizard, gameAtlas.findRegion(lizard));
		spockEntity 	= new RPSLSEntity(spock, gameAtlas.findRegion(spock));
	}
}
