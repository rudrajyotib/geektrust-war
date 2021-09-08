package geektrust.war.api;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    public static Map<String, Integer> parseOpponent(String battalion) {

        String[] units = battalion.split(" ");
        Map<String, Integer> opponent = new HashMap<>(4);
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < units[i].length(); j++) {
                if ((units[i].charAt(j) >= 'A') && (units[i].charAt(j) <= 'Z')) {
                    opponent.put(units[i].substring(j), Integer.parseInt(units[i].substring(0, j)));
                    break;
                }
            }
        }

        return opponent;
    }

}
