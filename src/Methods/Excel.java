/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
public class Excel {

    static Connection conn = coffee_shop.javaConnection.database();

    public static void ExcelPrint() {
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

    }
}
