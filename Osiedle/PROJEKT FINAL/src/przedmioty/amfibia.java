package przedmioty;
import miedzymordzia.*;

import java.util.List;

public class amfibia extends pojazd implements jazda, plywanie {

    public amfibia(int rozmiar, String Nazwa, int Pojemnosc, List<przedmiot> abc) {
        super(rozmiar, Nazwa, Pojemnosc, abc);
        this.czyJezdzi = true;
        this.czyLata = false;
        this.czyPlywa = true;
        this.typSilnik = "Diesel";
        this.skrzynia = "Manualna";
    }

    @Override
    public void brum() {
        System.out.println("Raz sobie jade, brum.");
    }

    @Override
    public void chlup() {
        System.out.println("A raz sobie plyne, chlup.");

    }
}
