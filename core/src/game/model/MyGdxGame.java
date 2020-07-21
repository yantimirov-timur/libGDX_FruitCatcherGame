package game.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import static game.model.Bucket.bucketRectangle;
import static game.model.Fruit.fruitCircle;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite backgroundSprite;
    Sprite fruitSprite;

    Texture imgFruit;
    Texture imgPlatform;
    Texture imgBucket;
    Texture background;

    Fruit fruit;
    Platform platform;
    Bucket bucket;

    GlyphLayout glyphLayout = new GlyphLayout();

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgFruit = new Texture("fruit.png");
        imgPlatform = new Texture("platform.png");
        imgBucket = new Texture("backet.png");

        background = new Texture("back.jpg");
        backgroundSprite = new Sprite(background);

        backgroundSprite.setPosition(0, 0f);
        backgroundSprite.setSize(700, 500);

        Vector2 center = new Vector2();

        center.x = fruitCircle.x + 50;
        center.y = fruitCircle.y + 50;

        fruitCircle = new Circle(center, 50);
    }

    public static float positionY = 400f;

    public static float positionXBucket = 0f;
    public static float positionXFruit = 0F;

    BitmapFont font;

    int score = 0;

    int randomPlace(){
        return new Random().nextInt(450);
    }

    @Override
    public void render() {
        fruit = new Fruit(imgFruit, positionXFruit, positionY, 50, 50);

        platform = new Platform(imgPlatform, -20, -20, 700, 50);

        bucket = new Bucket(imgBucket, positionXBucket, 15, 100, 100);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        fruitCircle.setPosition(positionXFruit, positionY);
        bucketRectangle.setPosition(positionXBucket, bucket.getBounds().getY());

        font = new BitmapFont();
        if (Intersector.overlaps(fruitCircle, bucketRectangle)) {
            score += 50;
            positionY = 450;
            positionXFruit =  randomPlace();
        } else if (positionY <= 0) {
            positionY = 450;
            positionXFruit = randomPlace();
        }

        glyphLayout.setText(font,"score " + score);

       // positionXFruit = new Random().nextInt(450);

        batch.begin();

        backgroundSprite.draw(batch);
        fruit.draw(batch);
        platform.draw(batch);
        bucket.draw(batch);
        font.draw(batch, glyphLayout, 550, 450);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgFruit.dispose();
        imgPlatform.dispose();
        imgBucket.dispose();
        font.dispose();
    }
}
