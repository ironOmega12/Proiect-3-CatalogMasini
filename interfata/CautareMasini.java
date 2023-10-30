package interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


import javax.swing.*;


public class CautareMasini {
    private JFrame frameCautare;
    private ImageIcon startBackground;
    private JButton buttonSearch;
    private JButton searchButton;
    private JLabel startBgLabel;
    private JTextField VIN;
    private JLabel vinLabel;

    public CautareMasini(){
        startBackground = new ImageIcon(this.getClass().getResource("brembo.png"));
        startBgLabel = new JLabel(startBackground);
        startBgLabel.setSize(500, 600);
        startBgLabel.setLayout(null);


    frameCautare=new JFrame();

        frameCautare.setSize(600, 600);
        frameCautare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCautare.setLayout(new BorderLayout());
        frameCautare.setResizable(false);
        frameCautare.setLocationRelativeTo(null);  // This will center the frame.



        buttonSearch=new TransparentRoundedButton("Cauta masina");
        buttonSearch.setBounds(240, 250, 150, 30);




        vinLabel = new JLabel("<html><font face='Arial'  size='5' color='yellow'>Introduceti VIN:</font></html>");
        vinLabel.setBounds(250, 290, 350, 30);
        vinLabel.setVisible(false);

        VIN = new JTextField();
        VIN.setBounds(240, 320, 150, 30);
        VIN.setVisible(false);


        searchButton=new TransparentRoundedButton("Click pentru cautare");
        searchButton.setBounds(240, 360, 150, 30);
        searchButton.setVisible(false);


        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make VIN label, text field, and search button visible
                vinLabel.setVisible(true);
                VIN.setVisible(true);
                searchButton.setVisible(true);
            }
        });

        startBgLabel.add(searchButton);
        startBgLabel.add(vinLabel);
        startBgLabel.add(VIN);
        startBgLabel.add(buttonSearch);
        frameCautare.add(startBgLabel);
        frameCautare.setVisible(true);
    }

}
