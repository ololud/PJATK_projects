package okienka;

import Modele.MyModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Startowe extends JFrame {

    private Startowe win;

    public Startowe(){

        super("World saver!");
        win = this;
        setSize(300, 300);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ikona = new ImageIcon("obrazki/virus-icon.png");
        setIconImage(ikona.getImage());

        JPanel panelN = new JPanel();
        panelN.setLayout(new GridBagLayout());

        JButton buttonN = new JButton("Nowa gra");

        buttonN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Poziom (win);
            }
        });

        JButton buttonH = new JButton("Tabela Wynikow");

        buttonH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Wyniki();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton buttonW = new JButton("Wyjscie z gry");

        buttonW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.fill = GridBagConstraints.NONE;

        panelN.add(buttonN, gb);

        gb.gridy = 1;

        panelN.add(buttonH, gb);

        gb.gridy = 2;

        panelN.add(buttonW, gb);

        add(panelN);
        setVisible(true);




    }
}
