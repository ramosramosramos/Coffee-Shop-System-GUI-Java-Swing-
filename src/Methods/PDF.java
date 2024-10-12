/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class PDF {
    
    public static void PrintPDF(JTable previousTable){
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
    }
}
