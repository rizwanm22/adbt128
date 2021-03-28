package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SwordEncounter implements CollisionListener {

    /**
     * Collision between the warrior and the sword
     * <p>
     * When the warrior touches the sword, this collision allows the warrior to progress to the next level
     *
     * @param  warrior the Main character of the game
     * @return nothing
     */

    private GameLevel level;
    private Game game;
    private Warrior warrior;

    public SwordEncounter(GameLevel level, Game game, Warrior warrior) {
        this.level = level;
        this.game = game;
        this.warrior = warrior;
    }

    @Override
    public void collide(CollisionEvent e) {
        //if warrior collects all hearts
        //and touches exit then the warrior
        //goes to the next level
        if (e.getOtherBody() instanceof Warrior
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}





