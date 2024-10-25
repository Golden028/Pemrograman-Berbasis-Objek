package uts1;

import java.util.ArrayList;

public class Pemain {
    private int uang;
    private ArrayList<Tanaman> inventoriTanaman;
    private ArrayList<Tanaman> tanamanDitanam; // List for planted plants
    private ArrayList<Tanaman> tanamanDipanen; // List for harvested plants
    private ArrayList<Alat> inventoriAlat;

    public Pemain() {
        this.uang = 500; // Start with 500 coins
        this.inventoriTanaman = new ArrayList<>();
        this.tanamanDitanam = new ArrayList<>(); // Initialize the list for planted plants
        this.tanamanDipanen = new ArrayList<>(); // Initialize the list for harvested plants
        this.inventoriAlat = new ArrayList<>();

        // Adding tools to the inventory
        inventoriAlat.add(new Alat("Cangkul", 50));
        inventoriAlat.add(new Alat("Penyiram Tanaman", 30));
        inventoriAlat.add(new Alat("Pupuk", 20));
        inventoriAlat.add(new Alat("Pestisida", 40));
    }

    public void beliTanaman(Toko toko, String nama) {
        Tanaman tanaman = toko.beliTanaman(nama);
        if (tanaman != null) {
            System.out.println("Tanaman " + tanaman.getNama() + " seharga " + tanaman.getHarga() + " koin.");
            if (uang >= tanaman.getHarga()) {
                uang -= tanaman.getHarga();
                inventoriTanaman.add(tanaman);
                System.out.println("Anda telah membeli " + tanaman.getNama());
            } else {
                System.out.println("Uang tidak cukup untuk membeli " + tanaman.getNama());
            }
        } else {
            System.out.println("Tanaman tidak ditemukan di toko.");
        }
    }

    public void tanamTanaman(Tanaman tanaman) {
        if (inventoriTanaman.contains(tanaman)) {
            inventoriTanaman.remove(tanaman); // Remove the plant from inventory after planting
            tanamanDitanam.add(tanaman); // Add to the planted plants list
            System.out.println("Anda telah menanam " + tanaman.getNama());
        } else {
            System.out.println("Tanaman tidak ada dalam inventori.");
        }
    }

    public void panenTanaman(String nama) {
        Tanaman tanamanUntukDipanen = null;

        // Cari tanaman yang cocok di tanamanDitanam
        for (Tanaman tanaman : tanamanDitanam) {
            if (tanaman.getNama().equalsIgnoreCase(nama)) {
                tanamanUntukDipanen = tanaman; // Mark the plant to be harvested
                break;
            }
        }

        // Jika ditemukan tanaman yang bisa dipanen
        if (tanamanUntukDipanen != null) {
            tanamanDipanen.add(tanamanUntukDipanen); // Add to harvested plants
            tanamanDitanam.remove(tanamanUntukDipanen); // Remove from planted plants
            System.out.println("Anda telah memanen " + tanamanUntukDipanen.getNama() + ". Tanaman sudah siap untuk dijual.");
        } else {
            System.out.println("Tanaman dengan nama " + nama + " tidak ditemukan di lahan.");
        }
    }

    public void jualTanaman(String nama) {
        Tanaman tanamanUntukDijual = null;

        // Cek apakah tanaman ada di tanamanDipanen
        for (Tanaman tanaman : tanamanDipanen) {
            if (tanaman.getNama().equalsIgnoreCase(nama)) {
                tanamanUntukDijual = tanaman; // Mark the plant to be sold
                break;
            }
        }

        if (tanamanUntukDijual != null) {
            int hargaJual = tanamanUntukDijual.getHargaJual(); // Get the selling price
            uang += hargaJual; // Add the selling price to the player's money
            tanamanDipanen.remove(tanamanUntukDijual); // Remove the sold plant from the harvested list
            System.out.println("Anda telah menjual " + tanamanUntukDijual.getNama() + " dan menerima " + hargaJual + " koin.");
            System.out.println("Total koin Anda sekarang: " + uang + " koin."); // Show total money after selling
        } else {
            System.out.println("Tanaman dengan nama " + nama + " tidak ditemukan dalam daftar tanaman yang dipanen.");
        }
    }

    public void tampilkanTanamanDipanen() {
        if (tanamanDipanen.isEmpty()) {
            System.out.println("Tidak ada tanaman yang sudah dipanen.");
        } else {
            System.out.println("Tanaman yang sudah dipanen:");
            for (Tanaman t : tanamanDipanen) {
                System.out.println("- " + t.getNama());
            }
        }
    }

    public void tampilkanInventoriTanaman() {
        if (inventoriTanaman.isEmpty()) {
            System.out.println("Inventori tanaman kosong.");
        } else {
            System.out.println("Tanaman dalam inventori:");
            for (Tanaman tanaman : inventoriTanaman) {
                System.out.println("- " + tanaman.getNama());
            }
        }
    }

    public void tampilkanTanamanDitanam() { // Method to display planted plants
        if (tanamanDitanam.isEmpty()) {
            System.out.println("Belum ada tanaman yang ditanam.");
        } else {
            System.out.println("Tanaman yang telah ditanam:");
            for (Tanaman tanaman : tanamanDitanam) {
                System.out.println("- " + tanaman.getNama());
            }
        }
    }

    public void tampilkanInventoriAlat() {
        if (inventoriAlat.isEmpty()) {
            System.out.println("Inventori alat kosong.");
        } else {
            System.out.println("Alat dalam inventori:");
            for (Alat alat : inventoriAlat) {
                System.out.println("- " + alat.getNama());
            }
        }
    }

    public ArrayList<Tanaman> getTanamanDipanen() {
        return tanamanDipanen; // Return the list of harvested plants
    }

    public ArrayList<Tanaman> getInventoriTanaman() {
        return inventoriTanaman;
    }

    public ArrayList<Tanaman> getTanamanDitanam() { // Method to get planted plants
        return tanamanDitanam;
    }

    public void tambahUang(int jumlah) {
        uang += jumlah; // Add money to the player's account
    }

    public int getUang() {
        return uang; // Return the current amount of money
    }
}
