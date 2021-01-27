package ca.shaxomann.spaceshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class SparkEffect {

    private Animation<TextureRegion> sparkAnimation;
    private float sparkTimer;

    private Rectangle boudingBox;

    SparkEffect(Texture texture, Rectangle boudingBox, float totalAnimationTime){
        this.boudingBox = boudingBox;

        // splitting text
        TextureRegion[][] textureRegion2D = TextureRegion.split(texture,192,192);

        //convert to array

        TextureRegion[] textureRegion1D = new TextureRegion[20];
        int index= 0;
        for(int i= 0; i<4; i++){
            for(int j=0; j<5; j++) {
                textureRegion1D[index++] = textureRegion2D[i][j];
            }
        }

        sparkAnimation = new Animation<TextureRegion>(totalAnimationTime/20, textureRegion1D);
        sparkTimer = 0;

    }

    public void update(float deltaTime){
        sparkTimer+=deltaTime;
    }

    public void draw(SpriteBatch batch){
        batch.draw(sparkAnimation.getKeyFrame(sparkTimer),
                boudingBox.x,boudingBox.y+3,
                boudingBox.width,boudingBox.height+1);

    }

    public boolean isFinished(){
        return sparkAnimation.isAnimationFinished(sparkTimer);
    }


}

