package org.example;

public enum StavUctu {
    AKTIVNI(1, "Účet lze aktivně využávat."),
    BLOKOVANY(2, "Účet je blokován a nelze využívat.");

    private final int pozice;
    private final String popis;

    StavUctu(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }

    public String getPopis() {
        return popis;
    }

    public int getPozice() {
        return pozice;
    }

    public static StavUctu podlePozice(int pozice) {
        for (StavUctu typ : StavUctu.values()) {
            if (typ.getPozice() == pozice) {
                return typ;
            }
        }
        return null;
    }
}
