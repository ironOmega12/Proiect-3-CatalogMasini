package interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import vehicule.Masini;
import masiniSelectie.CarUI;
import masiniSelectie.Tesla;

public class NumarMasini {
    private JFrame frameNumar;
    private ImageIcon startBackground;
    private JButton buttonSearch, acasa;
    private JLabel startBgLabel;
    private JLabel electricCarCountLabel;
    private JLabel nonElectricCarCountLabel;

    public NumarMasini() {
        startBackground = new ImageIcon(this.getClass().getResource("brembo.png"));
        startBgLabel = new JLabel(startBackground);
        startBgLabel.setSize(500, 600);
        startBgLabel.setLayout(null);

        frameNumar = new JFrame();
        frameNumar.setSize(600, 600);
        frameNumar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNumar.setLayout(new BorderLayout());
        frameNumar.setResizable(false);
        frameNumar.setLocationRelativeTo(null);

        acasa = new TransparentRoundedButton("Acasa");
        acasa.setBounds(220, 50, 150, 30);

        buttonSearch = new TransparentRoundedButton("Numar Masini");
        buttonSearch.setBounds(220, 250, 150, 30);


        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int electricCarCount = CarUI.getElectricCarCount();
                int nonElectricCarCount = CarUI.getNonElectricCarCount();

                String message = "Electric Cars: " + electricCarCount + "\nNon-Electric Cars: " + nonElectricCarCount;

                JOptionPane.showMessageDialog(null, message, "Numar Masini", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        acasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameNumar.dispose();
                new CatalogMasiniStart();
            }
        });

        startBgLabel.add(acasa);
        startBgLabel.add(buttonSearch);

        frameNumar.add(startBgLabel);
        frameNumar.setVisible(true);
    }
}
