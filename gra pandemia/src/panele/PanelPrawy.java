package panele;

import Modele.MyModel;
import Podmioty.Panstwo;

import javax.swing.*;

public class PanelPrawy extends JPanel {

    private MyModel mod;
    private JList<Panstwo> lista;
    private ImageIcon obraz;
    private String pathP;
    private JLabel obrazek;

    public PanelPrawy(MyModel mod){

        this.mod = mod;
        lista = new JList(mod.panstwa.toArray());
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(lista);

        setBorder(BorderFactory.createTitledBorder("Panstwa: "));

        obraz = new ImageIcon("obrazki/MapaSmall.png");
        obrazek = new JLabel("", obraz, JLabel.CENTER);
        obrazek.setBorder(BorderFactory.createTitledBorder(""));

        add(pane);

        Thread t = new Thread(){
            @Override
            public void run() {
                while (true) {
                    if (lista.getSelectedValue() != null) {
                        pathP = lista.getSelectedValue().path;
                        obraz = new ImageIcon(pathP);
                        obrazek.setIcon(obraz);
                    }
                    pane.setViewportView(lista);
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();
        add(obrazek);

    }

}
