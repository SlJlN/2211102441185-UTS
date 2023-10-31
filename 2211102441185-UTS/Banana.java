import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Apple
{
    public Banana()
    {
        this.reward = 2;
    }

    public void collision(SnakeWorld world) {
        Greenfoot.playSound("slurp.mp3");
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth() - 2) + 1,
            Greenfoot.getRandomNumber(getWorld().getHeight() - 2) + 1);
        world.grow(2);

        // Menambahkan poin ke skor ketika memakan banana
        world.getScore().addScore(reward);
    }
}