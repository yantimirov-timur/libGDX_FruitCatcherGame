package game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;
import game.model.MyGdxGame;

public class BucketController {
    Polygon bucketBounds;

    public BucketController(Polygon bucketBounds) {
        this.bucketBounds = bucketBounds;
    }

    float speed = 5f;

    public void handle() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (MyGdxGame.positionXBucket != 540)
                MyGdxGame.positionXBucket += speed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (MyGdxGame.positionXBucket != 0)
                MyGdxGame.positionXBucket -= speed;
        }

        bucketBounds.setPosition(bucketBounds.getX() * speed, bucketBounds.getY() * speed);
    }

}
