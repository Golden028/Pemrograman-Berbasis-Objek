package uts1;

public class Tanaman {
    private String nama;
    private int waktuPanen; // dalam hari
    private int kebutuhanAir;
    private int harga;
    private boolean dapatDipanen;
    private int hargaJual; // Harga saat tanaman dijual
    private boolean disiram;
    private boolean dipupuk;
    private boolean hama;

    public Tanaman(String nama, int waktuPanen, int kebutuhanAir, int harga, int hargaJual) {
        this.nama = nama;
        this.waktuPanen = waktuPanen;
        this.kebutuhanAir = kebutuhanAir;
        this.harga = harga;
        this.hargaJual = hargaJual;
        this.dapatDipanen = false;
        this.disiram = false;
        this.dipupuk = false;
        this.hama = false;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public boolean isDapatDipanen() {
        return dapatDipanen;
    }

    public void tumbuh() {
      if (waktuPanen > 0) {
          waktuPanen--;
      }
      if (waktuPanen == 0) {
          if (disiram && dipupuk && !hama) { // Pastikan tanaman disiram, dipupuk, dan tidak ada hama
              dapatDipanen = true;
              System.out.println(nama + " telah siap dipanen!");
          } else {
              System.out.println(nama + " belum siap dipanen, pastikan telah disiram, dipupuk dan tidak ada hama.");
          }
      }
  }
  
  

    public void siram() {
        disiram = true;
        System.out.println(nama + " telah disiram.");
    }

    public void pupuk() {
        dipupuk = true;
        System.out.println(nama + " telah dipupuk.");
    }

    public void berantasHama() {
        hama = false; // Menghapus hama
        System.out.println("Hama pada " + nama + " telah diberantas.");
    }

    public boolean isDisiram() {
        return disiram;
    }

    public boolean isDipupuk() {
        return dipupuk;
    }

    public boolean hasHama() {
        return hama;
    }

    // Override equals() to compare based on name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check reference equality
        if (!(obj instanceof Tanaman)) return false; // Check type
        Tanaman other = (Tanaman) obj;
        return this.nama.equalsIgnoreCase(other.nama); // Compare names
    }

    // Override hashCode() to maintain the contract with equals()
    @Override
    public int hashCode() {
        return nama.toLowerCase().hashCode(); // Use lowercase for consistency
    }

    public boolean areTasksCompleted() {
      return disiram && dipupuk && !hama;
  }
  
}
