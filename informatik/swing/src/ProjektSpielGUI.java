

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by emma on 03.04.17.
 */
public class ProjektSpielGUI extends JFrame {
    private ImageIcon steinBild = new ImageIcon("/Users/emma/Documents/git/informatik/swing/src/pns/images/stein.jpg");
    private ImageIcon schereBild = new ImageIcon("/Users/emma/Documents/git/informatik/swing/src/pns/images/schere.png");
    private ImageIcon papierBild = new ImageIcon("/Users/emma/Documents/git/informatik/swing/src/pns/images/papier.png");
    private JButton scherebutton = new JButton(schereBild);
    private JButton steinbutton = new JButton(steinBild);
    private JButton papierbutton = new JButton(papierBild);
    private JLabel anzeigefeldDu = new JLabel();
    private JLabel anzeigefeldComputer = new JLabel();
    private JLabel titel = new JLabel();

    public ProjektSpielGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 613;
        int frameHeight = 472;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("ProjektSpiel");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        erstellungButtons();
        this.add(titel);
        titel.setBounds(20,20,200,40);
        titel.setText("Willkommen zum spannenden Duell des Schere-Stein-Papier-Kampfes, sei der Held und tritt gegen den gefürchteten Master");
        this.add(anzeigefeldDu);
        anzeigefeldDu.setBounds(100, 20, 60, 60);
        anzeigefeldDu.setVisible(true);
        this.add(anzeigefeldComputer);
        anzeigefeldComputer.setBounds(300, 20, 60, 60);
        anzeigefeldComputer.setVisible(true);

        this.setVisible(true);
    }


    public void erstellungButtons() {
        steinbutton.setBounds(50, 320, 80, 80);
        this.add(steinbutton);
        steinbutton.setVisible(true);
        steinbutton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                reaktionButtons(2);
                                            }
                                        }
        );



        scherebutton.setBounds(250, 320, 80, 80);
        this.add(scherebutton);
        scherebutton.setVisible(true);
        scherebutton.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent evt) {
                                               reaktionButtons(1);
                                           }
                                       }
        );

        papierbutton.setBounds(330, 320, 80, 80);
        this.add(papierbutton);
        papierbutton.setVisible(true);
        papierbutton.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent evt) {
                                               reaktionButtons(3);
                                           }
                                       }
        );
    }

    public void reaktionButtons(int verteidigung) {
        if (verteidigung == 1) {
            anzeigefeldDu.setIcon(schereBild);
        }
        if (verteidigung == 2) {
            anzeigefeldDu.setIcon(steinBild);
        }
        if (verteidigung == 3) {
            anzeigefeldDu.setIcon(papierBild);
        }

        int auswahlComputer = auswahlComputer();
        if (auswahlComputer == 1) {
            anzeigefeldComputer.setIcon(schereBild);
        }
        if (auswahlComputer == 2) {
            anzeigefeldComputer.setIcon(steinBild);
        }
        if (auswahlComputer == 3) {
            anzeigefeldComputer.setIcon(papierBild);
        }
    }

    public int auswahlComputer(){
        return ThreadLocalRandom.current().nextInt(1, 4);

    }

    public static void main(String[] args) {
        new ProjektSpielGUI();


    } // end of main
}
