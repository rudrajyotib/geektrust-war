package geektrust.war.batallion;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Commander {

    private final Army[] layout
            = new Army[]{new Army(100, "H"),
            new Army(50, "E"),
            new Army(10, "AT"),
            new Army(5, "SG")};

    public String fight(Map<String, Integer> opponent) {
        boolean warResult = true;
        for (int i = 0; i < 4; i++) {
            if (opponent.containsKey(layout[i].getSuffix())) {
                int enemyStrength = opponent.get(layout[i].getSuffix());
                int fightResult = layout[i].fight(enemyStrength);
                if (fightResult > 0) {
                    if (i > 0) {
                        fightResult = layout[i - 1].compensate(Conversion.HALF, fightResult);
                    }
                }
                if (fightResult > 0) {
                    if (i < 3) {
                        fightResult = layout[i + 1].compensate(Conversion.DOUBLE, fightResult);
                    }
                }
                if (fightResult > 0) {
                    warResult = false;
                }
            }
        }
        return String.format("%s %s", (warResult ? "WINS" : "LOSES"),
                Arrays.stream(layout).map(Army::generateUsageReport).collect(joining(" ")));
    }


}
