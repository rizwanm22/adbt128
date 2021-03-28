package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;

import javax.imageio.IIOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.Container;
import java.sql.SQLOutput;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    private Warrior warrior;

    //second game world

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private WarriorController controller;

    private final JFrame frame;

    //adding sound
    private SoundClip gameMusic;

    /** Initialise a new Game. */
    public Game() {

        //initialize the level to level 1
        level = new Level1(this);

        // make the world
        //game music

        try {
            gameMusic = new SoundClip("data/warriormusic.wav");
            gameMusic.setVolume(1);
            gameMusic.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        // make a view
        view = new GameView(level, level.getWarrior(), 1280, 720);
        view.setZoom(25);
        view.setBack(level.paintBackground());

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new GiveFocus(view));
        controller = new WarriorController(level.getWarrior(), this);
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        //world.addStepListener(new Tracker(view, world.getStudent()));

        // add the view to a frame (Java top level window)
        frame = new JFrame("Basic world");

        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.WEST);

        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);

        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        frame.addKeyListener(new WarriorController(level.getWarrior(), this));

        // uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(level, 1280, 720);

        // start our game world simulation!
        level.start();
    }

    public Warrior getWarrior(){
        return level.getWarrior();
    }
    public GameView getView(){
        return view;
    }
    public GameLevel getLevel() {
        return level;
    }

    public void setLevel(GameLevel level){
        //stop current level
        this.level.stop();
        //create new level
        this.level = level;
        //view for new level
        view.setWorld(this.level);
        //zoom
        view.setZoom(25);
        //background
        view.setBack(this.level.paintBackground());
        //controller for next level
        controller.updateWarrior(this.level.getWarrior());
        //start new level
        this.level.start();
    }

    public void goToNextLevel(){

        if(level instanceof Level1){
            //stop current level
            level.stop();
            //create new level
            level = new Level2(this);
            //view for new level
            view.setWorld(level);
            //zoom
            view.setZoom(25);
            //background
            view.setBack(level.paintBackground());
            //controller for next level
            controller.updateWarrior(level.getWarrior());
            //start new level
            level.start();
        }
        else if(level instanceof Level2){
            level.stop();
            level = new Level3(this);
            view.setWorld(level);
            view.setZoom(25);
            view.setBack(level.paintBackground());
            controller.updateWarrior(level.getWarrior());

            level.start();
        }
        else if(level instanceof  Level3){
            JDialog diaScore = new JDialog(frame, true);
            HighScore highScore = new HighScore(level,this);
            diaScore.getContentPane().add(highScore.getPnlScores());
            diaScore.pack();
            diaScore.setVisible(true);

        }
    }

    public void pause(){

        level.stop();
    }

    public void start(){

        level.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }


}
