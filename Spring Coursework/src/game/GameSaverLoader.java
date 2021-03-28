package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    /**
     * Saves the game to a file
     * <p>
     * Saves the level that you are in, with the progress you made within that level
     *
     * @param  filename The file you save it to
     * @param  level Level that you are in
     * @return nothing
     */

    public static void save(GameLevel level, String filename)
            throws IOException
    {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, append);
            writer.write(level.getLevelName() + "," +
                    level.getWarrior().getHeartsCollected() + "," +
                    level.getWarrior().getLifeCount() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static GameLevel load(Game game, String fileName)
        throws IOException
    {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int heartsCollected = Integer.parseInt(tokens[1]);

            GameLevel level = null;
            if (name.equals("Level1"))
                level = new Level1(game);
            else if (name.equals("Level2"))
                level = new Level2(game);
            else if (name.equals("Level3"))
                level = new Level3(game);

            level.getWarrior().setHeartsCollected(heartsCollected);

            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
