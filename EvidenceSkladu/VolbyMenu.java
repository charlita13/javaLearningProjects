package org.example;

public enum VolbyMenu {
    PRIDAT(1, "Přidat nový produkt"),
    VYPIS_VSE(2, "Vypsat všechny produkty"),
    NAJDI_DLE_KODU(3, "Vyhledat produkt podle kódu"),
    PRIDEJ_KS_K_PrRODUKTU(4, "Přidat kusy produktu"),
    ODEBER_KS_OD_PRODUKTU(5, "Odebrat kusy produktu"),
    VYPIS_DLE_TYPU(6, "Vypsat produkty podle typu"),
    HODNOTA(7, "Zobrazit celkovou hodnotu skladu"),
    KONEC(8, "Konec");

    private int pozice;
    private String popis;

    VolbyMenu(int pozice, String popis) {
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
