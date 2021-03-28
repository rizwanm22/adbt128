/*package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.Color;

public class GameWorld extends World {


    private Heart heart;
    private Warrior warrior;

    public GameWorld(){

        // ground
        Shape shape = new BoxShape(55, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setFillColor(Color.red);
        ground.setPosition(new Vec2(0f, -15f));

        // ceiling
        Shape platform1Shape = new BoxShape(55, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0, 15f));

        // add another platform here
        //StaticBody platform2 = new StaticBody(this, platform1Shape);
        //platform2.setPosition(new Vec2(5, 2.5f));

        // left wall
        Shape wallShape = new BoxShape(0.5f, 25f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-26.2f, -6));

        // right wall
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(26.2f, -6));

        //obstacles
        Shape obstacleShape = new BoxShape(4.25f, 0.1f);
        StaticBody obstacle = new StaticBody(this, obstacleShape);
        obstacle.setFillColor(Color.black);
        obstacle.setPosition(new Vec2(-0.7f, 0.5f));

        Shape obstacleShape2 = new BoxShape(3.7f, 0.1f);
        StaticBody obstacle2 = new StaticBody(this, obstacleShape2);
        obstacle2.setFillColor(Color.black);
        obstacle2.setPosition(new Vec2(18.88f, -0.65f));

        Shape obstacleShape3 = new BoxShape(4.3f, 0.1f);
        StaticBody obstacle3 = new StaticBody(this, obstacleShape3);
        obstacle3.setFillColor(Color.black);
        obstacle3.setPosition(new Vec2(-16.27f, -3.9f));

        Shape obstacleShape4 = new BoxShape(12.8f, 0.1f);
        StaticBody obstacle4 = new StaticBody(this, obstacleShape4);
        obstacle4.setFillColor(Color.black);
        obstacle4.setPosition(new Vec2(-0.75f, -8.4f));





            for (int i = 0; i < 5; i++) {
                heart = new Heart(this);
                heart.setPosition(new Vec2(i * 2 - 10, 10));
            }

       // add more bodies here
       Villain villain = new Villain(this);
       villain.setPosition(new Vec2(0,-10));
//     villain.addCollisionListener(new Pickup(warrior));

       warrior = new Warrior(this);
       warrior.setPosition(new Vec2(8, -10));
       Pickup pickup = new Pickup(warrior);
       warrior.addCollisionListener(pickup);
       
    }

    public Warrior getWarrior(){
        return warrior;
    }
}*/
