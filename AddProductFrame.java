package GUI;

import MainCode.SellerService;

import javax.swing.*;

public class AddProductFrame extends JFrame {

    public AddProductFrame(int sellerId) {
        setTitle("Add Product");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JTextField name = new JTextField(15);
        JTextField price = new JTextField(15);
        JTextField stock = new JTextField(15);

        JButton add = new JButton("Add");

        add.addActionListener(e -> {
            try {
                SellerService.addProduct(sellerId);
                JOptionPane.showMessageDialog(this, "Product added");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding product");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name"));
        panel.add(name);
        panel.add(new JLabel("Price"));
        panel.add(price);
        panel.add(new JLabel("Stock"));
        panel.add(stock);
        panel.add(add);

        add(panel);
        setVisible(true);
    }
}
