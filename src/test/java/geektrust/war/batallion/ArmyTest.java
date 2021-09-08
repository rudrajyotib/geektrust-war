package geektrust.war.batallion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {


    @Test
    public void shouldFightEqualNumbers()
    {
        Army army = new Army(30, "H");
        assertEquals(0, army.fight(30));
    }

    @Test
    public void shouldReportDeficitWhenOpponentIsLargerSize()
    {
        Army army = new Army(30, "H");
        assertEquals(1, army.fight(61));
    }

    @Test
    public void shouldFightAndCompensateArmyWithHalfStrength()
    {
        Army army = new Army(15, "H");
        assertEquals(0, army.fight(21));
        assertEquals(0, army.compensate(Conversion.DOUBLE, 3));
        assertEquals("12H", army.generateUsageReport());
    }

    @Test
    public void shouldFightAndCompensateArmyWithDoubleStrength()
    {
        Army army = new Army(15,"H");
        assertEquals(0, army.fight(21));
        assertEquals(1, army.compensate(Conversion.HALF, 5));
        assertEquals("15H", army.generateUsageReport());
    }


}