package org.example;

public enum Menu {

    PRIDAT(1, "Přidání zaměstnance"),
    VYPIS_VSE(2, "Výpis všech zaměstnanců"),
    NAJIT_DLE_ID(3, "Vyhledání zaměstnance dle ID"),
    SMAZAT_DLE_ID(4, "Odstranění zaměstnance dle ID"),
    ZMENIT(5, "Změna údajů zaměstnance"),
    VYPIS_ODDELENI(6, "Vypsat zaměstnance podle oddělení"),
    KONEC(7, "Ukončení programu");

    private final int pozice;
    private final String popis;

    Menu(int pozice, String popis) {
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
