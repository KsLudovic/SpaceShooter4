package ca.shaxomann.spaceshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class WarpEffect {

    private Animation<TextureRegion> warpAnimation;
    private float warpTimer;

    private Rectangle boudingBox;

    WarpEffect(Texture texture, Rectangle boudingBox, float totalAnimationTime){
        this.boudingBox = boudingBox;

        // splitting text
        TextureRegion[][] textureRegion2D = TextureRegion.split(texture,320,364);

        //convert to array

        TextureRegion[] textureRegion1D = new TextureRegion[8];
        int index= 0;
        for(int i= 0; i<1; i++){
            for(int j=0; j<8; j++) {
                textureRegion1D[index++] = textureRegion2D[i][j];
            }
        }

        warpAnimation = new Animation<TextureRegion>(totalAnimationTime/8, textureRegion1D);
        warpTimer = 0;

    }

    public void update(float deltaTime){
        warpTimer+=deltaTime;
    }

    public void draw(SpriteBatch batch){
        batch.draw(warpAnimation.getKeyFrame(warpTimer),
                boudingBox.x-5,boudingBox.y-7,
                boudingBox.width+10,boudingBox.height+10);

    }

    public boolean isFinished(){
        return warpAnimation.isAnimationFinished(warpTimer);
    }


}



