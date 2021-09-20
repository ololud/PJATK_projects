package SrodkiTransportu;

import Podmioty.Panstwo;
import miedzymordzia.Plywanie;

public class Statek extends Pojazd implements Plywanie {

    public Statek(Panstwo a){
        if (!a.czyZainfekowane) {
            this.czyZarazona = false;
        }
        else {
            this.pasazerowie = 300;
            double tmp = (a.liczbaZainfekowanych / a.populacja);
            double control;
            for (int i = 0; i < this.pasazerowie; i++){
                control = Math.random();
                if (control < tmp) {
                    this.czyZarazona = true;

                }
            }
        }
    }

    @Override
    public void plyn(Panstwo b) {
        if (this.czyZarazona) {
            if (!b.czyZainfekowane) {
                b.czyZainfekowane = true;
                b.liczbaZainfekowanych = 1;
                System.out.println(b);
            }
        }
    }
}
