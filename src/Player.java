import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player {
    private Pong game;
    private Color color;

    private int width, height, upKey, downKey, xAxis, yAxis, yStep, score;

    public Player(Pong game, Color color, int upKey, int downKey, int xAxis) {
        score = 0;
        width = 5;
        height = 50;
        this.game = game;
        this.xAxis = xAxis;
        yAxis = game.getHeight() / 2;

        this.upKey = upKey;
        this.downKey = downKey;

        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public void update() {
        if (yAxis > 0 && yAxis < game.getHeight() - height)
            yAxis += yStep;
        else if (yAxis == 0)
            yAxis++;
        else if (yAxis == game.getHeight() - height)
            yAxis--;
    }

    public void pressed(int keyCode) {
        if (keyCode == upKey)
            yStep = -1;
        else if (keyCode == downKey)
            yStep = 1;
    }

    public void released(int keyCode) {
        if (keyCode == upKey || keyCode == downKey)
            yStep = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(xAxis, yAxis, width, height);
    }

    public void paint(Graphics g) {
        g.fillRect(xAxis, yAxis, width, height);
        g.setColor(color);
    }
}