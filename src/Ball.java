import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private static final int WIDTH = 15, HEIGHT = 15;
    private Pong game;
    private int x, y, xa = 2, ya = 2;

    public Ball(Pong game) {
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }

    public void update() {
        x += xa;
        y += ya;
        if (x < 0) {
            game.getPongPanel().getRedPlayer().increaseScore();
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (x > game.getWidth() - WIDTH - 7) {
            game.getPongPanel().getBluePlayer().increaseScore();
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
        checkCollision();
    }

    public void checkCollision() {
        if (game.getPongPanel().getRedPlayer().getBounds().intersects(getBounds()) || game.getPongPanel().getBluePlayer().getBounds().intersects(getBounds()))
            xa = -xa;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}