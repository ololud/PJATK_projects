package przedmioty;


import java.util.List;

public abstract class pojazd extends przedmiot {

    private int pojemnosc;
    private String typ;
    String typSilnik;
    String skrzynia;
    Boolean czyPlywa;
    Boolean czyJezdzi;
    Boolean czyLata;

    pojazd(int rozmiar, String nazwa, int Pojemnosc, List<przedmiot> abc){
        super(rozmiar, nazwa, abc);
        this.nazwa = "[Pojazd] " + this.nazwa;
        this.typ = this.getClass().toString();
        this.pojemnosc = Pojemnosc;
    }

    public String toString(){
        return super.toString() + " Typ: " + this.typ;
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
