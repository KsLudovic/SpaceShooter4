package ca.grasley.spaceshooter;

import com.badlogic.gdx.Game;

import java.util.Random;



public class SpaceShooterGame extends Game {

	private GameScreen gameScreen;
	private LoadingScreen loadingScreen;
	SpaceShooterGame spaceShooterGame;
	// private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private EndScreen endScreen;

	public final static int MENU = 1;
	// public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;

	public static Random random = new Random();

	@Override
	public void create() {


		/* menuScreen = new MenuScreen(this);
		setScreen(menuScreen); */
		  gameScreen = new GameScreen(this);
		  setScreen(gameScreen);

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


	public void changeToGame(){
		spaceShooterGame.setScreen(new GameScreen(spaceShooterGame));


}

}



