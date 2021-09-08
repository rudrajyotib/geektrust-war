package geektrust.war.batallion;

public enum Conversion {

    SELF(2),
    HALF(1),
    DOUBLE(4);

    private final int conversionRate;

    Conversion(int conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getConversionRate()
    {
        return this.conversionRate;
    }

    public int convertUnit(int units)
    {
        if ((units % this.conversionRate) == 0)
        {
            return units/conversionRate;
        }
        return (units / conversionRate) + 1;
    }
}
