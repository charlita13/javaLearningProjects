package org.example;

import java.util.ArrayList;

public class EvidenceUctu {

    private ArrayList<Ucet> vsechnyUcty = new ArrayList<>();

    static void vypisMenu() {
        System.out.println("\nMENU");
        for (Menu m : Menu.values()) {
            System.out.println(m.getPozice() + " - " + m.getPopis());
        }
    }

    static void vypisUcty() {
        System.out.println("Vyberte účet, zadejte jeho čísené označení:");
        for (TypUctu tu : TypUctu.values()) {
            System.out.println(tu.getPozice() + " " + tu.getPopis());
        }
    }

    public void zalozUcet(String cislo, String jmeno, TypUctu typ) {
        Ucet ucet = new Ucet(cislo, jmeno, typ);

        for (Ucet ucet1 : vsechnyUcty) {
            if (ucet.getCisloUctu().equals(ucet1.getCisloUctu())) {
                System.out.println("Duplicitní číslo účtu, nelze zadat nový účet s tímto číslem.");
                return;
            }
        }

        vsechnyUcty.add(ucet);
        System.out.println("Byl založen nový účet\nMajitel: :" + jmeno + "\nČíslo: " + cislo + "\nTyp: " + typ + "\nAktivní: " + ucet.getStavUctu() + "\nZůstatek: " + ucet.getZustatek());
    }

    public void vypisVsechnyUcty() {
        if (vsechnyUcty.isEmpty()) {
            System.out.println("Aktuálně nejsou založeny žádné účty.");
            return;
        }
        System.out.println("Aktuální seznam účtů");
        for (Ucet u : vsechnyUcty) {
            System.out.println("-------------------------------------------");
            System.out.println((vsechnyUcty.indexOf(u) + 1) + ". účet");
            System.out.println("Majitel: :" + u.getJmenoMajitele() + "\nČíslo: " + u.getCisloUctu() + "\nTyp: " + u.getTypUctu() + "\nStav účtu: " + u.getStavUctu() + "\nZůstatek: " + u.getZustatek());
        }
    }

    public boolean prevodDotazNaVhodneUcty() {
        int pocetAktivnich = 0;
        int seZustatkem = 0;
        int pozice = 1;

        for (Ucet uc : vsechnyUcty) {
            if (uc.getStavUctu() == StavUctu.AKTIVNI) {
                pocetAktivnich++;
                if (uc.getZustatek() > 0) {
                    seZustatkem++;
                }
                if (pocetAktivnich >= 2 && seZustatkem >= 1) {
                    System.out.println("Vyberte z kterého  účtu chcete provést převod.");
                    for (Ucet uce : vsechnyUcty) {
                        if (uce.getStavUctu() == StavUctu.AKTIVNI) {
                            System.out.println(pozice + " || " + uce.getJmenoMajitele() + " || " + uce.getCisloUctu() + " || " + uce.getTypUctu() + " || " + uce.getZustatek());
                            pozice++;
                        }
                    }
                    return true;
                }
            }
        }
        if (pocetAktivnich <= 1 || seZustatkem == 0) {
            System.out.println("Nebyly nalezeny alespoň 2 aktnivní účty, z nichž jeden má kladný zůstatek.");
        }
        return false;
    }

    public boolean vkladDotazNaVhodneUcty() {
        int pozice = 1;
        boolean jeCoVypsat = false;

        for (Ucet u : vsechnyUcty) {
            if (u.getStavUctu() == StavUctu.AKTIVNI) {
                jeCoVypsat = true;

                if (jeCoVypsat) {
                    System.out.println("Seznam aktivních účtů:");
                    for (Ucet uc : vsechnyUcty) {
                        if (uc.getStavUctu() == StavUctu.AKTIVNI) {
                            System.out.println(pozice + " || " + uc.getJmenoMajitele() + " || " + uc.getCisloUctu() + " || " + uc.getTypUctu() + " || " + uc.getZustatek());
                            pozice++;
                        }
                    }
                    return true;
                }
            }
        }
        System.out.println("Nebyl nalezen žádný aktivní účet.");
        return false;
    }

    public boolean vyberDotazNaVhodneUcty() {
        int pozice = 1;
        boolean jeCoVypsat = false;

        for (Ucet u : vsechnyUcty) {
            if (u.getStavUctu() == StavUctu.AKTIVNI && u.getZustatek() > 0) {
                jeCoVypsat = true;

                if (jeCoVypsat) {
                    System.out.println("Seznam aktivních účtů:");

                    for (Ucet uc : vsechnyUcty) {
                        if (uc.getStavUctu() == StavUctu.AKTIVNI) {
                            System.out.println(pozice + " || " + uc.getJmenoMajitele() + " || " + uc.getCisloUctu() + " || " + uc.getTypUctu() + " || " + uc.getZustatek());
                            pozice++;
                        }
                    }
                    return true;
                }
            }
        }
        System.out.println("Nebyl nalezen žádný aktivní účet se zůstatkem.");
        return false;
    }

    public void provedeniVkladu(double suma, Ucet ucet) {
        ucet.vkladNaUcet(suma);
        System.out.println("Zůstatek účtu " + ucet.getCisloUctu() + " byl navýšen o " + suma + " na " + ucet.getZustatek());
    }

    public Ucet nalezeniSpravnehoUctu(int poziceUctu) {
        try {
            return vsechnyUcty.get(poziceUctu - 1);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Účet nenalezen. Zadejte číslo/pořadí účtu: ");
        }
        return null;
    }

    public Ucet nalezeniSpravnehoAktivnihoUctu(int poziceUctu) {
        int nalezen = 0;
        for (Ucet ucet : vsechnyUcty) {
            if (ucet.getStavUctu() == StavUctu.AKTIVNI) {
                nalezen++;
                if (nalezen == poziceUctu) {
                    try {
                        return ucet;
                    } catch (IndexOutOfBoundsException i) {
                        System.out.println("Účet nenalezen. Zadejte číslo/pořadí účtu: ");
                    }
                }
            }
        }
        return null;
    }

    public Ucet nalezeniSpravnehoBlokovanehoUctu(int poziceUctu) {
        int nalezen = 0;
        for (Ucet ucet : vsechnyUcty) {
            if (ucet.getStavUctu() == StavUctu.BLOKOVANY) {
                nalezen++;
                if (nalezen == poziceUctu) {
                    try {
                        return ucet;
                    } catch (IndexOutOfBoundsException i) {
                        System.out.println("Účet nenalezen. Zadejte číslo/pořadí účtu: ");
                    }
                }
            }
        }
        return null;
    }

    public void vyberHotovosti(double suma, Ucet ucet) {
        if (ucet.getZustatek() >= suma) {
            ucet.vyberUcet(suma);
            System.out.println("Zůstatek účtu " + ucet.getCisloUctu() + " byl snížen o " + suma + " na " + ucet.getZustatek());
        }
        else {
            System.out.println("Výběr nelze provést, na účtu není dostatečný zůstatek.");
        }
    }

    public void prevodMeziUcty(double suma, Ucet ponizenyUcet, Ucet povysenyUcet) {
        if (ponizenyUcet.getZustatek() >= suma) {
            ponizenyUcet.vyberUcet(suma);
            povysenyUcet.vkladNaUcet(suma);
            System.out.println("Suma " + suma + " byla převedena mezi účty.");
        }
        else {
            System.out.println("Transakci nelze provést, na účtu není dostatečný zůstatek.");
        }
    }

    public void zmenStavNaBlokovany(Ucet ucet) {
        if (ucet.getStavUctu() == StavUctu.BLOKOVANY) {
            System.out.println("Tento účet již je blokovaný.");
        } else {
            ucet.setStavUctu(StavUctu.BLOKOVANY);
            System.out.println("Účet je nastaven na BLKOVANY");
        }
    }

    public void zmenStavNaAktivni(Ucet ucet) {
        if (ucet.getStavUctu() == StavUctu.AKTIVNI) {
            System.out.println("Tento účet již je aktivní.");
        } else {
            ucet.setStavUctu(StavUctu.AKTIVNI);
            System.out.println("Účet je nastaven na AKTIVNI");
        }
    }

    public boolean jeBlkovanyUcet() {
        int pozice = 1;
        boolean jeCoVypsat = false;

        for (Ucet u : vsechnyUcty) {
            if (u.getStavUctu() == StavUctu.BLOKOVANY) {
                jeCoVypsat = true;

                if (jeCoVypsat) {
                    System.out.println("Seznam blokovaných účtů:");
                    for (Ucet uc : vsechnyUcty) {
                        if (uc.getStavUctu() == StavUctu.BLOKOVANY) {

                        System.out.println(pozice + " || " + uc.getJmenoMajitele() + " || " + uc.getCisloUctu() + " || " + uc.getTypUctu() + " || " + uc.getZustatek());
                        pozice++;
                        }
                    }
                    return true;
                }
            }
        }
        System.out.println("Nebyl nalezen žádný blokovaný účet.");
        return false;
    }

    public void vypisHodnotuVsechUctu() {
        double suma = 0;
        for (Ucet ucet : vsechnyUcty) {
            suma+=ucet.getZustatek();
        }
        System.out.println("Celková hodnota na všech účtech je " + suma + " Kč");
    }
}
