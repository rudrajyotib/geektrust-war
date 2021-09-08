package geektrust.war.batallion;

public class Army {

    private int size;
    private int unitUsed = 0;
    private final String suffix;

    public Army(int size, String suffix) {
        this.size = size;
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int fight(int opponentSize) {
        return compensate(Conversion.SELF, opponentSize);
    }

    public int compensate(Conversion conversion, int unitsToCompensate) {
        if (this.size == 0) {
            return unitsToCompensate;
        }

        int unitsNeeded = conversion.convertUnit(Math.round(unitsToCompensate/ 2.0f));
        if (unitsNeeded >= this.size) {
            int compensationShortage = (int) (unitsToCompensate - this.size * conversion.getConversionRate() * 2);
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
