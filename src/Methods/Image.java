package Methods;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class Image {

    static JFileChooser imgChooser = new JFileChooser();
    static File selectedImage;

    public static void chooseImage(JMenuItem item, JButton button) {

        item.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int resultImage = imgChooser.showOpenDialog(null);
                if (resultImage == JFileChooser.APPROVE_OPTION) {
                    selectedImage = imgChooser.getSelectedFile().getAbsoluteFile();
                    button.setText("");
                    try {
                        BufferedImage img = ImageIO.read(new FileInputStream(selectedImage));
                        java.awt.Image image = img.getScaledInstance(button.getWidth(), button.getHeight(), java.awt.Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(image));

                    } catch (Exception ee) {
                        System.err.println(ee);

                    }

                }
            }

        });
    }
}
