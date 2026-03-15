package org.example;

public class Cheese {

    private String cheeseId;
    private String manufacturerProvCode;
    private String manufacturingType;
    private String moisturePercent;
    private String flavour;
    private String characteristics;
    private String organic;
    private String categoryType;
    private String milkType;
    private String milkTreatment;
    private String rindType;
    private String cheeseName;
    private String fatLevel;

    public Cheese(String cheeseId, String manufacturerProvCode, String manufacturingType,
                  String moisturePercent, String flavour, String characteristics,
                  String organic, String categoryType, String milkType,
                  String milkTreatment, String rindType, String cheeseName, String fatLevel) {
        this.cheeseId = cheeseId;
        this.manufacturerProvCode = manufacturerProvCode;
        this.manufacturingType = manufacturingType;
        this.moisturePercent = moisturePercent;
        this.flavour = flavour;
        this.characteristics = characteristics;
        this.organic = organic;
        this.categoryType = categoryType;
        this.milkType = milkType;
        this.milkTreatment = milkTreatment;
        this.rindType = rindType;
        this.cheeseName = cheeseName;
        this.fatLevel = fatLevel;
    }

    public String getCheeseId()            { return cheeseId; }
    public String getManufacturerProvCode() { return manufacturerProvCode; }
    public String getManufacturingType()   { return manufacturingType; }
    public String getMoisturePercent()     { return moisturePercent; }
    public String getFlavour()             { return flavour; }
    public String getCharacteristics()     { return characteristics; }
    public String getOrganic()             { return organic; }
    public String getCategoryType()        { return categoryType; }
    public String getMilkType()            { return milkType; }
    public String getMilkTreatment()       { return milkTreatment; }
    public String getRindType()            { return rindType; }
    public String getCheeseName()          { return cheeseName; }
    public String getFatLevel()            { return fatLevel; }
}
