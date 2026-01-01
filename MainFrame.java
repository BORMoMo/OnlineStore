package GUI;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Online Store");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");
        JButton exitBtn = new JButton("Exit");

        loginBtn.addActionListener(e -> new LoginFrame());
        registerBtn.addActionListener(e -> new RegisterFrame());
        exitBtn.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.add(loginBtn);
        panel.add(registerBtn);
        panel.add(exitBtn);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
