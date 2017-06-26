import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Pong extends JFrame {
    private PongPanel PongPanel;

    public Pong() {
        setTitle("Pong");
        setSize(1200, 300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PongPanel = new PongPanel(this);
        add(PongPanel);

        setVisible(true);
    }

    public PongPanel getPongPanel() {
        return PongPanel;
    }

    public static void main(String[] args) {
        new Pong();
    }
}