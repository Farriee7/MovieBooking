package org.example;

import javax.swing.*;
import java.awt.*;

public class SignupWindow extends JFrame {
    public SignupWindow() {
        setTitle("Signup - Movie Booking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel appTitle = new JLabel("Movie Booking Application");
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        appTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 30, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(appTitle, gbc);

        // Reset gridwidth for labels and fields
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 10);

        // Full Name
        addFieldWithLabel(panel, gbc, 1, "Full Name:", new JTextField(20));
        // Username
        addFieldWithLabel(panel, gbc, 2, "Username:", new JTextField(20));
        // Password
        addFieldWithLabel(panel, gbc, 3, "Password:", new JPasswordField(20));
        // Phone Number
        addFieldWithLabel(panel, gbc, 4, "Phone Number:", new JTextField(20));
        // Address
        addFieldWithLabel(panel, gbc, 5, "Address:", new JTextField(20));

        // Signup Button
        JButton signupButton = new JButton("Signup");
        styleButton(signupButton);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(25, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(signupButton, gbc);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    private void addFieldWithLabel(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField field) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }


}
