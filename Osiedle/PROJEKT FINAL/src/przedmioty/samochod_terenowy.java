package przedmioty;
import miedzymordzia.jazda;

import java.util.List;

public class samochod_terenowy extends pojazd implements jazda {

    public samochod_terenowy(int rozmiar, String Nazwa, int Pojemnosc, List<przedmiot> abc) {
        super(rozmiar, Nazwa, Pojemnosc, abc);
        this.czyJezdzi = true;
        this.czyLata = false;
        this.czyPlywa = false;
        this.typSilnik = "Diesel";
        this.skrzynia = "Manualna";
    }

    @Override
    public void brum() {
        System.out.println("Brum, brum jade po bagnach");
    }
}
