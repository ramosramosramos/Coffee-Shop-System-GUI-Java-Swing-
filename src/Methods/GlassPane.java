/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JRootPane;

/**
 *
 * @author User
 */
public class GlassPane {
    public static void setTheGlassPane(JRootPane rootPane){
               rootPane.setGlassPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {

                g.setColor(new Color(0, 0, 0, 190));
                g.fillRect(0, 0, getWidth(), getHeight());
            }

        });
    }
}
