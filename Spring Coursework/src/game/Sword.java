package game;

import city.cs.engine.*;

public class Sword extends StaticBody {

    private static final Shape swordShape = new PolygonShape(0.87f,1.37f, -0.88f,-0.23f, -1.45f,-1.07f, -0.88f,-1.52f, -0.07f,-0.84f, 1.36f,0.99f, 1.42f,1.53f);

    private static final BodyImage image =
            new BodyImage("data/sword.png", 3.1f);

    public Sword(World world) {
        super(world, swordShape);
        addImage(image);
    }
}
