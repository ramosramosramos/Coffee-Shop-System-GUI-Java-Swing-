/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class IP {
      static InputStream inputStream = null;

    public static void SendMessage(String IP_ADDRESS, String SEND_TO, String MESSSAGE, boolean appear) {

        String FINAL_MESSAGE = MESSSAGE.replaceAll("\\s", "+");
        try {

            String link = "http://" + IP_ADDRESS + ":8080/v1/sms/send/?phone=" + SEND_TO
                    + "&message=" + FINAL_MESSAGE;
            URL url = new URL(link);
            inputStream = url.openStream();
            inputStream.close();
            if (appear == true) {
                JOptionPane.showMessageDialog(null, "Message to employee has been sent");
            }

        } catch (IOException | HeadlessException e) {
            System.err.println(e.getMessage());
        }
    }
}
