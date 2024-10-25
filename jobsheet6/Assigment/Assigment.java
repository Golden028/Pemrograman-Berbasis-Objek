package jobsheet6.Assigment;

public class Assigment {
  public static void main(String[] args) {
    DaftarGaji daftarGaji = new DaftarGaji(2);

    Dosen dosen1 = new Dosen("01234", "Dr. Jarjit", "Bandung");
    dosen1.setSKS(12);

    daftarGaji.addPegawai(dosen1);

    Dosen dosen2 = new Dosen("56789", "Dr. Tanmi", "Surabaya");
    dosen2.setSKS(8);

    daftarGaji.addPegawai(dosen2);

    daftarGaji.printSemuaGaji();
  }
}

