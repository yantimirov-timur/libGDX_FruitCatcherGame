package game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import game.controller.BucketController;

public class CurrentObject extends GameObject {
    //границы падающих и двигающихся обьектов
    public static Circle bombCircle = new Circle();
    public static Circle fruitCircle = new Circle();
    public static Rectangle bucketRectangle = new Rectangle();

    //управление корзиной
    private final BucketController bucketController;

    //скорость движения обьектов
    private float speedFruit = 1f;
    private float speedBomb = 1.6f;

    /**
     * границы обьекта
     */
    public CurrentObject(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        bucketController = new BucketController(bounds);
    }

    /**
     * Отрисовка
     */
    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        handleBomb();
        handleFruit();
        bucketController.handle();
    }

    /**
     * Движение бомбы
     */
    public void handleBomb() {
        if (Logic.positionYBomb <= 0) {
            speedBomb = 0f;
        } else {
            Logic.positionYBomb -= speedBomb;
        }
    }

    /**
     * Движение фрукта
     */
    public void handleFruit() {
        if (Logic.positionYFruit <= 0) {
            speedFruit = 0f;
        } else {
            Logic.positionYFruit -= speedFruit;
        }
    }
}
