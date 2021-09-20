import nieruchomosci.*;
import podmioty.osoba;
import przedmioty.*;
import watki.czasowy;
import watki.kalendarz;
import watki.kontrolny;
import wyjatki.ProblematicTenantException;
import wyjatki.TooManyThingsException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
AUTOR PROJEKTU: OLAF LUDWIG W RAMACH STUDIÓW NA PJATK NR. STUDENTA S21265

NAZWA: PROGRAM DO ZARZADZANIA OSIEDLEM MIESZKANIOWYM

PROGRAM IMPLEMENTUJE WSZYSTKIE FUNCKJE WSKAZANE W ZALOZENIACH PROJEKTOWYCH!

STEROWANIE NINIEJSZYM PROGRAMEM ODBYWA SIE ZA POMOCA WPISYWANIA W KONSOLI LICZB CALKOWITYCH, KTORYCH WARTOSCI
ODPOWIADAJA POSZCZEGOLNYM FUNKCJOM PROGRAMU I SA NA BIEZACO WYSWIETLANE W TRAKCIE DZIALANIA PROGRAMU.

PROGRAM MOZNA OPUSCIC POPRZEZ WPISANIE W DOWOLNYM MOMENCIE WARTOSCI 123 W KOSNOLI (NAWET JESLI PROGRAM PROSI O PSEL OSOBY, ID NIERUCHOMOSCI ITP).

ZEBY UMIESCIC PRZEDMIOT W JEDNYM POMIESZCZENIU NAJPIERW TRZEBA WYCIAGNAC GO Z INNEGO (PRZEDMIOT NIE MOZE ZNAJDOWAC SIE W DWOCH POMIESZCZENIACH JEDNOCZESNIE)

KLUCZOWE DLA DZIALANIA PROGRAMU SA KLASY:

1. OSOBA - TO W TEJ KLASIE ZNAJDUJE SIE WIEKSZOSC METOD ODPOWIEDZIALNYCH ZA WYKNONYWANIE DZIALAN NA PRZEDMIOTACH I POMIESZCZENIACH
4. PACKAGE WATKI - W TEJ PACZCE ZDEFINIOWANO WATEK KONTROLNY KTORY CO 10 SEKUND SPRAWDZA CZY NIE ZLAMANO WARUNKOW NAJMU, ORAZ WATEK CZASOWY DODAJACY CO 5 SEKUND 1 DZIEN
ZDEFINIOWANA ZOSTALA TEZ KLASA KALENDARZ KTOREJ OBIEKT W PRAKTYCE TWORZY INSTANCJE CZASU W PROGRAMIE.
2. MIESZKANIE - ZAWIERA METODY WERYFIKACYJNE PRZEKROCZENIE CZASU NAJMU
3. MIEJSCE PARKINGOWE - ZAWIERA METODY WERYFIKACYJNE PRZEKROCZENIE CZASU NAJMU

SLOWNICZEK POJEC:

PESEL OSOBY: WARTOSC TYPU INTEGER PODAWANA W KONSTRUKTORZE KONKRETNEJ OSOBY

ID NIERUCHOMOSCI: JEST TO WYRAZENIE W POSTACI "mX" (DLA MIESZKAN) LUB "pX" (DLA PARKINGOW) GDZIE "X" > 0 I WYRAZANY JEST POPRZEZ KOLEJNOSC TWORZENIA POSZCZEGOLNYCH LOKALI

NAZWA PRZEDMIOTU: JEST TO WYRAZENIE W POSTACI "StringX" GDZIE "X" > 0 I WYRAZANY JEST POPRZEZ KOLEJNOSC TWORZENIA POSZCZEGOLNYCH PRZEDMIOTOW,
A "String" JEST NAZWA PRZEDMIOTU SKIEROWANA DO KONSTRUKTORA. WAŻNE! ID POJAZDU JEST DEFINIOWANE W TEN SAM SPOSOB, GDYZ POJAZD JEST KLASA,
DZIEDZICZACA PO ABSTRAKCYJNEJ KLASIE PRZEDMIOT.

W CELU PRZEJRZYSTEGO POZNANIA DOKLADNYCH ID WSZYSTKICH ISTNIEJACYCH LOKALI, PRZEDMIOTOW, ORAZ OSOB POLECAM W PIERWSZYCH CHWILACH DZIALANIA PROGRAMU WYSWIETLIC,
TE INFORMACJE ZA POSREDNICTWEM WYDAWANYCH Z KONSOLI POLECEN.

C:\Users\Olaf\Desktop\pojazdy.txt
 */

public class main {

    public static void main(String[] args) throws ProblematicTenantException, TooManyThingsException {

        // ++++++++++++++++++++++++++++++++++++++++++++TWORZENIE I ROZRUCH WATKOW I KONIECZNYCH LIST

        List<osiedle> glowna = new ArrayList<osiedle>();
        List<osoba> glownaO = new ArrayList<osoba>();
        List<przedmiot> glownaP = new ArrayList<przedmiot>();
        kalendarz kal = new kalendarz();
        czasowy nth = new czasowy(kal);
        kontrolny ntj = new kontrolny(kal, glowna);
        nth.t.start();
        ntj.t.start();

        try {
            Thread.sleep(1000);                         //Ta funkcja daje programowi czas na prawidlowe zaladowanie watkow.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // +++++++++++++++++++++++++++++++++++++++++++++TWORZENIE NIERUCHOMOSCI

        osiedle berberys = new osiedle("berberys", glowna);
        blok pierwszy = new blok(10, berberys);
        pierwszy.Wydziel(10);
        pierwszy.Wydziel(15);
        pierwszy.Wydziel(25);
        pierwszy.Wydziel(40);
        blok drugi = new blok(5,berberys);
        drugi.Wydziel(100);
        drugi.Wydziel(95);
        drugi.Wydziel(78);
        drugi.Wydziel(120);
        osiedle fiolek = new osiedle("fiolek",glowna);
        blok trzeci = new blok(2, fiolek);
        trzeci.Wydziel(45);
        trzeci.Wydziel(67);

        miejscePark p1 = new miejscePark(25,berberys);
        miejscePark p2 = new miejscePark(100, berberys);
        miejscePark p3 = new miejscePark(75, berberys);
        miejscePark p4 = new miejscePark(80, berberys);
        miejscePark p5 = new miejscePark(100, fiolek);



        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++TWORZENIE POTENCJALNYCH MIESZKANCOW

        osoba Franek = new osoba("Franek", "Walaszek", 12121995, "Gnojna8", 1000, glownaO);
        osoba Janek = new osoba("Janek", "Jamnik", 19071965, "Zdrojna7", 1001, glownaO );
        osoba Adam  = new osoba("Adam", "Papier", 12041971, "Jasna3", 1002, glownaO);
        osoba Michal = new osoba("Michal", "Kowal", 14091995, "Wiejska4", 1003, glownaO );
        osoba Wojtek = new osoba("Wojtek", "Mnich", 14301993, "Zlota1", 1004, glownaO);
        osoba Klaudia = new osoba("Klaudia", "Borsuk", 22041984, "Akacjowa2", 1005, glownaO );
        osoba Sylwek = new osoba("Sylwek", "Igla", 1092004, "ObiWana4", 1006, glownaO);
        osoba Ania = new osoba("Ania", "Walec", 6101997, "Poprzeczna2", 1006, glownaO );

        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++TWORZENIE PRZEDMIOTOW

        samochod_miejski tesla = new samochod_miejski(5, "Tesla", 3000, glownaP);
        amfibia zil = new amfibia(10, "Zil", 10000, glownaP);
        lodz pershing = new lodz(8,"Pershing", 6000, glownaP);
        motocykl honda = new motocykl(2, "Honda", 1200, glownaP);
        samochod_terenowy jeep = new samochod_terenowy(7,"Jeep", 3000, glownaP);
        telewizor samsung = new telewizor(3,"Samsung",glownaP);
        telewizor sony = new telewizor(14,"Sony", glownaP);
        zabawka pilka = new zabawka(1, "Pilka", glownaP);
        zabawka lalka = new zabawka(2, "Lalka", glownaP);
        owoc banan = new owoc(5,"Banan",glownaP);
        owoc mango = new owoc(2,"Mango", glownaP);
        procesor intel = new procesor(1, "Intel", glownaP);
        procesor amd = new procesor(25, "Amd", glownaP);

        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++WSTEPNE PRZYPISANIA

        Franek.najmij(pierwszy.listaM.get(0), kal);
        Franek.najmij(p1,kal);
        Franek.wsadzPrzed(banan, (mieszkanie) Franek.listaN.get(0));
        Franek.wsadzPrzed(mango, (mieszkanie) Franek.listaN.get(0));
        Franek.wsadzPrzed(tesla,p1);

        Janek.najmij(pierwszy.listaM.get(1),kal);
        Janek.najmij(p2,kal);
        Janek.wsadzPrzed(lalka, p2);
        Janek.wsadzPrzed(amd, p2);
        Janek.wsadzPrzed(zil, p2);

        Adam.najmij(pierwszy.listaM.get(2), kal);
        Adam.najmij(p3, kal);
        Adam.wsadzPrzed(pershing, p3);
        Adam.wsadzPrzed(intel, (mieszkanie)Adam.listaN.get(0));

        Michal.najmij(pierwszy.listaM.get(3), kal);
        Michal.najmij(p4, kal);
        Michal.wsadzPrzed(honda, p4);
        Michal.wsadzPrzed(samsung, (mieszkanie)Michal.listaN.get(0));

        Wojtek.najmij(drugi.listaM.get(0),kal);
        Wojtek.najmij(p5, kal);
        Wojtek.wsadzPrzed(jeep, p5);
        Wojtek.wsadzPrzed(sony, (mieszkanie) Wojtek.listaN.get(0));

        Klaudia.najmij(drugi.listaM.get(1), kal);
        Klaudia.wsadzPrzed(pilka, (mieszkanie) Klaudia.listaN.get(0));
        Klaudia.dodajNajemce(Sylwek, (mieszkanie) Klaudia.listaN.get(0));
        Klaudia.dodajNajemce(Ania, (mieszkanie) Klaudia.listaN.get(0));

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PANEL STEROWANIA

        boolean off = true;
        int exit = 123;
        String exiT = "123";

        System.out.println("WITAJ W PORGRAMIE ZARZADZANIA OSIEDLEM!");

        while (off) {


            System.out.println("JEŻELI CHCESZ:\n ZALOGOWAC SIE JAKO KONKRETNA OSOBA WYBIERZ: 1  \n" +
                    "WYSWIETLIC LISTE OSOB WYBIERZ: 2 \n WYSWIETLIC LISTE OSIEDLI WYBIERZ: 3 \n" +
                    "ZAPISAC DO PLIKU WSZELKIE INFORMACJE O OSIEDLACH WYBIERZ: 4 \n WYSWIETLIC LISTE WOLNYCH POMIESZCZENZ: 5 \n" +
                    "WYSWIETLIC WSZYSTKIE INFORMACJE WYBIERZ: 6 \n" + "WYSWIETLIC LISTE ISTNIEJACYCH PRZEDMIOTOW WYBIERZ: 7 " +
                    "\n WYSWIETLIC AKTUALNA DATE WYBIERZ: 8 \n OPUSCIC PROGRAM W DOWOLNYM MOMENCIE WYBIERZ: 123 \n WPISZ TERAZ SWOJ WYBOR: ");

            java.util.Scanner data = new java.util.Scanner(System.in);
            int decyzyjny = data.nextInt();

            switch (decyzyjny) {
                case 1: {
                    System.out.println("PODAJ NUMER PESEL OSOBY: ");
                    int pesel = data.nextInt();
                    if(pesel == exit)
                        System.exit(0);
                    osoba tmp = osoba.getO(glownaO,pesel);
                    if(tmp.pesel == pesel) {
                        boolean testO = true;
                        System.out.println("Jestes zalogowany jako: " + tmp);
                        while (testO) {

                            System.out.println("JEZELI CHCESZ: \n  WYNAJAC NIERUCHOMOSC WYBIERZ: 1\n  ZAMELDOWAC OSOBE W MIESZKANIU WYBIERZ: 2 \n " +
                                    "WYMELDOWAĆ OSOBE Z MIESZKNIA WYBIERZ: 3 \n  UMIESCIC PRZEDMIOT W NIERUCHOMOSCI WYBIERZ: 4 \n WYCIAGNAC PRZEDMIOT Z NIERUCHOMOSCI: 5 \n" +
                                    "PRZEDLUZYC WYNAJEM NIERUCHOMOSCI WYBIERZ: 6 \n PRZERWAC WYNAJEM NIERUCHOMOSCI WYBIERZ: 7 \n" + "WYSWIETLIC SWOJE INFORMACJE WYBIERZ: 8" +
                                    "\n WYSWIETLIC LISTE SWOICH NIERUCHOMOSCI WYBIERZ: 9 \n WYSWIETLIC IFNORMACJE O KONKRETNEJ NIERUCHOMOSCI WYBIERZ: 10 \n POWROCIC DO POPRZEDNIEGO MENU WYBIERZ 11 \n "
                                    + "  WYSWIETLIC AKTUALNA DATE WYBIERZ: 12 \n OPUSCIC PROGRAM W DOWOLNYM MOMENCIE WYBIERZ: 123 \n WPISZ SWOJ WYBOR: ");

                            decyzyjny = data.nextInt();

                            switch (decyzyjny) {
                                case 1: {
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt instanceof mieszkanie) {
                                        try {
                                            tmp.najmij((mieszkanie) wrt, kal);
                                        } catch (ProblematicTenantException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (wrt instanceof miejscePark) {
                                        try {
                                            tmp.najmij((miejscePark) wrt, kal);
                                        } catch (ProblematicTenantException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null){
                                        System.out.println("PODAJ PESEL OSOBY KTORA CHCESZ ZAMELDOWAC: ");
                                        int peselO = data.nextInt();
                                        osoba gosc = osoba.getO(glownaO, peselO);
                                        if (gosc != null)
                                            tmp.dodajNajemce(gosc,(mieszkanie)wrt);
                                    }
                                    break;
                                }
                                case 3: {
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null) {
                                        System.out.println("PODAJ PESEL OSOBY KTORA CHCESZ ZAMELDOWAC: ");
                                        int peselO = data.nextInt();
                                        if(peselO == exit)
                                            System.exit(0);
                                        osoba gosc = osoba.getO(glownaO, peselO);
                                        if (gosc != null)
                                            tmp.usunNajemce(gosc, (mieszkanie) wrt);
                                    }
                                    break;
                                }
                                case 4:{
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null) {
                                        System.out.println("PODAJ DOKLADNA NAZWE PRZEDMIOTU, KTORY CHCESZ UMIESCIC W NIERUCHOMOSCI: ");
                                        String nazwaP = data.next();
                                        if(nazwaP.equals(exiT))
                                            System.exit(0);
                                        przedmiot wsad = przedmiot.getP(glownaP, nazwaP);
                                        if (wsad != null)
                                            if(wrt instanceof miejscePark) {
                                                try {
                                                    tmp.wsadzPrzed(wsad, (miejscePark) wrt);
                                                } catch (TooManyThingsException e) {
                                                    e.printStackTrace();
                                                }
                                            }else if(wrt instanceof mieszkanie){
                                                try {
                                                    tmp.wsadzPrzed(wsad, (mieszkanie) wrt);
                                                } catch (TooManyThingsException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                    }
                                    break;
                                }
                                case 5:{
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null) {
                                        System.out.println("PODAJ DOKLADNA NAZWE PRZEDMIOTU, KTORY CHCESZ WYCIAGNAC Z NIERUCHOMOSCI: ");
                                        String nazwaP = data.next();
                                        if(nazwaP.equals(exiT))
                                            System.exit(0);
                                        przedmiot wsad = przedmiot.getP(glownaP, nazwaP);
                                        if (wsad != null)
                                            if(wrt instanceof miejscePark) {
                                                tmp.wyciagnijPrzed(wsad, (miejscePark) wrt);
                                            }else if(wrt instanceof mieszkanie){
                                                tmp.wyciagnijPrzed(wsad, (mieszkanie) wrt);
                                            }
                                    }
                                    break;
                                }
                                case 6: {
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null) {
                                        tmp.przedluzWynajem(wrt);
                                    }
                                    break;
                                }
                                case 7:{
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null) {
                                        tmp.porzucLok(wrt);
                                    }
                                    break;
                                }
                                case 8: {
                                    System.out.println(tmp);
                                    break;
                                }
                                case 9: {
                                    System.out.println(tmp.listaN);
                                    break;
                                }
                                case 10: {
                                    System.out.println("PODAJ DOKLADNE ID NIERUCHOMOSCI: ");
                                    String idTmp = data.next();
                                    if(idTmp.equals(exiT))
                                        System.exit(0);
                                    nieruchomosc wrt = osiedle.getM(idTmp, glowna);
                                    if (wrt != null) {
                                        System.out.println(wrt);
                                    }
                                    break;
                                }
                                case 11:
                                    testO = false;
                                    break;
                                case 12:
                                    System.out.println(kal);
                                    break;
                                case 123: {
                                    nth.wylacz();
                                    ntj.wylacz();
                                    off = false;
                                    testO = false;
                                    System.out.println("TRWA WYCHODZENIE Z PROGRAMU");
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2:
                    System.out.println(glownaO);
                    break;
                case 3:
                    System.out.println(glowna);
                    break;
                case 4: {
                    System.out.println("PODAJ LOKALIZACJE W KTOREJ CHCESZ ZAPISAC PLIK: ");
                    String lok = data.next();
                    if(lok.equals(exiT))
                        System.exit(0);
                    try {
                        osiedle.zapiszDoPliku(glowna, lok);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:
                    osiedle.pusteM(glowna);
                    break;
                case 6:
                    osiedle.wyswietlInf(glowna);
                    break;
                case 7:
                    System.out.println(glownaP);
                    break;
                case 8:
                    System.out.println(kal);
                    break;
                case 123:
                    nth.wylacz();
                    ntj.wylacz();
                    off = false;
                    System.out.println("TRWA WYCHODZENIE Z PROGRAMU");
            }
        }


    }
}
