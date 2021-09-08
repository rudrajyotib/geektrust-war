package geektrust.war.api;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    public void shouldParseCommand()
    {
        Map<String, Integer> opponent = CommandParser.parseOpponent("FALICORNIA_ATTACK 100H 101E 20AT 5SG");
        assertEquals(4, opponent.size());
        assertEquals(Integer.valueOf(100), opponent.get("H"));
        assertEquals(Integer.valueOf(101), opponent.get("E"));
        assertEquals(Integer.valueOf(20), opponent.get("AT"));
        assertEquals(Integer.valueOf(5), opponent.get("SG"));
    }

}