package com.caycon.view;

import javax.swing.*;
import java.awt.*;

import com.caycon.model.User;

public class ResultFrame extends JFrame {
    private User user;

    public ResultFrame(double score, double maxScore, User user) {
        this.user = user;
        setTitle("Kết Quả Bài Thi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblTitle = new JLabel("Kết Quả Bài Thi");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblTitle, gbc);

        JLabel lblScore = new JLabel(String.format("Điểm: %.2f / %.2f", score, maxScore));
        lblScore.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        panel.add(lblScore, gbc);

        JButton btnBack = new JButton("Quay Lại");
        btnBack.setPreferredSize(new Dimension(100, 30));
        gbc.gridy = 2;
        panel.add(btnBack, gbc);

        btnBack.addActionListener(e -> {
            dispose();
            new MainFrame(user).setVisible(true);
        });

        add(panel);
    }

    public static void main(String[] args) {
        User user = new User(1, "user", "123456", "candidate");
        SwingUtilities.invokeLater(() -> {
            ResultFrame frame = new ResultFrame(80, 100, user);
            frame.setVisible(true);
        });
    }
}