package okienka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Poziom extends JFrame {

    private Startowe win;
    private JButton latwy;
    private JButton sredni;
    private JButton trudny;
    private JLabel opis;
    private JPanel panel;

    Poziom(Startowe win){
        super("Wolrd saver!");
        this.win = win;
        win.setVisible(false);
        setLayout(new GridBagLayout());
        setSize(200, 250);
        setResizable(true);
        ImageIcon ikona = new ImageIcon("obrazki/virus-icon.png");
        setIconImage(ikona.getImage());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                win.setVisible(true);
            }
        });

        opis = new JLabel("Wybierz poziom trudności:");
        opis.setBorder(BorderFactory.createTitledBorder(""));
        latwy = new JButton("Latwy");
        sredni = new JButton("Sredni");
        trudny = new JButton("Trudny");

        latwy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Glowne(0, win);
                setVisible(false);
                dispose();
            }
        });

        sredni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Glowne(1,win);
                setVisible(false);
                dispose();
            }
        });
        trudny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Glowne(2,win);
                setVisible(false);
                dispose();
            }
        });

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.fill = GridBagConstraints.NONE;

        panel.add(opis, gb);

        gb.gridy = 1;

        panel.add(latwy, gb);

        gb.gridy = 2;

        panel.add(sredni, gb);

        gb.gridy = 3;

        panel.add(trudny, gb);

        add(panel);
        setVisible(true);
    }

}
