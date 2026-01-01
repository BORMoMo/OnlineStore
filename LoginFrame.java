package GUI;

import MainCode.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JTextField username = new JTextField(15);
        JPasswordField password = new JPasswordField(15);

        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> login(username.getText(), new String(password.getPassword())));

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username"));
        panel.add(username);
        panel.add(new JLabel("Password"));
        panel.add(password);
        panel.add(loginBtn);

        add(panel);
        setVisible(true);
    }

    private void login(String user, String pass) {
        try (Connection c = DatabaseConnection.connect()) {
            String sql = "SELECT id, role FROM users WHERE username=? AND password=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");

                dispose();
                if (role.equals("seller")) new SellerFrame(id);
                else new BuyerFrame(id);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
