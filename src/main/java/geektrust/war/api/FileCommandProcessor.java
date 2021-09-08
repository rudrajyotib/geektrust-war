package geektrust.war.api;

import geektrust.war.batallion.Commander;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCommandProcessor {

    private final String filePath;

    public FileCommandProcessor(String filePath) {
        this.filePath = filePath;
    }

    public String processFile() throws IOException {
        File commandFile = new File(filePath);
        if(!commandFile.exists())
        {
            throw new IllegalArgumentException("File does not exist");
        }
        if (!commandFile.isFile())
        {
            throw new IllegalArgumentException("Not a file");
        }
        String command = Files.readAllLines(Paths.get(this.filePath)).get(0);

        Commander commander = new Commander();
        return commander.fight(CommandParser.parseOpponent(command));

    }
}
