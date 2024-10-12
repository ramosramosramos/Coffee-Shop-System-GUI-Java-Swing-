/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Total {
    public static void getTotalAmount(DefaultTableModel model, JLabel totalValue ) {
        
        double total = 0.0;
        
        for (int i = 0; i < model.getRowCount(); i++) {
            
            Object value = model.getValueAt(i, 2);
            
            if (value != null && value instanceof Number) {
                
                total += ((Number) value).doubleValue();
            }
        }
        
        totalValue.setText(String.valueOf(total));
        totalValue.repaint();
        totalValue.revalidate();
    }
}
