package interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CatalogMasiniUI {
    private JFrame frameStart;
    private ImageIcon carBackground;
    private JLabel mainStartBg;

    public CatalogMasiniUI() {
        
        carBackground = new ImageIcon(this.getClass().getResource("backgroundMain.jpg"));
        mainStartBg = new JLabel(carBackground);
        mainStartBg.setSize(500, 600);

        frameStart = new JFrame("Pagina Start");
        frameStart.setSize(500, 600);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setResizable(false);
        frameStart.setLocationRelativeTo(null);  // This will center the frame.


        TransparentRoundedButton butonStart = new TransparentRoundedButton("Start");
        butonStart.setBounds(190, 380, 100, 50);


        mainStartBg.add(butonStart);
        frameStart.add(mainStartBg);

        butonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameStart.dispose();
                new CatalogMasiniStart();
            }
        });

        frameStart.setVisible(true);
    }
}
