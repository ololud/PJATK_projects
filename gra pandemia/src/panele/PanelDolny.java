package panele;

import Modele.MyModel;
import okienka.Glowne;

import javax.swing.*;
import java.awt.*;

public class PanelDolny extends JPanel {

    private MyModel mod;
    private JLabel ofiary;
    private JLabel pojazdy;
    private JLabel samolotJ;
    private JLabel samochodJ;
    private JLabel rakietaJ;
    private JLabel chodJ;
    private JLabel statekJ;
    private ImageIcon samolot;
    private ImageIcon rakieta;
    private ImageIcon chod;
    private ImageIcon samochod;
    private ImageIcon statek;

    public PanelDolny(MyModel mod){

        this.mod = mod;

        setBorder(BorderFactory.createTitledBorder("Swiat"));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        Dimension wrt = new Dimension();
        setBackground(Color.white);
        wrt.height = 60;
        setPreferredSize(wrt);

        ofiary = new JLabel("POPULACJA ŚWIATA: " + mod.getPopulacjaSwiata() + " " +  "ZARAŻENI ŚWIATA: " + mod.getZarazeniSwiata());
        pojazdy = new JLabel("AKTYWNE SRODKI TRANSPORTU: ");

        samolot = new ImageIcon("obrazki/plane.png");
        samolotJ = new JLabel("", samolot, JLabel.CENTER);

        rakieta = new ImageIcon("obrazki/rocket.png");
        rakietaJ = new JLabel("", rakieta, JLabel.CENTER);

        statek = new ImageIcon("obrazki/ship.png");
        statekJ = new JLabel("", statek, JLabel.CENTER);

        chod = new ImageIcon("obrazki/walking.png");
        chodJ = new JLabel("", chod, JLabel.CENTER);

        samochod = new ImageIcon("obrazki/car.png");
        samochodJ = new JLabel("", samochod, JLabel.CENTER);


        Thread t = new Thread(){
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(!mod.granice) {
                        chod = new ImageIcon("obrazki/restriction.png");
                        chodJ.setIcon(chod);
                        samochod = new ImageIcon("obrazki/restriction.png");
                        samochodJ.setIcon(samochod);
                    }
                    if(!mod.lotniska) {
                        samolot = new ImageIcon("obrazki/restriction.png");
                        samolotJ.setIcon(samolot);
                    }
                    if(!mod.porty) {
                        statek = new ImageIcon("obrazki/restriction.png");
                        statekJ.setIcon(statek);
                    }
                    if(!mod.portyKosmiczne) {
                        rakieta = new ImageIcon("obrazki/restriction.png");
                        rakietaJ.setIcon(rakieta);
                    }

                    ofiary.setText("POPULACJA ŚWIATA: " + mod.getPopulacjaSwiata() + " " +  "ZARAŻENI ŚWIATA: " + mod.getZarazeniSwiata());
                }
            }
        };

        add(ofiary);
        add(pojazdy);
        add(samochodJ);
        add(samolotJ);
        add(statekJ);
        add(chodJ);
        add(rakietaJ);
        t.start();
    }

}
