package geektrust.war.batallion;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommanderTest {


    @Test
    public void shouldFightAndReportWinWithHelpFromLeftSideOnly()
    {
        Commander commander = new Commander();
        assertEquals("WINS 52H 50E 10AT 3SG",
                commander.fight(new HashMap<>()
                {
                    {
                        put("H", 100);
                        put("E", 101);
                        put("AT", 20);
                        put("SG", 5);
                    }
                }));
    }

    @Test
    public void shouldReportLoseAfterTakingHelpFromLeftAndRight()
    {
        Commander commander = new Commander();
        assertEquals("LOSES 100H 50E 10AT 5SG",
                commander.fight(new HashMap<>()
                {
                    {
                        put("H", 210);
                        put("E", 80);
                        put("AT", 30);
                        put("SG", 9);
                    }
                }));
    }

}