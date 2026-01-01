package GUI;

import MainCode.BuyerService;

import javax.swing.*;

public class BuyerActions {

    public static void confirm(int buyerId) {
        BuyerService.confirmPurchase(buyerId);
        JOptionPane.showMessageDialog(null, "Purchase processed");
    }
}
