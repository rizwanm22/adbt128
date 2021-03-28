package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Walker;
import org.jbox2d.common.Vec2;

//collision encounters for walker and lava

public class LavaEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;
    private Warrior warrior;
    private Villain villain;
    private VillainFlipped villainFlipped;

    public LavaEncounter(GameLevel level, Game game, Warrior warrior, Villain villain, VillainFlipped villainFlipped){
        this.level = level;
        this.game = game;
        this.warrior = warrior;
        this.villain = villain;
        this.villainFlipped = villainFlipped;
    }

    @Override
    public void collide(CollisionEvent e){
        //if warrior touches lava, the game ends
        if (e.getOtherBody() instanceof Warrior && e.getReportingBody() instanceof Lava){
            System.exit(0);
        }

        //if the villain touches the lava then a new villain respawns
        if(e.getOtherBody() instanceof Villain) {
                e.getOtherBody().destroy();

                //villain = new Villain(level);
                //villain.setPosition(new Vec2(-10, -1.75f));
        }
        
        if(e.getOtherBody() instanceof VillainFlipped){
            e.getOtherBody().destroy();

            //villainFlipped = new VillainFlipped(level);
            //villainFlipped.setPosition(new Vec2(7.25f,-1.75f));
        }
    }
}
