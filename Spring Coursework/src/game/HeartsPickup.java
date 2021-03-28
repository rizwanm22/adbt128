package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class HeartsPickup implements CollisionListener {

    /**
     * Collisions with the heart and with the villain
     * <p>
     * This allows the warrior to collect the hearts and the warrior to lose lives when touching the villain
     *
     * @param  ground The ground will disappear and the sword will unleash at one point in the game
     * @return nothing
     */


    private Warrior warrior;
    private Villain villain;
    private GameLevel level;
    private StaticBody ground;
    private VillainFlipped villainFlipped;
    private Sword sword;

    public HeartsPickup(Warrior warrior, Villain villain, GameLevel level,StaticBody ground ,VillainFlipped villainFlipped, Sword sword){
        this.warrior = warrior;
        this.villain = villain;
        this.level = level;
        this.ground = ground;
        this.villainFlipped = villainFlipped;
        this.sword = sword;
    }

    //warrior touching heart gains a life and destroys heart object
    //warrior touching villain gets a life reduced
    @Override
    public void collide(CollisionEvent e) {
        //System.out.println("collision!");
        if (e.getOtherBody() instanceof Heart) {
            warrior.incrementHeartsCollected();
            e.getOtherBody().destroy();

            if(Warrior.heartsCollected == 8){
                ground.destroy();
                sword.setPosition(new Vec2(0, -4));
                villain = new Villain(level);
                villain.setPosition(new Vec2(-8, -13.1f));
                villainFlipped = new VillainFlipped(level);
                villainFlipped.setPosition(new Vec2(8,-13.1f));
            }
        }

        else if (e.getReportingBody() == warrior && e.getOtherBody() instanceof Villain) {
            warrior.decrementLifeCount();
            e.getOtherBody().destroy();
        }

        else if (e.getReportingBody() == warrior && e.getOtherBody() instanceof VillainFlipped) {
            warrior.decrementLifeCount();
            e.getOtherBody().destroy();
        }
    }
}