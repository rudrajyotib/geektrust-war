package geektrust.war.batallion;

public class Army {

    private int size;
    private int unitUsed = 0;
    private final String suffix;

    public Army(int size, String suffix) {
        this.size = size;
        this.suffix = suffix;
    }

    public int fight(int opponentSize) {
        return compensate(Conversion.SELF, opponentSize);
    }

    public int compensate(Conversion conversion, int unitsToCompensate) {
        if (this.size == 0) {
            return 0;
        }

        int unitsNeeded = conversion.convertUnit(unitsToCompensate);
        if (unitsNeeded >= this.size) {
            int compensationShortage = unitsToCompensate - this.size * conversion.getConversionRate();
            this.unitUsed += this.size;
            this.size = 0;
            return Math.max(compensationShortage, 0);
        }
        this.unitUsed += unitsNeeded;
        this.size -= unitsNeeded;
        return 0;
    }

    public String generateUsageReport() {
        return String.format("%d%s", this.unitUsed, this.suffix);
    }

}
