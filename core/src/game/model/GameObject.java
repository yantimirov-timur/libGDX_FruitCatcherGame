package game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

public abstract class GameObject {
    Polygon bounds;
    Sprite obj;

    /**
     * границы обьекта
     */
    public GameObject(Texture texture, float x, float y, float width, float height) {
        obj = new Sprite(texture);
        obj.setSize(width, height);
        obj.setOrigin(width / 2f, height / 2f);
        obj.setPosition(x, y);

        bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition(x, y);
        bounds.setOrigin(width / 2f, height / 2f);
    }

    public void draw(SpriteBatch spriteBatch) {
        obj.setPosition(bounds.getX(), bounds.getY());
        obj.setRotation(bounds.getRotation());
        obj.draw(spriteBatch);
    }

    public Polygon getBounds() {
        return bounds;
    }
}