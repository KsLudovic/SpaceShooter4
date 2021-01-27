package ca.shaxomann.spaceshooter;

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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameOverScreen implements Screen {

    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_HEIGHT = 100;
    private Stage stage;

    private SpaceShooterGame spaceShooterGame;
    private Game game;
    private SpriteBatch batch;

    int score, highscore;

    Texture gameOverBanner;
    BitmapFont scoreFont;




    @Override
    public void show () {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("tracer/skin/tracer-ui.json"));
        TextButton menu = new TextButton("Menu", skin);
        table.row().pad(10, 0, 10, 0);
        menu.setPosition(10,10);
        table.add(menu).expand().bottom().left();
        TextButton tryagain = new TextButton("Try Again", skin);
        table.row().pad(10, 0, 10, 0);
        menu.setPosition(10,10);
        table.add(tryagain).expand().bottom().left();
    }

    @Override
    public void render (float delta) {

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();


        batch.draw(gameOverBanner, SpaceShooterGame.WIDTH-65, SpaceShooterGame.HEIGHT*3+30, BANNER_WIDTH, BANNER_HEIGHT);

        GlyphLayout scoreLayout = new GlyphLayout(scoreFont, "Score: \n" + score, Color.WHITE, 0, Align.left, false);
        GlyphLayout highscoreLayout = new GlyphLayout(scoreFont, "Highscore: \n" + highscore, Color.WHITE, 0, Align.left, false);
        scoreFont.draw(batch, scoreLayout, SpaceShooterGame.WIDTH*2 - scoreLayout.width / 2, SpaceShooterGame.HEIGHT*3);
        scoreFont.draw(batch, highscoreLayout, SpaceShooterGame.WIDTH *3 - highscoreLayout.width / 2, SpaceShooterGame.HEIGHT*3 - BANNER_HEIGHT - scoreLayout.height - 15 * 3);



        batch.end();
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
        gameOverBanner = new Texture("game_over.png");
        scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

    }

}