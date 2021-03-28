package game;

import city.cs.engine.*;

public class Lava extends StaticBody {

    private static final Shape lavaShape = new PolygonShape(-12.13f,4.95f, 7.5f,4.95f, 12.09f,4.85f, 12.13f,-4.55f, -0.58f,-4.79f, -11.99f,-4.41f, -12.13f,4.12f);

    private static final BodyImage image =
            new BodyImage("data/lava.png", 10f);

    public Lava(World world) {
        super(world, lavaShape);
        addImage(image);
    }
}
