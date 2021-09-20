package SrodkiTransportu;

import Podmioty.Panstwo;
import miedzymordzia.Jazda;

public class Samochod extends Pojazd implements Jazda {

    public Samochod(Panstwo a){
        if (!a.czyZainfekowane)
            this.czyZarazona = false;
        else {
            this.pasazerowie = 4;
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
    public void jedz(Panstwo b) {
        if (this.czyZarazona) {
            if (!b.czyZainfekowane) {
                b.czyZainfekowane = true;
                b.liczbaZainfekowanych = 1;
            }
        }
    }
}
