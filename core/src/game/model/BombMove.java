package game.model;

public class BombMove {
    float speed = 4f;

    public void handle() {
        if (Logic.positionYBomb <= 0) {
            speed = 0f;
        } else {
            Logic.positionYBomb -= speed;
        }
    }
}
