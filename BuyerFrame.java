package GUI;

import javax.swing.*;

public class BuyerFrame extends JFrame {

    public BuyerFrame(int buyerId) {
        setTitle("Buyer Menu");
        setSize(300, 300);
        setLocationRelativeTo(null);

        JButton viewProducts = new JButton("View Products");
        JButton addToCart = new JButton("Add To Cart");
        JButton addBalance = new JButton("Add Balance");
        JButton confirm = new JButton("Confirm Purchase");
        JButton balance = new JButton("View Balance");

        JButton logout = new JButton("Logout");

        viewProducts.addActionListener(e -> new ViewProductsFrame(buyerId, false));
        addToCart.addActionListener(e -> new AddToCartFrame(buyerId));
        addBalance.addActionListener(e -> BalanceDialog.add(buyerId));
        confirm.addActionListener(e -> BuyerActions.confirm(buyerId));
        balance.addActionListener(e -> BalanceDialog.show(buyerId));

        logout.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.add(viewProducts);
        panel.add(addToCart);
        panel.add(addBalance);
        panel.add(confirm);
        panel.add(balance);
        panel.add(logout);

        add(panel);
        setVisible(true);
    }
}
