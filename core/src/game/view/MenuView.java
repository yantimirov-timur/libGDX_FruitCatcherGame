package game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuView implements Screen {
    private MainGame mainGame;
   private OrthographicCamera camera;

    public MenuView(MainGame mainGame){
        this.mainGame = mainGame;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,700,600);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        mainGame.batch.setProjectionMatrix(camera.combined);
        mainGame.batch.begin();

        mainGame.font.draw(mainGame.batch, "Catch fruit!",350,350);

        mainGame.batch.end();

        if (Gdx.input.isTouched()){
            mainGame.setScreen(new GameView());
            dispose();
        }

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


}
