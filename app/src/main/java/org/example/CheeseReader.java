package org.example;

import java.io.*;
import java.util.Scanner;

public class CheeseReader {

    private String filePath;

    public CheeseReader(String filePath) {
        this.filePath = filePath;
    }

    public CheeseList readAll() throws IOException {
        CheeseList cheeseList = new CheeseList();

        Scanner scanner = new Scanner(new File(filePath));
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] fields = CheeseParser.parseCSVLine(line);

            if (!CheeseRowCleaner.isValidRow(fields)) {
                continue;
            }

            Cheese cheese = CheeseParser.parseCheese(fields);
            cheeseList.add(cheese);
        }

        scanner.close();
        return cheeseList;
    }

    public String getFilePath() {
        return filePath;
    }
}
