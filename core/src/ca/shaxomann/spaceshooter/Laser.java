package ca.shaxomann.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

class Laser {

    //position and dimensions
    Rectangle boundingBox;

    //laser physical characteristics
    float movementSpeed; //world units per second

    //graphics
    TextureRegion textureRegion;

    // SOUND
    Sound LaserSound = Gdx.audio.newSound(Gdx.files.internal("laserRetro_000.ogg"));

    public Laser(float xCentre, float yBottom, float width, float height, float movementSpeed,
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
