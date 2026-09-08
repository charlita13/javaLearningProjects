package org.example;

public class Main {
    public static void main(String[] args) {

        boolean behProgramu = true;
        InputHandler inputHandler = new InputHandler();
        EvidenceUctu evidenceUctu = new EvidenceUctu();

        while (behProgramu) {
            EvidenceUctu.vypisMenu();
            int volba = inputHandler.menuCisloVolby();

            switch (volba) {
                case 1 -> {
                    String cisloUCtu = inputHandler.zadejCisloUctu();

                    System.out.println("Zadejte jméno majitele účtu: ");
                    String jmenoMajitele = inputHandler.jakykoliStringTriPLus();

                    EvidenceUctu.vypisUcty();
                    int typ = inputHandler.jednaNeboDva();
                    TypUctu typUctu = TypUctu.podlePozice(typ);

                    evidenceUctu.zalozUcet(cisloUCtu, jmenoMajitele, typUctu);
                }
                case 2 -> {
                    boolean jeAktivniProVklad = evidenceUctu.vkladDotazNaVhodneUcty();
                    if (jeAktivniProVklad) {
                        Ucet ucet = null;

                        while (ucet == null) {
                            int indexUctu = inputHandler.kladnyIntObecne();
                            ucet = evidenceUctu.nalezeniSpravnehoAktivnihoUctu(indexUctu);
                        }

                        double castka = inputHandler.sumaTransakceDouble();
                        evidenceUctu.provedeniVkladu(castka, ucet);
                    }
                }
                case 3 -> {
                    boolean jeAktivniProVyber = evidenceUctu.vyberDotazNaVhodneUcty();
                    if (jeAktivniProVyber) {
                        Ucet ucet = null;

                        while (ucet == null) {
                            int indexUctu = inputHandler.kladnyIntObecne();
                            ucet = evidenceUctu.nalezeniSpravnehoAktivnihoUctu(indexUctu);
                        }

                        double castka = inputHandler.sumaTransakceDouble();
                        evidenceUctu.vyberHotovosti(castka, ucet);
                    }
                }
                case 4 -> {
                    boolean nalezenyDvaAktivni = evidenceUctu.prevodDotazNaVhodneUcty();
                    if (nalezenyDvaAktivni) {
                        Ucet ucetPonizeny = null;
                        Ucet ucetPovyseny = null;
                        int indexUctuPoniz = 0;
                        int indexUctuPovys = 0;

                        while (ucetPonizeny == null) {
                            System.out.println("Účet Z kterého posíláme finance");
                            indexUctuPoniz = inputHandler.kladnyIntObecne();
                            ucetPonizeny = evidenceUctu.nalezeniSpravnehoAktivnihoUctu(indexUctuPoniz);
                        }

                        while (ucetPovyseny == null) {
                            System.out.println("Účet NA který posíláme finance");
                            indexUctuPovys = inputHandler.kladnyIntObecne();
                            if (indexUctuPovys == indexUctuPoniz) {
                                System.out.println("Nelze vybrat stejný účet jako příjemce i odesílatele");
                                continue;
                            }
                            ucetPovyseny = evidenceUctu.nalezeniSpravnehoAktivnihoUctu(indexUctuPovys);
                        }

                        double castka = inputHandler.sumaTransakceDouble();
                        evidenceUctu.prevodMeziUcty(castka, ucetPonizeny, ucetPovyseny);
                        }
                    }
                case 5 -> {
                    boolean jeAktivniProVklad = evidenceUctu.vkladDotazNaVhodneUcty();
                    if (jeAktivniProVklad) {
                        Ucet ucet = null;

                        while (ucet == null) {
                            int indexUctu = inputHandler.kladnyIntObecne();
                            ucet = evidenceUctu.nalezeniSpravnehoAktivnihoUctu(indexUctu);
                        }

                        evidenceUctu.zmenStavNaBlokovany(ucet);
                    }
                }
                case 6 -> {
                    boolean jeBlokovany = evidenceUctu.jeBlkovanyUcet();
                    if (jeBlokovany) {
                        Ucet ucet = null;

                        while (ucet == null) {
                            int indexUctu = inputHandler.kladnyIntObecne();
                            ucet = evidenceUctu.nalezeniSpravnehoBlokovanehoUctu(indexUctu);
                        }

                        evidenceUctu.zmenStavNaAktivni(ucet);
                    }
                }
                case 7 -> {
                    evidenceUctu.vypisVsechnyUcty();
                }
                case 8 -> {
                    evidenceUctu.vypisHodnotuVsechUctu();
                }
                case 9 -> {
                    System.out.println("Program je ukončen.");
                    behProgramu = false;
                }
                default -> System.out.println("Chybná volba! Zadejte číslo dle nabídky menu:");
            }
        }
    }
}
