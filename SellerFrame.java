package GUI;

import javax.swing.*;

public class SellerFrame extends JFrame {

    public SellerFrame(int sellerId) {
        setTitle("Seller Menu");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JButton addProduct = new JButton("Add Product");
        JButton viewProducts = new JButton("My Products");
        JButton balance = new JButton("View Balance");
        JButton logout = new JButton("Logout");

        addProduct.addActionListener(e -> new AddProductFrame(sellerId));
        viewProducts.addActionListener(e -> new ViewProductsFrame(sellerId, true));
        balance.addActionListener(e -> BalanceDialog.show(sellerId));
        logout.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.add(addProduct);
        panel.add(viewProducts);
        panel.add(balance);
        panel.add(logout);

        add(panel);
        setVisible(true);
    }
}
