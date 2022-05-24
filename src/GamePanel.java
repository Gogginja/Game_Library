

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodySquares = 1;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean isRunning = false;
    Timer timer;
    Random random;
    JButton playAgain, quit;
    

    /**
     * Constructor
     * Sets screen width and height
     * Sets background
     * Adds a key listener
     */
    GamePanel(){
    random = new Random();
    this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    this.setBackground(Color.DARK_GRAY);
    this.setFocusable(true);
    this.addKeyListener(new myKeyAdapter());
    startGame();
    }

    /**
     * Method to start the game
     * Sets a Timer delay and then starts the timer
     */
    public void startGame(){
        newAppleGen();
        isRunning = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * Paint method
     * @param graphic to paint
     */

    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        draw(graphic);
    }

    /**
     *  method to draw Game over and score
     * @param g to draw
     */
    public void draw(Graphics g){

        if(isRunning) {
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodySquares; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten,
                    (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        }
        else{
            gameOver(g);
        }
    }

    /**
     * Method that randomly spawns in new apples after eaten
     */
    public void newAppleGen(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
    }

    /**
     * method to move snake
     */
    public void move(){
        for(int i = bodySquares; i > 0; i--){
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    /**
     * Method to check if apple is eaten
     * Increase score an body length
     * Calls newAppleGen() to spawn new apple
     */

    public void checkAppleEaten(){
        if((x[0] == appleX) && (y[0] == appleY)){
            bodySquares++;
            applesEaten++;
            newAppleGen();
        }

    }

    /**
     * Method to check if snake has crashed with itself or wall
     */

    public void checkCollisions(){
        //will check for head collide with body
        for(int i = bodySquares; i > 0; i--){
            if((x[0] == x[i]) && (y[0] == y[i])){
                isRunning = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0)
            isRunning = false;
        //checks if head touches right
        if(x[0] > SCREEN_WIDTH - UNIT_SIZE)
            isRunning = false;
        //checks if head touches top border
        if(y[0] < 0)
            isRunning = false;
        //checks if head touches bottom border
        if(y[0] > SCREEN_HEIGHT - UNIT_SIZE)
            isRunning = false;
        if(!isRunning){
            timer.stop();
        }
    }

    /**
     *Method to draw game over sign and creates the play again button
     * @param g to draw the game over text
     */

    public void gameOver(Graphics g){
        //score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten,
                (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        //game over
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",
                (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

       playAgain = new JButton("Play Again");
       playAgain.setSize(95, 50);
       playAgain.setLocation(250,340);
       playAgain.addActionListener(this);
       playAgain.setBackground(Color.WHITE);
       playAgain.setBorderPainted(false);
       this.add(playAgain);

       quit = new JButton("Quit");
       quit.setSize(95, 50);
       quit.setLocation(250, 400);
       quit.addActionListener(this);
       quit.setBackground(Color.WHITE);
       quit.setBorderPainted(false);
       this.add(quit);

    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isRunning){
            move();
            checkAppleEaten();
            checkCollisions();
        }
        repaint();
        //FIXME just opens a new window needs to start fresh
        if(e.getSource() == playAgain){
            new GameFrame();
            new GamePanel();
        }

        if(e.getSource()== quit){
            new LaunchPage();
        }

    }

    public class myKeyAdapter extends KeyAdapter{
        /**
         * 
         * @param e the event to be processed
         */
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }

        }
    }
}