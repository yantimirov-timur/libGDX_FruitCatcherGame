package game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Objects;

public class MainGame extends Game {
    SpriteBatch batch;
    BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        font.getData().setLineHeight(2f);

        this.setScreen(new MenuView(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainGame mainGame = (MainGame) o;
        return Objects.equals(batch, mainGame.batch) &&
                Objects.equals(font, mainGame.font);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batch, font);
    }

    @Override
    public String toString() {
        return "MainGame{" +
                "batch=" + batch +
                ", font=" + font +
                '}';
    }
}
