package geektrust.war.batallion;

public enum Conversion {

    SELF(1),
    HALF(0.5f),
    DOUBLE(2);

    private final float conversionRate;

    Conversion(float conversionRate) {
        this.conversionRate = conversionRate;
    }

    public float getConversionRate()
    {
        return this.conversionRate;
    }

    public int convertUnit(int units)
    {
        return Math.round(units/this.conversionRate);
    }
}
