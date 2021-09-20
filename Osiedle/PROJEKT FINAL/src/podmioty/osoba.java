package podmioty;

import nieruchomosci.*;
import przedmioty.File;
import przedmioty.pojazd;
import przedmioty.przedmiot;
import watki.kalendarz;
import wyjatki.ProblematicTenantException;
import wyjatki.TooManyThingsException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class osoba {


    public List<File> listaF;
    public List<nieruchomosc> listaN;
    private final int maxNieru = 5;
    public int pesel;
    public String imie;
    public String nazwisko;
    private int dataUrodzenia;
    private String adres;

    public osoba(String imie, String nazwisko, int dataUrodzenia, String adres, int pesel, List<osoba> glownaO) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.adres = adres;
        this.pesel = pesel;
        this.listaN = new ArrayList<nieruchomosc>();
        this.listaF = new ArrayList<File>();
        glownaO.add(this);

    }

    @Override
    public String toString() {
        return "Imie: " + this.imie + ", Nazwisko: " + this.nazwisko + ", Data urodzenia: " + this.dataUrodzenia
                + ", Adres: " + this.adres + ", pesel: " + this.pesel + " ,Liczba upomnien: " + listaF.size() + " ,Wynajmowane nieruchomosci: \n" + listaN + "\n";
    }

    /*
    ++++++++++++++++++++++++++++WYNAJEM MIESZKANIA+++++++++++++++++++++++++++++
     */
    public void najmij(mieszkanie wrt, kalendarz kal) throws ProblematicTenantException {
        if (this.listaF.size() < 3) {
            if (wrt.najemcaGlo == null && this.listaN.size() < maxNieru) {
                wrt.startDate = new GregorianCalendar();
                wrt.startDate.set(kal.kalendarz.get(Calendar.YEAR),kal.kalendarz.get(Calendar.MONTH), kal.kalendarz.get(Calendar.DATE));
                wrt.endDate = new GregorianCalendar();
                wrt.endDate.set(kal.kalendarz.get(Calendar.YEAR), kal.kalendarz.get(Calendar.MONTH), kal.kalendarz.get(Calendar.DATE));
                wrt.endDate.add(5, 30);
                wrt.listO.add(this);
                this.listaN.add(wrt);
                wrt.najemcaGlo = this;
            } else
                System.out.println("Ten lokal jest juz zajety, lub wynajmujesz zbyt wiele nieruchomosci!");
        } else {
            throw new ProblematicTenantException(this);
        }
    }

    /*
    +++++++++++++++DODAWANIE LOKATOROW PRZEZ GLOWNEGO NAJEMCE++++++++++++++++++++
    */
    public void dodajNajemce(osoba abc, mieszkanie wrt) {
        if (this == wrt.najemcaGlo) {
            wrt.listO.add(abc);
        } else
            System.out.println("Tylko glowny najemca, moze domeldowac nowa osobe");
    }

    /*
   +++++++++++++++++++++USUWANIE LOKATOROW PRZEZ NAJEMCE+++++++++++++++++++++++++
   */
    public void usunNajemce(osoba abc, mieszkanie wrt) {
        if (this == wrt.najemcaGlo) {
            if (wrt.listO.contains(abc)) {
                wrt.listO.remove(abc);
            }else
                System.out.println("Taki lokator nie jest zameldowany w obiekcie.");
        } else
            System.out.println("Tylko glowny najemca, moze wymeldowac osobe z lokalu.");
    }

    /*
    +++++++++++++++++++++WYNAJMOWANIE MIEJSCA PARKINGOWEGO+++++++++++++++++++++++++++
    */
    public void najmij(miejscePark wrt, kalendarz kal) throws ProblematicTenantException {
        if (this.listaF.size() < 3) {
            if (this.listaN != null) {
                if (wrt.najemcaGlo == null && this.listaN.size() < maxNieru) {
                    wrt.startDate = new GregorianCalendar();
                    wrt.startDate.set(kal.kalendarz.get(Calendar.YEAR), kal.kalendarz.get(Calendar.MONTH), kal.kalendarz.get(Calendar.DATE));
                    wrt.endDate = new GregorianCalendar();
                    wrt.endDate.set(kal.kalendarz.get(Calendar.YEAR), kal.kalendarz.get(Calendar.MONTH), kal.kalendarz.get(Calendar.DATE));
                    wrt.endDate.add(5, 30);
                    this.listaN.add(wrt);
                    wrt.najemcaGlo = this;
                } else
                    System.out.println("Ten lokal jest juz zajety, lub wynajmujesz zbyt wiele nieruchomosci!");
            }else{
                System.out.println("Miejsce parkingowe przysluguje tylko najemcy mieszkania");
            }
        } else {
            throw new ProblematicTenantException(this);
        }
    }
    /*
    +++++++++++++++++++++WSADZANIE PRZEDMIOTOW DO MIEJSCA PARKINGOWEGO++++++++++++++++++++++++
    */
    public <T extends przedmiot> void wsadzPrzed(T abc, miejscePark wrt) throws TooManyThingsException {
        if (!abc.somewhere) {
            if ((abc.rozmiar + wrt.powZaj) > wrt.powUz) {
                throw new TooManyThingsException();
            } else {
                if ((abc instanceof pojazd) && (wrt.auto == null)) {
                    wrt.auto = abc;
                    wrt.powZaj = wrt.powZaj + abc.rozmiar;
                    abc.somewhere = true;
                } else if (!wrt.listP.contains(abc)) {
                    wrt.listP.add(abc);
                    abc.somewhere = true;
                    wrt.powZaj = wrt.powZaj + abc.rozmiar;
                    wrt.listP.sort(przedmiot::compareTo);
                } else if (wrt.listP.contains(abc)) {
                    System.out.println("PRZEDMIOT ZNAJDUJE SIE JUZ W LOKALU");
                } else if (abc instanceof pojazd) {
                    System.out.println("JEDEN POJAZD JUZ ZNAJDUJE SIE NA TYM MIEJSCU");
                }
            }
        } else {
            System.out.println("Najpierw wyciagnij przedmiot z lokalu w ktorym obecnie sie znajduje");
        }
    }

    /*
    ++++++++++++++++++++++WYCIĄGANIE PRZEDMIOTÓW Z MIEJSCA PARKINGOWEGO+++++++++++++++++++++++++
    */
    public void wyciagnijPrzed(przedmiot abc, miejscePark wrt) {
        if (abc instanceof pojazd && abc.nazwa.equals(wrt.auto.nazwa)){
            wrt.powZaj = wrt.powZaj - wrt.auto.rozmiar;
            wrt.auto = null;
            abc.somewhere = false;
        } else if (wrt.listP.contains(abc)) {
            wrt.powZaj = wrt.powZaj - abc.rozmiar;
            wrt.listP.remove(abc);
            abc.somewhere = false;
            if(wrt.listP != null)
            wrt.listP.sort(przedmiot::compareTo);
        } else {
            System.out.println("Nie odnaleziono twojego przedmiotu!");
        }
    }

    /*
    ++++++++++++++++++++++++++++WSADZANIE PRZEDMIOTOW DO MIESZKANIA++++++++++++++++++++++++++++++++
    */
    public void wsadzPrzed(przedmiot abc, mieszkanie wrt) throws TooManyThingsException {
        if (!abc.somewhere) {
            if ((wrt.powZaj + abc.rozmiar) > wrt.powUz) {
                throw new TooManyThingsException();
            } else {
                if (abc instanceof pojazd) {
                    System.out.println("Pojazdy mozna parkowac jedynie na wyznaczonych miejscach!");
                } else if (!wrt.listP.contains(abc)) {
                    wrt.listP.add(abc);
                    abc.somewhere = true;
                    wrt.listP.sort(przedmiot::compareTo);
                    wrt.powZaj = wrt.powZaj + abc.rozmiar;
                } else if (wrt.listP.contains(abc))
                    System.out.println("PRZEDMIOT TEN ZNAJDUJE SIE JUZ W LOKALU!");
            }
        } else {
            System.out.println("Najpierw wyciagnij przedmiot z lokalu w ktorym obecnie sie znajduje");
        }
    }

    /*
    ++++++++++++++++++++++WYCIĄGANIE PRZEDMIOTÓW Z MIESZKANIA+++++++++++++++++++++++++
    */
    public void wyciagnijPrzed(przedmiot abc, mieszkanie wrt) {
        if (abc instanceof pojazd) {
            System.out.println("W mieszkaniu nie znajduje sie zaden pojazd!");
        } else if (wrt.listP.contains(abc)) {
            wrt.powZaj = wrt.powZaj - abc.rozmiar;
            wrt.listP.remove(abc);
            abc.somewhere = false;
            if(wrt.listP != null)
            wrt.listP.sort(przedmiot::compareTo);
        } else {
            System.out.println("Nie odnaleziono twojego przedmiotu!");
        }
    }


    /*
    ++++++++++++++++++++++++++++PRZEDLUZ WYNAJEM++++++++++++++++++++++++++++++++++++++++++
     */

    public void przedluzWynajem(nieruchomosc abc) {
        if (this == abc.najemcaGlo) {
            if (abc.czyFile) {
                abc.czyFile = false;
                abc.najemcaGlo.listaF.forEach(File -> {
                    if (File.wrt == abc) abc.najemcaGlo.listaF.remove(File);
                });
                abc.endDate.add(5, 30);
            } else {
                abc.endDate.add(5, 30);
            }
        } else {
            System.out.println("Nie mozesz przedluzyc najmu, gdzyz nie jestes najemca!");
        }
    }

    /*
    ++++++++++++++++++++++++++++PORZUC WYNAJEM++++++++++++++++++++++++++++++++++++++++
     */

    public void porzucLok(nieruchomosc abc) {
        if (this == abc.najemcaGlo) {
            if (abc.czyFile) {
                abc.czyFile = false;
                abc.najemcaGlo.listaF.forEach(File -> {
                    if (File.wrt == abc) abc.najemcaGlo.listaF.remove(File);
                });}
                abc.najemcaGlo.listaN.remove(abc);
                abc.najemcaGlo = null;
                abc.czyFile = false;
                abc.listO.clear();
                abc.listP.clear();
                abc.powZaj = 0;

        }else{
            System.out.println("Tylko glowny najemca moze porzucic lokal!");
        }
    }

    /*
    +++++++++++++++++++++++++++GETTER OSOBY+++++++++++++++++++++++++++++++++++++++++
     */

    public static osoba getO(List<osoba> abc, int wrt){
        osoba tmp = null;
        for (int i = 0; i < abc.size(); i++){
            if (abc.get(i).pesel == wrt)
                tmp = abc.get(i);
        }if(tmp != null)
            return tmp;
        else
            System.out.println("OSOBA Z TAKIM PESELEM NIE ISTNIEJE");
            return null;
    }
}