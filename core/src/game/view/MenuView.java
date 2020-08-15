package game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.model.Logic;

import java.util.Objects;

public class MenuView implements Screen {
    private final MainGame mainGame;
    private final OrthographicCamera camera;
    Texture backgroundMenu;
    SpriteBatch backgroundBatch;

    public MenuView(MainGame mainGame) {
        this.mainGame = mainGame;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 700, 600);
    }

    @Override
    public void show() {
        backgroundMenu = new Texture("background.jpg");
        backgroundBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        camera.update();

        mainGame.batch.setProjectionMatrix(camera.combined);
        mainGame.batch.begin();

        mainGame.batch.draw(backgroundMenu, 0, 0, 700, 800);

        mainGame.batch.end();

        if (Gdx.input.isTouched()) {
            mainGame.setScreen(new GameView());
            dispose();
        }
      //  else if (Logic.getScore()<0){
        //    mainGame.setScreen();
       // }
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

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuView menuView = (MenuView) o;
        return Objects.equals(mainGame, menuView.mainGame) &&
                Objects.equals(camera, menuView.camera) &&
                Objects.equals(backgroundMenu, menuView.backgroundMenu) &&
                Objects.equals(backgroundBatch, menuView.backgroundBatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainGame, camera, backgroundMenu, backgroundBatch);
    }

    @Override
    public String toString() {
        return "MenuView{" +
                "mainGame=" + mainGame +
                ", camera=" + camera +
                ", backgroundMenu=" + backgroundMenu +
                ", backgroundBatch=" + backgroundBatch +
                '}';
    }
}
