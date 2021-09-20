package okienka;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Wyniki extends JFrame {

    private JList<String> lista;
    private String gracz;
    private ArrayList<String> list;
    private JPanel panel;

    Wyniki() throws IOException {
        super("Tabela wynikow");
        setVisible(true);
        setSize(600, 400);
        setResizable(false);
        setLayout(new BorderLayout());

        ImageIcon ikona = new ImageIcon("obrazki/cup.png");
        setIconImage(ikona.getImage());

        panel = new JPanel();
        list = new ArrayList<String>();

        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista wynikow: "));

        FileReader fr = new FileReader("inne/ranking.txt");
        BufferedReader br = new BufferedReader(fr);

        while((gracz=br.readLine())!=null) {
            list.add(gracz);
        }

        fr.close();

        lista = new JList(list.toArray());
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(lista);

        panel.add(pane, BorderLayout.CENTER);

        add(panel);

    }





}
