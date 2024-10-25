package jobsheet7.Task;

public class MainManusia {
  public static void main(String[] args) {
    Manusia manusia;
    manusia = new Dosen();
    manusia.bernafas();
    manusia.makan();
    manusia = new Mahasiswa();
    manusia.bernafas();
    manusia.makan();
    Dosen dosen = new Dosen();
    dosen.lembur();
    Mahasiswa mahasiswa = new Mahasiswa();
    mahasiswa.tidur();
  }
}

