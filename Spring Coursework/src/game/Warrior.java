package game;

import city.cs.engine.*;

public class Warrior extends Walker {

    private static final Shape warriorShape = new PolygonShape(
            -1.8f,1.47f, -1.31f,-1.78f, -0.14f,-1.87f, 1.4f,0.14f, 0.73f,1.35f, -0.22f,1.88f, -1.48f,1.78f);

    private static final BodyImage imageRight =
            new BodyImage("data/warrior.png", 4f);

    private static final BodyImage imageLeft =
            new BodyImage("data/warriorFlipped.png", 4f);

    public int lifeCount;
    public static int heartsCollected;

    public Warrior(World world) {
        super(world, warriorShape);
        addImage(imageRight);

        lifeCount = 5;

    }

    //increment the life gained after heart picked up
    public void incrementHeartsCollected(){
        heartsCollected++;
        System.out.println("You collected a heart!: " +
                "Hearts Collected = " + heartsCollected);
    }

    public static int getHeartsCollected(){
        return heartsCollected;
    }

    //decrement life count if villain touched
    public void decrementLifeCount(){
        lifeCount = lifeCount - 1;
        System.out.println("You lost a life!: " +
                "lifeCount = " + lifeCount);

        if (lifeCount == 0){
            System.exit(0);
        }
    }
    public int getLifeCount(){
        return lifeCount;
    }

    //warrior facing left
    public void WarriorLeft(){
        removeAllImages();
        addImage(imageLeft);
    }

    //warrior facing right
    public void WarriorRight(){
        removeAllImages();
        addImage(imageRight);
    }

    public void setHeartsCollected(int hc){
        heartsCollected = hc;
    }
}