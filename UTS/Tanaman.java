package UTS;

public class Tanaman {
  private String nama;
  private int waktuPanen; // waktu panen dalam hari

  public Tanaman(String nama, int waktuPanen) {
      this.nama = nama;
      this.waktuPanen = waktuPanen;
  }

  public void tanam() {
      System.out.println("Anda telah menanam " + nama + ".");
  }

  public String getNama() {
      return nama;
  }

  public int getWaktuPanen() {
      return waktuPanen;
  }
}
