package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CheeseWriter {

    private String csvFilePath;
    private CheeseAnalyzer analyzer;

    public CheeseWriter(String csvFilePath, CheeseAnalyzer analyzer) {
        this.csvFilePath = csvFilePath;
        this.analyzer    = analyzer;
    }

    public void writeOutputFile() throws IOException {
        PrintWriter outputFile = new PrintWriter(new FileWriter("output.txt"));

        outputFile.println("=== Canadian Cheese Dataset Analysis ===");
        outputFile.println();

        outputFile.println("Milk Treatment:");
        outputFile.println("  Pasteurized: " + analyzer.countPasteurized());
        outputFile.println("  Raw Milk: "    + analyzer.countRawMilk());
        outputFile.println();

        outputFile.println("Organic Cheeses with Moisture Greater Than 41%:");
        outputFile.println("  Count: " + analyzer.countOrganicHighMoisture());
        outputFile.println();

        outputFile.println("Milk Type Counts:");
        outputFile.println("  Cow: "     + analyzer.countCow());
        outputFile.println("  Goat: "    + analyzer.countGoat());
        outputFile.println("  Ewe: "     + analyzer.countEwe());
        outputFile.println("  Buffalo: " + analyzer.countBuffalo());
        outputFile.println("  Most common milk type: " + analyzer.getMostCommonMilkType());
        outputFile.println();

        outputFile.printf("Average Moisture Percent: %.2f%%%n", analyzer.getAverageMoisture());
        outputFile.println();

        outputFile.println("Cheeses with 'lactic' in their flavor description: " + analyzer.countLactic());

        outputFile.close();
        System.out.println("output.txt has been written.");
    }

    public void writeNoHeaders() throws IOException {
        Scanner scanner = new Scanner(new File(csvFilePath));
        scanner.nextLine();

        PrintWriter noHeaderFile = new PrintWriter(new FileWriter("cheese_without_headers.csv"));
        while (scanner.hasNextLine()) {
            noHeaderFile.println(scanner.nextLine());
        }

        scanner.close();
        noHeaderFile.close();
        System.out.println("cheese_without_headers.csv has been written.");
    }

    public void writeNoIds() throws IOException {
        Scanner scanner = new Scanner(new File(csvFilePath));

        String headerLine     = scanner.nextLine();
        String[] headerFields = CheeseParser.parseCSVLine(headerLine);

        PrintWriter noIdFile = new PrintWriter(new FileWriter("cheese_without_ids.csv"));

        String newHeader = "";
        for (int i = 1; i < headerFields.length; i++) {
            if (i > 1) {
                newHeader = newHeader + ",";
            }
            newHeader = newHeader + headerFields[i];
        }
        noIdFile.println(newHeader);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] fields = CheeseParser.parseCSVLine(line);
            String newLine  = "";

            for (int i = 1; i < fields.length; i++) {
                if (i > 1) {
                    newLine = newLine + ",";
                }
                if (fields[i].contains(",")) {
                    newLine = newLine + "\"" + fields[i] + "\"";
                } else {
                    newLine = newLine + fields[i];
                }
            }
            noIdFile.println(newLine);
        }

        scanner.close();
        noIdFile.close();
        System.out.println("cheese_without_ids.csv has been written.");
    }

    public void writeMissingIds() throws IOException {
        ArrayList<Integer> missingIds = analyzer.getMissingIds();
        int minId = analyzer.getMinId();
        int maxId = analyzer.getMaxId();

        PrintWriter missingFile = new PrintWriter(new FileWriter("missing_ids.txt"));
        missingFile.println("Missing Cheese IDs (from " + minId + " to " + maxId + "):");

        for (int id : missingIds) {
            missingFile.println(id);
        }

        missingFile.println();
        missingFile.println("Total missing IDs: " + missingIds.size());

        missingFile.close();
        System.out.println("missing_ids.txt has been written.");
    }
}
