package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level2 extends GameLevel implements ActionListener {

    //private Villain villain;

    public Level2(Game game){

        super(game);

        getVillain().destroy();
        getVillainFlipped().destroy();

        getSword().setPosition(new Vec2(0, -14.5f));
        getLava().setPosition(new Vec2(-25f,-15.5f));
        getLava2().setPosition(new Vec2(25f, -15.9f));

        // left wall
        Shape wallShape = new BoxShape(0.5f, 5f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setFillColor(Color.white);
        wall1.setPosition(new Vec2(-12.5f, -16f));

        // right wall
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setFillColor(Color.white);
        wall2.setPosition(new Vec2(12.5f, -16f));

        // ground
        Shape shape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setFillColor(Color.white);
        ground.setPosition(new Vec2(-3f, -11.5f));

        // other ground
        Shape shape2 = new BoxShape(15, 0.5f);
        StaticBody ground1 = new StaticBody(this, shape);
        ground1.setFillColor(Color.white);
        ground1.setPosition(new Vec2(-3f, -15f));

        //ceiling
        Shape platform1Shape = new BoxShape(55, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0, 15f));

        // big left wall
        Shape wallLeftShape = new BoxShape(0.5f, 25f);
        StaticBody wall3 = new StaticBody(this, wallLeftShape);
        wall3.setPosition(new Vec2(-26.2f, -6));

        // big right wall
        StaticBody wall4 = new StaticBody(this, wallLeftShape);
        wall4.setPosition(new Vec2(26.2f, -6));

        //obstacles
        Shape obstacleShape = new BoxShape(3.25f, 0.085f);
        StaticBody obstacle = new StaticBody(this, obstacleShape);
        obstacle.setFillColor(Color.white);
        obstacle.setPosition(new Vec2(-16f, -8f));

        Shape obstacleShape2 = new BoxShape(4.25f, 0.085f);
        StaticBody obstacle2 = new StaticBody(this, obstacleShape);
        obstacle2.setFillColor(Color.white);
        obstacle2.setPosition(new Vec2(18f, -4f));

        Shape obstacleShape3 = new BoxShape(2.3f, 0.1f);
        StaticBody obstacle3 = new StaticBody(this, obstacleShape3);
        obstacle3.setFillColor(Color.white);
        obstacle3.setPosition(new Vec2(2.27f, 3.5f));

        //heart pickup
        getWarrior().addCollisionListener(new HeartsPickup(getWarrior(), getVillain(), this, ground, getVillainFlipped(), getSword()));

        //hearts around level 2
        Heart heart = new Heart(this);
        heart.setPosition(new Vec2(18, 1.1f));

        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(-16,0.1f));

        Heart heart3 = new Heart(this);
        heart3.setPosition(new Vec2(0.27f,4f));

        Timer t = new Timer(7500, this);
        t.start();
    }

    @Override
    public boolean isComplete() {
        if (getWarrior().getHeartsCollected() >= 8)
            return true;
        else
            return false;
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/background2.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Villain v = new Villain(this);
        v.setPosition(new Vec2(-10, -11f));
        v.startWalking(5.5f);
        v.setGravityScale(10);

        VillainFlipped c = new VillainFlipped(this);
        c.setPosition(new Vec2(-17,-11f));
        c.startWalking(-5.5f);
        c.setGravityScale(10);
    }
}
