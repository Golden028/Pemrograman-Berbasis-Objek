package UTS;

import java.util.Scanner;

public class Toko {
    public void jual(Pemain pemain, String namaTanaman, Scanner scanner) {
        if (pemain.uang < 0) {
            System.out.println("Anda tidak memiliki cukup uang untuk bertransaksi.");
            return;
        }

        // Memeriksa apakah pemain memiliki tanaman yang ingin dijual
        switch (namaTanaman.toLowerCase()) {
            case "padi":
                if (pemain.jumlahTanaman[0] > 0) {
                    System.out.print("Berapa banyak Padi yang ingin dijual? ");
                    int jumlahJualPadi = scanner.nextInt();
                    if (jumlahJualPadi <= pemain.jumlahTanaman[0]) {
                        System.out.print("Anda ingin menjual Padi. Harga jual: $10 per tanaman. Y/N? ");
                        if (confirmTransaction(scanner)) {
                            pemain.jumlahTanaman[0] -= jumlahJualPadi;
                            pemain.tambahUang(jumlahJualPadi * 10.0); // Harga jual
                            System.out.println("Anda telah menjual " + jumlahJualPadi + " Padi. Uang Anda sekarang: " + pemain.uang);
                        }
                    } else {
                        System.out.println("Anda tidak memiliki cukup Padi untuk dijual.");
                    }
                } else {
                    System.out.println("Anda tidak memiliki Padi untuk dijual.");
                }
                break;
            case "jagung":
                if (pemain.jumlahTanaman[1] > 0) {
                    System.out.print("Berapa banyak Jagung yang ingin dijual? ");
                    int jumlahJualJagung = scanner.nextInt();
                    if (jumlahJualJagung <= pemain.jumlahTanaman[1]) {
                        System.out.print("Anda ingin menjual Jagung. Harga jual: $10 per tanaman. Y/N? ");
                        if (confirmTransaction(scanner)) {
                            pemain.jumlahTanaman[1] -= jumlahJualJagung;
                            pemain.tambahUang(jumlahJualJagung * 10.0); // Harga jual
                            System.out.println("Anda telah menjual " + jumlahJualJagung + " Jagung. Uang Anda sekarang: " + pemain.uang);
                        }
                    } else {
                        System.out.println("Anda tidak memiliki cukup Jagung untuk dijual.");
                    }
                } else {
                    System.out.println("Anda tidak memiliki Jagung untuk dijual.");
                }
                break;
            case "sayuran":
                if (pemain.jumlahTanaman[2] > 0) {
                    System.out.print("Berapa banyak Sayuran yang ingin dijual? ");
                    int jumlahJualSayuran = scanner.nextInt();
                    if (jumlahJualSayuran <= pemain.jumlahTanaman[2]) {
                        System.out.print("Anda ingin menjual Sayuran. Harga jual: $10 per tanaman. Y/N? ");
                        if (confirmTransaction(scanner)) {
                            pemain.jumlahTanaman[2] -= jumlahJualSayuran;
                            pemain.tambahUang(jumlahJualSayuran * 10.0); // Harga jual
                            System.out.println("Anda telah menjual " + jumlahJualSayuran + " Sayuran. Uang Anda sekarang: " + pemain.uang);
                        }
                    } else {
                        System.out.println("Anda tidak memiliki cukup Sayuran untuk dijual.");
                    }
                } else {
                    System.out.println("Anda tidak memiliki Sayuran untuk dijual.");
                }
                break;
            default:
                System.out.println("Tanaman yang ingin dijual tidak dikenali.");
                break;
        }
    }

    private boolean confirmTransaction(Scanner scanner) {
        String response = scanner.next().toLowerCase();
        return response.equals("y");
    }
}
