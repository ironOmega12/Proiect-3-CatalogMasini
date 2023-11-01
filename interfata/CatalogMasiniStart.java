package interfata;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CatalogMasiniStart {
    private JFrame frameMain;
    private ImageIcon startBackground;
    private JLabel startBgLabel;
    private JButton buttonAdd, buttonSearch, buttonNumber;

    public CatalogMasiniStart() {

        startBackground = new ImageIcon(this.getClass().getResource("mainBG2.png"));
        startBgLabel = new JLabel(startBackground);
        startBgLabel.setSize(500, 600);
        startBgLabel.setLayout(null);


        frameMain = new JFrame();
        frameMain.setSize(500, 600);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setLayout(new BorderLayout());
        frameMain.setResizable(false);
        frameMain.setLocationRelativeTo(null);  // This will center the frame.


        buttonAdd = new TransparentRoundedButton("Adauga Masina");
        buttonSearch =  new TransparentRoundedButton("Cautare Masina");
        buttonNumber =  new TransparentRoundedButton("Numar Masini");
        buttonAdd.setBounds(50, 400, 100, 30);
        buttonSearch.setBounds(100, 450, 100, 30);
        buttonNumber.setBounds(150, 500, 100, 30);

        
        startBgLabel.add(buttonAdd);
        startBgLabel.add(buttonSearch);
        startBgLabel.add(buttonNumber);


        buttonAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameMain.dispose();
                new AdaugareMasini();
            }
        });

         buttonSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameMain.dispose();
                new CautareMasini();
            }
        });


           buttonNumber.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameMain.dispose();
                new NumarMasini();
            }
        });
        frameMain.add(startBgLabel);

        frameMain.setVisible(true);
    }
}
