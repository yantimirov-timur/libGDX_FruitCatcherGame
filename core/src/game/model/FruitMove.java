package game.model;

public class FruitMove {
    float speed = 5f;

    public void handle() {
        if (Logic.positionY <= 0) {
            speed = 0f;
        } else {
            Logic.positionY -= speed;
        }
    }
}
