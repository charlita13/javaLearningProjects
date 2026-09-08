package org.example;

public class Objednavka {
    private final int cisloObjednavky;
    private final String jmenoZakaznika;
    private final int cena;
    private StavObejdnavky stav;

    Objednavka(int cisloObjednavky, String jmenoZakaznika, int cena) {
        this.cisloObjednavky = cisloObjednavky;
        this.jmenoZakaznika = jmenoZakaznika;
        this.cena = cena;
        this.stav = StavObejdnavky.NOVA;
    }

    public int getCena() {
        return cena;
    }

    public StavObejdnavky getStav() {
        return stav;
    }

    public int getCisloObjednavky() {
        return cisloObjednavky;
    }

    public String getJmenoZakaznika() {
        return jmenoZakaznika;
    }

    public void setStav(StavObejdnavky stav) {
        this.stav = stav;
    }
}
