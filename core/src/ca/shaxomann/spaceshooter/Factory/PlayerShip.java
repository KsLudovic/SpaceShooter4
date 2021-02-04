package ca.shaxomann.spaceshooter.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.Menu;

import javax.xml.soap.Text;

import ca.shaxomann.spaceshooter.Screens.MenuScreen;
import ca.shaxomann.spaceshooter.SpriteAndEffects.Laser;
import ca.shaxomann.spaceshooter.SpriteAndEffects.Rocket;

import static ca.shaxomann.spaceshooter.Screens.GameScreen.gameOverSound;

public class PlayerShip extends ca.shaxomann.spaceshooter.Factory.Ship {

    public int lives =3;
    public int numberOfRockets = 3;
    TextureRegion rocketTextureRegion;
    public PlayerShip(float xCentre, float yCentre,
                      float width, float height,
                      float movementSpeed, int shield,
                      float laserWidth, float laserHeight,
                      float laserMovementSpeed, float timeBetweenShots,
                      TextureRegion shipTextureRegion,
                      TextureRegion shieldTextureRegion,
                      TextureRegion laserTextureRegion, TextureRegion rocketTextureRegion) {
        super(xCentre, yCentre,
                width, height,
                movementSpeed, shield,
                laserWidth, laserHeight,
                laserMovementSpeed, timeBetweenShots,
                shipTextureRegion, shieldTextureRegion, laserTextureRegion);
        this.rocketTextureRegion = rocketTextureRegion;



    }

    @Override
    public Laser[] fireLasers() {
        Laser[] laser = new Laser[2];

        laser[0] = new Laser(boundingBox.x + boundingBox.width * 0.20f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth, laserHeight,
                laserMovementSpeed, laserTextureRegion);
        laser[1] = new Laser(boundingBox.x + boundingBox.width * 0.80f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth, laserHeight,
                laserMovementSpeed, laserTextureRegion);

        timeSinceLastShot = 0;

        return laser;
    }

    public boolean canRocket(){
        if(numberOfRockets>0 && Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            fireRocket();

            return true;
        }
        return false;
    }

    public Rocket fireRocket() {
        Rocket rockets = new Rocket(boundingBox.x + boundingBox.width * 0.50f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth+2, laserHeight+2,
                laserMovementSpeed, rocketTextureRegion);

        return rockets;
    }
    public void death(){
        gameOverSound.play(0.1f,1f,0f);
    }


}
