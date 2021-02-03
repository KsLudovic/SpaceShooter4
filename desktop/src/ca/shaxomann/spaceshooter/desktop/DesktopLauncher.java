package ca.shaxomann.spaceshooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ca.shaxomann.spaceshooter.SpaceShooterGame;
import ca.shaxomann.spaceshooter.SplashWorker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 640;
		config.width = 360;
		SpaceShooterGame spaceShooterGame = new SpaceShooterGame();
		spaceShooterGame.setSplashWorker(new DesktopSplashWorker());
		new LwjglApplication(spaceShooterGame, config);
	}
}
