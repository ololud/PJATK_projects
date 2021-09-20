package przedmioty;
import miedzymordzia.jazda;

import java.util.List;

public class motocykl extends pojazd implements jazda {

    public motocykl(int rozmiar, String Nazwa, int Pojemnosc, List<przedmiot> abc) {
        super(rozmiar, Nazwa, Pojemnosc, abc);
        this.czyJezdzi = true;
        this.czyLata = false;
        this.czyPlywa = false;
        this.typSilnik = "Benzynowy";
        this.skrzynia = "Manualna";

    }
    @Override
    public void brum() {
        System.out.println("Po szosie robie bziuuuum");
    }
}
