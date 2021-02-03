package ca.shaxomann.spaceshooter.SpriteAndEffects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Explosion {
    
    private Animation<TextureRegion> explosionAnimation;
    private float explosionTimer;
    
    private Rectangle boudingBox;
    
    public Explosion(Texture texture, Rectangle boudingBox, float totalAnimationTime){
        this.boudingBox = boudingBox;
        
        // splitting text
        TextureRegion[][] textureRegion2D = TextureRegion.split(texture,512,512);
        
        //convert to array
        
        TextureRegion[] textureRegion1D = new TextureRegion[64];
        int index= 0;
        for(int i= 0; i<8; i++){
            for(int j=0; j<8; j++) {
                textureRegion1D[index++] = textureRegion2D[i][j];
            }
        }

        explosionAnimation = new Animation<TextureRegion>(totalAnimationTime/64, textureRegion1D);
        explosionTimer = 0;
        
    }
    
    public void update(float deltaTime){
        explosionTimer+=deltaTime;
    }
    
    public void draw(SpriteBatch batch){
        batch.draw(explosionAnimation.getKeyFrame(explosionTimer),
                boudingBox.x-8,boudingBox.y-8,
                boudingBox.width+15,boudingBox.height+15);
                
    }
    
    public boolean isFinished(){
        return explosionAnimation.isAnimationFinished(explosionTimer);
    }
}
