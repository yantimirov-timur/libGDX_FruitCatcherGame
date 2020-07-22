package game.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import view.MyGdxGame;

import java.util.Random;

import static game.model.Bucket.bucketRectangle;
import static game.model.Fruit.fruitCircle;
import static game.model.Bomb.bombCircle;

public class Logic extends ApplicationAdapter {

    //model
    Fruit fruit;
    Platform platform;
    Bucket bucket;
    Bomb bomb;

    public static int score = 0;
    public static float positionYFruit = 400f;

    public static float positionYBomb = 400f;

    public static float positionXBucket = 0f;
    public static float positionXFruit = 0F;
    public static float positionXBomb = 400f;

    int randomPlace() {
        return new Random().nextInt(450);
    }

    @Override
    public void create() {
        Vector2 centerFruit = new Vector2();
        centerFruit.x = fruitCircle.x + 50;
        centerFruit.y = fruitCircle.y + 50;

        Vector2 centerBomb = new Vector2();
        centerBomb.x = bombCircle.x + 50;
        centerBomb.y = bombCircle.y + 50;

        fruitCircle = new Circle(centerFruit, 50);
        bombCircle  = new Circle(centerBomb,50);
    }

    @Override
    public void render() {
        fruit = new Fruit(MyGdxGame.getImgFruit(), positionXFruit, positionYFruit, 50, 50);
        platform = new Platform(MyGdxGame.getImgPlatform(), -20, -20, 700, 50);
        bucket = new Bucket(MyGdxGame.getImgBucket(), positionXBucket, 15, 100, 100);
        bomb = new Bomb(MyGdxGame.getImgBomb(), positionXBomb, positionYBomb, 50, 50);

        if (Intersector.overlaps(fruitCircle, bucketRectangle)) {
            score += 50;
            positionYFruit = 450;
            positionXFruit = randomPlace();
        } else if (Intersector.overlaps(bombCircle, bucketRectangle)) {
            score -=70;
            positionYBomb = 450;
            positionXBomb = randomPlace();
        } else if (positionYFruit <= 0) {
            positionYFruit = 450;
            positionXFruit = randomPlace();
        } else if (positionYBomb <= 0) {
            positionYBomb = 450;
            positionXBomb = randomPlace();
        }

        bomb.draw(MyGdxGame.getBatch());
        fruit.draw(MyGdxGame.getBatch());
        platform.draw(MyGdxGame.getBatch());
        bucket.draw(MyGdxGame.getBatch());
        //  bomb.draw(MyGdxGame.getBatch());

        fruitCircle.setPosition(positionXFruit, positionYFruit);
        bombCircle.setPosition(positionXBomb,positionYBomb);
        bucketRectangle.setPosition(positionXBucket, bucket.getBounds().getY());
    }
}
