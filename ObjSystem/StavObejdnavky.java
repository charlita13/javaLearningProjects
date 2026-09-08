package org.example;

public enum StavObejdnavky {

    NOVA(1, "Nově založená objednávka."),
    ZPRACOVAVANA(2, "Objednávka zpracována."),
    ODESLANA(3, "Objednávka odeslána."),
    ZRUSENA(4, "Objednávka zrušena.");

    private final int pozice;
    private final String popis;

    StavObejdnavky(int pozice, String popis) {
        this.popis = popis;
        this.pozice = pozice;
    }

    public int getPozice() {
        return pozice;
    }

    public String getPopis() {
        return popis;
    }

    public static StavObejdnavky vratStavObjednavkyDlePozice(int poziceOdUsera) {
        for (StavObejdnavky stav : StavObejdnavky.values()) {
            if (poziceOdUsera == stav.getPozice()) {
                return stav;
            }
        }
        return null;
    }
}
