package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class VillainFlipped extends Walker{

    private static final Shape villainFlippedShape = new PolygonShape(-2.29f,-0.11f, -0.96f,1.76f, 2.16f,1.71f, 1.46f,-1.82f, -0.61f,-1.89f, -1.83f,-0.91f, -2.25f,-0.34f);

    private static final BodyImage image =
            new BodyImage("data/villainFlipped.png", 4f);

    private static SoundClip villainFlippedSound;
    static {
        try {
            villainFlippedSound = new SoundClip("data/villainsound.wav");
            villainFlippedSound.setVolume(0.25);
            System.out.println("Loading heart collected sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public VillainFlipped(World world){
        super(world, villainFlippedShape);
        addImage(image);
        startWalking(-5.5f);
        setGravityScale(10);
    }

    @Override
    public void destroy()
    {
        villainFlippedSound.play();
        super.destroy();
    }
}
