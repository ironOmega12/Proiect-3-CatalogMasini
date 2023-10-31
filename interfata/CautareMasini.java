package interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import vehicule.Masini;

public class CautareMasini {
    private JFrame frameCautare;
    private ImageIcon startBackground;
    private JButton buttonSearch, searchButton, acasa;
    private JLabel startBgLabel;
    private JTextField VIN;
    private JLabel vinLabel;

    public CautareMasini() {
        startBackground = new ImageIcon(this.getClass().getResource("brembo.png"));
        startBgLabel = new JLabel(startBackground);
        startBgLabel.setSize(500, 600);
        startBgLabel.setLayout(null);

        frameCautare = new JFrame();

        frameCautare.setSize(600, 600);
        frameCautare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCautare.setLayout(new BorderLayout());
        frameCautare.setResizable(false);
        frameCautare.setLocationRelativeTo(null);  // This will center the frame.

        acasa = new TransparentRoundedButton("Acasa");
        acasa.setBounds(220, 50, 150, 30);
        buttonSearch = new TransparentRoundedButton("Cauta masina");
        buttonSearch.setBounds(220, 250, 150, 30);

        vinLabel = new JLabel("<html><font face='Arial'  size='5' color='yellow'>Introduceti VIN:</font></html>");
        vinLabel.setBounds(220, 290, 350, 30);
        vinLabel.setVisible(false);

        VIN = new JTextField();
        VIN.setBounds(220, 320, 150, 30);
        VIN.setVisible(false);

        searchButton = new TransparentRoundedButton("Click pentru cautare");
        searchButton.setBounds(220, 360, 150, 30);
        searchButton.setVisible(false);

        acasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameCautare.dispose();
                new CatalogMasiniStart();
            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make VIN label, text field, and search button visible
                vinLabel.setVisible(true);
                VIN.setVisible(true);
                searchButton.setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPlacuta = VIN.getText().trim();
                Masini foundCar = findCarByPlacuta(enteredPlacuta);
                VIN.setText("");
                if (foundCar != null) {
                    displayCarDetails(foundCar);
                    JOptionPane.showMessageDialog(null, foundCar.refillOrRecharge(), "Rezervor / baterie", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    vinLabel.setVisible(false);
                    VIN.setVisible(false);
                    searchButton.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Car not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            private Masini findCarByPlacuta(String placuta) {
                for (Masini car : Masini.getAllCars()) {
                    if (car.getPlacuta().equals(placuta)) {
                        return car; // Found the car
                    }
                }
                return null; // Car not found
            }
        });

        startBgLabel.add(acasa);
        startBgLabel.add(searchButton);
        startBgLabel.add(vinLabel);
        startBgLabel.add(VIN);
        startBgLabel.add(buttonSearch);
        frameCautare.add(startBgLabel);
        frameCautare.setVisible(true);
    }

    private void displayCarDetails(Masini car) {
        CarDetailsDialog carDetailsDialog = new CarDetailsDialog(car);
        carDetailsDialog.setVisible(true);

    }
}
