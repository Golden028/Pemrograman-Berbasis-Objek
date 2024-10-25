package UTS;

public class Cuaca {
  private String[] kondisiCuaca = {"Cerah", "Mendung", "Hujan"};
  private String kondisi;

  public Cuaca() {
      this.kondisi = kondisiCuaca[(int)(Math.random() * kondisiCuaca.length)];
  }

  public String getKondisi() {
      return kondisi;
  }
}
