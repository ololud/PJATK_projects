package nieruchomosci;

import podmioty.osoba;
import przedmioty.przedmiot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class nieruchomosc implements Comparator <nieruchomosc>, Comparable<nieruchomosc> {

    public boolean czyFile;
    public GregorianCalendar startDate;
    public GregorianCalendar endDate;
    public osoba najemcaGlo;
    public List<przedmiot> listP;
    public List<osoba> listO;
    public final int powUz;
    public int powZaj;
    String id;

    nieruchomosc(int powUz){
        this.powUz = powUz;
        this.powZaj = 0;
        this.czyFile = false;
        this.startDate = null;
        this.endDate = null;
        this.najemcaGlo = null;
        this.listP = new ArrayList<przedmiot>();
        this.listO = new ArrayList<osoba>();
    }
}
