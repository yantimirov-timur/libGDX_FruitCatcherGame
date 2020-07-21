package game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class FruitMove {
    private Polygon fruitBounds;


    public FruitMove(Polygon fruitBounds) {
        this.fruitBounds = fruitBounds;
    }

    float speed = 5f;

    Random random = new Random();

    public void checkCollisionWithBucket() {
        MyGdxGame.positionXFruit = random.nextInt(450);
    }

    public void handle() {
        if (MyGdxGame.positionY <= 0) {
            speed = 0f;
        } else {
            MyGdxGame.positionY -= speed;
        }
     //  checkCollisionWithBucket();

    }

}
