package game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import game.controller.BucketController;

public class Bucket extends GameObject{
    /**
     * границы обьекта
     *
     * @param texture
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Bucket(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        bucketController = new BucketController(bounds);
    }

    BucketController bucketController;

    static Rectangle bucketRectangle = new Rectangle();

    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
        bucketController.handle();
    }
}
