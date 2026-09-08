package org.example;

public class Produkt {

    private int kodProduktu;
    private String nazev;
    private int cena;
    private int pocetKusu;
    private TypProduktu typ;

    Produkt(int kodProduktu, String nazev, int cena, int pocetKusu, TypProduktu typ) {
        this.kodProduktu = kodProduktu;
        this.nazev = nazev;
        this.cena = cena;
        this.pocetKusu = pocetKusu;
        this.typ = typ;
    }

    public int getCena() {
        return cena;
    }

    public String getNazev() {
        return nazev;
    }

    public int getKodProduktu() {
        return kodProduktu;
    }

    public int getPocetKusu() {
        return pocetKusu;
    }

    public TypProduktu getTyp() {
        return typ;
    }

    public void setPocetKusu(int pocetKusu) {
        this.pocetKusu = pocetKusu;
    }
}
