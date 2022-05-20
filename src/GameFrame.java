

import javax.swing.*;

public class GameFrame extends JFrame{
    JFrame snakeFrame = new JFrame();
    /**
     * Constructor to build the frame
     */
    GameFrame(){
        snakeFrame.add(new GamePanel());
        snakeFrame.setTitle("Snake");
        snakeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snakeFrame.setResizable(false);
        snakeFrame.pack();
        snakeFrame.setVisible(true);
        snakeFrame.setLocationRelativeTo(null);

    }
}
