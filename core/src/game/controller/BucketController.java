package game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;

import game.model.Logic;

public class BucketController {
    private final Polygon bucketBounds;

    public BucketController(Polygon bucketBounds) {
        this.bucketBounds = bucketBounds;
    }

    float speed = 5f;

    public void handle() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (Logic.positionXBucket != 540)
                Logic.positionXBucket += speed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (Logic.positionXBucket != 0)
                Logic.positionXBucket -= speed;
        }

        bucketBounds.setPosition(bucketBounds.getX() * speed, bucketBounds.getY() * speed);
    }

}
