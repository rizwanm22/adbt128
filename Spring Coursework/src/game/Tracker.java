package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Warrior warrior;
    public Tracker(GameView view, Warrior warrior) {
        this.view = view;
        this.warrior = warrior;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(warrior.getPosition()));
    }
}