package ca.shaxomann.spaceshooter.SpriteAndEffects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


public class Rocket {
    //position and dimensions
    public Rectangle boundingBox;

    //laser physical characteristics
    public float movementSpeed; //world units per second
    private TextureAtlas textureAtlas1;

    //graphics
    TextureRegion textureRegion;


    // SOUND
    Sound rocketSound = Gdx.audio.newSound(Gdx.files.internal("laserRetro_000.ogg"));

    public Rocket(float xCentre, float yBottom, float width, float height, float movementSpeed,
                 TextureRegion textureRegion) {
        this.boundingBox = new Rectangle(xCentre - width / 2, yBottom, width, height);
        this.movementSpeed = movementSpeed;
        this.textureRegion = textureRegion;
    }

    public void draw(Batch batch) {
        batch.draw(textureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
    }

//    public Rectangle getBoundingBox() {
//        return boundingBox;
//    }
}

