package org.example;

public enum Menu {
    ZALOZIT(1, "Založit účet"),
    VLOZIT(2, "Vložit peníze"),
    VYBRAT(3, "Vybrat peníze"),
    PREVOD(4, "Převést peníze mezi účty"),
    BLOKACE(5, "Zablokovat účet"),
    ODBLOKACE(6, "Odblokovat účet"),
    VYPISINFO(7, "Vypsat všechny účty"),
    MAJETEK(8, "Zobrazit celkový majetek"),
    KONEC(9, "Ukončit program");

    private final int pozice;
    private final String popis;

    Menu(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }

    public int getPozice() {
        return pozice;
    }

    public String getPopis() {
        return popis;
    }
}
