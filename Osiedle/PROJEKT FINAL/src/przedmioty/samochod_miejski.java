package przedmioty;
import miedzymordzia.jazda;

import java.util.List;

public class samochod_miejski extends pojazd implements jazda {

    public samochod_miejski(int rozmiar, String Nazwa, int Pojemnosc, List<przedmiot> abc) {
        super(rozmiar, Nazwa, Pojemnosc, abc);
        this.czyJezdzi = true;
        this.czyLata = false;
        this.czyPlywa = false;
        this.typSilnik = "Elektryczny";
        this.skrzynia = "Automatyczna";
    }

    @Override
    public void brum() {
        System.out.println("Brum, brum sobie jade");
    }
}
