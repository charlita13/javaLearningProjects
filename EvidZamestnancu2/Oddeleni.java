package org.example;

public enum Oddeleni {

    HR(1, "Lidské zdroje"),
    IT(2, "Vývoj a technická podpora"),
    FINANCE(3, "Účetní oddělení"),
    SALES(4, "Obchodní divize");

    private final int pozice;
    private final String popis;


    Oddeleni(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }

    public String getPopis() {
        return popis;
    }

    public int getPozice() {
        return pozice;
    }

    public static Oddeleni dlePoziceVratOddeleni(int zadanaPozice) {
        for (Oddeleni oddeleni : Oddeleni.values()) {
            if (oddeleni.pozice == zadanaPozice) {
                return oddeleni;
            }
        }
        return null;
    }
}
