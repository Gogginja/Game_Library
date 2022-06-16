import java.awt.*;
@SuppressWarnings("All")
public class PongScore extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;

    /**
     *
     * @param GAME_WIDTH Constant for window width
     * @param GAME_HEIGHT Constant for window height
     */
    PongScore(int GAME_WIDTH, int GAME_HEIGHT){
        PongScore.GAME_WIDTH = GAME_WIDTH;
        PongScore.GAME_HEIGHT = GAME_HEIGHT;
    }

    /**
     *
     * @param g draws the scores graphics
     */
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);
    }
}
