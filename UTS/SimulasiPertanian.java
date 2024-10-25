package UTS;

import java.util.Scanner;

public class SimulasiPertanian {
    private static Pemain pemain;
    private static Padi padi;
    private static Jagung jagung;
    private static Sayuran sayuran;
    private static int hari; // Variabel untuk melacak hari

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Masukkan nama pemain: ");
        String namaPemain = scanner.nextLine();
        pemain = new Pemain(namaPemain);
        hari = 1; // Hari dimulai dari 1
        System.out.println("Selamat datang, " + pemain.nama);

        // Inisialisasi Tanaman
        padi = new Padi();
        jagung = new Jagung();
        sayuran = new Sayuran();

        // Simulasi
        Lahan lahan = new Lahan(100.0, "Tanah Subur");
        Cuaca cuaca = new Cuaca();
        Waktu waktu = new Waktu();

        while (true) {
            System.out.println("\nHari ke-" + hari); // Tampilkan hari
            System.out.println("Cuaca hari ini: " + cuaca.getKondisi());
            System.out.println("Waktu: " + waktu.getWaktu());
            System.out.println("Uang Anda: " + pemain.uang);
            System.out.println("Energi Anda: " + pemain.energi);

            tampilkanMenu();

            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    pemain.cekInventori(); // Cek inventori tanaman
                    break;
                case 2:
                    // Cek inventori alat
                    System.out.println("Inventori Alat: " + String.join(", ", pemain.inventoriAlat));
                    break;
                case 3:
                    tanamPadi(scanner);
                    break;
                case 4:
                    tanamJagung(scanner);
                    break;
                case 5:
                    tanamSayuran(scanner);
                    break;
                case 6:
                    pemain.cekTanamanDitanam(); // Tampilkan tanaman yang telah ditanam
                    break;
                case 7:
                    panenTanaman(scanner);
                    break;
                case 8:
                    jualTanaman(scanner);
                    break;
                case 9:
                    lewatkanHari(); // Melewati hari
                    break;
                case 10:
                    System.out.println("Terima kasih telah bermain!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("===== Pilihan Menu =====");
        System.out.println("1. Cek Inventori Tanaman");
        System.out.println("2. Cek Inventori Alat");
        System.out.println("3. Tanam Padi");
        System.out.println("4. Tanam Jagung");
        System.out.println("5. Tanam Sayuran");
        System.out.println("6. Tanaman yang Ditanam");
        System.out.println("7. Panen Tanaman");
        System.out.println("8. Jual Tanaman");
        System.out.println("9. Lewati Hari");
        System.out.println("10. Keluar");
        System.out.println("========================");
    }

    private static void tanamPadi(Scanner scanner) {
        System.out.print("Berapa banyak Padi yang ingin ditanam? ");
        int jumlahPadi = scanner.nextInt();
        for (int i = 0; i < jumlahPadi; i++) {
            if (pemain.energi >= 1) { // Menggunakan 1 energi untuk menanam
                padi.tanam();
                pemain.kurangiEnergi(1);
                pemain.tambahTanaman(padi.getNama()); // Gunakan getter
            } else {
                System.out.println("Energi tidak cukup untuk menanam.");
            }
        }
    }

    private static void tanamJagung(Scanner scanner) {
        System.out.print("Berapa banyak Jagung yang ingin ditanam? ");
        int jumlahJagung = scanner.nextInt();
        for (int i = 0; i < jumlahJagung; i++) {
            if (pemain.energi >= 1) { // Menggunakan 1 energi untuk menanam
                jagung.tanam();
                pemain.kurangiEnergi(1);
                pemain.tambahTanaman(jagung.getNama()); // Gunakan getter
            } else {
                System.out.println("Energi tidak cukup untuk menanam.");
            }
        }
    }

    private static void tanamSayuran(Scanner scanner) {
        System.out.print("Berapa banyak Sayuran yang ingin ditanam? ");
        int jumlahSayuran = scanner.nextInt();
        for (int i = 0; i < jumlahSayuran; i++) {
            if (pemain.energi >= 1) { // Menggunakan 1 energi untuk menanam
                sayuran.tanam();
                pemain.kurangiEnergi(1);
                pemain.tambahTanaman(sayuran.getNama()); // Gunakan getter
            } else {
                System.out.println("Energi tidak cukup untuk menanam.");
            }
        }
    }

    private static void panenTanaman(Scanner scanner) {
        System.out.print("Pilih tanaman untuk dipanen (Padi/Jagung/Sayuran): ");
        String namaTanaman = scanner.next();
        System.out.print("Berapa banyak yang ingin dipanen? ");
        int jumlahPanen = scanner.nextInt();
        pemain.panenTanaman(namaTanaman, jumlahPanen);
    }

    private static void jualTanaman(Scanner scanner) {
        System.out.print("Pilih tanaman untuk dijual (Padi/Jagung/Sayuran): ");
        String tanamanJual = scanner.next();
        System.out.print("Berapa banyak yang ingin dijual? ");
        int jumlahJual = scanner.nextInt();
        pemain.jualTanaman(tanamanJual, jumlahJual);
    }

    private static void lewatkanHari() {
        hari++; // Tambah hari
        pemain.energi = 100; // Reset energi saat melewati hari
        System.out.println("Hari telah berlalu. Hari ke-" + hari + ". Energi Anda telah di-refresh.");
    }
}
