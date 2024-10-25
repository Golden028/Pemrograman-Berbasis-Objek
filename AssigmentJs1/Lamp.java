package AssigmentJs1;

public class Lamp {
    // Attributes
    private String lampType;
    private int powerUsage;
    private String color;  // Additional attribute
    private String lightingType; // Additional attribute

    // Constructor
    public Lamp(String lampType, int powerUsage, String color, String lightingType) {
        this.lampType = lampType;
        this.powerUsage = powerUsage;
        this.color = color;
        this.lightingType = lightingType;
    }

    // Methods
    public void turnOn() {
        System.out.println("Lamp turned on.");
    }

    public void turnOff() {
        System.out.println("Lamp turned off.");
    }

    public void showInfo() {
        System.out.println("Lamp type " + lampType + ", with power " + powerUsage + " watts, color " + color + ", lighting type " + lightingType + ".");
    }
}
