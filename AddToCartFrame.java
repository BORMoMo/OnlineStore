package GUI;

import MainCode.BuyerService;

import javax.swing.*;

public class AddToCartFrame extends JFrame {

    public AddToCartFrame(int buyerId) {
        setTitle("Add To Cart");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JTextField productId = new JTextField(10);
        JTextField quantity = new JTextField(10);

        JButton add = new JButton("Add");

        add.addActionListener(e -> {
            BuyerService.addToCart(buyerId);
            JOptionPane.showMessageDialog(this, "Added to cart");
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Product ID"));
        panel.add(productId);
        panel.add(new JLabel("Quantity"));
        panel.add(quantity);
        panel.add(add);

        add(panel);
        setVisible(true);
    }
}
