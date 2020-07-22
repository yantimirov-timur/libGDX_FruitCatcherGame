package game.model;

public class FruitMove {
    float speed = 5f;

    public void handle() {
        if (Logic.positionYFruit <= 0) {
            speed = 0f;
        } else {
            Logic.positionYFruit -= speed;
        }
    }
}
