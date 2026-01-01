package GUI;

import MainCode.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JTextField username = new JTextField(15);
        JTextField password = new JTextField(15);
        JComboBox<String> role = new JComboBox<>(new String[]{"buyer", "seller"});

        JButton registerBtn = new JButton("Register");

        registerBtn.addActionListener(e -> register(username.getText(), password.getText(), role.getSelectedItem().toString()));

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username"));
        panel.add(username);
        panel.add(new JLabel("Password"));
        panel.add(password);
        panel.add(new JLabel("Role"));
        panel.add(role);
        panel.add(registerBtn);

        add(panel);
        setVisible(true);
    }

    private void register(String u, String p, String r) {
        try (Connection c = DatabaseConnection.connect()) {
            String sql = "INSERT INTO users(username,password,role,balance) VALUES(?,?,?,0)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, u);
            ps.setString(2, p);
            ps.setString(3, r);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registered Successfully");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Username already exists");
        }
    }
}
