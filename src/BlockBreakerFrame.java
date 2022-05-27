import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockBreakerFrame implements ActionListener{
    JFrame breaker = new JFrame();
    JMenuBar menuBar;
    JMenu exitMenu;
    JMenuItem library;
    BlockBreakerFrame(){
        menuBar = new JMenuBar();
        exitMenu = new JMenu("Exit");
        library = new JMenuItem("Exit to Library");


        exitMenu.add(library);
        menuBar.add(exitMenu);
        breaker.setJMenuBar(menuBar);
        library.addActionListener(this);
        GamePlay gamePlay = new GamePlay();
        breaker.add(gamePlay);
        breaker.setBounds(10,10,700,620);
        breaker.setTitle("BlockBreaker Game");
        breaker.setResizable(false);
        breaker.setLocationRelativeTo(null);
        breaker.setVisible(true);
        breaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == library){
            breaker.dispose();
            new LaunchPage();
        }
    }
}
