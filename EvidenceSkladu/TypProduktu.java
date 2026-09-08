package org.example;

public enum TypProduktu {
    ELEKTRONIKA(1, "Elektronika"),
    POTRAVINY(2, "Potraviny"),
    OBLECENI(3,"Oblečení"),
    NABYTEK(4, "Nábytek");

    final private int pozice;
    final private String popis;

    TypProduktu(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }

    public String getPopis() {
        return popis;
    }

    public int getPozice() {
        return pozice;
    }

    static void vypisTypyProduktu() {
        for (TypProduktu typ : TypProduktu.values()) {
            System.out.println(typ.getPozice() + " - " + typ.getPopis());
        }
    }

    static TypProduktu vratTypProduktuDlePozice(int poziceOdUsera) {
        for (TypProduktu typ : TypProduktu.values()) {
            if (typ.getPozice() == poziceOdUsera) {
                return typ;
            }
        }
        return null;
    }
}
