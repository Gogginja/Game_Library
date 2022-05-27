

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {
    JFrame snakeFrame = new JFrame();
    JMenuBar menuBar;
    JMenu exitMenu;
    JMenu playMenu;
    JMenuItem library;
    JMenuItem playAgain;
    /**
     * Constructor to build the frame
     */
    GameFrame(){
        //creates menu items
        menuBar = new JMenuBar();
        exitMenu = new JMenu("Exit");
        playMenu = new JMenu("Play Again");
        library = new JMenuItem("Exit to Library");
        playAgain = new JMenuItem("Play Again");



        exitMenu.add(library);
        playMenu.add(playAgain);
        menuBar.add(exitMenu);
        menuBar.add(playMenu);
        snakeFrame.setJMenuBar(menuBar);

        library.addActionListener(this);
        playAgain.addActionListener(this);

        snakeFrame.add(new GamePanel());
        snakeFrame.setTitle("Snake");
        snakeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snakeFrame.setResizable(false);
        snakeFrame.pack();
        snakeFrame.setVisible(true);
        snakeFrame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == library){
            snakeFrame.dispose();
            new LaunchPage();
        }

        if(e.getSource() == playAgain){
            snakeFrame.dispose();
            new GamePanel();
            new GameFrame();
        }
    }
}
