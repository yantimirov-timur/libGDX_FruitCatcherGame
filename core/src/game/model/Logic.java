package game.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import view.MyGdxGame;

import java.util.Random;

import static game.model.Bucket.bucketRectangle;
import static game.model.Fruit.fruitCircle;

public class Logic extends ApplicationAdapter {

    //model
    Fruit fruit;
    Platform platform;
    Bucket bucket;

    public static int score = 0;
    public static float positionY = 400f;

    public static float positionXBucket = 0f;
    public static float positionXFruit = 0F;

    int randomPlace() {
        return new Random().nextInt(450);
    }

    @Override
    public void create() {
        Vector2 center = new Vector2();

        center.x = fruitCircle.x + 50;
        center.y = fruitCircle.y + 50;

        fruitCircle = new Circle(center, 50);
    }

    @Override
    public void render() {
        fruit = new Fruit(MyGdxGame.getImgFruit(), positionXFruit, positionY, 50, 50);
        platform = new Platform(MyGdxGame.getImgPlatform(), -20, -20, 700, 50);
        bucket = new Bucket(MyGdxGame.getImgBucket(), positionXBucket, 15, 100, 100);

        if (Intersector.overlaps(fruitCircle, bucketRectangle)) {
            score += 50;
            positionY = 450;
            positionXFruit = randomPlace();
        } else if (positionY <= 0) {
            positionY = 450;
            positionXFruit = randomPlace();
        }

        fruit.draw(MyGdxGame.getBatch());
        platform.draw(MyGdxGame.getBatch());
        bucket.draw(MyGdxGame.getBatch());

        fruitCircle.setPosition(positionXFruit, positionY);
        bucketRectangle.setPosition(positionXBucket, bucket.getBounds().getY());
    }
}
