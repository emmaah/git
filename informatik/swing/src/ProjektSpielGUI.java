

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by emma on 03.04.17.
 */
public class ProjektSpielGUI extends JFrame {
    private ImageIcon steinBild = new ImageIcon("images/stein.jpg");
    private ImageIcon schereBild = new ImageIcon("images/schere.png");
    private ImageIcon papierBild = new ImageIcon("images/papier.png");
    private ImageIcon vsBild = new ImageIcon ("images/vs.png");
    private JButton scherebutton = new JButton(schereBild);
    private JButton steinbutton = new JButton(steinBild);
    private JButton papierbutton = new JButton(papierBild);
    private JLabel anzeigefeldDu = new JLabel();
    private JLabel anzeigefeldComputer = new JLabel();
    private JLabel titel = new JLabel();
    private JLabel titel2 = new JLabel();
    private JLabel vs = new JLabel();
    private JLabel wahl = new JLabel();
    


    public ProjektSpielGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 600;
        int frameHeight = 500;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("ProjektSpiel");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        cp.setBackground(Color.black);
        erstellungButtons();
        this.add(titel);
        titel.setBounds(95,20,800,40);
        titel.setText("Willkommen zum spannenden Duell des Schere-Stein-Papier-Kampfes");
        titel.setForeground(Color.red);
        this.add(titel2);
        titel2.setBounds(65,50,800,20);
        titel2.setText("Sei ein Held und tritt gegen den gefürchteten Schning-Schang-Schong Meister an");
        titel2.setForeground(Color.red);
        this.add(vs);
        vs.setBounds(250,155,100,100);
        vs.setVisible(true);
        this.add(anzeigefeldDu);
        anzeigefeldDu.setBounds(175, 150, 100, 100);
        anzeigefeldDu.setVisible(true);
        this.add(anzeigefeldComputer);
        anzeigefeldComputer.setBounds(375, 150, 100, 100);
        anzeigefeldComputer.setVisible(true);
        this.add(wahl);
        wahl.setBounds(215,280,500,20);
        wahl.setText("Wähle deine Verteidigung!");
        wahl.setForeground(Color.red);
        this.setVisible(true);
    }


    public void erstellungButtons() {
        steinbutton.setBounds(250, 320, 80, 80);
        this.add(steinbutton);
        steinbutton.setVisible(true);
        steinbutton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                reaktionButtons(2);
                                            }
                                        }
        );



        scherebutton.setBounds(50, 320, 80, 80);
        this.add(scherebutton);
        scherebutton.setVisible(true);
        scherebutton.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent evt) {
                                               reaktionButtons(1);
                                           }
                                       }
        );

        papierbutton.setBounds(450, 320, 80, 80);
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
            vs.setIcon(vsBild);
        }
        if (verteidigung == 2) {
            anzeigefeldDu.setIcon(steinBild);
            vs.setIcon(vsBild);
        }
        if (verteidigung == 3) {
            anzeigefeldDu.setIcon(papierBild);
            vs.setIcon(vsBild);
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
