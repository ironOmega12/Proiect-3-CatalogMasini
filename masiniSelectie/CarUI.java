package masiniSelectie;

import vehicule.*;
import interfata.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CarUI {
    private JFrame cadruCar;
    private JComboBox<String> comboBoxModel;
    private JTextField textFieldVIN, textFieldKM;
    private JLabel carBackgroundLabel, lblMarca, lblModel, lblSasiu, lblKM;
    private ImageIcon carBackground;
    private String brand;
    private boolean isElectric;
    private static int electricCarCount = Tesla.getElectricCarCount();
    private static int nonElectricCarCount = 0;


    public CarUI(String brand,boolean isElectric) {
        this.brand = brand;
        this.isElectric=isElectric;
        switch (brand) {
            case "Audi":
                carBackground = new ImageIcon(this.getClass().getResource("audi_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "A4", "A5", "A6" });
                break;
            case "BMW":
                carBackground = new ImageIcon(this.getClass().getResource("bmw_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "Seria3", "Seria5", "Seria7" });
                break;
            case "Ford":
                carBackground = new ImageIcon(this.getClass().getResource("ford_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "Fiesta RS", "Focus RS", "Mustang" });
                break;
            case "Hyundai":
                carBackground = new ImageIcon(this.getClass().getResource("hyundai_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "Tucson", "Sonata", "Santa FE" });
                break;
            case "Mercedes":
                carBackground = new ImageIcon(this.getClass().getResource("mercedes_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "E_Class", "S_Class", "G_Class" });
                break;
            case "Opel":
                carBackground = new ImageIcon(this.getClass().getResource("opel_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "Astra J", "Vectra A", "Calibra" });
                break;
            case "Volkswagen":
                carBackground = new ImageIcon(this.getClass().getResource("volkswagen_background.jpg"));
                comboBoxModel = new JComboBox<>(new String[] { "Passat", "Golf", "Maybach" });
                break;
            
            default:
                throw new IllegalArgumentException("Unsupported brand");
        }


        carBackgroundLabel = new JLabel(carBackground);
        carBackgroundLabel.setSize(500, 600);
        carBackgroundLabel.setLayout(null);

        cadruCar = new JFrame(brand);
        cadruCar.setSize(500, 600);
        cadruCar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadruCar.setResizable(false);
        cadruCar.setLocationRelativeTo(null);
        
        lblMarca = new JLabel("Marca: " + brand);                   //marca, label + brand
        lblMarca.setBounds(35, 60, 105, 40);
        lblMarca.setForeground(Color.white);
        lblMarca.setBackground(new Color(255, 255, 255, 50));
        lblMarca.setOpaque(true);
        Font currentFont = lblMarca.getFont();
        Font newFont = currentFont.deriveFont(18f); // setting font size to 18
        lblMarca.setFont(newFont);
        cadruCar.add(lblMarca);


        lblModel = new JLabel("Model: ");           //model, dropdown
        lblModel.setBounds(35, 120, 185, 40);
        lblModel.setForeground(Color.white);
        lblModel.setBackground(new Color(255, 255, 255, 50));
        lblModel.setOpaque(true);
        Font currentFontModel = lblModel.getFont();
        Font newFontModel = currentFontModel.deriveFont(18f); // setting font size to 18
        lblModel.setFont(newFontModel);
        comboBoxModel.setBounds(100, 125, 105, 30);
        carBackgroundLabel.add(lblModel);
        carBackgroundLabel.add(comboBoxModel);
        String selectetModel = (String) comboBoxModel.getSelectedItem();

        lblSasiu = new JLabel("Sasiu: ");                   //sasiu
        lblSasiu.setBounds(35, 180, 105, 40);
        lblSasiu.setForeground(Color.black);
        lblSasiu.setBackground(new Color(255, 255, 255, 180));
        lblSasiu.setOpaque(true);
        Font currentFontSasiu = lblSasiu.getFont();
        Font newFontSasiu = currentFontSasiu.deriveFont(18f); // setting font size to 18
        lblSasiu.setFont(newFontSasiu);
        cadruCar.add(lblSasiu);

        textFieldVIN = new JTextField(15);              // font size pt text field
        textFieldVIN.setBounds(100, 180, 105, 40);
        Font currentFontVIN = textFieldVIN.getFont();
        Font newFontVIN = currentFontVIN.deriveFont(20f);  // setting font size to 20
        textFieldVIN.setFont(newFontVIN);
        carBackgroundLabel.add(textFieldVIN);

        lblKM = new JLabel("KM: ");                   //KM
        lblKM.setBounds(35, 240, 105, 40);
        lblKM.setForeground(Color.black);
        lblKM.setBackground(new Color(255, 255, 255, 180));
        lblKM.setOpaque(true);
        Font currentFontKM = lblKM.getFont();
        Font newFontKM = currentFontKM.deriveFont(18f); // setting font size to 18
        lblKM.setFont(newFontKM);
        cadruCar.add(lblKM);

        textFieldKM = new JTextField(15);                          // font size pt text field
        textFieldKM.setBounds(70, 240, 105, 40);
        textFieldKM.setFont(newFontKM);
        carBackgroundLabel.add(textFieldKM);

        TransparentRoundedButton btnAdd = new TransparentRoundedButton("Adaugare");
        btnAdd.setBounds(35, 300, 100, 50);
        carBackgroundLabel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double km = Double.parseDouble(textFieldKM.getText());
                if (km < 0) {
                    JOptionPane.showMessageDialog(null, "KM nu pot fi negativi", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Masini masinaNoua = new Masini(textFieldVIN.getText(), Double.parseDouble(textFieldKM.getText()),
                            brand, selectetModel);
                    Masini.addCar(masinaNoua);
                    JOptionPane.showMessageDialog(null, "Success", "Notification", JOptionPane.INFORMATION_MESSAGE);

                    if (isElectric) {
                        electricCarCount++;
                    } else {
                        nonElectricCarCount++;
                    }
                }
            }
        });


        TransparentRoundedButton btnAcasa = new TransparentRoundedButton("Meniu Principal");
        btnAcasa.setBounds(180, 430, 100, 40);
        carBackgroundLabel.add(btnAcasa);
        // JLabel test = new JLabel();
        // test.setBounds(180, 460, 100, 40);
        // test.setVisible(false);
        // carBackgroundLabel.add(test);
        // test.setForeground(Color.white);
        // test.setFont(newFontKM);

        btnAcasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadruCar.dispose();
                new CatalogMasiniStart();
            }
        });

        cadruCar.add(carBackgroundLabel);

        cadruCar.setVisible(true);


    }

    // Getter methods for car counts
    public static int getElectricCarCount() {
        return electricCarCount;
    }

    public static int getNonElectricCarCount() {
        return nonElectricCarCount;
    }



    }
