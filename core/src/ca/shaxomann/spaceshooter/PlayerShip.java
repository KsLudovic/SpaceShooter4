package ca.shaxomann.spaceshooter;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

class PlayerShip extends ca.shaxomann.spaceshooter.Ship {

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
    public ca.shaxomann.spaceshooter.Laser[] fireLasers() {
        ca.shaxomann.spaceshooter.Laser[] laser = new ca.shaxomann.spaceshooter.Laser[2];
        laser[0] = new ca.shaxomann.spaceshooter.Laser(boundingBox.x + boundingBox.width * 0.20f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth, laserHeight,
                laserMovementSpeed, laserTextureRegion);
        laser[1] = new ca.shaxomann.spaceshooter.Laser(boundingBox.x + boundingBox.width * 0.80f, boundingBox.y + boundingBox.height * 0.50f,
                laserWidth, laserHeight,
                laserMovementSpeed, laserTextureRegion);

        timeSinceLastShot = 0;

        return laser;
    }


}
