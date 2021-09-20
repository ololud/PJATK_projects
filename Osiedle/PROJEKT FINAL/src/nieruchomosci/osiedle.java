package nieruchomosci;

import podmioty.osoba;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class osiedle {

    public List<blok> listaBlok;
    public List<miejscePark> listaPark;
    private List<osoba> listaMieszkancow;
    private String nazwa;

    public osiedle(String nazwa, List<osiedle> wrt) {
        this.nazwa = nazwa;
        wrt.add(this);
        this.listaBlok = new ArrayList<blok>();
        this.listaPark = new ArrayList<miejscePark>();
        this.listaMieszkancow = new ArrayList<osoba>();
    }

    @Override
    public String toString() {

        return "Osiedle: " + this.nazwa;
    }

    public static nieruchomosc getM(String idN, List<osiedle> abc) {
        nieruchomosc tmp = null;
        for (int k = 0; k < abc.size(); k++) {
            for (int i = 0; i < abc.get(k).listaBlok.size(); i++) {
                for (int j = 0; j < abc.get(k).listaBlok.get(i).listaM.size(); j++) {
                    if (abc.get(k).listaBlok.get(i).listaM.get(j).id.equals(idN))
                        tmp = abc.get(k).listaBlok.get(i).listaM.get(j);
                }
            }
        }
        if (tmp != null) {
            return tmp;
        } else {
            for (int i = 0; i < abc.get(i).listaPark.size(); i++) {
                if (abc.get(i).listaPark.get(i).id.equals(idN))
                    tmp = abc.get(i).listaPark.get(i);
            }
        }
        if (tmp != null) {
            return tmp;
        } else
            System.out.println("WSKAZANA NIERUCHOMOSC NIE ISTNIEJE");
        return null;
    }


    public static void wyswietlInf(List<osiedle> abc) {
        for (int i = 0; i < abc.size(); i++) {
            for (int j = 0; j < abc.get(i).listaBlok.size(); j++) {
                for (int k = 0; k < abc.get(i).listaBlok.get(j).listaM.size(); k++) {
                    if (abc.get(i).listaBlok.get(j).listaM.get(k).najemcaGlo != null)
                        if(!abc.get(i).listaMieszkancow.contains(abc.get(i).listaBlok.get(j).listaM.get(k).najemcaGlo))
                            abc.get(i).listaMieszkancow.add(abc.get(i).listaBlok.get(j).listaM.get(k).najemcaGlo);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < abc.size(); k++) {
            sb.append(abc.get(k) + "\n" + "Miejsca parkingowe: \n");
            for (int l = 0; l < abc.get(k).listaPark.size(); l++) {
                sb.append(abc.get(k).listaPark.get(l) + "\n");
            }
            sb.append("Lista mieszkancow: \n");
            for (int m = 0; m < abc.get(k).listaMieszkancow.size(); m++) {
                sb.append(abc.get(k).listaMieszkancow.get(m));
            }
            for (int i = 0; i < abc.get(k).listaBlok.size(); i++) {
                sb.append(abc.get(k).listaBlok.get(i) + "\n");
                for (int j = 0; j < abc.get(k).listaBlok.get(i).listaM.size(); j++) {
                    sb.append(abc.get(k).listaBlok.get(i).listaM.get(j).toString() + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static void zapiszDoPliku(List<osiedle> abc, String lokalizacja) throws IOException {
        for (int i = 0; i < abc.size(); i++) {
            for (int j = 0; j < abc.get(i).listaBlok.size(); j++) {
                for (int k = 0; k < abc.get(i).listaBlok.get(j).listaM.size(); k++) {
                    if (abc.get(i).listaBlok.get(j).listaM.get(k).najemcaGlo != null)
                        if(!abc.get(i).listaMieszkancow.contains(abc.get(i).listaBlok.get(j).listaM.get(k).najemcaGlo))
                        abc.get(i).listaMieszkancow.add(abc.get(i).listaBlok.get(j).listaM.get(k).najemcaGlo);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < abc.size(); k++) {
            sb.append(abc.get(k) + "\n" + "Miejsca parkingowe: \n");
            for (int l = 0; l < abc.get(k).listaPark.size(); l++) {
                sb.append(abc.get(k).listaPark.get(l) + "\n");
            }
            sb.append("Lista mieszkancow: \n");
            for (int m = 0; m < abc.get(k).listaMieszkancow.size(); m++) {
                sb.append(abc.get(k).listaMieszkancow.get(m));
            }
            for (int i = 0; i < abc.get(k).listaBlok.size(); i++) {
                sb.append(abc.get(k).listaBlok.get(i) + "\n");
                for (int j = 0; j < abc.get(k).listaBlok.get(i).listaM.size(); j++) {
                    abc.get(k).listaBlok.get(i).listaM.sort(mieszkanie::compareTo);             //SORTOWANIE PO POWIERZCHNI ACZKOLWIEK WEDLUG MNIE DOMYSLNA KOLEJNOSC JEST BARDZIEJ PRZEJRZYSTA
                    sb.append(abc.get(k).listaBlok.get(i).listaM.get(j).toString() + "\n");
                }
            }
        }
        System.out.println(sb);

        FileWriter fr = new FileWriter(lokalizacja);
        fr.write(sb.toString());
        fr.close();

    }

    public static void pusteM(List<osiedle>abc){
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < abc.size(); k++) {
            sb.append(abc.get(k) + "\n" + "Wolne miejsca parkingowe: \n");
            for (int l = 0; l < abc.get(k).listaPark.size(); l++) {
                if(abc.get(k).listaPark.get(l).najemcaGlo == null)
                    sb.append(abc.get(k).listaPark.get(l) + "\n");
            }
            for (int i = 0; i < abc.get(k).listaBlok.size(); i++) {
                sb.append("Wolne mieszkania: " + "\n");
                for (int j = 0; j < abc.get(k).listaBlok.get(i).listaM.size(); j++) {
                    if(abc.get(k).listaBlok.get(i).listaM.get(j).najemcaGlo == null) {
                        sb.append(abc.get(k).listaBlok.get(i).listaM.get(j).toString() + "\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
