package org.example;

import javax.management.ObjectName;
import java.util.ArrayList;

public class DatabazeObjednavek {

    private ArrayList<Objednavka> seznamObjednavek = new ArrayList<Objednavka>();

    static void vypisVolbyMenu() {
        System.out.println("\nMENU");
        for (VolbyMenu volba : VolbyMenu.values()) {
            System.out.println(volba.pozice + " - " + volba.popis);
        }
    }

    static void vypisStavyObjednavek() {
        System.out.println("\nMOŽNÉ STAVY");
        for (StavObejdnavky stav : StavObejdnavky.values()) {
            System.out.println(stav.getPozice() + " - " + stav.getPopis());
        }
    }

    public void zalozObjednavku(int cisloObjednavky, String jmenoZakaznika, int hodnota) {
        Objednavka objednavka = new Objednavka(cisloObjednavky, jmenoZakaznika, hodnota);
        for (Objednavka objednavka1 : seznamObjednavek) {
            if (objednavka1.getCisloObjednavky() == objednavka.getCisloObjednavky()) {
                System.out.println("Duplicitní číslo objednávky, objednávka nebyla založena.");
                return;
            }
        }
        seznamObjednavek.add(objednavka);
        System.out.println("Byla založena nová objednávka číslo " + objednavka.getCisloObjednavky() + " v hodnotě " + objednavka.getCena() + " Kč.");
    }

    public void vypisVsechnyObjednávky() {
        System.out.println("\n*** PŘEHLED OBJEDNÁVEK ***");
        for (Objednavka objednavka : seznamObjednavek) {
            System.out.println("č. " + objednavka.getCisloObjednavky());
            System.out.println("zákanzník " + objednavka.getJmenoZakaznika());
            System.out.println("stav " + objednavka.getStav());
            System.out.println("cena " + objednavka.getCena() + " Kč");
            System.out.println("-------------------------------------------");
        }
    }

    public void vypisKonkretniObjednávku(int cisloObjednavky) {
        boolean nalezeno = false;
        for (Objednavka objednavka : seznamObjednavek) {
            if (objednavka.getCisloObjednavky() == cisloObjednavky) {
                nalezeno = true;
                System.out.println("\n*** DETAIL OBJEDNÁVKY č. " + objednavka.getCisloObjednavky() + " ***");
                System.out.println("zákazník " + objednavka.getJmenoZakaznika());
                System.out.println("stav " + objednavka.getStav());
                System.out.println("cena " + objednavka.getCena() + " Kč");
            }
        }
        if (!nalezeno) {
            System.out.println("Objednávka s číslem " + cisloObjednavky + " nebyla nalezena v seznamu objednávek.");
        }
    }

    public boolean nejsouObjednavky() {
        if (seznamObjednavek.isEmpty()) {
            System.out.println("Aktuálně nejsou založeny žádné objednávky.");
        }
        return seznamObjednavek.isEmpty();
    }

    public void zmenStavObjednavky(Objednavka objednavka, StavObejdnavky stav) {
        if (objednavka.getStav() == stav) {
            System.out.println("Objednávka je již v požadovaném stavu. Změnu nelze provést.");
        } else {
            System.out.println("Stav objednávky byl změněn z " + objednavka.getStav() + " na " + stav + ".");
            objednavka.setStav(stav);
        }
    }

    public Objednavka overNalzeniCislaObjednavky(int cisloObjednavky) {
        for (Objednavka objednavka : seznamObjednavek) {
            if (objednavka.getCisloObjednavky() == cisloObjednavky) {
                return objednavka;
            }
        }
        return null;
    }

    public void hodnotaVsechObjednavek() {
        int suma = 0;
        System.out.println("\n*** CELKOVÁ HODNOTA ***");

        for (Objednavka objednavka : seznamObjednavek) {
            suma+= objednavka.getCena();
        }
        System.out.println("Celková hodnota všech objednávek je " + suma + " Kč.");
    }

    public void vypisVsechnyObjednávkyVeSpecifickemStavu(StavObejdnavky stav) {
        System.out.println("\n*** PŘEHLED OBJEDNÁVEK ve stavu " + stav + " ***");
        boolean nalezena = false;
        for (Objednavka objednavka : seznamObjednavek) {
            if (objednavka.getStav() == stav) {
                System.out.println("č. " + objednavka.getCisloObjednavky());
                System.out.println("zákazník " + objednavka.getJmenoZakaznika());
                System.out.println("cena " + objednavka.getCena() + " Kč");
                System.out.println("-------------------------------------------");
                nalezena = true;
            }
        }
        if (!nalezena) {
            System.out.println("V tomto stavu neevidujeme aktuálně žádnou objednávku.");
        }
    }
}
