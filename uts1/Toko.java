package uts1;

import java.util.ArrayList;

public class Toko {
    private ArrayList<Tanaman> daftarTanaman;

    public Toko() {
        daftarTanaman = new ArrayList<>();
        daftarTanaman.add(new Padi());
        daftarTanaman.add(new Jagung());
        daftarTanaman.add(new Sayuran());
    }

    public void tampilkanDaftarTanaman() {
        System.out.println("Daftar tanaman di toko:");
        for (Tanaman tanaman : daftarTanaman) {
            System.out.println("- " + tanaman.getNama() + " (Harga: " + tanaman.getHarga() + " koin)");
        }
    }

    public Tanaman beliTanaman(String nama) {
        for (Tanaman tanaman : daftarTanaman) {
            if (tanaman.getNama().equalsIgnoreCase(nama)) {
                return tanaman;
            }
        }
        return null; // Tanaman tidak ditemukan
    }
}
