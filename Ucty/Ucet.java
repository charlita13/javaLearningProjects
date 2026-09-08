package org.example;

public class Ucet {

    private final String cisloUctu;
    private final String jmenoMajitele;
    private final TypUctu typUctu;
    private double zustatek;
    private StavUctu stavUctu;

    Ucet(String cisloUctu, String jmenoMajitele, TypUctu typUctu) {
        this.cisloUctu = cisloUctu;
        this.jmenoMajitele = jmenoMajitele;
        this.typUctu = typUctu;
        this.zustatek = 0;
        this.stavUctu = StavUctu.AKTIVNI;
    }

    public double getZustatek() {
        return zustatek;
    }

    public String getCisloUctu() {
        return cisloUctu;
    }

    public String getJmenoMajitele() {
        return jmenoMajitele;
    }

    public TypUctu getTypUctu() {
        return typUctu;
    }

    public StavUctu getStavUctu() {
        return stavUctu;
    }

    public void setZustatek(double zustatek) {
        this.zustatek = zustatek;
    }

    public void setStavUctu(StavUctu stavUctu) {
        this.stavUctu = stavUctu;
    }

    public void vkladNaUcet(double suma) {
        zustatek+=suma;
    }

    public void vyberUcet(double suma) {
        zustatek-=suma;
    }
}
