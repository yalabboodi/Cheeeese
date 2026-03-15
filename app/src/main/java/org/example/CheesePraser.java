package org.example;

import java.util.ArrayList;
import java.util.List;

public class CheeseParser {

    public static String[] parseCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        String current = "";
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(current.trim());
                current = "";
            } else {
                current = current + c;
            }
        }

        fields.add(current.trim());
        return fields.toArray(new String[0]);
    }

    public static Cheese parseCheese(String[] fields) {
        return new Cheese(
                fields[0],
                fields[1],
                fields[2],
                fields[3],
                fields[4],
                fields[5],
                fields[6],
                fields[7],
                fields[8],
                fields[9],
                fields[10],
                fields[11],
                fields[12]
        );
    }
}
