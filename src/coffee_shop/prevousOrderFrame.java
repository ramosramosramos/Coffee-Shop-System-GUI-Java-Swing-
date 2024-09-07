
package coffee_shop;

import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class prevousOrderFrame extends javax.swing.JFrame {
Connection conn = null;
    public prevousOrderFrame() {
        initComponents();
        
        conn = javaConnection.database();
        setupDatabase();
   
        
        
        
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

    
       void setupDatabase() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS CoffeeDatabase");
            stmt.executeUpdate("USE CoffeeDatabase");

            try (PreparedStatement pstPreviousTable = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS PreviousCoffeeTable ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "item_name VARCHAR(100) NOT NULL, "
                    + "item_quantity VARCHAR(100) NOT NULL, "
                    + "item_amount VARCHAR(100) NOT NULL, "
                    + "order_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")) {
                pstPreviousTable.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        excelPrintButton2 = new javax.swing.JButton();
        excelPrintButton1 = new javax.swing.JButton();
        pdfPrintButton = new javax.swing.JButton();
        deleteOrder = new javax.swing.JButton();
        previousTotalSales = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        previousTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 51, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 75));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        excelPrintButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        excelPrintButton2.setText("Back");
        excelPrintButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excelPrintButton2.setPreferredSize(new java.awt.Dimension(150, 40));
        excelPrintButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelPrintButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(excelPrintButton2);

        excelPrintButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        excelPrintButton1.setText("Print (Excel)");
        excelPrintButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excelPrintButton1.setPreferredSize(new java.awt.Dimension(150, 40));
        excelPrintButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelPrintButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(excelPrintButton1);

        pdfPrintButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        pdfPrintButton.setText("Print (PDF)");
        pdfPrintButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pdfPrintButton.setPreferredSize(new java.awt.Dimension(150, 40));
        pdfPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfPrintButtonActionPerformed(evt);
            }
        });
        jPanel3.add(pdfPrintButton);

        deleteOrder.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        deleteOrder.setText("Delete All Order");
        deleteOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteOrder.setPreferredSize(new java.awt.Dimension(150, 40));
        deleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderActionPerformed(evt);
            }
        });
        jPanel3.add(deleteOrder);

        previousTotalSales.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        previousTotalSales.setForeground(new java.awt.Color(255, 255, 255));
        previousTotalSales.setText("Total Sales:");
        previousTotalSales.setToolTipText("");
        jPanel3.add(previousTotalSales);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        previousTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        previousTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previousTable.setRowHeight(20);
        previousTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(previousTable);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1269, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void excelPrintButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelPrintButton1ActionPerformed
        JFileChooser fileSave = new JFileChooser();
        File selectedFile;
        int result = fileSave.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileSave.getSelectedFile().getAbsoluteFile();
            String location = selectedFile + ".xlsx";
            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Previous Order");
                PreparedStatement pst = conn.prepareStatement("Select * from PreviousCoffeeTable");
                ResultSet rs = pst.executeQuery();

                XSSFRow rowHeader = sheet.createRow(0);
                rowHeader.createCell(0).setCellValue("Name");
                rowHeader.createCell(1).setCellValue("Quantity");
                rowHeader.createCell(2).setCellValue("Amount");
                rowHeader.createCell(3).setCellValue("Order Time");

                int rowNumber = 1;
                while (rs.next()) {
                    XSSFRow row = sheet.createRow(rowNumber++);

                    row.createCell(0).setCellValue(rs.getString("item_name"));
                    row.createCell(1).setCellValue(rs.getString("item_quantity"));
                    row.createCell(2).setCellValue(rs.getString("item_amount"));
                    row.createCell(3).setCellValue(rs.getString("order_time"));

                }

                JOptionPane.showMessageDialog(null, "Successfull Printed to : " + location);
                System.out.println(location);
                workbook.write(new FileOutputStream(location));
                Desktop.getDesktop().open(new File(location));
            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }//GEN-LAST:event_excelPrintButton1ActionPerformed

    private void pdfPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfPrintButtonActionPerformed
        JFileChooser pdfChooser = new JFileChooser();

        pdfChooser.setDialogTitle("Please choose a directory and name the file");
        File pdf;
        int result = pdfChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            pdf = pdfChooser.getSelectedFile().getAbsoluteFile();

            try {

                Document document = new Document(PageSize.A4);
                PdfWriter.getInstance(document, new FileOutputStream(pdf + ".pdf"));
                document.open();

                Paragraph title = new Paragraph("Orders", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(20);
                document.add(title);

                PdfPTable tables = new PdfPTable(previousTable.getColumnCount());

                for (int i = 0; i < previousTable.getColumnCount(); i++) {
                    tables.addCell(previousTable.getColumnName(i));
                }
                for (int row = 0; row < previousTable.getRowCount(); row++) {
                    for (int column = 0; column < previousTable.getColumnCount(); column++) {
                        tables.addCell(previousTable.getValueAt(row, column).toString());
                    }
                }

                document.add(tables);
                document.close();
                JOptionPane.showMessageDialog(null, "Successfull printed to pdf,locatio: " + pdf.toString() + ".pdf");
                Desktop.getDesktop().open(new File(pdf.toString() + ".pdf"));

            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_pdfPrintButtonActionPerformed

    private void deleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Are you sure want to delete all", "Warning", JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = conn.prepareStatement("truncate table PreviousCoffeeTable")) {
                previousTotalSales.setText("");
                int affect = pst.executeUpdate();
                if (affect > 0) {
                    DefaultTableModel model = (DefaultTableModel) this.previousTable.getModel();
                    model.setRowCount(0);

                }
            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }//GEN-LAST:event_deleteOrderActionPerformed

    private void excelPrintButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelPrintButton2ActionPerformed
     new home().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_excelPrintButton2ActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new prevousOrderFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteOrder;
    private javax.swing.JButton excelPrintButton;
    private javax.swing.JButton excelPrintButton1;
    private javax.swing.JButton excelPrintButton2;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pdfPrintButton;
    private javax.swing.JTable previousTable;
    private javax.swing.JLabel previousTotalSales;
    // End of variables declaration//GEN-END:variables
}
