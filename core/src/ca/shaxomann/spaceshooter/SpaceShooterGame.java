package ca.shaxomann.spaceshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

import ca.shaxomann.spaceshooter.Screens.EndScreen;
import ca.shaxomann.spaceshooter.Screens.GameOverScreen;


public class SpaceShooterGame extends Game {


	// splashworker
	public SplashWorker splashWorker;

	// window relative


	public static final float WIDTH = 72;
	public static final float HEIGHT = 128;
	public Batch batch;

	// multiples windows

	private Game game;
	private AppPreferences preferences;

	private ca.shaxomann.spaceshooter.Screens.GameScreen gameScreen;
	private ca.shaxomann.spaceshooter.Screens.LoadingScreen loadingScreen;
	SpaceShooterGame spaceShooterGame;
	private ca.shaxomann.spaceshooter.Screens.PreferenceScreen preferencesScreen;
	private ca.shaxomann.spaceshooter.Screens.MenuScreen menuScreen;
	private ca.shaxomann.spaceshooter.Screens.ScoreScreen scoreScreen;
	private ca.shaxomann.spaceshooter.Screens.EndScreen endScreen;
	private ca.shaxomann.spaceshooter.Screens.GameOverScreen gameOverScreen;

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
		splashWorker.closeSplashScreen();
		menuScreen = new ca.shaxomann.spaceshooter.Screens.MenuScreen(this);
		setScreen(menuScreen);
	/*	 gameOverScreen = new GameOverScreen(this,0);
		  setScreen(gameOverScreen); */


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
				if(menuScreen == null) menuScreen = new ca.shaxomann.spaceshooter.Screens.MenuScreen(game);
				this.setScreen(menuScreen);
				break;

			case APPLICATION:
				if(gameScreen == null) gameScreen = new ca.shaxomann.spaceshooter.Screens.GameScreen(game);
				this.setScreen(gameScreen);
				break;

			case SCORE:
				if(scoreScreen == null) scoreScreen = new ca.shaxomann.spaceshooter.Screens.ScoreScreen(game);
				this.setScreen(scoreScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new ca.shaxomann.spaceshooter.Screens.PreferenceScreen(game);
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


	public SplashWorker getSplashWorker() {
		return splashWorker;
	}

	public void setSplashWorker(SplashWorker splashWorker) {
		this.splashWorker = splashWorker;
	}
	}










