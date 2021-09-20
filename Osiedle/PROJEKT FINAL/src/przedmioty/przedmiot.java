package przedmioty;

import java.util.Comparator;
import java.util.List;

public abstract class przedmiot implements Comparable<przedmiot>, Comparator<przedmiot> {

    public int rozmiar;
    private int id;
    private static int licznik;
    public String nazwa;
    public boolean somewhere;

    public przedmiot(int rozmiar, String Nazwa, List<przedmiot> abc){
        ++licznik;
        this.id = licznik;
        this.nazwa = Nazwa + licznik;
        this.rozmiar = rozmiar;
        this.somewhere = false;
        abc.add(this);
    }

    @Override
    public String toString() {

        return "\n Nazwa: " + this.nazwa + " Rozmiar: " + this.rozmiar;
    }

    public static przedmiot getP(List<przedmiot> wrt, String tmp){
        przedmiot tnp = null;
        for (int i = 0; i < wrt.size(); i++){
            if (tmp.equals(wrt.get(i).nazwa))
                tnp = wrt.get(i);
        }
        if (tnp != null)
            return tnp;
        else
            System.out.println("PRZEDMIOT O TAKIEJ NAZWIE NIE ISTNIEJE");
            return null;
    }


}
