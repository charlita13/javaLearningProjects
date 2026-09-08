package org.example;

public enum VolbyMenu {

    VYTVOR(1, "Vytvořit novou objednávku"),
    VYPIS_VSECHNY(2, "Vypsat všechny objednávky"),
    VYHLEDAT(3, "Vyhledat objednávku podle čísla"),
    ZMENIT(4, "Změnit stav objednávky"),
    VYPIS_DLE_STAVU(5, "Vypsat objednávky v určitém stavu"),
    HODNOTA(6, "Zobrazit celkovou hodnotu objednávek"),
    KONEC(7, "Uončit program");

    final int pozice;
    final String popis;

    VolbyMenu(int pozice, String popis) {
        this.pozice = pozice;
        this.popis = popis;
    }
}
