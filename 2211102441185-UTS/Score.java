import greenfoot.*;

public class Score extends Actor {
    private int score = 0;

    public Score() {
        // Set initial score and display it on the screen
        updateScore();
    }

    public void act() {
        // The act method can be used for any additional score-related behavior if needed
    }

    public void addScore(int points) {
        // Add points to the current score
        score += points;
        updateScore();
    }

    private void updateScore() {
        // Update the displayed score on the screen
        GreenfootImage image = new GreenfootImage("Score: " + score, 24, Color.WHITE, Color.BLACK);
        setImage(image);
    }
}