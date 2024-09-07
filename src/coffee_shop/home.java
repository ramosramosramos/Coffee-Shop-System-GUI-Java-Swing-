package coffee_shop;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class home extends javax.swing.JFrame {
Connection conn = null;
    public home() {
        initComponents();
        conn = javaConnection.database();
        setupDatabase();
        s1.setVisible(false);
        s2.setVisible(false);
        hover(menuLabel, s1);
        hover(previousLabel, s2);
    
            hover(exit, dummy);
     
    }

    void hover(JLabel main, JLabel second) {
       
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                main.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));
                second.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                main.setBorder(null);
                second.setVisible(false);
            }

        });

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

        jPanel1 = new javax.swing.JPanel();
        previousLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        menuLabel = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        dummy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        previousLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        previousLabel.setForeground(new java.awt.Color(255, 255, 255));
        previousLabel.setText("Previous Order");
        previousLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previousLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                previousLabelMousePressed(evt);
            }
        });
        jPanel1.add(previousLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 50));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 520, 40));

        exit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Exit");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 70, 50));

        menuLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        menuLabel.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel.setText("Menu");
        menuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuLabelMousePressed(evt);
            }
        });
        jPanel1.add(menuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 50));

        s2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        s2.setForeground(new java.awt.Color(255, 255, 255));
        s2.setText("Show previous order");
        jPanel1.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 220, 50));

        s1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        s1.setForeground(new java.awt.Color(255, 255, 255));
        s1.setText("Proceed to order");
        jPanel1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 210, 50));
        jPanel1.add(dummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 150, 20));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(521, 310));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLabelMousePressed
        new mainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuLabelMousePressed

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void previousLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousLabelMousePressed
     new prevousOrderFrame().setVisible(true);
    }//GEN-LAST:event_previousLabelMousePressed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dummy;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JLabel previousLabel;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    // End of variables declaration//GEN-END:variables
}
