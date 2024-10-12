
package Methods;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Character {
       public static void noCharacterQuantity(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (!java.lang.Character.isDigit(c)) {
                    e.consume();
                }

            }

        });
    }
}
