package AssigmentJs1;

public class Wardrobe extends Furniture {
  // Attributes
  private int numberOfDoors;
  private String size;

  // Constructor
  public Wardrobe(String material, String color, int numberOfDoors, String size) {
      super(material, color);
      this.numberOfDoors = numberOfDoors;
      this.size = size;
  }

  // Methods
  public void openDoor() {
      System.out.println("Opening the wardrobe door.");
  }

  public void closeDoor() {
      System.out.println("Closing the wardrobe door.");
  }

  @Override
  public void showInfo() {
      super.showInfo();
      System.out.println("Wardrobe with " + numberOfDoors + " doors and size " + size + ".");
  }
}
