package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public int volbaVMenu() {
        System.out.println("Vyberte si z nabídky menu (zadejte číselnou volbu): ");
        while (true) {
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();

                if (volba > 0 && volba <= VolbyMenu.values().length) {
                    return volba;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Neplatná volba, vyberte číselnou hodnotu dle nabídky menu.");
        }
    }

    public int kladnyInt(String otazka) {
        System.out.println(otazka);
        while (true) {
            System.out.println("Zadejte číselnou hodnotu (celé kladné číslo): ");

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
        }
    }

    public int kladnyIntBezOtazky() {
        while (true) {
            System.out.println("Zadejte číselnou hodnotu (celé kladné číslo): ");

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
        }
    }

    public String stringTriZnakyPlus(String otazka) {
        System.out.println(otazka);
        while (true) {
            System.out.println("Zadejte text o minimální délce 3 znaky.");

            String text = scanner.nextLine();
            if (text.length() >= 3) {
                return text;
            }
        }
    }

    public int intNulaAVic(String otazka) {
        System.out.println(otazka);
        while (true) {
            System.out.println("Zadejte nezápornou číselnou hodnotu: ");

            try {
                int volba = scanner.nextInt();
                scanner.nextLine();

                if (volba >= 0) {
                    return volba;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    public TypProduktu najdiProdukt(String otazka) {
        System.out.println(otazka);
        System.out.println("Zadejte číslo vybraného produktového typu: ");
        TypProduktu.vypisTypyProduktu();

        while (true) {
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();

                if (volba > 0 && volba <= TypProduktu.values().length) {
                    return TypProduktu.vratTypProduktuDlePozice(volba);
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Neplatná volba, vyberte číselnou hodnotu dle nabídky produktových typů.");
        }
    }
}
