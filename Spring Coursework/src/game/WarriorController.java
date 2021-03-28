package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class WarriorController implements KeyListener {

    private static final float WALKING_SPEED = 4f;

    private Game game;

    private Warrior warrior;

    public WarriorController(Warrior warrior, Game game){
        this.warrior = warrior;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            warrior.startWalking(-WALKING_SPEED);
            warrior.WarriorLeft();
        } else if (code == KeyEvent.VK_D) {
            warrior.startWalking(WALKING_SPEED);
            warrior.WarriorRight();
        }
        else if (code == KeyEvent.VK_K){
            System.out.println("saved");
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            System.out.println("load");
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            warrior.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            warrior.stopWalking();
        }
        else if (code == KeyEvent.VK_W) {
            warrior.jump(20);
            warrior.setGravityScale(1.45f);
        }
    }

    public void updateWarrior(Warrior warrior){
        this.warrior = warrior;
    }
}
