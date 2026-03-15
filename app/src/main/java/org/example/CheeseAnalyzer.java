package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class CheeseAnalyzer {

    private CheeseList cheeseList;

    public CheeseAnalyzer(CheeseList cheeseList) {
        this.cheeseList = cheeseList;
    }

    public int countPasteurized() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (cheese.getMilkTreatment().equalsIgnoreCase("Pasteurized")) {
                count++;
            }
        }
        return count;
    }

    public int countRawMilk() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (cheese.getMilkTreatment().equalsIgnoreCase("Raw Milk")) {
                count++;
            }
        }
        return count;
    }

    public int countOrganicHighMoisture() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            String organicStr  = cheese.getOrganic();
            String moistureStr = cheese.getMoisturePercent();

            if (organicStr.isEmpty() || moistureStr.isEmpty()) {
                continue;
            }

            int organic     = Integer.parseInt(organicStr);
            double moisture = Double.parseDouble(moistureStr);

            if (organic == 1 && moisture > 41.0) {
                count++;
            }
        }
        return count;
    }

    public int countCow() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (cheese.getMilkType().equalsIgnoreCase("Cow")) {
                count++;
            }
        }
        return count;
    }

    public int countGoat() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (cheese.getMilkType().equalsIgnoreCase("Goat")) {
                count++;
            }
        }
        return count;
    }

    public int countEwe() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (cheese.getMilkType().equalsIgnoreCase("Ewe")) {
                count++;
            }
        }
        return count;
    }

    public int countBuffalo() {
        int count = 0;
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (cheese.getMilkType().equalsIgnoreCase("Buffalo")) {
                count++;
            }
        }
        return count;
    }

    public String getMostCommonMilkType() {
        int cowCount     = countCow();
        int goatCount    = countGoat();
        int eweCount     = countEwe();
        int buffaloCount = countBuffalo();

        String mostCommon = "Cow";
        int mostCount     = cowCount;

        if (goatCount > mostCount) {
            mostCommon = "Goat";
            mostCount  = goatCount;
        }
        if (eweCount > mostCount) {
            mostCommon = "Ewe";
            mostCount  = eweCount;
        }
        if (buffaloCount > mostCount) {
            mostCommon = "Buffalo";
        }

        return mostCommon;
    }

    public double getAverageMoisture() {
        double total = 0;
        int count    = 0;

        for (Cheese cheese : cheeseList.getCheeses()) {
            String moistureStr = cheese.getMoisturePercent();

            if (!moistureStr.isEmpty()) {
                total += Double.parseDouble(moistureStr);
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    public int countLactic() {
        int count = 0;
        Pattern lacticPattern = Pattern.compile("\\blactic\\b", Pattern.CASE_INSENSITIVE);

        for (Cheese cheese : cheeseList.getCheeses()) {
            String flavour = cheese.getFlavour();

            if (!flavour.isEmpty()) {
                if (lacticPattern.matcher(flavour).find()) {
                    count++;
                }
            }
        }

        return count;
    }

    public ArrayList<Integer> getMissingIds() {
        ArrayList<Integer> presentIds = new ArrayList<>();

        for (Cheese cheese : cheeseList.getCheeses()) {
            String idStr = cheese.getCheeseId();
            if (!idStr.isEmpty()) {
                presentIds.add(Integer.parseInt(idStr));
            }
        }

        Collections.sort(presentIds);
        int minId = presentIds.get(0);
        int maxId = presentIds.get(presentIds.size() - 1);

        ArrayList<Integer> missingIds = new ArrayList<>();
        for (int id = minId; id <= maxId; id++) {
            if (!presentIds.contains(id)) {
                missingIds.add(id);
            }
        }

        return missingIds;
    }

    public int getMinId() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (!cheese.getCheeseId().isEmpty()) {
                ids.add(Integer.parseInt(cheese.getCheeseId()));
            }
        }
        Collections.sort(ids);
        return ids.get(0);
    }

    public int getMaxId() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Cheese cheese : cheeseList.getCheeses()) {
            if (!cheese.getCheeseId().isEmpty()) {
                ids.add(Integer.parseInt(cheese.getCheeseId()));
            }
        }
        Collections.sort(ids);
        return ids.get(ids.size() - 1);
    }
}
