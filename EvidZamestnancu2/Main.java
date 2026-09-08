package org.example;

public class Main {
    public static void main(String[] args) {

        PrehledZamestnancu prehledZamestnancu = new PrehledZamestnancu();
        InputHandler inputHandler = new InputHandler();
        boolean hlavniCyklus = true;

        while (hlavniCyklus) {

            PrehledZamestnancu.vypisNabidkuMenu();
            int volba = inputHandler.vyberPolozkyHlavnihoMenu();

            switch (volba) {
                case 1 -> {
                    System.out.println("\n*** ZALOŽENÍ NOVÉHO ZAMĚSTNANCE ***");

                    int IDzamestanance;
                    while (true) {
                        IDzamestanance = inputHandler.intKladny("Vložte unikántí ID zaměstnance");
                        if (!prehledZamestnancu.jeZadaneIDJizPouzito(IDzamestanance)) {
                            break;
                        }
                    }
                    String jmeno = inputHandler.textTriZnakyPlus("Vložte jméno zaměstnance:");
                    Oddeleni oddeleni = inputHandler.vyberOddeleni("Vyberte oddělení zaměstnance:");
                    int plat = inputHandler.intKladny("Vložte výši platu: ");

                    prehledZamestnancu.zalozeniNovehoZamestnance(IDzamestanance, jmeno, oddeleni, plat);
                }
                case 2 -> {
                    prehledZamestnancu.vypisVse();
                }
                case 3 -> {
                    System.out.println("\n*** VYHLEDÁNÍ ZAMĚSTNANCE DLE ID ***");

                    if (!prehledZamestnancu.existujeZamestnanec()) {
                        prehledZamestnancu.hlaskaKdyzNejsouZamesnatnanci();
                        break;
                    }

                    int validniID = IDcheckerPositive(inputHandler, prehledZamestnancu);
                    prehledZamestnancu.ukazDetailZamestnance(validniID);
                }
                case 4 -> {
                    System.out.println("\n*** SMAZANI ZAMĚSTNANCE DLE ID ***");

                    if (!prehledZamestnancu.existujeZamestnanec()) {
                        prehledZamestnancu.hlaskaKdyzNejsouZamesnatnanci();
                        break;
                    }

                    int validniID = IDcheckerPositive(inputHandler, prehledZamestnancu);
                    prehledZamestnancu.smazZamestnance(validniID);
                }
                case 5 -> {
                    System.out.println("\n*** EDITACE ZAMĚSTNANCE DLE ID ***");

                    if (!prehledZamestnancu.existujeZamestnanec()) {
                        prehledZamestnancu.hlaskaKdyzNejsouZamesnatnanci();
                        break;
                    }

                    int validniID = IDcheckerPositive(inputHandler, prehledZamestnancu);
                    int operace = inputHandler.vybeEditMenu("Položka k editaci: ");
                    switch (operace) {
                        case 1 -> {
                            String jmeno = inputHandler.textTriZnakyPlus("Vložte nové jméno zaměstnance:");
                            prehledZamestnancu.upravJmeno(validniID, jmeno);
                        }
                        case 2 -> {
                            Oddeleni oddeleni = inputHandler.vyberOddeleni("Vyberte nové oddělení zaměstnance:");
                            prehledZamestnancu.upravOddeleni(validniID, oddeleni);
                        }
                        case 3 -> {
                            int plat = inputHandler.intKladny("Vložte novou výši platu: ");
                            prehledZamestnancu.upravPlat(validniID, plat);
                        }
                    }
                }
                case 6 -> {
                    System.out.println("*** VYPSÁNÍ ZAMĚSTNANCŮ Z ODDĚLENÍ ***");
                    if (!prehledZamestnancu.existujeZamestnanec()) {
                        prehledZamestnancu.hlaskaKdyzNejsouZamesnatnanci();
                        break;
                    }

                    Oddeleni oddeleni = inputHandler.vyberOddeleni("Vyberte oddělení:");
                    prehledZamestnancu.vypisDleOddeleni(oddeleni);
                }
                case 7 -> {
                    System.out.println("Ukončení programu");
                    hlavniCyklus = false;
                }
                default -> System.out.println("Chybná volba, opakujte zadání.");
            }
        }
    }

    static int IDcheckerPositive (InputHandler inputHandler, PrehledZamestnancu prehledZamestnancu) {
        int IDzamestnance;
        while (true) {
            IDzamestnance = inputHandler.intKladny("Vložte unikántí ID zaměstnance");
            if (prehledZamestnancu.jeZadaneIDJizPouzito(IDzamestnance)) {
                return IDzamestnance;
            }
            System.out.println("Zaměstnanec nenalezen, zkuste to znovu");
        }
    }
}
