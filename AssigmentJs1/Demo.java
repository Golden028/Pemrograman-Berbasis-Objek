package AssigmentJs1;

public class Demo {
  public static void main(String[] args) {
      // Creating instances of each class
      Wardrobe wardrobe = new Wardrobe("Wood", "Brown", 2, "Large");
      Bookshelf bookshelf = new Bookshelf("Wood", "White", 5, 100);
      Lamp lamp = new Lamp("Desk", 40, "Yellow", "Fluorescent");
      RoomDoor roomDoor = new RoomDoor("Wood", "White", "Swing", true);

      // Applying methods to each object
      wardrobe.showInfo();
      wardrobe.openDoor();
      wardrobe.closeDoor();

      bookshelf.showInfo();
      bookshelf.addBook();
      bookshelf.removeBook();

      lamp.showInfo();
      lamp.turnOn();
      lamp.turnOff();

      roomDoor.showInfo();
      roomDoor.open();
      roomDoor.close();
  }
}
