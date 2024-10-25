package jobsheet6.Assigment;

public class DaftarGaji {
  private Pegawai[] listPegawai;
  private int jumlahPegawai = 0;

  public DaftarGaji(int jumlah){
    listPegawai = new Pegawai[jumlah];
  }

  public void addPegawai(Pegawai pegawai){
    if (jumlahPegawai < listPegawai.length) {
      listPegawai[jumlahPegawai] = pegawai;
      jumlahPegawai++;
    }
  }

  public void printSemuaGaji(){
    for (int i = 0; i < jumlahPegawai; i++){
      System.out.println("Nama: "+ listPegawai[i].getNama() + ", Gaji: "+ listPegawai[i].getGaji());
    }
  }
}

