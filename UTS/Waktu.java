package UTS;

public class Waktu {
  private int hari;

  public Waktu() {
      this.hari = 1;
  }

  public void lewatkanHari() {
      hari++;
  }

  public String getWaktu() {
      return "Hari ke-" + hari;
  }
}
