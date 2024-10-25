package jobsheet7.Task;

public class MainSegitiga {
  public static void main(String[] args) {
    Segitiga segitiga = new Segitiga();
    System.out.println("Total Sudut with one known angle (90): " + segitiga.totalSudut(90));
    System.out.println("Total Sudut with two known angles (60, 30): " + segitiga.totalSudut(60, 30));
    System.out.println("Keliling with three sides (3, 4, 5): " + segitiga.keliling(3, 4, 5));
    System.out.println("Keliling with two sides (3, 4): " + segitiga.keliling(3, 4));
  }
}

