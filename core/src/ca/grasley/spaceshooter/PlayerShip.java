package ca.grasley.spaceshooter;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

class PlayerShip extends Ship {

    int lives =3;
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
}
