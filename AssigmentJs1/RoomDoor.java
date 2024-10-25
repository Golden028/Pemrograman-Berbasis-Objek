package AssigmentJs1;

public class RoomDoor {
  // Attributes
  private String material;
  private String color;
  private String type;  // Additional attribute
  private boolean hasLock; // Additional attribute

  // Constructor
  public RoomDoor(String material, String color, String type, boolean hasLock) {
      this.material = material;
      this.color = color;
      this.type = type;
      this.hasLock = hasLock;
  }

  // Methods
  public void open() {
      System.out.println("Room door opened.");
  }

  public void close() {
      System.out.println("Room door closed.");
  }

  public void showInfo() {
      System.out.println("Room door made of " + material + ", color " + color + ", type " + type + ", lock: " + (hasLock ? "Yes" : "No") + ".");
  }
}
