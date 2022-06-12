import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanPanel extends JPanel {

    //declare jbuttons and text fields

    public HangmanPanel(){

        setLayout(new GridLayout(10, 2));
        setBackground(Color.lightGray);



    }






    private class ButtonListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
