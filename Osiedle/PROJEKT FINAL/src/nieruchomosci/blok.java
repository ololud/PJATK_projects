package nieruchomosci;

import java.util.ArrayList;
import java.util.List;

public class blok {

    private static int numerBlok;
    private String idBlok;
    private int maxliczMieszk;
    private osiedle NazwaOsiedla;
    public List<mieszkanie> listaM;

    public blok (int liczMieszk, osiedle Osiedle){

        this.listaM = new ArrayList<mieszkanie>();
        ++numerBlok;
        this.idBlok = "b" + numerBlok;
        this.maxliczMieszk = liczMieszk;
        this.NazwaOsiedla = Osiedle;
        this.NazwaOsiedla.listaBlok.add(this);

        }

        public mieszkanie Wydziel(int powUz){
            if(this.listaM.size() >= this.maxliczMieszk) {
                System.out.println("W tym bloku nie ma juz miejsca na kolejne mieszkania");
                return null;
            }
            else
                return new mieszkanie(powUz, this);
        }

    @Override
    public String toString() {

        return "Blok: " + this.idBlok;
    }
}
