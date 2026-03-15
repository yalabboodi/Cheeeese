package org.example;

public class CheeseRowCleaner {

    public static boolean isValidRow(String[] fields) {
        if (fields.length < 13) {
            return false;
        }

        for (String field : fields) {
            if (!field.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
