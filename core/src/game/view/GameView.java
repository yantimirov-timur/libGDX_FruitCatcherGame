package game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.model.Logic;

import java.util.Objects;

import static game.model.Logic.getScore;


public class GameView implements Screen {
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

    private BitmapFont scoreFont;

    private final Logic logic = new Logic();
    private final GlyphLayout glyphLayout = new GlyphLayout();

    @Override
    public void show() {
        batch = new SpriteBatch();
        imgFruit = new Texture("fruit.png");
        imgPlatform = new Texture("platform.png");
        imgBucket = new Texture("bucket.png");
        imgBomb = new Texture("bomb.png");

        Texture background = new Texture("back.jpg");
        backgroundSprite = new Sprite(background);

        backgroundSprite.setPosition(0, 0f);
        backgroundSprite.setSize(700, 500);

        logic.create();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        scoreFont = new BitmapFont();
        glyphLayout.setText(scoreFont, "score " + getScore());

        batch.begin();

        backgroundSprite.draw(batch);
        logic.render();
        scoreFont.draw(batch, glyphLayout, 550, 450);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgFruit.dispose();
        imgPlatform.dispose();
        imgBucket.dispose();
        scoreFont.dispose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameView gameView = (GameView) o;
        return Objects.equals(backgroundSprite, gameView.backgroundSprite) &&
                Objects.equals(scoreFont, gameView.scoreFont) &&
                Objects.equals(logic, gameView.logic) &&
                Objects.equals(glyphLayout, gameView.glyphLayout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backgroundSprite, scoreFont, logic, glyphLayout);
    }

    @Override
    public String toString() {
        return "GameView{" +
                "backgroundSprite=" + backgroundSprite +
                ", scoreFont=" + scoreFont +
                ", logic=" + logic +
                ", glyphLayout=" + glyphLayout +
                '}';
    }
}
