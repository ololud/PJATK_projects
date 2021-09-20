package panele;

import Modele.MyModel;
import Podmioty.Zegar;

import javax.swing.*;
import java.awt.*;

public class PanelGorny extends JPanel {

    private MyModel mod;
    private JLabel zegarmistrz;
    private JLabel gotowka;
    private JLabel punkty;

    public PanelGorny(MyModel model){

        mod = model;

        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder("Rozgrywka"));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        Dimension wrt = new Dimension();
        wrt.height = 60;
        setPreferredSize(wrt);

        punkty = new JLabel("WYNIK: " + mod.score);
        punkty.setBorder(BorderFactory.createTitledBorder(""));

        gotowka = new JLabel("PUNKTY ULEPSZEN: " + mod.waluta);
        gotowka.setBorder(BorderFactory.createTitledBorder(""));

        zegarmistrz = new JLabel(mod.zegar.toString());
        zegarmistrz.setBorder(BorderFactory.createTitledBorder(""));

        Thread t = new Thread(){
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    zegarmistrz.setText(mod.zegar.toString());
                    gotowka.setText("PUNKTY ULEPSZEN: " + mod.waluta);
                    punkty.setText("WYNIK: " + mod.score);
                }
            }
        };
        t.start();
        add(zegarmistrz);
        add(gotowka);
        add(punkty);





    }

}
