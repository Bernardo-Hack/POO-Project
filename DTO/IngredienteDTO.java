package DTO;

public class IngredienteDTO {

    private int id;
    private String name;
    private double value; // value se refere ao custo de compra do ingrediente(ex.: R$50/L ou R$50/Kg)
    private int quant;
    private String measuringUnit;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
    public String getMeasuringUnit() {
        return measuringUnit;
    }
    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
