import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongFrame extends JFrame implements ActionListener {

    PongPanel panel;
    JFrame pongFrame = new JFrame();
    JMenuBar menuBar;
    JMenu exitMenu;
    JMenu playMenu;
    JMenuItem library;
    JMenuItem playAgain;
    PongFrame(){
        panel = new PongPanel();

        menuBar = new JMenuBar();
        exitMenu = new JMenu("Exit");
        playMenu = new JMenu("Play Again");
        library = new JMenuItem("Exit to Library");
        playAgain = new JMenuItem("Play Again");



        exitMenu.add(library);
        playMenu.add(playAgain);
        menuBar.add(exitMenu);
        menuBar.add(playMenu);
        pongFrame.setJMenuBar(menuBar);

        library.addActionListener(this);
        playAgain.addActionListener(this);

        pongFrame.add(panel);
        pongFrame.setTitle("Pong Game");
        pongFrame.setResizable(false);
        pongFrame.setBackground(Color.DARK_GRAY);
        pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pongFrame.pack();
        pongFrame.setVisible(true);
        pongFrame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == library){
            pongFrame.dispose();
            new LaunchPage();
        }

        if(e.getSource() == playAgain){
            pongFrame.dispose();
            new PongPanel();
            new PongFrame();
        }

    }
}
