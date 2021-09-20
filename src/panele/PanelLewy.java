package panele;

import Modele.MyModel;
import com.sun.scenario.effect.Glow;
import javafx.scene.layout.Border;
import okienka.Glowne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLewy extends JPanel {

    private MyModel mod;

    private JButton buton1 = new JButton("Upgrade - 10");
    private JButton buton2 = new JButton("Upgrade - 15");
    private JButton buton3 = new JButton("Upgrade - 15");
    private JButton buton4 = new JButton("Upgrade - 15");
    private JButton buton5 = new JButton("Upgrade - 20");
    private JButton buton6 = new JButton("Upgrade - 20");
    private JButton buton7 = new JButton("Upgrade - 25");
    private JButton buton8 = new JButton("Upgrade - 30");
    private JButton buton9 = new JButton("Upgrade - 40");

    public PanelLewy(MyModel model){

        mod = model;

        Dimension wrt = new Dimension();
        wrt.width = 150;
        setPreferredSize(wrt);
        setBorder(BorderFactory.createTitledBorder("Ulepszenia"));
        setLayout(new GridBagLayout());

        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade1 | mod.waluta < 10)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie1();
            }
        });
        buton1.setToolTipText("HIGIENA PODSTAWOWA. ZMNIEJSZA TEMPO ROZPRZESTRZENIANIA 0.16x");

        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade2 | mod.waluta < 15)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie2();
            }
        });
        buton2.setToolTipText("ZAMKNIECIE LOTNISK. ZAMYKA LOTNISKA NA CALYM SWIECIE, ALE ZWIEKSZA TEMO ROZPRZESTRZENIANIA 0.1x");

        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade3 | mod.waluta < 15)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie3();
            }
        });
        buton3.setToolTipText("ZAMKCIECIE PORTOW. ZAMYKA PORTY NA CALYM SWIECIE, ALE ZWIEKSZA TEMPO ROZPRZESTRZENIANIA 0.1x");

        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade4 | mod.waluta < 15)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie4();
            }
        });
        buton4.setToolTipText("ZAMKNIECIE GRANIC LADOWYCH. ZAMYKA GRANICE NA CALYM SWIECIE ALE W WYNIKU ZAMIESZEK TEMPO ROZPRZESTRZENIANIA WZRASTA 0.3x");

        buton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade5 | mod.waluta < 20)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie5();
            }
        });
        buton5.setToolTipText("ZAMKNIECIE PORTOW KOSMICZNYCH. ZAMYKA PORTY KOSMICZNE, ALE ZMNIEJSZA PREDKOSC LECZENIA 0.2x (O ILE ODKRYTO LEK)");

        buton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade6 | mod.waluta < 20)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie6();
            }
        });
        buton6.setToolTipText("HIGIENA ZAAWANSOWANA. ZMNIEJSZA TEMPO ROZPRZESTRZENIANIA 0.5x");

        buton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade7 | mod.waluta < 25)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie7();
            }
        });
        buton7.setToolTipText("LECZENIE. WLACZA WATEK LECZENIA LUDZI WEWNATRZ KRAJU Z PODSTAWOWA PREDKOSCIA = 0.1");

        buton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade8 | mod.waluta < 30)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie8();
            }
        });
        buton8.setToolTipText("HIGIENA EKSTREMALNA. CALKOWICIE ZAMYKA WSZYSTKIE DROGI KOMUNIKACJI, ZMNIEJSZA PREDKOSC ZARAZANIA 0.8x");

        buton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mod.upgrade9 | mod.waluta < 40)
                    JOptionPane.showMessageDialog(getParent(), "Posiadasz juz ten upgrade lub brakuje ci grosza","Ups", JOptionPane.INFORMATION_MESSAGE);
                else
                    mod.setUlepszeie9();
            }
        });
        buton9.setToolTipText("SZCZEPIONKA. ZATRZYMUJE ZARAŻENIA, (NIEMAL) NATYCHMIAST KONCZY GRĘ");



        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.fill = GridBagConstraints.NONE;

        add(buton1, gb);

        gb.gridy = 1;

        add(buton2,gb);

        gb.gridy = 2;

        add(buton3, gb);

        gb.gridy = 3;

        add(buton4,gb);

        gb.gridy = 4;

        add(buton5, gb);

        gb.gridy = 5;

        add(buton6, gb);

        gb.gridy = 6;

        add(buton7, gb);

        gb.gridy = 7;

        add(buton8,gb);

        gb.gridy = 8;

        add(buton9, gb);



    }

}
