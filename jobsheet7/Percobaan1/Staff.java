package jobsheet7.Percobaan1;

public class Staff extends Karyawan{
  private int lembur;
  private double gajiLembur;

  public void setLembur(int lembur) {
    this.lembur = lembur;
  }

  public int getLembur() {
    return lembur;
  }

  public void setGajiLembur(double gajiLembur) {
    this.gajiLembur = gajiLembur;
  }

  public double getGajiLembur() {
    return gajiLembur;
  }

  public double getGaji(int lembur, double gajiLembur) {
    return super.getGaji()+lembur*gajiLembur;
  }

  public double getGaji() {
    return super.getGaji()+lembur*gajiLembur;
  }

  public void lihatInfo() {
    System.out.println("NIP :"+ this.getNip());
    System.out.println("Nama :"+ this.getNama());
    System.out.println("Golongan :"+ this.getGolongan());
    System.out.println("Jumlah Lembur :"+ this.getLembur());
    System.out.println("Gaji Lembur :%.0f\n"+ this.getGajiLembur());
    System.out.println("Gaji :%.0f\n"+ this.getGaji());
  }
}
