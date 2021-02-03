package ca.shaxomann.spaceshooter.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.xml.soap.Text;

import ca.shaxomann.spaceshooter.SpriteAndEffects.Laser;
import ca.shaxomann.spaceshooter.SpriteAndEffects.Rocket;

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
                      TextureRegion laserTextureRegion) {
        super(xCentre, yCentre,
                width, height,
                movementSpeed, shield,
                laserWidth, laserHeight,
                laserMovementSpeed, timeBetweenShots,
                shipTextureRegion, shieldTextureRegion, laserTextureRegion);



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

    public Rocket[] fireRocket() {
        Rocket[] rockets = new Rocket[2];

        rockets[0] = new Rocket(boundingBox.x + boundingBox.width * 0.20f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth, laserHeight,
                laserMovementSpeed, rocketTextureRegion);
        rockets[1] = new Rocket(boundingBox.x + boundingBox.width * 0.80f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth, laserHeight,
                laserMovementSpeed, rocketTextureRegion);

        timeSinceLastShot = 0;

        return rockets;
    }


}
