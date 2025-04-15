package com.caycon.view;

import javax.swing.*;

import com.caycon.dao.UserDAO;
import com.caycon.model.User;

import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Đăng Nhập");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        panel.add(lblUsername, gbc);

        JTextField txtUsername = new JTextField(15);
        txtUsername.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        panel.add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        panel.add(lblPassword, gbc);

        JPasswordField txtPassword = new JPasswordField(15);
        txtPassword.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        panel.add(txtPassword, gbc);

        // Nút đăng nhập
        JButton btnLogin = new JButton("Đăng nhập");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(btnLogin, gbc);

        add(panel, BorderLayout.CENTER);

        // Xử lý sự kiện nút Đăng nhập
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            try {
                UserDAO userDAO = new UserDAO();
                User user = userDAO.authenticate(username, password);
                if (user != null) {
                    // Đăng nhập thành công, chuyển sang MainFrame
                    dispose(); // Đóng LoginFrame
                    new MainFrame(user).setVisible(true); // Mở MainFrame
                } else {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}