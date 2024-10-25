package UTS;

public class Pemain {
    String nama;
    double uang;
    int energi;
    String[] inventoriAlat;
    int[] jumlahTanaman; // Array untuk jumlah masing-masing tanaman
    int[] inventoriTanaman; // Array untuk menyimpan jumlah inventori tanaman
    String[] statusTanaman; // Menyimpan status tanaman yang ditanam

    public Pemain(String nama) {
        this.nama = nama;
        this.uang = 0.0; // Uang awal diatur menjadi 0
        this.energi = 100; // Energi awal
        this.inventoriAlat = new String[]{"Cangkul", "Pupuk", "Penyiram Tanaman"};
        this.jumlahTanaman = new int[3]; // Padi, Jagung, Sayuran
        this.inventoriTanaman = new int[3]; // Padi, Jagung, Sayuran untuk inventori
        this.statusTanaman = new String[3]; // Status tanaman (Ditanam atau Belum Ditanam)
    }

    public void kurangiEnergi(int jumlah) {
        energi -= jumlah;
        if (energi < 0) {
            energi = 0;
        }
    }

    public void tambahUang(double jumlah) {
        uang += jumlah;
    }

    public void panenTanaman(String namaTanaman, int jumlah) {
        switch (namaTanaman.toLowerCase()) {
            case "padi":
                if (jumlahTanaman[0] >= jumlah) {
                    jumlahTanaman[0] -= jumlah;
                    inventoriTanaman[0] += jumlah; // Masukkan ke inventori setelah panen
                    kurangiEnergi(jumlah); // Mengurangi energi sesuai jumlah panen
                    System.out.println("Anda telah memanen " + jumlah + " Padi.");
                } else {
                    System.out.println("Jumlah Padi tidak cukup untuk dipanen.");
                }
                break;
            case "jagung":
                if (jumlahTanaman[1] >= jumlah) {
                    jumlahTanaman[1] -= jumlah;
                    inventoriTanaman[1] += jumlah; // Masukkan ke inventori setelah panen
                    kurangiEnergi(jumlah); // Mengurangi energi sesuai jumlah panen
                    System.out.println("Anda telah memanen " + jumlah + " Jagung.");
                } else {
                    System.out.println("Jumlah Jagung tidak cukup untuk dipanen.");
                }
                break;
            case "sayuran":
                if (jumlahTanaman[2] >= jumlah) {
                    jumlahTanaman[2] -= jumlah;
                    inventoriTanaman[2] += jumlah; // Masukkan ke inventori setelah panen
                    kurangiEnergi(jumlah); // Mengurangi energi sesuai jumlah panen
                    System.out.println("Anda telah memanen " + jumlah + " Sayuran.");
                } else {
                    System.out.println("Jumlah Sayuran tidak cukup untuk dipanen.");
                }
                break;
            default:
                System.out.println("Tanaman tidak dikenali.");
                break;
        }
    }

    public void tambahTanaman(String namaTanaman) {
        if (namaTanaman.equalsIgnoreCase("Padi")) {
            jumlahTanaman[0]++;
            statusTanaman[0] = "Ditanam"; // Set status padi
        } else if (namaTanaman.equalsIgnoreCase("Jagung")) {
            jumlahTanaman[1]++;
            statusTanaman[1] = "Ditanam"; // Set status jagung
        } else if (namaTanaman.equalsIgnoreCase("Sayuran")) {
            jumlahTanaman[2]++;
            statusTanaman[2] = "Ditanam"; // Set status sayuran
        }
    }

    public void cekInventori() {
        System.out.println("Inventori Tanaman:");
        System.out.println("Padi: " + inventoriTanaman[0]);
        System.out.println("Jagung: " + inventoriTanaman[1]);
        System.out.println("Sayuran: " + inventoriTanaman[2]);
    }

    public void cekTanamanDitanam() {
        System.out.println("Tanaman yang telah ditanam:");
        for (int i = 0; i < statusTanaman.length; i++) {
            if (statusTanaman[i] != null && statusTanaman[i].equals("Ditanam")) {
                switch (i) {
                    case 0:
                        System.out.println("Padi: " + jumlahTanaman[0]);
                        break;
                    case 1:
                        System.out.println("Jagung: " + jumlahTanaman[1]);
                        break;
                    case 2:
                        System.out.println("Sayuran: " + jumlahTanaman[2]);
                        break;
                }
            }
        }
    }

    public void jualTanaman(String namaTanaman, int jumlah) {
        switch (namaTanaman.toLowerCase()) {
            case "padi":
                if (inventoriTanaman[0] >= jumlah) {
                    inventoriTanaman[0] -= jumlah;
                    tambahUang(jumlah * 5); // Misalnya harga Padi 5
                    System.out.println("Anda telah menjual " + jumlah + " Padi.");
                } else {
                    System.out.println("Jumlah Padi tidak cukup untuk dijual.");
                }
                break;
            case "jagung":
                if (inventoriTanaman[1] >= jumlah) {
                    inventoriTanaman[1] -= jumlah;
                    tambahUang(jumlah * 7); // Misalnya harga Jagung 7
                    System.out.println("Anda telah menjual " + jumlah + " Jagung.");
                } else {
                    System.out.println("Jumlah Jagung tidak cukup untuk dijual.");
                }
                break;
            case "sayuran":
                if (inventoriTanaman[2] >= jumlah) {
                    inventoriTanaman[2] -= jumlah;
                    tambahUang(jumlah * 4); // Misalnya harga Sayuran 4
                    System.out.println("Anda telah menjual " + jumlah + " Sayuran.");
                } else {
                    System.out.println("Jumlah Sayuran tidak cukup untuk dijual.");
                }
                break;
            default:
                System.out.println("Tanaman tidak dikenali.");
                break;
        }
    }

    public void lewatkanHari() {
        // Mengembalikan energi pemain saat melewati hari
        energi = 100; // Reset energi ke maksimum
        System.out.println("Hari telah berlalu. Energi Anda telah di-refresh ke: " + energi);
    }
}
