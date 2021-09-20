package SrodkiTransportu;

import Podmioty.Panstwo;
import miedzymordzia.Lot;

public class Rakieta extends Pojazd implements Lot {

    public Rakieta(Panstwo a){
        if (!a.czyZainfekowane)
            this.czyZarazona = false;
        else {
            this.pasazerowie = 10;
            double tmp = (a.liczbaZainfekowanych / a.populacja);
            double control;
            for (int i = 0; i < this.pasazerowie; i++){
                control = Math.random();
                if (control < tmp)
                    this.czyZarazona = true;
            }
        }
    }

    @Override
    public void lec(Panstwo b) {
        if (this.czyZarazona) {
            if (!b.czyZainfekowane) {
                b.czyZainfekowane = true;
                b.liczbaZainfekowanych = 1;
            }
        }
    }
}
