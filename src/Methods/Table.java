package Methods;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table {

    public static void DesignTable(JTable table) {
        table.getTableHeader().setFont(new Font("Sanserif", Font.BOLD, 15));
        table.setDefaultEditor(Object.class, null);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }

        });
    }

    public static void RemoveItem(JTable table, DefaultTableModel model, JLabel totalValue,
            JLabel cashValue, JLabel balanceLabel, double totalAmount) {
        coffee_shop.mainFrame main = new coffee_shop.mainFrame();
        if (table.getSelectedRow() != -1) {
            model.removeRow(table.getSelectedRow());

            for (int i = 0; i < table.getRowCount(); i++) {
                String valueTotalAmount = model.getValueAt(i, 2).toString().replace("₱", "");
                totalAmount += Double.parseDouble(valueTotalAmount);
            }
            totalValue.setText("₱" + totalAmount);
            cashValue.setText("");
            balanceLabel.setText("");
        } else {
            main.onGlass();
            JOptionPane.showMessageDialog(table, "Please select a row you want to delete");
            main.offGlass();
        }
    }
}
