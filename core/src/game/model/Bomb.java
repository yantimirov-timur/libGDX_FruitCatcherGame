package game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class Bomb extends GameObject{
    BombMove bombMove;

    public static Circle bombCircle = new Circle();
    /**
     * границы обьекта
     *
     * @param texture
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Bomb(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);

        bombMove = new BombMove();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        bombMove.handle();
    }
}
