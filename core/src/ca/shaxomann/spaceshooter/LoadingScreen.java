package ca.shaxomann.spaceshooter;

import com.badlogic.gdx.Screen;

public class LoadingScreen implements Screen {
    private ca.shaxomann.spaceshooter.SpaceShooterGame parent;
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {



       // parent.changeScreen(SpaceShooterGame.MENU);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public LoadingScreen(SpaceShooterGame spaceShooterGame){
        parent = spaceShooterGame;

    }
}