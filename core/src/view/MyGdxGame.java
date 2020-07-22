package view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import game.model.Logic;

import static game.model.Fruit.fruitCircle;
import static game.model.Logic.score;

public class MyGdxGame extends ApplicationAdapter {
    private static SpriteBatch batch;
    private Sprite backgroundSprite;

    private static Texture imgFruit;
    private static Texture imgPlatform;
    private static Texture imgBucket;
    private static Texture imgBomb;

    public static Texture getImgFruit() {
        return imgFruit;
    }
    public static Texture getImgBucket() {
        return imgBucket;
    }
    public static Texture getImgPlatform() {
        return imgPlatform;
    }
    public static SpriteBatch getBatch() {
        return batch;
    }
    public static Texture getImgBomb() {
        return imgBomb;
    }

    private BitmapFont font;

    private final Logic logic = new Logic();
    private final GlyphLayout glyphLayout = new GlyphLayout();

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgFruit = new Texture("fruit.png");
        imgPlatform = new Texture("platform.png");
        imgBucket = new Texture("backet.png");
        imgBomb = new Texture("bomb.png");

        Texture background = new Texture("back.jpg");
        backgroundSprite = new Sprite(background);

        backgroundSprite.setPosition(0, 0f);
        backgroundSprite.setSize(700, 500);

       logic.create();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        font = new BitmapFont();
        glyphLayout.setText(font, "score " + score);

        batch.begin();

        backgroundSprite.draw(batch);
        logic.render();
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
