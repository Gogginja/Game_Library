import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    
    
    JFrame frame = new JFrame();
    JButton snake = new JButton("Snake");
    JButton hangman = new JButton("Hangman");
    JButton memory = new JButton("Memory");
    JButton blockBreaker = new JButton("Block-Breaker");

    LaunchPage(){
        snake.setBounds(100, 100, 200, 40);
        snake.setFocusable(false);
        snake.addActionListener(this);
        hangman.setBounds(300, 100, 200, 40);
        hangman.setFocusable(false);
        hangman.addActionListener(this);
        memory.setBounds(300, 200, 200, 40);
        memory.setFocusable(false);
        memory.addActionListener(this);
        blockBreaker.setBounds(100, 200, 200, 40);
        blockBreaker.setFocusable(false);
        blockBreaker.addActionListener(this);

        frame.add(snake);
        frame.add(hangman);
        frame.add(memory);
        frame.add(blockBreaker);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==snake){
           new GameFrame();
           frame.dispose();
        }
        if(e.getSource() == blockBreaker){
            new BlockBreakerFrame();
            frame.dispose();
        }
    }
    
}
