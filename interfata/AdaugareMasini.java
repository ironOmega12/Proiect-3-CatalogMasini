package interfata;
import masiniSelectie.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdaugareMasini {
    private JFrame frameAdaugare;

    public AdaugareMasini(){
        frameAdaugare = new JFrame("Adaugare Masini");
        frameAdaugare.setSize(900, 900);
        frameAdaugare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdaugare.setLayout(new GridLayout(3, 3));
        frameAdaugare.setResizable(false);
        frameAdaugare.setLocationRelativeTo(null);

        JButton button = new JButton();
        ImageIcon icon = new ImageIcon("imagini-adaugare/img1.jpg");
        button.setIcon(icon);
        frameAdaugare.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("Audi",false);
            }
        });

        JButton button2 = new JButton();
        ImageIcon icon2 = new ImageIcon("imagini-adaugare/img2.jpg");
        button2.setIcon(icon2);
        frameAdaugare.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("BMW",false);
            }
        });

        JButton button3 = new JButton();
        ImageIcon icon3 = new ImageIcon("imagini-adaugare/img3.jpg");
        button3.setIcon(icon3);
        frameAdaugare.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("Volkswagen",false);
            }
        });
        JButton button4 = new JButton();
        ImageIcon icon4 = new ImageIcon("imagini-adaugare/img4.jpg");
        button4.setIcon(icon4);
        frameAdaugare.add(button4);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("Mercedes",false);
            }
        });

        JButton button5 = new JButton();
        ImageIcon icon5 = new ImageIcon("imagini-adaugare/img5.jpg");
        button5.setIcon(icon5);
        frameAdaugare.add(button5);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new Custom();
            }
        });

        JButton button6 = new JButton();
        ImageIcon icon6 = new ImageIcon("imagini-adaugare/img6.jpg");
        button6.setIcon(icon6);
        frameAdaugare.add(button6);
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("Opel",false);
            }
        });

        JButton button7 = new JButton();
        ImageIcon icon7 = new ImageIcon("imagini-adaugare/img7.jpg");
        button7.setIcon(icon7);
        frameAdaugare.add(button7);
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new Tesla("Tesla",true);
            }
        });

        JButton button8 = new JButton();
        ImageIcon icon8 = new ImageIcon("imagini-adaugare/img8.jpg");
        button8.setIcon(icon8);
        frameAdaugare.add(button8);
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("Hyundai",false);
            }
        }); 
        JButton button9 = new JButton();
        ImageIcon icon9 = new ImageIcon("imagini-adaugare/img9.jpg");
        button9.setIcon(icon9);
        frameAdaugare.add(button9);
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameAdaugare.dispose();
                new CarUI("Ford",false);
            }
        });





        

        frameAdaugare.setVisible(true);
    }
    
}
