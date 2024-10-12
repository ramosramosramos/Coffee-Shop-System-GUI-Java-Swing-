/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MenuItem {

    public static void JMenuItem_EditPrice_Function(JMenuItem item, JLabel OldName) {

        item.addActionListener((ActionEvent e) -> {
            coffee_shop.mainFrame main = new coffee_shop.mainFrame();
            main.onGlass();
            String newName = JOptionPane.showInputDialog(OldName, "", "Rename old item price:", JOptionPane.PLAIN_MESSAGE);
            main.offGlass();
            if (newName != null && !newName.trim().isEmpty()) {
                try {
                    Double.parseDouble(newName);
                    OldName.setText("₱" + newName);
                } catch (NumberFormatException ex) {
                    main.onGlass();
                    JOptionPane.showMessageDialog(OldName, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    main.offGlass();
                }
            }
        });

    }

    public static void JMenuItem_Rename_Function(JMenuItem item, JLabel Oldname) {
        item.addActionListener((ActionEvent e) -> {
            coffee_shop.mainFrame main = new coffee_shop.mainFrame();
            main.onGlass();
            String New_name = JOptionPane.showInputDialog(Oldname, "", "Rename old item name :", JOptionPane.PLAIN_MESSAGE);
            main.offGlass();
            try {
                if (!New_name.trim().equals("")) {
                    Oldname.setText(New_name);
                }
            } catch (Exception ee) {
                System.err.println(ee.getMessage());

            }
        });
    }
}
