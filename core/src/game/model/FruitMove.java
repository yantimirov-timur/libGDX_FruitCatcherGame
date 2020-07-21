package game.model;

import com.badlogic.gdx.math.Polygon;

public class FruitMove {
    private Polygon fruitBounds;

    public FruitMove(Polygon fruitBounds) {
        this.fruitBounds = fruitBounds;
    }

    float speed = 5f;

    public void handle() {
        if (MyGdxGame.positionY <= 0) {
            speed = 0f;
        } else {
            MyGdxGame.positionY -= speed;
        }
    }
}
