package Modele;

import Podmioty.Panstwo;
import Podmioty.Zegar;
import SrodkiTransportu.*;
import okienka.Startowe;
import watki.*;

import java.util.ArrayList;

public class MyModel {

    //WATKI
    private Komunikacja kom;
    private Zarazenia zar;
    private Leczenie lec;
    private Czas cza;
    private Monety mon;
    private Punkty pon;
    private Zwyciestwo zwy;

    public Zegar zegar;

    public int score;

    public int populacjaSwiata;
    public int zarazeniSwiata;

    public ArrayList<Panstwo> panstwa;
    private ArrayList<Panstwo> listaShip;
    private ArrayList<Panstwo> listaCar;
    private ArrayList<Panstwo> listaRocket;
    private ArrayList<Panstwo> listaPlane;
    private ArrayList<Panstwo> listaWalk;

    public boolean win = false;
    public boolean lose = false;

    public Boolean granice = true;
    public Boolean porty = true;
    public Boolean lotniska = true;
    public Boolean portyKosmiczne = true;
    public Boolean upgrade1 = false;
    public Boolean upgrade2 = false;
    public Boolean upgrade3 = false;
    public Boolean upgrade4 = false;
    public Boolean upgrade5 = false;
    public Boolean upgrade6 = false;
    public Boolean upgrade7 = false;
    public Boolean upgrade8 = false;
    public Boolean upgrade9 = false;
    public int waluta;

    public double infectionSpeed;
    public double curingSpeed;

    public MyModel(int poziom){

        this.zegar = new Zegar();
        this.waluta = 15;

        switch (poziom){
            case 0:
                this.score = 6000;
                this.infectionSpeed = 1.5;
                break;
            case 1:
                this.score = 8000;
                this.infectionSpeed = 3;
                break;
            case 2:
                this.score = 10000;
                this.infectionSpeed = 5;
                break;
        }

        this.panstwa = new ArrayList<Panstwo>();
        this.listaShip = new ArrayList<Panstwo>();
        this.listaCar = new ArrayList<Panstwo>();
        this.listaRocket = new ArrayList<Panstwo>();
        this.listaPlane = new ArrayList<Panstwo>();
        this.listaWalk = new ArrayList<Panstwo>();


        Panstwo Polska = new Panstwo(30000000, panstwa,"Polska", true,false,true,true,true, "obrazki/Polska.png");
        Panstwo Niemcy = new Panstwo(60000000, panstwa,"Niemcy",true,true,true,true,true, "obrazki/Niemcy.png");
        Panstwo Francja = new Panstwo(80000000, panstwa,"Francja",true,true,true,true,true,"obrazki/Francja.png");
        Panstwo Litwa = new Panstwo(2700000, panstwa,"Litwa",true,false,false,true,true, "obrazki/Litwa.png");
        Panstwo Wlochy = new Panstwo(58000000, panstwa,"Włochy", true,true,true,true,true, "obrazki/WielkaBrytania.png");
        Panstwo WielkaBrytania = new Panstwo(60000000, panstwa,"Wielka Brytania",false,true,true,true,true, "obrazki/Włochy.png");
        Panstwo Belgia = new Panstwo(10000000, panstwa,"Belgia", true,true,true,true,true, "obrazki/Belgia.png");
        Panstwo Norwegia = new Panstwo(4000000, panstwa,"Norwegia",false,false,true,true,true, "obrazki/Norwegia.png");
        Panstwo Slowcaja = new Panstwo(5000000, panstwa,"Slowacja",true,false,true,true,false, "obrazki/Słowacja.png");
        Panstwo Hiszpania = new Panstwo(49000000, panstwa,"Hiszpania",true,true,true,true,true, "obrazki/Hiszpania.png");

        Panstwo PoludniowaAfryka = new Panstwo(55000000, panstwa,"Poludniowa Afryka",true,false,true,false,true, "obrazki/AfrykaPoludniowa.png");
        Panstwo Kongo = new Panstwo(85000000, panstwa,"Kongo",true,false,true,true,true, "obrazki/Kongo.png");
        Panstwo Etiopia = new Panstwo(74000000, panstwa,"Etiopia",true,false,true,true,false, "obrazki/Etiopia.png");
        Panstwo Nigeria = new Panstwo(200000000, panstwa,"Nigeria",true,false,true,false,true, "obrazki/Nigeria.png");
        Panstwo Kenia = new Panstwo(48000000, panstwa,"Kenia",true,false,true,true,false, "obrazki/Kenia.png");
        Panstwo Sudan = new Panstwo(43000000, panstwa,"Sudan",true,false,true,true,true, "obrazki/Sudan.png");
        Panstwo Algieria = new Panstwo(40000000, panstwa,"Algieria",true,true,true,true,true, "obrazki/Algieria.png");
        Panstwo Uganda = new Panstwo(28000000, panstwa,"Uganda",true,false,true,true,false, "obrazki/Uganda.png");
        Panstwo Maroko = new Panstwo(3400000, panstwa,"Maroko",true,false,true,true,true, "obrazki/Maroko.png");
        Panstwo Ghana = new Panstwo(28000000, panstwa,"Ghana",true,false,true,true,true, "obrazki/Ghana.png");

        Panstwo Chiny = new Panstwo(1400000000, panstwa,"Chiny",true,true,true,true,true,"obrazki/Chiny.png");
        Panstwo Indie = new Panstwo(1300000000, panstwa,"Indie",true,true,true,true,true, "obrazki/Indie.png");
        Panstwo Indonezja = new Panstwo(262000000, panstwa,"Indonezja",false,false,false,true,true, "obrazki/Indonezja.png");
        Panstwo Bangladesz = new Panstwo(159000000, panstwa,"Bangladesz",true,false,true,true,true, "obrazki/Bangladesz.png");
        Panstwo Rosja = new Panstwo(142000000, panstwa,"Rosja",true,true,true,true,true,"obrazki/Rosja.png");
        Panstwo Japonia = new Panstwo(126000000, panstwa,"Japonia",false,true,true,true,true,"obrazki/Japonia.png");
        Panstwo Filipiny = new Panstwo(105000000, panstwa,"Filipiny",false,false,false,true,true,"obrazki/Filipiny.png");
        Panstwo Wietnam = new Panstwo(97000000, panstwa,"Wietnam",true,false,true,true,true,"obrazki/Wietnam.png");
        Panstwo Tajlandia = new Panstwo(68000000, panstwa,"Tajlandia",true,false,true,true,true,"obrazki/Tajlandia.png");
        Panstwo Australia = new Panstwo(23000000, panstwa,"Australia",false,true,false,true,true, "obrazki/Australia.png");

        Panstwo StanyZjednoczone = new Panstwo(329000000, panstwa,"Stany Zjednoczone",true,true,true,true,true,"obrazki/StanyZjednoczone.png");
        Panstwo Kanada = new Panstwo(35000000, panstwa,"Kanada",true,true,true,true,true, "obrazki/Kanada.png");
        Panstwo Brazylia = new Panstwo(208000000, panstwa,"Brazylia",true,false,true,true,true, "obrazki/Brazylia.png");
        Panstwo Meksyk = new Panstwo(125000000, panstwa,"Meksyk",true,false,true,true,true, "obrazki/Meksyk.png");
        Panstwo Kolumbia = new Panstwo(48000000, panstwa,"Kolumbia",true,false,true,true,true,"obrazki/Kolumbia.png");
        Panstwo Argentyna = new Panstwo(44000000, panstwa,"Argentyna",true,false,true,true,true, "obrazki/Argentyna.png");
        Panstwo Wenezuela = new Panstwo(31000000, panstwa,"Wenezuela",true,false,true,false,true, "obrazki/Wenezuela.png");
        Panstwo Peru = new Panstwo(31000000, panstwa,"Peru",true,false,true,true,true, "obrazki/Peru.png");
        Panstwo Chile = new Panstwo(17900000, panstwa,"Chile",true,false,true,true,true, "obrazki/Chile.png");
        Panstwo Ekwador = new Panstwo(16000000, panstwa,"Ekwador",true,false,true,true,true, "obrazki/Ekwador.png");

        this.populacjaSwiata = this.getPopulacjaSwiata();
        this.zarazeniSwiata = this.getZarazeniSwiata();

        for (Panstwo panstwo : panstwa) {
            if (panstwo.czyPieszo)
                listaWalk.add(panstwo);
        }
        for (Panstwo panstwo : panstwa) {
            if (panstwo.czyRakieta)
                listaRocket.add(panstwo);
        }
        for (Panstwo panstwo : panstwa) {
            if (panstwo.czySamochod)
                listaCar.add(panstwo);
        }
        for (Panstwo panstwo : panstwa) {
            if (panstwo.czySamolot)
                listaPlane.add(panstwo);
        }
        for (Panstwo panstwo : panstwa) {
            if (panstwo.czyStatek)
                listaShip.add(panstwo);
        }

        Chiny.czyZainfekowane = true;
        Chiny.liczbaZainfekowanych = 100;

        kom = new Komunikacja(this);
        kom.t.start();
        zar = new Zarazenia(this);
        zar.t.start();
        cza = new Czas(this);
        cza.t.start();
        mon = new Monety(this);
        mon.t.start();
        pon = new Punkty(this);
        pon.t.start();
        zwy = new Zwyciestwo(this);
        zwy.t.start();
        lec = new Leczenie(this);  //WATEK RUSZA PO ZAKUPIE ULEPSZENIA7


    }

    //GETTERY ITP:

    public int getPopulacjaSwiata(){
        this.populacjaSwiata = 0;
        for (Panstwo panstwo : panstwa){
            this.populacjaSwiata += panstwo.populacja;
        }
        return this.populacjaSwiata;
    }

    public int getZarazeniSwiata(){
        this.zarazeniSwiata = 0;
        for (Panstwo panstwo : panstwa){
            this.zarazeniSwiata += panstwo.liczbaZainfekowanych;
        }
        return this.zarazeniSwiata;
    }

    public void money(){
        this.waluta += 1;
    }

    //INFEKOWANIE

    public void infekuj(){

        int how = (int)(Math.random()*5);

        switch (how){
            case 0: {
                if(porty) {
                    int who = (int) (Math.random() * listaShip.size());
                    Statek arka = new Statek(listaShip.get(who));
                    int where = who;
                    while (where == who) {
                        where = (int) (Math.random() * listaShip.size());
                    }
                    arka.plyn(listaShip.get(where));
                }
                break;
            }
            case 1: {
                if(granice) {
                    int who = (int) (Math.random() * listaCar.size());
                    Samochod fiat = new Samochod(listaCar.get(who));
                    int where = who;
                    while (where == who) {
                        where = (int) (Math.random() * listaCar.size());
                    }
                    fiat.jedz(listaCar.get(where));
                }
                break;
            }
            case 2: {
                if(granice) {
                    int who = (int) (Math.random() * listaWalk.size());
                    Pieszo marcinek = new Pieszo(listaWalk.get(who));
                    int where = who;
                    while (where == who) {
                        where = (int) (Math.random() * listaWalk.size());
                    }
                    marcinek.idz(listaWalk.get(where));
                }
                break;
            }
            case 3: {
                if(lotniska) {
                    int who = (int) (Math.random() * listaPlane.size());
                    Samolot messerschmitt = new Samolot(listaPlane.get(who));
                    int where = who;
                    while (where == who) {
                        where = (int) (Math.random() * listaPlane.size());
                    }
                    messerschmitt.lec(listaPlane.get(where));
                }
                break;
            }
            case 4: {
                if(portyKosmiczne) {
                    int who = (int) (Math.random() * listaRocket.size());
                    Rakieta sputnik = new Rakieta(listaRocket.get(who));
                    int where = who;
                    while (where == who) {
                        where = (int) (Math.random() * listaRocket.size());
                    }
                    sputnik.lec(listaRocket.get(where));
                }
                break;
            }
        }
    }

    //ULEPSZENIA

    public void setUlepszeie1(){                //HIGIENA PODSTAWOWA. ZMNIEJSZA TEMPO ROZPRZESTRZENIANIA 0.16x

        if(!upgrade1 && this.waluta >= 10){
            this.waluta -= 10;
            this.infectionSpeed = this.infectionSpeed - this.infectionSpeed * 0.16;
            this.upgrade1 = true;
        }
    }

    public void setUlepszeie2(){                //ZAMKNIECIE LOTNISK. ZAMYKA LOTNISKA NA CALYM SWIECIE, ALE ZWIEKSZA TEMO ROZPRZESTRZENIANIA 0.1x

        if(!upgrade2 && this.waluta >= 15){
            this.waluta -= 15;
            this.infectionSpeed = this.infectionSpeed + this.infectionSpeed * 0.1;
            this.lotniska = false;
            this.upgrade2 = true;
        }
    }

    public void setUlepszeie3(){                //ZAMKCIECIE PORTOW. ZAMYKA PORTY NA CALYM SWIECIE, ALE ZWIEKSZA TEMPO ROZPRZESTRZENIANIA 0.1x

        if(!upgrade3 && this.waluta >= 15){
            this.waluta -= 15;
            this.infectionSpeed = this.infectionSpeed + this.infectionSpeed * 0.1;
            this.porty = false;
            this.upgrade3 = true;
        }
    }

    public void setUlepszeie4(){                //ZAMKNIECIE GRANIC LADOWYCH. ZAMYKA GRANICE NA CALYM SWIECIE ALE W WYNIKU ZAMIESZEK TEMPO ROZPRZESTRZENIANIA WZRASTA 0.3x

        if(!upgrade4 && this.waluta >= 15){
            this.waluta -= 15;
            this.infectionSpeed = this.infectionSpeed + this.infectionSpeed * 0.3;
            this.granice = false;
            this.upgrade4 = true;
        }
    }

    public void setUlepszeie5(){                //ZAMKNIECIE PORTOW KOSMICZNYCH. ZAMYKA PORTY KOSMICZNE, ALE ZMNIEJSZA PREDKOSC LECZENIA 0.2x (O ILE ODKRYTO LEK)

        if(!upgrade5 && this.waluta >= 20){
            this.waluta -= 20;
            this.upgrade5 = true;
            if(this.curingSpeed > 0)
                this.curingSpeed = this.curingSpeed - this.curingSpeed * 0.2;
            this.portyKosmiczne = false;
        }
    }

    public void setUlepszeie6() {                //HIGIENA ZAAWANSOWANA. ZMNIEJSZA TEMPO ROZPRZESTRZENIANIA 0.5x

        if (!upgrade6 && this.waluta >= 20) {
            this.waluta -= 20;
            this.infectionSpeed = this.infectionSpeed - this.infectionSpeed * 0.5;
            this.upgrade6 = true;
        }
    }

    public void setUlepszeie7(){                //LECZENIE. WLACZA WATEK LECZENIA LUDZI WEWNATRZ KRAJU Z PODSTAWOWA PREDKOSCIA = 0.1

        if(!upgrade7 && this.waluta >= 25){
            this.waluta -= 25;
            this.curingSpeed = 0.1;
            lec.t.start();
            this.upgrade7 = true;
        }
    }

    public void setUlepszeie8(){                //HIGIENA EKSTREMALNA. CALKOWICIE ZAMYKA WSZYSTKIE DROGI KOMUNIKACJI, ZMNIEJSZA PREDKOSC ZARAZANIA 0.8x

        if(!upgrade8 && this.waluta >= 30){
            this.waluta -= 30;
            this.infectionSpeed = this.infectionSpeed - this.infectionSpeed * 0.8;
            this.portyKosmiczne = false;
            this.porty = false;
            this.granice = false;
            this.lotniska = false;
            this.upgrade8 = true;
        }
    }

    public void setUlepszeie9(){                //SZCZEPIONKA. ZATRZYMUJE ZARAŻENIA, (NIEMAL) NATYCHMIAST KONCZY GRĘ.

        if(!upgrade9 && this.waluta >= 40){
            this.waluta -= 40;
            this.infectionSpeed = 0;
            this.upgrade9 = true;
        }
    }

    public int setof(){

        this.cza.wylacz();
        this.kom.wylacz();
        this.lec.wylacz();
        this.mon.wylacz();
        this.pon.wylacz();
        this.zar.wylacz();
        this.zwy.wylacz();
        return 1;
    }

}






