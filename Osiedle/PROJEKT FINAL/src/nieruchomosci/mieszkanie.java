package nieruchomosci;

import podmioty.osoba;
import przedmioty.File;
import watki.kalendarz;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class mieszkanie extends nieruchomosc {

    private static int numerLok;
    private blok numerBlok;

    mieszkanie(int powUz, blok Blok) {
        super(powUz);
        ++numerLok;
        this.id = "m" + numerLok;
        this.numerBlok = Blok;
        this.numerBlok.listaM.add(this);

    }

    @Override
    public String toString() {
        if(najemcaGlo != null)
        return "Mieszkanie nr: " + this.id  + " Najemca glowny: " + this.najemcaGlo.imie + " " + this.najemcaGlo.nazwisko + " " + this.najemcaGlo.pesel
                + " Powierzchnia dostepna: " + (this.powUz - powZaj) + " Koninec wynajmu: " + this.datka() + " Lokatorzy: " + this.lokatorzy() +
                " W pomieszczeniu znajduja sie przedmioty: " + this.listP + "\n";
        else
            return this.Wolne();
    }

    public String Wolne(){
        return "Mieszkanie nr: " + this.id  + " Powierzchnia: " + this.powUz + " Koninec wynajmu: " + this.datka() + " Lokatorzy: " + this.lokatorzy() + "\n";
    }

    public String datka() {
        if (endDate != null) {
            return  this.endDate.get(Calendar.YEAR)  + " " + this.endDate.get(Calendar.MONTH) + " " +this.endDate.get(Calendar.DATE);
        } else {
            return " Lokal pusty";
        }
    }

    public String lokatorzy() {
        if (this.najemcaGlo != null) {
            osoba tmp = null;
            StringBuffer lok = new StringBuffer();
            for(int i = 0; i < this.listO.size(); i++){
            tmp = this.listO.get(i);
                lok.append(tmp.imie + " " + tmp.nazwisko + " ");
            }
            return lok.toString();
        }else{
            return "brak";
        }
    }

    public void weryfikacja(kalendarz date) {
        if (this.najemcaGlo != null) {
            if (this.endDate.compareTo(date.kalendarz) < 0) {
                GregorianCalendar tmp = new GregorianCalendar();
                tmp.set(this.endDate.get(Calendar.YEAR), this.endDate.get(Calendar.MONTH), this.endDate.get(Calendar.DATE));
                tmp.add(5, 30);
                if (tmp.compareTo(date.kalendarz) < 0) {
                    this.najemcaGlo.listaN.remove(this);
                    this.najemcaGlo = null;
                    this.czyFile = false;
                    this.listO.clear();
                    for (int i = 0; i < this.listP.size(); i++){
                        this.listP.get(i).somewhere = false;
                    }
                    this.listP.clear();
                    this.powZaj = 0;
                } else if (!this.czyFile) {
                    this.czyFile = true;
                    File wrt = new File(this);
                    this.najemcaGlo.listaF.add(wrt);
                }
            }
        }
    }

    @Override
    public int compareTo(nieruchomosc o) {
        return this.compare(this, o);
    }

    @Override
    public int compare(nieruchomosc o1, nieruchomosc o2) {
        if (o1.powUz < o2.powUz)
            return -1;
        if (o1.powUz == o2.powUz)
            return 0;
        if (o1.powUz > o2.powUz)
            return 1;
        else
            return 0;
    }
}
