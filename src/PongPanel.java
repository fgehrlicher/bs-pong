import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class PongPanel extends JPanel {
    private Pong game;
    private Ball ball;
    private Player bluePlayer;
    private Player redPlayer;

    public PongPanel(Pong game) {

        setBackground(Color.GRAY);
        bluePlayer = new Player(game, Color.BLUE, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 20);
        redPlayer = new Player(game, Color.RED, KeyEvent.VK_W, KeyEvent.VK_S, 10);

        this.game = game;
        ball = new Ball(game);

        addKeyListener(new PongKeyListener());
        Timer timer = new Timer(1, new PongActionListener());
        timer.start();

        setFocusable(true);
    }

    private class PongKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            bluePlayer.pressed(e.getKeyCode());
            redPlayer.pressed(e.getKeyCode());
        }

        public void keyReleased(KeyEvent e) {
            bluePlayer.released(e.getKeyCode());
            redPlayer.released(e.getKeyCode());
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    private class PongActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ball.update();
            bluePlayer.update();
            redPlayer.update();
            repaint();
        }
    }

    public Player getBluePlayer() {
        return bluePlayer;
    }

    public Player getRedPlayer() {
        return redPlayer;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Schwarz " + game.getPongPanel().getBluePlayer().getScore() + " : " + game.getPongPanel().getRedPlayer().getScore() + " Rot", game.getWidth() / 2, 10);

        ball.paint(g);
        redPlayer.paint(g);
        bluePlayer.paint(g);

        if (game.getPongPanel().getRedPlayer().getScore() == 10) {
            JOptionPane.showMessageDialog(null, "Roter Spieler gewinnt!", "Pong", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        } else if (game.getPongPanel().getBluePlayer().getScore() == 10) {
            JOptionPane.showMessageDialog(null, "Schwarz Spieler gewinnt!", "Pong", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

    }


}
