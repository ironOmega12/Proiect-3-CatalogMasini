package masiniSelectie;

import vehicule.*;
import interfata.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tesla {
    private JFrame cadruTesla;
    private JComboBox<String> comboBoxModel;
    private JTextField textFieldVIN, textFieldKM;
    private JLabel TeslaBackgroundLabel, lblMarca, lblModel, lblSasiu, lblKM;
    private ImageIcon TeslaBackground;


    public Tesla(String brand) {

        TeslaBackground = new ImageIcon(this.getClass().getResource("tesla_background.jpg"));
        TeslaBackgroundLabel = new JLabel(TeslaBackground);
        TeslaBackgroundLabel.setSize(500, 600);
        TeslaBackgroundLabel.setLayout(null);

        cadruTesla = new JFrame(brand);
        cadruTesla.setSize(500, 600);
        cadruTesla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadruTesla.setResizable(false);
        cadruTesla.setLocationRelativeTo(null);
        
        lblMarca = new JLabel("Marca: " + brand);                   //marca, label + brand
        lblMarca.setBounds(35, 60, 165, 40);
        lblMarca.setForeground(Color.black);
        lblMarca.setBackground(new Color(255, 255, 255, 180));
        lblMarca.setOpaque(true);
        Font currentFont = lblMarca.getFont();
        Font newFont = currentFont.deriveFont(18f); // setting font size to 18
        lblMarca.setFont(newFont);
        cadruTesla.add(lblMarca);


        lblModel = new JLabel("Model: ");           //model, dropdown
        lblModel.setBounds(35, 120, 185, 40);
        lblModel.setForeground(Color.black);
        lblModel.setBackground(new Color(255, 255, 255, 180));
        lblModel.setOpaque(true);
        Font currentFontModel = lblModel.getFont();
        Font newFontModel = currentFontModel.deriveFont(18f); // setting font size to 18
        lblModel.setFont(newFontModel);
        comboBoxModel = new JComboBox<>(new String[] { "Model S", "Model X", "Model Y" });
        comboBoxModel.setBounds(100, 125, 105, 30);
        TeslaBackgroundLabel.add(lblModel);
        TeslaBackgroundLabel.add(comboBoxModel);
        String selectetModel = (String) comboBoxModel.getSelectedItem();

        lblSasiu = new JLabel("Sasiu: ");                   //sasiu
        lblSasiu.setBounds(35, 180, 105, 40);
        lblSasiu.setForeground(Color.black);
        lblSasiu.setBackground(new Color(255, 255, 255, 180));
        lblSasiu.setOpaque(true);
        Font currentFontSasiu = lblSasiu.getFont();
        Font newFontSasiu = currentFontSasiu.deriveFont(18f); // setting font size to 18
        lblSasiu.setFont(newFontSasiu);
        cadruTesla.add(lblSasiu);

        textFieldVIN = new JTextField(15);              // font size pt text field
        textFieldVIN.setBounds(100, 180, 105, 40);
        Font currentFontVIN = textFieldVIN.getFont();
        Font newFontVIN = currentFontVIN.deriveFont(20f);  // setting font size to 20
        textFieldVIN.setFont(newFontVIN);
        TeslaBackgroundLabel.add(textFieldVIN);

        lblKM = new JLabel("KM: ");                   //KM
        lblKM.setBounds(35, 240, 105, 40);
        lblKM.setForeground(Color.black);
        lblKM.setBackground(new Color(255, 255, 255, 180));
        lblKM.setOpaque(true);
        Font currentFontKM = lblKM.getFont();
        Font newFontKM = currentFontKM.deriveFont(18f); // setting font size to 18
        lblKM.setFont(newFontKM);
        cadruTesla.add(lblKM);

        textFieldKM = new JTextField(15);                          // font size pt text field
        textFieldKM.setBounds(70, 240, 105, 40);
        textFieldKM.setFont(newFontKM);
        TeslaBackgroundLabel.add(textFieldKM);

        TransparentRoundedButton btnAdd = new TransparentRoundedButton("Adaugare");
        btnAdd.setBounds(35, 300, 100, 50);
        TeslaBackgroundLabel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MasiniElectrice masinaNoua = new MasiniElectrice(textFieldVIN.getText(), Double.parseDouble(textFieldKM.getText()), brand, selectetModel, 50);
                MasiniElectrice.addCar(masinaNoua);
                JOptionPane.showMessageDialog(null, "Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        TransparentRoundedButton btnAcasa = new TransparentRoundedButton("Meniu Principal");
        btnAcasa.setBounds(180, 430, 100, 40);
        TeslaBackgroundLabel.add(btnAcasa);

        btnAcasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadruTesla.dispose();
                new CatalogMasiniStart();
            }
        });


        cadruTesla.add(TeslaBackgroundLabel);

        cadruTesla.setVisible(true);
    }
}
