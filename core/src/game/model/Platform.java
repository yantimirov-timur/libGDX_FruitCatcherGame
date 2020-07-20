package game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Platform extends GameObject{
    /**
     * границы обьекта
     *
     * @param texture
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Platform(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }

    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
    }
}
