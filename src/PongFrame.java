import javax.swing.*;
import java.awt.*;

public class PongFrame extends JFrame {

    PongPanel panel;
    PongFrame(){
        panel = new PongPanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
