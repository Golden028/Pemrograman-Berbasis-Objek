package AssigmentJs1;

public class Bookshelf extends Furniture {
  // Attributes
  private int numberOfShelves;
  private int capacity;

  // Constructor
  public Bookshelf(String material, String color, int numberOfShelves, int capacity) {
      super(material, color);
      this.numberOfShelves = numberOfShelves;
      this.capacity = capacity;
  }

  // Methods
  public void addBook() {
      System.out.println("Book added to the shelf.");
  }

  public void removeBook() {
      System.out.println("Book removed from the shelf.");
  }

  @Override
  public void showInfo() {
      super.showInfo();
      System.out.println("Bookshelf with " + numberOfShelves + " shelves and capacity " + capacity + " books.");
  }
}
