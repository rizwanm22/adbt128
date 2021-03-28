package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    /**
     * View of the game throughout
     * <p>
     * Sets the background, foreground and the width/height of the game window
     *
     * @param  world The world the gameview is in
     * @return nothing
     */

    private Image background;
    private Image background2;

    public Image back;
    Warrior warrior;



    public GameView(World w, Warrior warrior, int width, int height) {
        super(w, width, height);
        this.warrior = warrior;
        //background = new ImageIcon("data/background.png").getImage();
        //background2 = new ImageIcon("data/background2.png").getImage();
    }

    public void setBack(Image background){
        this.back = background;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(back, 0, 0, 1280, 720, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Lives:" + warrior.getLifeCount(), 25, 20);
        g.drawString("Hearts Collected:" + warrior.getHeartsCollected(), 300, 20);
    }
}
