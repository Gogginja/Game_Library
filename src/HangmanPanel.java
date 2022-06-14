import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanPanel extends JPanel {

    //declare jbuttons and text fields
    private Hangman game;
    private JLabel lblProgress, lblErrors, lblGuessed;
    private JButton guessButton;
    private JTextField guessField;

    public HangmanPanel(){

        game = new Hangman();

        setLayout(new GridLayout(10, 2));
        setBackground(Color.lightGray);

        add(new JLabel("Progress: "));
        lblProgress = new JLabel();
        lblProgress.setText(game.displayProcess());
        add(lblProgress);

        guessField = new JTextField("Enter a letter");
        add(guessField);

        guessButton = new JButton("Guess");
        add(guessButton);

        add(new JLabel("Errors: "));
        lblErrors = new JLabel();
        String errors = String.valueOf(game.getErrors());
        lblErrors.setText(errors);
        add(lblErrors);

        add(new JLabel("Guessed Letters: "));
        lblGuessed = new JLabel();
        lblGuessed.setText(game.getGuessedLetters());
        add(lblGuessed);


        guessButton.addActionListener(new ButtonListener());

        JOptionPane.showMessageDialog(null, "Welcome to Hangman! " +
                "You will be guessing Java Keywords. Guess one alphabetic character at a time, 6 errors and it's " +
                "game over.");

    }

    private void newGame(){
        game.newGame();
        lblProgress.setText(game.displayProcess());
        String errors = String.valueOf(game.getErrors());
        lblErrors.setText(errors);
        lblGuessed.setText(game.getGuessedLetters());
        guessField.setText("Enter a letter");
    }



    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == guessButton){
                if(guessField.getText().matches("[a-zA-Z]+")){
                    if(guessField.getText().length() == 1) {
                        switch (game.guess(guessField.getText())) {
                            case (0):
                                JOptionPane.showMessageDialog(null, "Incorrect!");
                                break;
                            case (1):
                                JOptionPane.showMessageDialog(null, "Correct");
                                break;
                            case (2):
                                JOptionPane.showMessageDialog(null, "You already guessed this letter!");
                                break;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please enter only ONE character.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter an alphabetical character.");
                }

                lblProgress.setText(game.displayProcess());
                String errors = String.valueOf(game.getErrors());
                lblErrors.setText(errors);
                lblGuessed.setText(game.getGuessedLetters());

                if (game.completenessCheck()) {
                    String[] responses = {"Play Again", "Game Library"};
                    ImageIcon icon = new ImageIcon("src\\Images\\hmwin.JPEG");
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "You Win!",
                            "Game Over",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            icon,
                            responses,
                            0);
                    //Play Again
                    if (choice == JOptionPane.YES_OPTION) {
                        newGame();
                    }
                    //Back to Game Library
                    if (choice == JOptionPane.NO_OPTION) {
                        ((Frame)HangmanPanel.this.getTopLevelAncestor()).dispose();
                        new LaunchPage();
                    }
                }

                if (game.getErrors() == 6) {
                    String[] responses = {"Play Again", "Game Library"};
                    ImageIcon icon = new ImageIcon("src\\Images\\hmlose.JPEG");
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "You Lose!",
                            "Game Over",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            icon,
                            responses,
                            0);
                    //Play Again
                    if (choice == JOptionPane.YES_OPTION) {
                        newGame();
                    }
                    //Back to Game Library
                    if (choice == JOptionPane.NO_OPTION) {
                        ((Frame)HangmanPanel.this.getTopLevelAncestor()).dispose();
                        new LaunchPage();
                    }
                }

            }
        }
    }
}
