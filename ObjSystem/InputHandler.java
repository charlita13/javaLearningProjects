package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public int volbaPolozkyVMenu() {
        while (true) {
            System.out.println("Zadejte číselnou volbu v rozsahu nabídky menu: ");
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba > 0 && volba <= VolbyMenu.values().length) {
                    return volba;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    public int zadaniCislaObjednavky() {
        while (true) {
            System.out.println("Zadejte šestimístné číslo objednávky (nesmí začínat hodnotou 0): ");
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba >= 100000 && volba <= 999999) {
                    return volba;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    public String zadaniJmnenaZakaznika() {
        while (true) {
            System.out.println("Zadejte jméno zákazníka (minimální délka 4 znaky): ");
            String jmeno = scanner.nextLine();
            if (jmeno.trim().length() >= 4) {
                return jmeno;
            }
        }
    }

    public int libovolnyKladnyInt() {
        while (true) {
            System.out.println("Zadejte hodnotu objednávky (celé kladné číslo): ");
            try {
                int volba = scanner.nextInt();
                scanner.nextLine();
                if (volba >= 1) {
                    return volba;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }
        }
    }

    public StavObejdnavky volbaStavuObjednavky() {
        while (true) {
            System.out.println("Vyberte stav objednávky (zadejte jeho číselné označení): ");
            try {
                int pozice = scanner.nextInt();
                scanner.nextLine();
                if (pozice > 0 && pozice <= StavObejdnavky.values().length) {
                    return StavObejdnavky.vratStavObjednavkyDlePozice(pozice);
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            } catch (IndexOutOfBoundsException ee) {
                continue;
            }
        }
    }
}
