package org.example;

public enum EditMenu {

    JMENO(1, "Změna jména"),
    ODDELENI(2, "Změna oddělení"),
    PLAT(3, "Změna platu");

    private final int pozice;
    private final String popis;

    EditMenu(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }

    public String getPopis() {
        return popis;
    }

    public int getPozice() {
        return pozice;
    }
}
