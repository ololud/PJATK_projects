package przedmioty;

import java.util.List;

public class procesor extends przedmiot {

    public procesor(int rozmiar, String Nazwa, List<przedmiot> abc) {
        super(rozmiar, Nazwa, abc);
    }

    @Override
    public int compareTo(przedmiot o) {
        return this.compare(this, o);
    }

    @Override
    public int compare(przedmiot o1, przedmiot o2) {
        if (o1.rozmiar > o2.rozmiar)
            return -1;
        if (o1.rozmiar == o2.rozmiar)
            return 0;
        if (o1.rozmiar < o2.rozmiar)
            return 1;
        else
            return 0;
    }
}
