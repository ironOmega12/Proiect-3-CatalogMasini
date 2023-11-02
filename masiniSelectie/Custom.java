package masiniSelectie;

import vehicule.*;
import interfata.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Custom {
    private JFrame cadruCustom;
    private JTextField textFieldVIN, textFieldKM, textFieldModel, textFieldMarca, textFieldCuloare;
    private JLabel CustomBackgroundLabel, lblMarca, lblModel, lblSasiu, lblKM, lblCuloare;
    private ImageIcon CustomBackground;


    public Custom() {

        CustomBackground = new ImageIcon(this.getClass().getResource("porsche_background.jpg"));
        CustomBackgroundLabel = new JLabel(CustomBackground);
        CustomBackgroundLabel.setSize(500, 600);
        CustomBackgroundLabel.setLayout(null);

        cadruCustom = new JFrame("Custom Car");
        cadruCustom.setSize(500, 600);
        cadruCustom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadruCustom.setResizable(false);
        cadruCustom.setLocationRelativeTo(null);
        
        lblMarca = new JLabel("Marca: ");                   //marca, label + brand
        lblMarca.setBounds(35, 60, 165, 40);
        lblMarca.setForeground(Color.black);
        lblMarca.setBackground(new Color(255, 255, 255, 180));
        lblMarca.setOpaque(true);
        Font currentFont = lblMarca.getFont();
        Font newFont = currentFont.deriveFont(18f); // setting font size to 18
        lblMarca.setFont(newFont);
        cadruCustom.add(lblMarca);

        textFieldMarca = new JTextField(15);              // font size pt text field
        textFieldMarca.setBounds(100, 60, 105, 40);
        textFieldMarca.setFont(newFont);
        CustomBackgroundLabel.add(textFieldMarca);

        lblModel = new JLabel("Model: ");           //model, dropdown
        lblModel.setBounds(35, 120, 185, 40);
        lblModel.setForeground(Color.black);
        lblModel.setBackground(new Color(255, 255, 255, 180));
        lblModel.setOpaque(true);
        Font currentFontModel = lblModel.getFont();
        Font newFontModel = currentFontModel.deriveFont(18f); // setting font size to 18
        lblModel.setFont(newFontModel);
        textFieldModel = new JTextField(15);
        textFieldModel.setBounds(100, 125, 105, 30);
        CustomBackgroundLabel.add(lblModel);
        CustomBackgroundLabel.add(textFieldModel);

        lblSasiu = new JLabel("Sasiu: ");                   //sasiu
        lblSasiu.setBounds(35, 180, 105, 40);
        lblSasiu.setForeground(Color.black);
        lblSasiu.setBackground(new Color(255, 255, 255, 180));
        lblSasiu.setOpaque(true);
        Font currentFontSasiu = lblSasiu.getFont();
        Font newFontSasiu = currentFontSasiu.deriveFont(18f); // setting font size to 18
        lblSasiu.setFont(newFontSasiu);
        cadruCustom.add(lblSasiu);

        textFieldVIN = new JTextField(15);              // font size pt text field
        textFieldVIN.setBounds(100, 180, 105, 40);
        textFieldVIN.setFont(newFont);
        CustomBackgroundLabel.add(textFieldVIN);

        lblKM = new JLabel("KM: ");                   //KM
        lblKM.setBounds(35, 240, 105, 40);
        lblKM.setForeground(Color.black);
        lblKM.setBackground(new Color(255, 255, 255, 180));
        lblKM.setOpaque(true);
        Font currentFontKM = lblKM.getFont();
        Font newFontKM = currentFontKM.deriveFont(18f); // setting font size to 18
        lblKM.setFont(newFontKM);
        cadruCustom.add(lblKM);

        textFieldKM = new JTextField(15);                          // font size pt text field
        textFieldKM.setBounds(70, 240, 105, 40);
        textFieldKM.setFont(newFontKM);
        CustomBackgroundLabel.add(textFieldKM);

        lblCuloare = new JLabel("Culoare: ");                   //KM
        lblCuloare.setBounds(35, 300, 185, 40);
        lblCuloare.setForeground(Color.black);
        lblCuloare.setBackground(new Color(255, 255, 255, 180));
        lblCuloare.setOpaque(true);
        lblCuloare.setFont(newFontKM);
        cadruCustom.add(lblCuloare);

        textFieldCuloare = new JTextField(15);                          // font size pt text field
        textFieldCuloare.setBounds(120, 300, 105, 40);
        textFieldCuloare.setFont(newFontKM);
        CustomBackgroundLabel.add(textFieldCuloare);

        TransparentRoundedButton btnAdd = new TransparentRoundedButton("Adaugare");
        btnAdd.setBounds(35, 360, 100, 50);
        CustomBackgroundLabel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double km = Double.parseDouble(textFieldKM.getText());
                if (km < 0) {
                    JOptionPane.showMessageDialog(null, "KM nu pot fi negativi!", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Masini masinaNoua = new Masini(textFieldVIN.getText(), Double.parseDouble(textFieldKM.getText()),
                            textFieldMarca.getText(), textFieldModel.getText(), textFieldCuloare.getText());
                    Masini.addCar(masinaNoua);
                    JOptionPane.showMessageDialog(null, "Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        TransparentRoundedButton btnAcasa = new TransparentRoundedButton("Meniu Principal");
        btnAcasa.setBounds(180, 430, 100, 40);
        CustomBackgroundLabel.add(btnAcasa);

        btnAcasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadruCustom.dispose();
                new CatalogMasiniStart();
            }
        });


        cadruCustom.add(CustomBackgroundLabel);

        cadruCustom.setVisible(true);
    }
}
