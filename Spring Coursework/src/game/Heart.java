package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Heart extends Walker {

    /**
     * An object the warrior collects
     * <p>
     * This is the item that the warrior will be collecting
     *
     * @param  heartSound The sound made when the warrior collects the heart
     * @return nothing
     */

    private static final Shape heartShape = new CircleShape(1);

    private static SoundClip heartSound;
    static {
        try {
            heartSound = new SoundClip("data/heartpickup.wav");
            heartSound.setVolume(0.25);
            System.out.println("Loading heart collected sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/heart.gif", 1.5f);

    public Heart(World w) {
        super(w, heartShape);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        heartSound.play();
        super.destroy();
    }
}
