package jobsheet6.Assigment;

public class Dosen extends Pegawai {
  private int jumlahSKS;
  private static final int TARIF_SKS = 50000;

  public Dosen(String nip, String nama, String alamat){
    super(nip, nama, alamat);
  }

  public void setSKS(int jumlahSKS){
    this.jumlahSKS = jumlahSKS;
  }

  public int getGaji(){
    return jumlahSKS * TARIF_SKS;
  }
}

