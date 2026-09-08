package org.example;

public enum TypUctu {
    BEZNY(1, "Běžný bankovní účet se zákaldní úrokovou sazbou."),
    SPORICI(2, "Spořící účet se zvýhodněnou úrokovou sazbou.");

    private final int pozice;
    private final String popis;

    TypUctu(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }

    public String getPopis() {
        return popis;
    }

    public int getPozice() {
        return pozice;
    }

    public static TypUctu podlePozice(int pozice) {
        for (TypUctu typ : TypUctu.values()) {
            if (typ.getPozice() == pozice) {
                return typ;
            }
        }
        return null;
    }
}
