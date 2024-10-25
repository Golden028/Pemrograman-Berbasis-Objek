package uts1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pemain pemain = new Pemain();
        Toko toko = new Toko();
        Cuaca cuaca = new Cuaca("Cerah");

        int hari = 1;
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("\nHari ke-" + hari);
            cuaca.randomCuaca();
            System.out.println("Koin Anda: " + pemain.getUang());
            System.out.println("Menu:");
            System.out.println("1. Tampilkan Daftar Tanaman di Toko");
            System.out.println("2. Beli Tanaman");
            System.out.println("3. Tampilkan Inventori Alat");
            System.out.println("4. Tampilkan Inventori Tanaman");
            System.out.println("5. Tampilkan Tanaman yang Ditanam");
            System.out.println("6. Tampilkan Tanaman yang Dipanen");
            System.out.println("7. Tanam Tanaman");
            System.out.println("8. Panen Tanaman");
            System.out.println("9. Siram Tanaman");
            System.out.println("10. Pupuk Tanaman");
            System.out.println("11. Berantas Hama");
            System.out.println("12. Jual Tanaman");
            System.out.println("13. Lanjut ke Hari Berikutnya");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt

            switch (opsi) {
                case 1:
                    toko.tampilkanDaftarTanaman();
                    break;

                case 2:
                    System.out.println("Masukkan nama tanaman yang ingin dibeli:");
                    String namaBeli = scanner.nextLine();
                    pemain.beliTanaman(toko, namaBeli);
                    break;

                case 3:
                    pemain.tampilkanInventoriAlat();
                    break;

                case 4:
                    pemain.tampilkanInventoriTanaman();
                    break;

                case 5: // Tampilkan Tanaman yang Ditanam
                    pemain.tampilkanTanamanDitanam();
                    break;

                case 6: // Tampilkan Tanaman yang Dipanen
                    pemain.tampilkanTanamanDipanen();
                    break;

                case 7: // Tanam Tanaman
                    System.out.println("Masukkan nama tanaman yang ingin ditanam:");
                    String namaTanam = scanner.nextLine();
                    Tanaman tanamBaru = null;
                    switch (namaTanam.toLowerCase()) {
                        case "padi":
                            tanamBaru = new Padi();
                            break;
                        case "jagung":
                            tanamBaru = new Jagung();
                            break;
                        case "sayuran":
                            tanamBaru = new Sayuran();
                            break;
                        default:
                            System.out.println("Tanaman tidak dikenal.");
                            continue;
                    }
                    pemain.tanamTanaman(tanamBaru);
                    break;

                case 8: // Panen Tanaman
                    System.out.println("Masukkan nama tanaman yang ingin dipanen:");
                    String namaPanen = scanner.nextLine();
                    for (Tanaman t : pemain.getTanamanDitanam()) { // Check in planted plants
                        if (t.getNama().equalsIgnoreCase(namaPanen)) {
                            // Harvest the plant without additional checks
                            pemain.panenTanaman(t.getNama()); // Call the harvest method
                            break; // Exit the loop after harvesting
                        }
                    }
                    break;

                case 9: // Siram Tanaman
                    System.out.println("Masukkan nama tanaman yang ingin disiram:");
                    String namaSiram = scanner.nextLine();
                    for (Tanaman t : pemain.getTanamanDitanam()) { // Check in planted plants
                        if (t.getNama().equalsIgnoreCase(namaSiram)) {
                            t.siram();
                            break;
                        }
                    }
                    break;

                case 10: // Pupuk Tanaman
                    System.out.println("Masukkan nama tanaman yang ingin dipupuk:");
                    String namaPupuk = scanner.nextLine();
                    for (Tanaman t : pemain.getTanamanDitanam()) { // Check in planted plants
                        if (t.getNama().equalsIgnoreCase(namaPupuk)) {
                            t.pupuk();
                            break;
                        }
                    }
                    break;

                case 11:
                    System.out.println("Masukkan nama tanaman yang ingin diberantas hama:");
                    String namaHama = scanner.nextLine();
                    for (Tanaman t : pemain.getTanamanDitanam()) { // Check against tanamanDitanam
                        if (t.getNama().equalsIgnoreCase(namaHama)) {
                            t.berantasHama();
                            break;
                        }
                    }
                    break;

                case 12:
                    System.out.println("Masukkan nama tanaman yang ingin dijual:");
                    String namaJual = scanner.nextLine();
                    for (Tanaman t : pemain.getTanamanDipanen()) { // Check against harvested plants
                        if (t.getNama().equalsIgnoreCase(namaJual)) {
                            pemain.jualTanaman(namaJual); // Sell the harvested plant
                            break;
                        }
                    }
                    break;

                case 13: // Lanjut ke Hari Berikutnya
                    // Proses pertumbuhan tanaman
                    for (Tanaman t : pemain.getTanamanDitanam()) {
                        t.tumbuh();
                    }

                    // Daftar tugas harian
                    List<String> tasks = new ArrayList<>();
                    tasks.add("Siram Tanaman");
                    tasks.add("Pupuk Tanaman");
                    tasks.add("Berantas Hama");

                    // Acak dan pilih tugas secara acak
                    Collections.shuffle(tasks); // Mengacak tugas
                    int numberOfTasksToPerform = Math.min(tasks.size(), 3); // Maksimal 3 tugas

                    System.out.println("Tugas untuk hari ini:");
                    for (int i = 0; i < numberOfTasksToPerform; i++) {
                        String task = tasks.get(i);
                        System.out.println("Anda harus: " + task);
                    }

                    // Memberikan peringatan tentang perawatan tanaman
                    for (Tanaman t : pemain.getTanamanDitanam()) {
                        if (!t.areTasksCompleted()) { // Cek jika tugas telah selesai
                            System.out.println("Peringatan: " + t.getNama() + " perlu disiram, dipupuk, dan diperiksa dari hama sebelum dipanen.");
                        } else {
                            System.out.println(t.getNama() + " sudah siap untuk dipanen.");
                        }
                    }

                    hari++;
                    break;

                case 0:
                    gameRunning = false;
                    System.out.println("Terima kasih telah bermain!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
