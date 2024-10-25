package uts1;

import java.util.Random;

public class Cuaca {
    private String kondisi;

    public Cuaca(String kondisi) {
        this.kondisi = kondisi;
    }

    public void randomCuaca() {
        String[] cuacaOptions = {"Cerah", "Hujan", "Berawan"};
        Random rand = new Random();
        kondisi = cuacaOptions[rand.nextInt(cuacaOptions.length)];
        System.out.println("Cuaca hari ini: " + kondisi);
    }
}
