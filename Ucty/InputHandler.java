package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public int menuCisloVolby() {
        while (true) {
            System.out.println("Zadejte číslo dle nabídky menu: ");
            try {
                int cislo = scanner.nextInt();
                scanner.nextLine();
                if (cislo > 0 && cislo <= Menu.values().length) {
                    return cislo;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    public String jakykoliStringTriPLus() {
        while (true) {
            String slovo = scanner.nextLine();
            if (slovo.length() >=  3) {
                return slovo;
            }
            System.out.println("Zadejte validní vstup o minimální délce 3 znaky: ");
        }
    }

    public String zadejCisloUctu() {
        int cisloPred = 0;
        int cisloZa = 0;

        System.out.println("Zadejte číslo účtu PŘED lomítkem: ");
        while (true) {
            try {
                cisloPred = scanner.nextInt();
                scanner.nextLine();
                if (cisloPred >= 100) {
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Číslo účtu nesmí začínat nulou a minimální délka jsou 3 číslice.");
        }

        System.out.println("Zadejte číslo účtu ZA lomítkem: ");
        while (true) {
            try {
                cisloZa = scanner.nextInt();
                scanner.nextLine();

                if (cisloZa > 999 && cisloZa <= 9999 ) {
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Kód banky musí být 4 číslice a nesmí začínat nulou.");
        }

        return cisloPred + "/" + cisloZa;
    }

    public int jednaNeboDva() {
        System.out.println("Zadejte číslo dle nabídky menu: ");
        while (true) {
            try {
                int cislo = scanner.nextInt();
                scanner.nextLine();
                if (cislo == 1 || cislo == 2) {
                    return cislo;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Zadejte číslo dle nabídky menu, 1 nebo 2.");
        }
    }

    public int kladnyIntObecne() {
        System.out.println("Zadejte svoji volbu: ");
        while (true) {
            try {
                int cislo = scanner.nextInt();
                scanner.nextLine();
                if (cislo > 0) {
                    return cislo;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Zadejte svoji volbu (kaldné celé číslo): ");
        }
    }

    public double sumaTransakceDouble() {
        System.out.println("Zadejte výši transakce: ");
        while (true) {
            try {
                double cislo = scanner.nextDouble();
                scanner.nextLine();
                if (cislo > 0) {
                    return cislo;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            System.out.println("Zadejte výši transakce: ");
        }
    }
}
