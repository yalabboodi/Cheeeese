package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void parsesSimpleLine() {
        String[] result = CheeseParser.parseCSVLine("228,NB,Farmstead,47.0,Sharp,Uncooked,0,Firm Cheese,Ewe,Raw Milk,Washed Rind,Sieur de Duplessis,lower fat");
        assertEquals(13, result.length);
        assertEquals("228", result[0]);
        assertEquals("47.0", result[3]);
        assertEquals("Raw Milk", result[9]);
    }

    @Test
    void parsesQuotedFieldWithComma() {
        String[] result = CheeseParser.parseCSVLine("228,NB,Farmstead,47.0,\"Sharp, lactic\",Uncooked,0,Firm Cheese,Ewe,Raw Milk,Washed Rind,Sieur de Duplessis,lower fat");
        assertEquals(13, result.length);
        assertEquals("Sharp, lactic", result[4]);
    }

    @Test
    void handlesEmptyField() {
        String[] result = CheeseParser.parseCSVLine("301,ON,Industrial,54.0,Mild,Notes,0,Firm Cheese,Cow,Pasteurized,,Provolone,lower fat");
        assertEquals(13, result.length);
        assertEquals("", result[10]);
    }

    @Test
    void parsesCheeseObject() {
        String[] fields = {"228", "NB", "Farmstead", "47.0", "Sharp", "Uncooked",
                "0", "Firm Cheese", "Ewe", "Raw Milk", "Washed Rind", "Sieur de Duplessis", "lower fat"};
        Cheese cheese = CheeseParser.parseCheese(fields);
        assertEquals("228",      cheese.getCheeseId());
        assertEquals("47.0",     cheese.getMoisturePercent());
        assertEquals("Ewe",      cheese.getMilkType());
        assertEquals("Raw Milk", cheese.getMilkTreatment());
        assertEquals("0",        cheese.getOrganic());
    }

    @Test
    void acceptsValidRow() {
        String[] fields = {"228", "NB", "Farmstead", "47.0", "Sharp", "Uncooked",
                "0", "Firm Cheese", "Ewe", "Raw Milk", "Washed Rind", "Sieur de Duplessis", "lower fat"};
        assertTrue(CheeseRowCleaner.isValidRow(fields));
    }

    @Test
    void rejectsTooFewFields() {
        String[] fields = {"228", "NB", "Farmstead"};
        assertFalse(CheeseRowCleaner.isValidRow(fields));
    }

    @Test
    void rejectsAllEmptyRow() {
        String[] fields = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
        assertFalse(CheeseRowCleaner.isValidRow(fields));
    }
}
