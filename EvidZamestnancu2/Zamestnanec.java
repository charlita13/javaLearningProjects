package org.example;

public class Zamestnanec {

    private final int ID;   // UNIKATNI
    private String jmeno;
    private Oddeleni oddeleni;
    private int plat;

    public Zamestnanec(int id, String jmeno, Oddeleni oddeleni, int plat) {
        this.ID = id;
        this.jmeno = jmeno;
        this.oddeleni = oddeleni;
        this.plat = plat;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getID() {
        return ID;
    }

    public int getPlat() {
        return plat;
    }

    public Oddeleni getOddeleni() {
        return oddeleni;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setOddeleni(Oddeleni oddeleni) {
        this.oddeleni = oddeleni;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }
}
