package przedmioty;
import miedzymordzia.plywanie;

import java.util.List;

public class lodz extends pojazd implements plywanie {

    public lodz(int rozmiar, String Nazwa, int Pojemnosc, List<przedmiot> abc) {
        super(rozmiar, Nazwa, Pojemnosc, abc);
        this.czyJezdzi = false;
        this.czyLata = false;
        this.czyPlywa = true;
        this.typSilnik = "Benzynowy";
        this.skrzynia = "Automatyczna";
    }

    @Override
    public void chlup() {
        System.out.println("Po falach smigam niczym aquaman");
    }
}
