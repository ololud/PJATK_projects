package okienka;

import Modele.MyModel;
import Podmioty.Panstwo;
import com.sun.glass.ui.Window;
import com.sun.javafx.css.StyleCache;
import panele.PanelDolny;
import panele.PanelLewy;
import panele.PanelGorny;
import panele.PanelPrawy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Glowne extends JFrame {

    public MyModel mod;
    private Startowe win;
    private int lvl;
    private PanelLewy panelL;
    private PanelGorny panelG;
    private PanelPrawy panelP;
    private PanelDolny panelD;
    private JButton bye;

    Glowne(int lVl, Startowe win){
        super("World saver!");
        this.lvl = lVl;
        this.win = win;
        setSize(1000, 800);
        setLayout(new BorderLayout());
        setResizable(false);
        ImageIcon ikona = new ImageIcon("obrazki/virus-icon.png");
        setIconImage(ikona.getImage());
        bye = new JButton("Poddaje się");
        bye.setMnemonic(KeyEvent.VK_Q);
        bye.setToolTipText("Konczy gre");

        bye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                win.setVisible(true);
                mod.setof();
                dispose();
            }
        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                win.setVisible(true);
                mod.setof();
            }
        });


        Thread t = new Thread(){
            public void run() {
                boolean check = true;
                do {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for(Panstwo panstwo : mod.panstwa){
                        if(!panstwo.czyWyswietlono && panstwo.czyZainfekowane) {
                            panstwo.czyWyswietlono = true;
                            JDialog wrt = new JDialog();
                            JOptionPane.showMessageDialog(wrt, "Zainfekowano nowe państwo! " + panstwo.nazwa, "Zaraza", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                    if (mod.win){
                        mod.setof();
                        win.setVisible(true);
                        Wygrana wrt = new Wygrana(mod);
                        setVisible(false);
                        dispose();
                        check = false;

                    }
                    if (mod.lose){
                        mod.setof();
                        JDialog wrt = new JDialog();
                        JOptionPane.showMessageDialog(wrt,"Przegrałeś! Spróbuj jeszcze raz!", "Porazka", JOptionPane.WARNING_MESSAGE);
                        setVisible(false);
                        win.setVisible(false);
                        dispose();
                        check = false;
                    }

                }while (check);
            }
        };

        t.start();

        mod = new MyModel(this.lvl);

        panelG = new PanelGorny(mod);
        panelL = new PanelLewy(mod);
        panelP = new PanelPrawy(mod);
        panelD = new PanelDolny(mod);
        panelG.add(bye);

        add(panelG, BorderLayout.NORTH);
        add(panelD, BorderLayout.SOUTH);
        add(panelL, BorderLayout.WEST);
        add(panelP, BorderLayout.CENTER);

        setVisible(true);



    }


}
