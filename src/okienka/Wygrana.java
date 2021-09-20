package okienka;

import Modele.MyModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Wygrana extends JFrame {

    private MyModel mod;

    private JLabel nazwaGracza;
    private JLabel info;
    private JTextArea textArea;
    private JButton ok;

    Wygrana(MyModel mod){
        super("Zwyciestwo!");
        this.mod = mod;
        setLayout(new GridBagLayout());
        setSize(500, 250);
        setResizable(false);
        ImageIcon ikona = new ImageIcon("obrazki/cup.png");
        setIconImage(ikona.getImage());

        ok = new JButton("Ok");
        info = new JLabel("Gratulację! Wygrałeś grę twój wynik to: " + mod.score);
        nazwaGracza = new JLabel("Wprowadz swoją nazwę: ");
        textArea = new JTextArea(1, 10);
        textArea.setBorder(BorderFactory.createTitledBorder(""));

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wrt = textArea.getText() + " " + mod.score;
                try {
                    zapis(wrt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                setVisible(false);
                dispose();
            }
        });

        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 0;
        gb.weighty = 1;
        gb.anchor = GridBagConstraints.LINE_END;
        gb.fill = GridBagConstraints.NONE;

        add(info, gb);

        gb.anchor = GridBagConstraints.LINE_END;
        gb.gridy = 2;

        add(nazwaGracza, gb);

        gb.anchor = GridBagConstraints.LINE_START;
        gb.gridx = 1;

        add(textArea, gb);

        gb.anchor = GridBagConstraints.LINE_END;
        gb.gridx = 0;
        gb.gridy = 3;

        add(ok, gb);

        setVisible(true);
    }

    private static void zapis(String abc) throws IOException {
        String tmp = abc;
        StringBuffer sb =new StringBuffer();
        sb.append(tmp);

        FileWriter fw = new FileWriter("inne/ranking.txt", true);
        fw.write(tmp + "\n");
        fw.close();
    }

}
