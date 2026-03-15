package org.example;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {

        String csvFilePath = "../cheese_data.csv";

        CheeseReader reader   = new CheeseReader(csvFilePath);
        CheeseList cheeseList = reader.readAll();
        System.out.println("Loaded " + cheeseList.size() + " cheeses from the dataset.");

        CheeseAnalyzer analyzer = new CheeseAnalyzer(cheeseList);

        CheeseWriter writer = new CheeseWriter(csvFilePath, analyzer);
        writer.writeOutputFile();
        writer.writeNoHeaders();
        writer.writeNoIds();
        writer.writeMissingIds();

        System.out.println("Done! All files have been written.");
    }
}
