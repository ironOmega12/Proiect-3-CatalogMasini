package interfata;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import vehicule.LoggerSingleton;

public class CatalogMasiniUI {
    private JFrame frameLogin;
    private JLabel mainLoginBg;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private LoggerSingleton logger = LoggerSingleton.getInstance();
    private static final String CREDENTIALS_FILE = "credentials.txt";

    public CatalogMasiniUI() {

        frameLogin = new JFrame("Login Page");
        frameLogin.setSize(500, 600);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setLocationRelativeTo(null);


        mainLoginBg = new JLabel(new ImageIcon(this.getClass().getResource("backgroundMain.jpg")));
        mainLoginBg.setSize(500, 600);


        usernameField = new JTextField();
        usernameField.setBounds(190, 240, 100, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 280, 100, 30);

        TransparentRoundedButton loginButton = new TransparentRoundedButton("Login");
        loginButton.setBounds(190, 320, 100, 50);

        mainLoginBg.add(usernameField);
        mainLoginBg.add(passwordField);
        mainLoginBg.add(loginButton);
        frameLogin.add(mainLoginBg);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (isValidLogin(username, password)) {
                    frameLogin.dispose();
                    new CatalogMasiniStart();
                    storeLoginInfo(username, password);

                    logger.log("Login successful for user: " + username);
                } else {
                    JOptionPane.showMessageDialog(frameLogin, "Invalid login credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frameLogin.setVisible(true);
    }

    private boolean isValidLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frameLogin, "Username and password must not be empty", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!username.matches(".*\\d{3,}.*")) {
            JOptionPane.showMessageDialog(frameLogin, "Username must contain at least 3 digits", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!username.matches("^[a-zA-Z0-9]*$")) {
            JOptionPane.showMessageDialog(frameLogin, "Username must contain only letters and digits", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.matches("^\\d+$")) {
            JOptionPane.showMessageDialog(frameLogin, "Password must contain only digits", "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void storeLoginInfo(String username, String password) {
        try (FileWriter writer = new FileWriter(CREDENTIALS_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(username + ":" + password);
            bufferedWriter.newLine();
        } catch (IOException e){}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CatalogMasiniUI();
        });
    }
}
