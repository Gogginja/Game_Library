import java.awt.*;
import java.awt.event.KeyEvent;

public class PongPaddles extends Rectangle {

    int id;
    int yVelocity;
    int speed = 8;
    PongPaddles(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;

    }

    public void keyPressed(KeyEvent e){
        switch (id) {
            case 1 : {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
            }
            case 2 : {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){
        switch (id) {
            case 1 : {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
            }
            case 2 : {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
            }
        }
    }

    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    public void move(){
        y = y + yVelocity;
    }

    public void draw(Graphics graphics){
        if(id == 1)
            graphics.setColor(Color.BLUE);
        else
            graphics.setColor(Color.RED);
        graphics.fillRect(x, y, width, height);
    }
}
