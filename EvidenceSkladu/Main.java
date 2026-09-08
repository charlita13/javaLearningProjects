package org.example;

public class Main {
    public static void main(String[] args) {

        Sklad sklad = new Sklad();
        InputHandler inputHandler = new InputHandler();
        boolean hlavniCyklus = true;

        while (hlavniCyklus) {

            Sklad.vypisVolbyMenu();
            int menuVolba = inputHandler.volbaVMenu();

            switch (menuVolba) {
                case 1 -> {

                    System.out.println("\n*** PŘIDÁNÍ PRODUKTU ***");

                    int kodProduktu = inputHandler.kladnyInt("Kód: ");
                    while (!sklad.jeKodUnikatni(kodProduktu)) {
                        kodProduktu = inputHandler.kladnyIntBezOtazky();
                    }
                    String nazevProduktu = inputHandler.stringTriZnakyPlus("Název: ");
                    int cenaZaKus = inputHandler.kladnyInt("Cena za KS: ");
                    int pocetKS = inputHandler.kladnyInt("Počet KS: ");
                    TypProduktu typ = inputHandler.najdiProdukt("Typ: ");

                    sklad.pridejNovyProdukt(kodProduktu, nazevProduktu, cenaZaKus, pocetKS, typ);

                }
                case 2 -> {
                    sklad.vypisVsechnyProdukty();
                }
                case 3 -> {
                    int kodProduktu = inputHandler.kladnyInt("Kód: ");
                    while (!sklad.nalezenKodProduktu(kodProduktu)) {
                        sklad.hlaskaNaNernalezenyKod();
                        kodProduktu = inputHandler.kladnyInt("Kód: ");
                    }

                    sklad.vypisProduktDleKodu(kodProduktu);
                }
                case 4 -> {
                    int kodProduktu = inputHandler.kladnyInt("Kód: ");
                    while (!sklad.nalezenKodProduktu(kodProduktu)) {
                        sklad.hlaskaNaNernalezenyKod();
                        kodProduktu = inputHandler.kladnyInt("Kód: ");
                    }

                    int ks = inputHandler.kladnyInt("Počet ks k naskladnění:");
                    sklad.navysKsNaProduktu(kodProduktu, ks);
                }
                case 5 -> {
                    int kodProduktu = inputHandler.kladnyInt("Kód: ");
                    while (!sklad.nalezenKodProduktu(kodProduktu)) {
                        sklad.hlaskaNaNernalezenyKod();
                        kodProduktu = inputHandler.kladnyInt("Kód: ");
                    }

                    int ks = inputHandler.kladnyInt("Počet ks k vyskladnění:");
                    sklad.snizKsNaProduktu(kodProduktu, ks);
                }
                case 6 -> {
                    TypProduktu typ = inputHandler.najdiProdukt("Typ: ");
                    sklad.vypisProduktDleTypu(typ);
                }
                case 7 -> {
                    sklad.vypisHodnotuSkladu();
                }
                case 8 -> {
                    System.out.println("\n*** KONEC PROGRAMU ***");
                    hlavniCyklus = false;
                }
            }
        }
    }
}
