package GUI;

import MainCode.BuyerService;
import MainCode.SellerService;

import javax.swing.*;

public class ViewProductsFrame extends JFrame {

    public ViewProductsFrame(int userId, boolean isSeller) {
        setTitle("Products");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        if (isSeller) {
            SellerService.viewProducts(userId);
        } else {
            BuyerService.viewProducts();
        }

        add(scroll);
        setVisible(true);
    }
}
