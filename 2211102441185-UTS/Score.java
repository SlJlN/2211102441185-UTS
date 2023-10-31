import greenfoot.*;

public class Score extends Actor {
    private int score;

    public Score() {
        score = 0;
        updateImage();
    }

    public void act() {
        updateImage();
    }

    public void addScore(int points) {
        score += points;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage text = new GreenfootImage("Score: " + score, 24, Color.BLACK, Color.WHITE);
        setImage(text);
    }

    public int getScore() {
        return score;
    }
}