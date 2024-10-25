package uts1;

public class Waktu {
    private int hari;

    public Waktu() {
        this.hari = 1;
    }

    public void lewatkanHari() {
        hari++;
    }

    public String getWaktu() {
        return "Hari ke-" + hari;
    }

    public int getHari() {
        return hari;
    }
}
