package game.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import game.view.GameView;

import java.util.Objects;
import java.util.Random;

import static game.model.CurrentGameObject.bucketRectangle;
import static game.model.CurrentGameObject.bombCircle;
import static game.model.CurrentGameObject.fruitCircle;

public class Logic extends ApplicationAdapter {
    //действующие игровые обьекты
    CurrentGameObject bomb;
  //  CurrentGameObject bomb1;
    CurrentGameObject fruit;
    CurrentGameObject platform;
    CurrentGameObject bucket;

    //счет
    private static int score = 0;

    public static int getScore() {
        return score;
    }

    //позиции обьектов в двумерном пространстве
    public static float positionYFruit = 400f;
    public static float positionYBomb = 400f;
    public static float positionXBucket = 0f;
    public static float positionXFruit = 0F;
    public static float positionXBomb = 400f;

    int randomPlace() {
        return new Random().nextInt(450);
    }

    /**
     * Определение обьектов
     */
    @Override
    public void create() {
        Vector2 centerFruit = new Vector2();
        centerFruit.x = fruitCircle.x + 50;
        centerFruit.y = fruitCircle.y + 50;

        Vector2 centerBomb = new Vector2();
        centerBomb.x = bombCircle.x + 50;
        centerBomb.y = bombCircle.y + 50;

        fruitCircle = new Circle(centerFruit, 50);
        bombCircle = new Circle(centerBomb, 50);
    }

    /**
     * Действие которое происходит каждую секунду
     */
    @Override
    public void render() {
        platform = new CurrentGameObject(GameView.getImgPlatform(), -20, -20, 700, 50);
        bucket = new CurrentGameObject(GameView.getImgBucket(), positionXBucket, 15, 100, 100);

        bomb = new CurrentGameObject(GameView.getImgBomb(), positionXBomb, positionYBomb, 50, 50);
        fruit = new CurrentGameObject(GameView.getImgFruit(), positionXFruit, positionYFruit, 50, 50);

        //прибавление очков за пойманное яблоко
        if (Intersector.overlaps(fruitCircle, bucketRectangle)) {
            score += 50;
            positionYFruit = 450;
            positionXFruit = randomPlace();
        }
        //убавление очков за пойманную бомбу
        else if (Intersector.overlaps(bombCircle, bucketRectangle)) {
            score -= 70;
            positionYBomb = 450;
            positionXBomb = randomPlace();
        }
        //появление бомбы и фрукта в рандомном месте при приземлении на землю
        else if (positionYFruit <= 0) {
            positionYFruit = 450;
            positionXFruit = randomPlace();
        } else if (positionYBomb <= 0) {
            positionYBomb = 450;
            positionXBomb = randomPlace();
        } else if (score >= 1000) {
          //  positionYBomb1 = 450;
            //positionXBomb1 = 100;
        }

        //отрисовка
        bomb.draw(GameView.getBatch());
        fruit.draw(GameView.getBatch());
        platform.draw(GameView.getBatch());
        bucket.draw(GameView.getBatch());

        //изменение позиции
        fruitCircle.setPosition(positionXFruit, positionYFruit);
        bombCircle.setPosition(positionXBomb, positionYBomb);

        bucketRectangle.setPosition(positionXBucket, bucket.getBounds().getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logic logic = (Logic) o;
        return Objects.equals(bomb, logic.bomb) &&
                Objects.equals(fruit, logic.fruit) &&
                Objects.equals(platform, logic.platform) &&
                Objects.equals(bucket, logic.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bomb, fruit, platform, bucket);
    }

    @Override
    public String toString() {
        return "Logic{" +
                "bomb=" + bomb +
                ", fruit=" + fruit +
                ", platform=" + platform +
                ", bucket=" + bucket +
                '}';
    }
}
