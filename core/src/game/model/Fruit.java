package game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class Fruit extends GameObject {
    FruitMove fruitMove;

    static Circle fruitCircle = new Circle();

    /**
     * границы обьекта
     *
     * @param texture
     * @param x
     * @param y
     * @param width
     * @param height
     */

    public Fruit(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);

        fruitMove = new FruitMove(bounds);
    }

    /**
     * Отрисовка
     *
     * @param batch
     */
    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        fruitMove.handle();
    }
}
