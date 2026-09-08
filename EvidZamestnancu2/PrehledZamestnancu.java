package org.example;

import java.util.HashMap;

public class PrehledZamestnancu {

    HashMap<Integer, Zamestnanec> zamestnanci = new HashMap<>();

    static void vypisNabidkuMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getPozice() + " - " + menu.getPopis());
        }
    }

    static void vypisNabidkuEditMenu() {
        for (EditMenu editMenu : EditMenu.values()) {
            System.out.println(editMenu.getPozice() + " - " + editMenu.getPopis());
        }
    }

    static void vypisNabidkuOddeleni() {
        for (Oddeleni oddeleni : Oddeleni.values()) {
            System.out.println(oddeleni.getPozice() + " - " + oddeleni.getPopis());
        }
    }

    public void zalozeniNovehoZamestnance(int ID, String jmeno, Oddeleni oddeleni, int plat) {
        Zamestnanec zamestnanec = new Zamestnanec(ID, jmeno, oddeleni, plat);
        zamestnanci.put(zamestnanec.getID(), zamestnanec);
        System.out.println("Byl založen nový zaměstnanec: " + jmeno + "; ID " + ID + "; oddělení " + oddeleni + "; plat " + plat);
        System.out.println();
    }

    public boolean jeZadaneIDJizPouzito(int IDzamestnance) {
        return zamestnanci.containsKey(IDzamestnance);
    }

    public boolean existujeZamestnanec() {
        return !zamestnanci.isEmpty();
    }

    public void hlaskaKdyzNejsouZamesnatnanci() {
        if (!existujeZamestnanec()) {
            System.out.println("Aktuálně není v databázi evidován žádný zaměstnanec");
            System.out.println();
        }
    }

    public void vypisVse() {
        System.out.println("*** VYPSÁNÍ VŠECH ZAMĚSTNANCŮ ***");
        if (!existujeZamestnanec()) {
            hlaskaKdyzNejsouZamesnatnanci();
        }
        for (Zamestnanec zamestnanec : zamestnanci.values()) {
            System.out.println("Jméno: " + zamestnanec.getJmeno());
            System.out.println("ID: " + zamestnanec.getID());
            System.out.println("Oddělení: " + zamestnanec.getOddeleni());
            System.out.println("Plat: " + zamestnanec.getPlat());
            System.out.println("-------------------------------");
        }
        System.out.println();
    }

    public void ukazDetailZamestnance(int validniID) {
        Zamestnanec zamestnanec = zamestnanci.get(validniID);

        System.out.println("Jméno: " + zamestnanec.getJmeno());
        System.out.println("ID: " + zamestnanec.getID());
        System.out.println("Oddělení: " + zamestnanec.getOddeleni());
        System.out.println("Plat: " + zamestnanec.getPlat());
    }

    public void smazZamestnance(int validniID) {
        zamestnanci.remove(validniID);
        System.out.println("Zaměstnanec byl smazán z evidence");
    }

    public void upravJmeno(int validniID, String jmeno) {
        Zamestnanec zamestnanec = zamestnanci.get(validniID);
        zamestnanec.setJmeno(jmeno);
        System.out.println("Jméno zaměstnance bylo změněno");
    }

    public void upravPlat(int validniID, int plat) {
        Zamestnanec zamestnanec = zamestnanci.get(validniID);
        zamestnanec.setPlat(plat);
        System.out.println("Plat zaměstnance byl změněn");
    }

    public void upravOddeleni(int validniID, Oddeleni oddeleni) {
        Zamestnanec zamestnanec = zamestnanci.get(validniID);
        zamestnanec.setOddeleni(oddeleni);
        System.out.println("Oddělení zaměstnance bylo změněno");
    }

    public void vypisDleOddeleni(Oddeleni oddeleni) {
        boolean nalezeno = false;
        for (Zamestnanec zamestnanec : zamestnanci.values()) {
            if (zamestnanec.getOddeleni() == oddeleni) {
                nalezeno = true;
                System.out.println("Jméno: " + zamestnanec.getJmeno());
                System.out.println("ID: " + zamestnanec.getID());
                System.out.println("Oddělení: " + zamestnanec.getOddeleni());
                System.out.println("Plat: " + zamestnanec.getPlat());
                System.out.println("-------------------------------");
            }
        }
        if (!nalezeno) {
            System.out.println("Nebyl nalezen žádný zaměstnanec pro toto oddělení");
        }
        System.out.println();
    }
}
