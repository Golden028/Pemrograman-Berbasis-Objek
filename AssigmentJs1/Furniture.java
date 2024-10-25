package AssigmentJs1;

public class Furniture {
  // Attributes
  private String material;
  private String color;

  // Constructor
  public Furniture(String material, String color) {
      this.material = material;
      this.color = color;
  }

  // Methods
  public void showInfo() {
      System.out.println("Furniture made of " + material + " with color " + color + ".");
  }
}
