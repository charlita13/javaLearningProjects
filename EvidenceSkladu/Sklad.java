package org.example;

import java.util.HashMap;

public class Sklad {

    private final HashMap<Integer, Produkt> skladoveZasoby = new HashMap<>();

    static void vypisVolbyMenu() {
        System.out.println("\nMENU");
        for (VolbyMenu volba : VolbyMenu.values()) {
            System.out.println(volba.getPozice() + " - " +  volba.getPopis());
        }
    }

    public void pridejNovyProdukt(int kod, String jmeno, int cena, int ks, TypProduktu typ) {
        Produkt produkt = new Produkt(kod, jmeno, cena, ks, typ);
        skladoveZasoby.put(kod, produkt);
        System.out.println("Byl založen nový produkt " + jmeno + ". Evidováno " + ks + " ks, cena za 1 kus činí " + cena + " Kč.");
    }

    public boolean jeKodUnikatni(int pozadovanyKod) {
        if (skladoveZasoby.containsKey(pozadovanyKod)) {
            System.out.println("Tento kód již existuje. Kód musí být unikátní!");
        }
        return !skladoveZasoby.containsKey(pozadovanyKod);
    }

    public void vypisVsechnyProdukty() {
        if (skladoveZasoby.isEmpty()) {
            System.out.println("Aktuálně nejsou naskladněny žádné produkty.");
            return;
        }

        System.out.println("\n*** VÝPIS VŠECH PRODUKTŮ ***");
        for (Produkt produkt : skladoveZasoby.values()) {
            System.out.println("Kód: " + produkt.getKodProduktu());
            System.out.println("Název: " + produkt.getNazev());
            System.out.println("Počet kusů: " + produkt.getPocetKusu());
            System.out.println("Cena za kus: " + produkt.getCena());
            System.out.println("Typ: " + produkt.getTyp().getPopis());
            System.out.println("----------------------------------------");
        }
    }

    public boolean jeSkladPrazdny() {
        return skladoveZasoby.isEmpty();
    }

    public void hlaskaNaPrazdnySklad() {
        System.out.println("Aktuálně nejsou naskladněny žádné produkty.");

    }

    public boolean nalezenKodProduktu(int kodOdUzivatele) {
            return skladoveZasoby.containsKey(kodOdUzivatele);
    }

    public void hlaskaNaNernalezenyKod() {
        System.out.println("Kód produktu nebyl nalezen.");
    }

    public void vypisProduktDleKodu(int kodOdUzivatele) {
        if (skladoveZasoby.isEmpty()) {
            System.out.println("Aktuálně nejsou naskladněny žádné produkty.");
            return;
        }

        if (!skladoveZasoby.containsKey(kodOdUzivatele)) {
            System.out.println("Produkt s tímto kódem není evidován na skladě.");
        }

        Produkt produkt = skladoveZasoby.get(kodOdUzivatele);
        System.out.println("\n*** DETAIL PRODUKTU ***");
        System.out.println("Kód: " + produkt.getKodProduktu());
        System.out.println("Název: " + produkt.getNazev());
        System.out.println("Počet kusů: " + produkt.getPocetKusu());
        System.out.println("Cena za kus: " + produkt.getCena());
        System.out.println("Typ: " + produkt.getTyp().getPopis());
    }

    public void navysKsNaProduktu(int kodProduktu, int pocetKs) {
        if (skladoveZasoby.isEmpty()) {
            System.out.println("Aktuálně nejsou naskladněny žádné produkty.");
            return;
        }

        System.out.println("\n*** NAVÝŠENÍ KS U PRODUKTU ***");
        Produkt produkt = skladoveZasoby.get(kodProduktu);
        System.out.println("U produktu " + produkt.getNazev() + " došlo ke změně skladových zásob.\nPůvodní stav: " + produkt.getPocetKusu() + "\nNavýšeno o ks: " + pocetKs + "\nNový stav: " + (produkt.getPocetKusu() + pocetKs));
        produkt.setPocetKusu(produkt.getPocetKusu() + pocetKs);
    }

    public void snizKsNaProduktu(int kodProduktu, int pocetKs) {
        if (skladoveZasoby.isEmpty()) {
            System.out.println("Aktuálně nejsou naskladněny žádné produkty.");
            return;
        }

        System.out.println("\n*** SNÍŽENÍ KS U PRODUKTU ***");
        Produkt produkt = skladoveZasoby.get(kodProduktu);
        if ((produkt.getPocetKusu() - pocetKs) < 0) {
            System.out.println("Vyskaldnění nelze provést, produkt nemá dostatek kusů pro vyskladnění.");
            return;
        }

        System.out.println("U produktu " + produkt.getNazev() + " došlo ke změně skladových zásob.\nPůvodní stav: " + produkt.getPocetKusu() + "\nSníženo o ks: " + pocetKs + "\nNový stav: " + (produkt.getPocetKusu() - pocetKs));
        produkt.setPocetKusu(skladoveZasoby.get(kodProduktu).getPocetKusu() - pocetKs);
    }

    public void vypisHodnotuSkladu() {
        if (skladoveZasoby.isEmpty()) {
            System.out.println("Aktuálně nejsou naskladněny žádné produkty.");
            return;
        }
        long hodnota = 0;
        for (Produkt produkt : skladoveZasoby.values()) {
            long mezisoucet = (long) produkt.getCena() * produkt.getPocetKusu();
            hodnota+=mezisoucet;
        }
        System.out.println("Hodnota skladu je " + hodnota + " Kč");
    }

    public void vypisProduktDleTypu(TypProduktu typProduktu) {
        if (skladoveZasoby.isEmpty()) {
            System.out.println("Aktuálně nejsou naskladněny žádné produkty.");
            return;
        }

        boolean nalezeno = false;
        System.out.println("\n*** DETAIL PRODUKTŮ DLE TYPU ***");
        for (Produkt produkt : skladoveZasoby.values()) {
            if (produkt.getTyp().equals(typProduktu)) {
                nalezeno = true;
                System.out.println("Kód: " + produkt.getKodProduktu());
                System.out.println("Název: " + produkt.getNazev());
                System.out.println("Počet kusů: " + produkt.getPocetKusu());
                System.out.println("Cena za kus: " + produkt.getCena());
                System.out.println("Typ: " + produkt.getTyp().getPopis());
                System.out.println("----------------------------------------");
            }
        }
        if (!nalezeno) {
            System.out.println("Nebyl nalezen produkt s tímto typem.");
        }
    }
}
