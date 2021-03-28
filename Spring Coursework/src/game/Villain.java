package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class Villain extends Walker {

    private static final Shape villainShape = new PolygonShape(
            -1.98f,1.46f, -1.44f,-1.73f, -0.04f,-1.84f, 1.79f,-0.47f, 0.84f,1.23f, -0.52f,1.86f, -1.82f,1.68f);

    private static final BodyImage image =
            new BodyImage("data/villain.png", 4f);

    private static SoundClip villainSound;
    static {
        try {
            villainSound = new SoundClip("data/villainsound.wav");
            villainSound.setVolume(0.25);
            System.out.println("Loading heart collected sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Villain(World world) {
        super(world, villainShape);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        villainSound.play();
        super.destroy();
    }
}
