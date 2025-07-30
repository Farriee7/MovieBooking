package org.example;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginWindow() {
        setTitle("Login - Movie Booking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel appTitle = new JLabel("Movie Booking Application");
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        appTitle.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        panel.add(appTitle, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        styleLabel(usernameLabel);
        gbc.gridy++; gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        styleField(usernameField);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        styleLabel(passwordLabel);
        gbc.gridx = 0; gbc.gridy++;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        styleField(passwordField);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        styleButton(loginButton);
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            UserAuth auth = new UserAuth();
            if (auth.login(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new MovieEntryWindow(); // show movie entry UI
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        panel.add(loginButton, gbc);

        JButton switchToSignup = new JButton("Create an Account");
        switchToSignup.setBorderPainted(false);
        switchToSignup.setContentAreaFilled(false);
        switchToSignup.setForeground(Color.LIGHT_GRAY);
        switchToSignup.addActionListener(e -> {
            new SignupWindow();
            dispose();
        });

        gbc.gridy++;
        panel.add(switchToSignup, gbc);

        add(panel);
        setVisible(true);
    }

    private void styleLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }

    private void styleField(JTextField field) {
        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

}
