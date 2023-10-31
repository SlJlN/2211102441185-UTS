import greenfoot.*; 

public class Trap extends Actor {
    public void act() {
        SnakeWorld world = (SnakeWorld) getWorld();
        if (isTouching(SnakeBody.class)) {
            int currentTailSize = world.getTailCounter(); // Use the getter method
            if (currentTailSize > 0) {
                world.grow(-1);
            } else {
                world.dead();
            }
            getWorld().removeObject(this);
        }
    }
}