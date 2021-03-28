package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level1 extends GameLevel implements ActionListener {

    public Level1(Game game) {

        super(game);

        //positions of warrior, villain and sword
        getVillain().destroy();
        getVillainFlipped().destroy();

        getWarrior().setPosition(new Vec2(8, -6.1f));
        getSword().setPosition(new Vec2(-20, 7.5f));
        getLava().setPosition(new Vec2(-25.5f,-15));
        getLava2().setPosition(new Vec2(24.1f, -15));

        //end game if lava touched

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

        //platform for sword
        Shape swordplatform = new BoxShape(4.25f, 0.1f);
        StaticBody swordplat = new StaticBody(this, swordplatform);
        swordplat.setFillColor(Color.orange);
        swordplat.setPosition(new Vec2(-20.7f, 6f));

        //heart pickup
        getWarrior().addCollisionListener(new HeartsPickup(getWarrior(),getVillain(),this, ground, getVillainFlipped(), getSword()));

        //hearts around level 1
        Heart heart = new Heart(this);
        heart.setPosition(new Vec2(18, 1.1f));

        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(2,2));

        Heart heart3 = new Heart(this);
        heart3.setPosition(new Vec2(-3,2));

        Heart heart4 = new Heart(this);
        heart4.setPosition(new Vec2(-14,-1.7f));

        Heart heart5 = new Heart(this);
        heart5.setPosition(new Vec2(-19,-1.7f));

        Timer t = new Timer(7500, this);
        t.start();

    }

    @Override
    public boolean isComplete() {
        if (getWarrior().getHeartsCollected() >= 5)
            return true;
        else
            return false;
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/background.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Villain v = new Villain(this);
        v.setPosition(new Vec2(-8,-6.1f));
        v.startWalking(5.5f);
        v.setGravityScale(10);
    }
}

