import greenfoot.*;
import java.util.*;

public class SnakeWorld extends World {
    private LinkedList<SnakeBody> snake = new LinkedList<SnakeBody>();
    private int dx=1;
    private int dy=0;
    private int tailCounter = 5;
    private boolean dead = false;
    Score score = new Score();
    /**
     * Constructor for objects of class SnakeWorld.
     */
    public SnakeWorld() {
        super(40, 30, 20);
        SnakeBody body = new SnakeBody();
        snake.add(body);
        addObject(body, 19, 14);

        Apple apple = new Apple();
        addObject(apple, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);

        Banana banana = new Banana();
        addObject(banana, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);
        for (int x = 0; x < getWidth(); x++) {
            addObject(new Border(), x, 0);
            addObject(new Border(), x, getHeight() - 1);
        }
        for (int y = 0; y < getHeight(); y++) {
            addObject(new Border(), 0, y);
            addObject(new Border(), getWidth() - 1, y);
        }
        addObject(score, 2, 1);

        Trap trap = new Trap();
        addObject(trap, Greenfoot.getRandomNumber(getWidth() - 2) + 1,
            Greenfoot.getRandomNumber(getHeight() - 2) + 1);
    }

    public Score getScore(){
        return score;
    }

    public void act() {
        if(dead) return;
        changeDirection();
        SnakeBody head = snake.getLast();
        head.setImage("tail.png");
        SnakeBody newHead  = new SnakeBody();
        int newHeadX = head.getX() + dx;
        int newHeadY = head.getY() + dy;

        List<Block> blocks = getObjectsAt(newHeadX, newHeadY, Block.class);
        for(Block block : blocks) {
            block.collision(this);
        }

        addObject(newHead, newHeadX, newHeadY);
        snake.add(newHead);
        if(tailCounter ==0){
            SnakeBody tail = snake.removeFirst();
            removeObject(tail);
        } else {
            tailCounter--;
        }
        if(dead) {
            displayGameOver();
            return;
        }
    }

    private void changeDirection() {
        if(Greenfoot.isKeyDown("left") && dx ==0) {
            dx = -1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("right") && dx ==0) {
            dx = 1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("down") && dy ==0) {
            dx = 0;
            dy = 1;
        }
        if(Greenfoot.isKeyDown("up") && dy ==0) {
            dx = 0;
            dy = -1;
        }

    }

    public void dead() {
        dead = true;
    }

    public void grow(int size) {
        tailCounter+=size;
    }

    public void displayGameOver() {
        showText("Game Over", getWidth() / 2, getHeight() / 2);
        Greenfoot.stop(); // Memberhentikan permainan setelah menampilkan "Game Over"
    }

    public int getTailCounter() {
        return tailCounter;
    }
}

