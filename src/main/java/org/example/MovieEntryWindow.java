package org.example;

import javax.swing.*;
import java.awt.*;

public class MovieEntryWindow extends JFrame {
    public MovieEntryWindow() {
        setTitle("Add Movie - Movie Booking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();

        // App title
        JLabel appTitle = new JLabel("Movie Booking Application");
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        appTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 30, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(appTitle, gbc);

        // Reset gridwidth for fields
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 10);

        addFieldWithLabel(panel, gbc, 1, "Title:", new JTextField(20));
        addFieldWithLabel(panel, gbc, 2, "Genre:", new JTextField(20));
        addFieldWithLabel(panel, gbc, 3, "Rating:", new JTextField(20));
        addFieldWithLabel(panel, gbc, 4, "Duration:", new JTextField(20));
        addFieldWithLabel(panel, gbc, 5, "Synopsis:", new JTextField(20));

        // Add Movie Button
        JButton addMovieBtn = new JButton("Add Movie");
        styleButton(addMovieBtn);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(25, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addMovieBtn, gbc);

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
