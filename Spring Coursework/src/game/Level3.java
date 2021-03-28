package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level3 extends GameLevel implements ActionListener {

    public Level3(Game game) {

        super(game);

        //positions of warrior, villain and sword

        getLava2().destroy();

        getVillain().destroy();
        getVillainFlipped().destroy();

        getWarrior().setPosition(new Vec2(-20, -12f));
        getSword().setPosition(new Vec2(20, 10f));
        getLava().setPosition(new Vec2(0,-14));

        // ground
        Shape shape = new BoxShape(55, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setFillColor(Color.red);
        ground.setPosition(new Vec2(0f, -15f));

        // ceiling
        Shape platform1Shape = new BoxShape(55, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0, 15f));

        // left wall
        Shape wallShape = new BoxShape(0.5f, 25f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-26.2f, -6));

        // right wall
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(26.2f, -6));

        // ground 1
        Shape shape1 = new BoxShape(20,0.5f);
        StaticBody ground1 = new StaticBody(this, shape1);
        ground1.setFillColor(Color.yellow);
        ground1.setPosition(new Vec2(-10,-14.2f));

        // ground 2
        StaticBody ground2 = new StaticBody(this, shape1);
        ground2.setFillColor(Color.yellow);
        ground2.setPosition(new Vec2(10, -14.2f));

        // inner left wall
        Shape shape2 = new BoxShape(0.5f,2.5f);
        StaticBody innerleft = new StaticBody(this, shape2);
        innerleft.setFillColor(Color.yellow);
        innerleft.setPosition(new Vec2(-12.2f, -11.7f));

        // inner right wall
        StaticBody innerright = new StaticBody(this, shape2);
        innerright.setFillColor(Color.yellow);
        innerright.setPosition(new Vec2(12.2f,-11.7f));

        //obstacles
        Shape obstacleShape = new BoxShape(3.7f, 0.1f);
        StaticBody obstacle = new StaticBody(this, obstacleShape);
        obstacle.setFillColor(Color.yellow);
        obstacle.setPosition(new Vec2(-25f, -9f));

        Shape obstacleShape2 = new BoxShape(3.7f, 0.1f);
        StaticBody obstacle2 = new StaticBody(this, obstacleShape2);
        obstacle2.setFillColor(Color.yellow);
        obstacle2.setPosition(new Vec2(-12.5f, -2f));

        Shape obstacleShape3 = new BoxShape(3.7f, 0.1f);
        StaticBody obstacle3 = new StaticBody(this, obstacleShape3);
        obstacle3.setFillColor(Color.yellow);
        obstacle3.setPosition(new Vec2(-3.5f, 5f));

        Shape obstacleShape4 = new BoxShape(3.7f, 0.1f);
        StaticBody obstacle4 = new StaticBody(this, obstacleShape4);
        obstacle4.setFillColor(Color.yellow);
        obstacle4.setPosition(new Vec2(8.25f, -2f));

        Shape obstacleShape5 = new BoxShape(3.7f, 0.1f);
        StaticBody obstacle5 = new StaticBody(this,obstacleShape5);
        obstacle5.setFillColor(Color.yellow);
        obstacle5.setPosition(new Vec2(25f,-9f));

        //platform for sword
        //sword floor
        Shape swordplatform = new BoxShape(3.7f, 0.1f);

        //sword ceiling
        Shape swordplatform2 = new BoxShape(3.7f, 0.1f);
        StaticBody swordroof = new StaticBody(this, swordplatform);
        swordroof.setFillColor(Color.yellow);
        swordroof.setPosition(new Vec2(20f, 12f));

        //sword wall left
        StaticBody swordleft = new StaticBody(this, shape2);
        swordleft.setFillColor(Color.yellow);
        swordleft.setPosition(new Vec2(17f, 10f));

        //sword wall right
        StaticBody swordright = new StaticBody(this, shape2);
        swordright.setFillColor(Color.yellow);
        swordright.setPosition(new Vec2(23,10f));

        //heart pickup
        getWarrior().addCollisionListener(new HeartsPickup(getWarrior(),getVillain(),this, ground, getVillainFlipped(),getSword()));

        //hearts around level 3
        Heart heart = new Heart(this);
        heart.setPosition(new Vec2(-23f, -8.75f));

        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(-12f,-1.75f));

        Heart heart3 = new Heart(this);
        heart3.setPosition(new Vec2(-3f,5.25f));

        Heart heart4 = new Heart(this);
        heart4.setPosition(new Vec2(23.5f,-8.75f));

        Timer t = new Timer(7500,this);
        t.start();

    }

    @Override
    public boolean isComplete() {
        if (getWarrior().getHeartsCollected() >= 12)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/background3.jpg").getImage();
        return background;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Villain v = new Villain(this);
        v.setPosition(new Vec2(-11.25f, -1.75f));
        v.startWalking(5.5f);
        v.setGravityScale(10);

        VillainFlipped c = new VillainFlipped(this);
        c.setPosition(new Vec2(9.25f,-1.75f));
        c.startWalking(-5.5f);
        c.setGravityScale(10);

    }
}
