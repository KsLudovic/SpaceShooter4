package ca.shaxomann.spaceshooter.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ca.shaxomann.spaceshooter.SpaceShooterGame;

public class ScoreScreen implements Screen {


    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_HEIGHT = 100;
    private Game game;
    private SpaceShooterGame spaceShooterGame;
    private Stage stage;
    private SpriteBatch batch;
    BitmapFont scoreFont;
    GameScreen gameScreen;
    int score;
    Texture gameOverBanner;


    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("tracer/skin/tracer-ui.json"));
        TextButton menu = new TextButton("Menu", skin);
        table.row().pad(10, 0, 10, 0);
        menu.setPosition(10,10);
       table.add(menu).expand().bottom().left();
        menu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MenuScreen(game));
            }
        });

    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        GlyphLayout highscoreLayout = new GlyphLayout(scoreFont, "Highscore: \n" + GameOverScreen.highscore, Color.WHITE, 0, Align.left, false);
        scoreFont.draw(batch, highscoreLayout, SpaceShooterGame.WIDTH *3 - highscoreLayout.width , SpaceShooterGame.HEIGHT*3 - BANNER_HEIGHT/2);

        batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();



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
        stage.dispose();

    }
    public ScoreScreen(Game game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        Preferences prefs = Gdx.app.getPreferences("spacegame");
        GameOverScreen.highscore = prefs.getInteger("highscore", 0);
        scoreFont = new BitmapFont(Gdx.files.internal("tracer/raw/font-export.fnt"));

    }

}
