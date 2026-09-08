package org.example;

public class Main {
    public static void main(String[] args) {

        boolean hlavniCyklus = true;
        InputHandler inputHandler = new InputHandler();
        DatabazeObjednavek databazeObjednavek = new DatabazeObjednavek();

        while (hlavniCyklus) {
            DatabazeObjednavek.vypisVolbyMenu();
            int volba = inputHandler.volbaPolozkyVMenu();

            switch (volba) {
                case 1 -> {
                    System.out.println("\n*** ZALOŽENÍ OBJEDNÁVKY ***");
                    int cisloObjednavky = inputHandler.zadaniCislaObjednavky();
                    String jmenoZakaznika = inputHandler.zadaniJmnenaZakaznika();
                    int hodnotaObjednavky = inputHandler.libovolnyKladnyInt();
                    databazeObjednavek.zalozObjednavku(cisloObjednavky, jmenoZakaznika, hodnotaObjednavky);
                    }
                case 2 -> {
                    if (databazeObjednavek.nejsouObjednavky()) {
                        continue;
                        }

                    databazeObjednavek.vypisVsechnyObjednávky();
                    }
                case 3 -> {
                    if (databazeObjednavek.nejsouObjednavky()) {
                        continue;
                    }

                    System.out.println("\n*** OBJEDNÁVKA ***");
                    int cisloHledaneObjednavky = inputHandler.zadaniCislaObjednavky();
                    databazeObjednavek.vypisKonkretniObjednávku(cisloHledaneObjednavky);
                    }
                case 4 -> {
                    if (databazeObjednavek.nejsouObjednavky()) {
                        continue;
                        }

                    System.out.println("\n*** ZMĚNA STAVU ***");
                    Objednavka nalezeno = null;
                    while (nalezeno == null) {
                        int cisloObjKeZmene = inputHandler.zadaniCislaObjednavky();
                        nalezeno = databazeObjednavek.overNalzeniCislaObjednavky(cisloObjKeZmene);
                    }

                    StavObejdnavky stavObjednavky = null;
                    while (true) {
                        DatabazeObjednavek.vypisStavyObjednavek();
                        stavObjednavky = inputHandler.volbaStavuObjednavky();
                        if (stavObjednavky != null) {
                            break;
                        }
                    }

                    databazeObjednavek.zmenStavObjednavky(nalezeno, stavObjednavky);
                }
                case 5 -> {
                    if (databazeObjednavek.nejsouObjednavky()) {
                        continue;
                        }

                    StavObejdnavky stavObjednavky = null;
                    while (true) {
                        DatabazeObjednavek.vypisStavyObjednavek();
                        stavObjednavky = inputHandler.volbaStavuObjednavky();
                        if (stavObjednavky != null) {
                            break;
                        }
                    }

                    databazeObjednavek.vypisVsechnyObjednávkyVeSpecifickemStavu(stavObjednavky);
                    }
                case 6 -> {
                    if (databazeObjednavek.nejsouObjednavky()) {
                        continue;
                        }
                    databazeObjednavek.hodnotaVsechObjednavek();
                    }
                case 7 -> {
                    System.out.println("Program je ukončen.");
                    hlavniCyklus = false;
                }
            }
        }
    }
}
