package nieruchomosci;

import przedmioty.File;
import przedmioty.przedmiot;
import watki.kalendarz;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class miejscePark extends nieruchomosc {

    private static int numerPorz;
    public przedmiot auto;
    private osiedle osio;

    public miejscePark(int powUz, osiedle Osio) {
        super(powUz);
        ++numerPorz;
        this.id = "p" + numerPorz;
        this.auto = null;
        this.osio = Osio;
        Osio.listaPark.add(this);

    }

    public void weryfikacja(kalendarz date) {
        if (this.najemcaGlo != null) {
            if (endDate.compareTo(date.kalendarz) < 0) {
                GregorianCalendar tmp = new GregorianCalendar();
                tmp.set(this.endDate.get(Calendar.YEAR), this.endDate.get(Calendar.MONTH), this.endDate.get(Calendar.DATE));
                tmp.add(5, 30);
                if (tmp.compareTo(date.kalendarz) < 0) {
                    if (this.auto != null) {
                        this.powZaj = this.powZaj - this.auto.rozmiar;
                        this.auto.somewhere = false;
                        this.auto = null;
                        this.endDate.add(2, 2);
                        if (this.czyFile) {
                            this.czyFile = false;
                            for (int i = 0; i < this.najemcaGlo.listaF.size(); i ++){
                                if (this.najemcaGlo.listaF.get(i).wrt.id.equals(this.id))
                                    this.najemcaGlo.listaF.remove(this.najemcaGlo.listaF.get(i));
                            }
                        }
                    } else {
                        this.najemcaGlo.listaN.remove(this);
                        this.najemcaGlo = null;
                        this.czyFile = false;
                        for (int i = 0; i < this.listP.size(); i++){
                            this.listP.get(i).somewhere = false;
                        }
                        this.listP.clear();
                        this.powZaj = 0;
                    }
                } else if (!this.czyFile){
                    this.czyFile = true;
                    File wrt = new File(this);
                    this.najemcaGlo.listaF.add(wrt);
                }
            }
        }
    }

    @Override
    public String toString() {
        if(najemcaGlo != null)
            return "Parking nr: " + this.id  + " Najemca glowny: " + this.najemcaGlo.imie + " " + this.najemcaGlo.nazwisko + " " + this.najemcaGlo.pesel
                    + " Powierzchnia dostepna: " + (this.powUz - powZaj) + " Koninec wynajmu: " + this.datka() + " " + " W pomieszczeniu znajduja sie przedmioty: " + this.listP
                    + this.czyAuto() + "\n";
        else
            return this.Wolne();
    }

    public String Wolne(){
        return "Parking nr: " + this.id  + " Powierzchnia: " + this.powUz + " Koninec wynajmu: " + this.datka();
    }

    public String datka() {
        if (endDate != null) {
            return  this.endDate.get(Calendar.YEAR)  + " " + this.endDate.get(Calendar.MONTH) + " " +this.endDate.get(Calendar.DATE);
        } else {
            return " Lokal pusty";
        }
    }

    public String czyAuto(){
        if(this.auto != null)
            return " Pojazd: " + this.auto;
        else
            return "";
    }

    @Override
    public int compareTo(nieruchomosc o) {
        return this.compare(this, o);
    }

    @Override
    public int compare(nieruchomosc o1, nieruchomosc o2) {
        if (o1.powUz > o2.powUz)
            return 1;
        if (o1.powUz == o2.powUz)
            return 0;
        if (o1.powUz < o2.powUz)
            return -1;
        else
            return 0;
    }
}




