/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class PreviousCoffee {
    static Connection conn = coffee_shop.javaConnection.database();
    public static void History(JTable previousTable,JLabel previousTotalSales ){
           try (PreparedStatement pst = conn.prepareStatement("Select id as 'Product ID',item_name as 'Product Name',"
                + "item_quantity as 'Quantity',item_amount as 'Total amount',order_time as 'Date and time'  from PreviousCoffeeTable")) {
            ResultSet rs = pst.executeQuery();
            previousTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
        previousTable.getTableHeader().setFont(new Font("Sanserif", Font.BOLD, 14));
        previousTable.getColumnModel().getColumn(0).setMaxWidth(100);
        previousTable.getColumnModel().getColumn(0).setMinWidth(100);
        previousTable.getColumnModel().getColumn(2).setMaxWidth(100);
        previousTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setFont(new Font("Sanserif", Font.BOLD, 12));
                table.setRowHeight(30);

                return this;
            }

        });

        try (PreparedStatement pst = conn.prepareStatement("Select sum(item_amount)from PreviousCoffeeTable")) {
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString(1) != null) {
                    previousTotalSales.setText("Total sales: ₱" + rs.getString(1));
                }

            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
