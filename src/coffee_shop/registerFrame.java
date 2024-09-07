package coffee_shop;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

public class registerFrame extends javax.swing.JFrame {

    Connection conn = null;

    public registerFrame() {
        initComponents();
        conn = javaConnection.database();
        setupDatabase();
        hover(signin);
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

     
       void hover(JLabel main) {

        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                main.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                main.setBorder(null);

            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        t1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        t2 = new javax.swing.JPasswordField();
        signin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        t3 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main.setBackground(new java.awt.Color(102, 51, 0));
        main.setForeground(new java.awt.Color(255, 255, 255));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        main.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 280, 30));

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up");
        main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 5, 280, -1));

        t2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        main.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 280, 30));

        signin.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        signin.setForeground(new java.awt.Color(255, 255, 255));
        signin.setText("Sign in");
        signin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signinMousePressed(evt);
            }
        });
        main.add(signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 50, 20));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, 20));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Re-type Password");
        main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 150, 20));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Already have an account?");
        main.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 150, 20));

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("11th street");
        main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 190, 50));

        signUpButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        signUpButton.setText("Sign up");
        signUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        main.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 280, 40));

        t3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        main.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 280, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        main.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 150, 20));

        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(586, 512));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        sign_up();
    }//GEN-LAST:event_signUpButtonActionPerformed

    void sign_up() {
        String user = t1.getText();
        String password1 = new String(t2.getPassword());
        String password2 = new String(t3.getPassword());

        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill the username field");
            t1.requestFocus();
            return;
        }

        if (password1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill the password field");
            t2.requestFocus();
            return;
        }

        if (password2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill the Re-type password field");
            t3.requestFocus();
            return;
        }

        if (password1.equals(password2)) {
            try (PreparedStatement pst = conn.prepareStatement("Insert into users(username,password) values(?,?)")) {
                pst.setString(1, user);
                pst.setString(2, password1);
                int affect = pst.executeUpdate();
                if (affect > 0) {
                    JOptionPane.showMessageDialog(null, "Created Successfully");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }
            } catch (Exception e) {
                System.err.println(e);
            }

        } else {

            JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
    }


    private void signinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinMousePressed
        new loginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signinMousePressed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        sign_up();
    }//GEN-LAST:event_t1ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        sign_up();
    }//GEN-LAST:event_t2ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        sign_up();
    }//GEN-LAST:event_t3ActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new registerFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel main;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signin;
    private javax.swing.JTextField t1;
    private javax.swing.JPasswordField t2;
    private javax.swing.JPasswordField t3;
    // End of variables declaration//GEN-END:variables
}
