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

public class GameOverScreen implements Screen {

    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_HEIGHT = 100;
    private Stage stage;


    private Game game;
    private SpriteBatch batch;

    int score;
    static int highscore;

    Texture gameOverBanner;
    BitmapFont scoreFont;




    @Override
    public void show () {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("tracer/skin/tracer-ui.json"));
        TextButton tryAgain = new TextButton("Try again", skin);
        table.row().pad(10, 0, 10, 0);
        tryAgain.setPosition(10,10);
        table.add(tryAgain).expand().bottom().right();
        tryAgain.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));
            }
        });
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
    public void render (float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(gameOverBanner, SpaceShooterGame.WIDTH-65, SpaceShooterGame.HEIGHT*3+30, BANNER_WIDTH, BANNER_HEIGHT);

        GlyphLayout scoreLayout = new GlyphLayout(scoreFont, "Score: \n" + score, Color.WHITE, 0, Align.left, false);
        GlyphLayout highscoreLayout = new GlyphLayout(scoreFont, "Highscore: \n" + highscore, Color.WHITE, 0, Align.left, false);
        scoreFont.draw(batch, scoreLayout, SpaceShooterGame.WIDTH*2 - scoreLayout.width / 2, SpaceShooterGame.HEIGHT*3);
        scoreFont.draw(batch, highscoreLayout, SpaceShooterGame.WIDTH *2 - scoreLayout.width / 2, SpaceShooterGame.HEIGHT*3 - BANNER_HEIGHT);



        batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();






    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        stage.dispose();
        batch.dispose();

    }
    public GameOverScreen (Game game, int score) {
        this.game = game;
        this.score = score;
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        //Get highscore from save file
        Preferences prefs = Gdx.app.getPreferences("spacegame");
        this.highscore = prefs.getInteger("highscore", 0);

        //Check if score beats highscore
        if (score > highscore) {
            prefs.putInteger("highscore", score);
            prefs.flush();
        }

        //Load textures and fonts
        gameOverBanner = new Texture("go.png");
        scoreFont = new BitmapFont(Gdx.files.internal("tracer/raw/font-export.fnt"));

    }


}