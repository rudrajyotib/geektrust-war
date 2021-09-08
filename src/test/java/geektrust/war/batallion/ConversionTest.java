package geektrust.war.batallion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    public void shouldConvertByRate()
    {
        assertEquals(3, Conversion.SELF.convertUnit(3));
        assertEquals(2, Conversion.DOUBLE.convertUnit(3));
        assertEquals(6, Conversion.HALF.convertUnit(3));
    }


}