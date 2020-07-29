package game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class MainGame extends Game {
    private Screen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameView();

        setScreen(gameScreen);
    }
}
