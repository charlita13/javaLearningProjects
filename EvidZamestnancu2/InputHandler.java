package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public int vyberPolozkyHlavnihoMenu() {
        while (true) {
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba > 0 && volba <= Menu.values().length) {
                    return volba;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Neplatná voba, vyberte si z číselné nabídky v hlavním menu.");
        }
    }

    public int intKladny(String popis) {
        System.out.println(popis);
        while (true) {
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba > 0) {
                    return volba;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println(popis + " (zadejte celé kladné číslo)");
        }
    }

    public String textTriZnakyPlus(String popis) {
        System.out.println(popis);
        while (true) {
            String text = scanner.nextLine();
            if (text.trim().length() >= 3) {
                return text;
            }
            System.out.println(popis + " (o minimální délce tři znaky)");
        }
    }

    public Oddeleni vyberOddeleni(String popis) {
        while (true) {
            PrehledZamestnancu.vypisNabidkuOddeleni();
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba > 0 && volba <= Oddeleni.values().length) {
                    return Oddeleni.dlePoziceVratOddeleni(volba);
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println(popis + " (vyberte z nabídky a vložte číslo ddělení)");
        }
    }

    public int vybeEditMenu(String popis) {
        while (true) {
            PrehledZamestnancu.vypisNabidkuEditMenu();
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba > 0 && volba <= EditMenu.values().length) {
                    return volba;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println(popis + " (vyberte z nabídky a vložte číslo operace)");
        }
    }
}




