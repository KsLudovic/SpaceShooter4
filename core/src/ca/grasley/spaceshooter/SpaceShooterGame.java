package ca.grasley.spaceshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.util.Random;



public class SpaceShooterGame extends Game {

	// multiples windows

	private Game game;
	private AppPreferences preferences;

	private GameScreen gameScreen;
	private LoadingScreen loadingScreen;
	SpaceShooterGame spaceShooterGame;
	private PreferenceScreen preferencesScreen;
	private MenuScreen menuScreen;
	private ScoreScreen scoreScreen;
	private EndScreen endScreen;

	public final static int MENU = 0;
	public final static int APPLICATION = 1;
	public final static int SCORE =2;
	public final static int PREFERENCES = 3;
	public final static int ENDGAME = 4;

	public static Random random = new Random();




	public SpaceShooterGame(){

		game = this;
	}
	@Override
	public void create() {


		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
		 /*gameScreen = new GameScreen(this);
		  setScreen(gameScreen); */


	}


	@Override
	public void dispose() {
		super.dispose();
	}


	@Override
	public void render() {
		super.render();
	}


	@Override
	public void resize(int width, int height) {
//		gameScreen.resize(width, height);
		super.resize(width,height);
	}
	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(game);
				this.setScreen(menuScreen);
				break;

			case APPLICATION:
				if(gameScreen == null) gameScreen = new GameScreen(game);
				this.setScreen(gameScreen);
				break;

			case SCORE:
				if(scoreScreen == null) scoreScreen = new ScoreScreen(game);
				this.setScreen(scoreScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new PreferenceScreen(game);
				this.setScreen(preferencesScreen);
				break;

		/*	case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen();
				this.setScreen(endScreen);
				break; */
		}

	}
	public AppPreferences getPreferences(){
		return this.preferences;
	}

	}









