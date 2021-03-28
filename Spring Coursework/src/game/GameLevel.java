package game;

import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.awt.*;

public abstract class GameLevel extends World {
    private Warrior warrior;
    private Villain villain;
    private VillainFlipped villainFlipped;
    private Sword sword;
    private Lava lava;
    private Lava lava2;

    public GameLevel(Game game){
        //all levels have a warrior and many villains
        //the warrior needs to collect hearts to get through to the next level
        //the warrior can fail if he gets touched by the villain and lose lives
        //if the warrior falls off the map the game ends instantly
        warrior = new Warrior(this);

        villain = new Villain(this);
        villainFlipped = new VillainFlipped(this);
        sword = new Sword(this);
        lava = new Lava(this);
        lava2 = new Lava(this);

        SwordEncounter encounter = new SwordEncounter(this, game, warrior);
        LavaEncounter encounter2 = new LavaEncounter(this, game, warrior, villain, villainFlipped);
        sword.addCollisionListener(encounter);

        lava.addCollisionListener(encounter2);
        lava2.addCollisionListener(encounter2);
    }

    public Warrior getWarrior(){
        return warrior;
    }

    public Villain getVillain(){
        return villain;
    }

    public VillainFlipped getVillainFlipped(){
        return villainFlipped;
    }

    public Sword getSword(){
        return sword;
    }

    public Lava getLava(){
        return lava;
    }

    public Lava getLava2(){
        return lava2;
    }

    public abstract boolean isComplete();

    public abstract Image paintBackground();

    public abstract String getLevelName();

}