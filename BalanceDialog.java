package GUI;

import MainCode.Main;

import javax.swing.*;

public class BalanceDialog {

    public static void show(int userId) {
        try {
            double balance = Main.getBalanceForUser(userId);
            JOptionPane.showMessageDialog(null, "Your balance: " + balance + " TL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading balance");
        }
    }

    public static void add(int userId) {
        String input = JOptionPane.showInputDialog("Enter amount:");
        if (input == null) return;

        try {
            double amount = Double.parseDouble(input);
            Main.addBalance(userId);
            JOptionPane.showMessageDialog(null, "Balance added");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid amount");
        }
    }
}
