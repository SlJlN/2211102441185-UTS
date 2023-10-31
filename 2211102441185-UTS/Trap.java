import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends Actor
{
    /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 1) {
            int randomX = Greenfoot.getRandomNumber(getWorld().getWidth());
            int randomY = Greenfoot.getRandomNumber(getWorld().getHeight());
            setLocation(randomX, randomY);
        }
    }
}
