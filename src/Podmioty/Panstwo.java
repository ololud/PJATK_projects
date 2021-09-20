package Podmioty;

import java.util.ArrayList;
import java.util.List;

public class Panstwo {

    public String nazwa;
    public double populacja;
    public double liczbaZainfekowanych;
    public boolean czyZainfekowane;

    public boolean czyPieszo;
    public boolean czyRakieta;
    public boolean czySamochod;
    public boolean czySamolot;
    public boolean czyStatek;

    public boolean czyWyswietlono;


    public String path;

    public Panstwo(double Populacja, List<Panstwo> listap, String Nazwa, boolean pi, boolean ra, boolean sa, boolean sm, boolean st, String path){
        this.nazwa = Nazwa;
        this.path = path;
        listap.add(this);
        this.populacja = Populacja;
        this.czyZainfekowane = false;
        this.czyPieszo = pi;
        this.czyRakieta = ra;
        this.czySamochod = sa;
        this.czySamolot = sm;
        this.czyStatek = st;
        this.czyWyswietlono = false;
    }

    public String toString(){

        String infector;

        if(this.czyZainfekowane)
            infector = "Tak";
        else
            infector = "Nie";

        return this.nazwa + " Populacja: " + this.populacja + " Zainfekowane: " + infector + " Zarazona populacja: "  + this.liczbaZainfekowanych;
    }

    public void epidemia(double speed) {
        if (this.czyZainfekowane) {
            int nowi = (int) (this.liczbaZainfekowanych * speed);
            if (!((this.liczbaZainfekowanych + nowi) > this.populacja)) {
                this.liczbaZainfekowanych += nowi;
            } else if (((this.liczbaZainfekowanych + nowi) > this.populacja) | (this.populacja == this.liczbaZainfekowanych)) {
                this.liczbaZainfekowanych = this.populacja;
            }
        }
    }

    public void leczenie(double speed) {
        if (this.czyZainfekowane) {
            if(this.liczbaZainfekowanych > 0){
                int zdrowi = (int)(this.liczbaZainfekowanych * speed);
                this.liczbaZainfekowanych -= zdrowi;
                System.out.println("Leczenie..." + this);
            }if (liczbaZainfekowanych <= 0) {
                this.liczbaZainfekowanych = 0;
                this.czyZainfekowane = false;
            }
        }
    }

}


