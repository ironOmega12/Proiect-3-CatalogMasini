package interfata;

import javax.swing.*;
import vehicule.Masini;
import java.awt.*;

public class CarDetailsDialog extends JDialog {
    public CarDetailsDialog(Masini car) {
        setTitle("Car Details");
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create a JPanel to hold the labels
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create labels to display car details
        JLabel kmLabel = new JLabel("KM: " + car.getKm());
        JLabel marcaLabel = new JLabel("Marca: " + car.getMarca());
        JLabel modelLabel = new JLabel("Model: " + car.getModel());

        // Add labels to the panel
        contentPanel.add(kmLabel, BorderLayout.NORTH);
        contentPanel.add(marcaLabel, BorderLayout.CENTER);
        contentPanel.add(modelLabel, BorderLayout.SOUTH);

        // Set the content pane of the dialog to the panel
        setContentPane(contentPanel);

        // Make the dialog visible
        setVisible(true);
    }
}
