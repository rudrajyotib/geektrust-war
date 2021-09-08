package geektrust.war.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileCommandProcessorTest {

    @Test
    public void shouldReportIfNotValidLocation() {
        FileCommandProcessor fileCommandProcessor = new FileCommandProcessor("someFileLocation");
        assertThrows(IllegalArgumentException.class, fileCommandProcessor::processFile);
    }

    @Test
    public void shouldReportIfNotFile()
    {
        Path commandFile = Paths.get("src", "test", "resources");
        FileCommandProcessor fileCommandProcessor = new FileCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertThrows(IllegalArgumentException.class, fileCommandProcessor::processFile);
    }

    @Test
    public void shouldReadFileAndReportBattle() throws IOException {
        Path commandFile = Paths.get("src", "test", "resources", "command-success");
        FileCommandProcessor fileCommandProcessor = new FileCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertEquals("WINS 52H 50E 10AT 3SG", fileCommandProcessor.processFile());
    }


}