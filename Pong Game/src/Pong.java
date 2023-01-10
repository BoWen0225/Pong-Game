import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JPanel implements ActionListener {
    // Ball position and velocity
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    // Paddle position and size
    int paddleX = 0;
    int paddleY = 0;
    int paddleWidth = 10;
    int paddleHeight = 60;

    // Timer for animation
    Timer timer;

    public Pong() {
        // Start the timer
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw the ball
        g.fillOval(x, y, 20, 20);

        // Draw the paddle
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    public void actionPerformed(ActionEvent e) {
        // Move the ball
        x += xa;
        y += ya;

        // Check for collision with edges
        if (x + 20 > getWidth()) {
            xa = -1;
        }
        if (y + 20 > getHeight()) {
            ya = -1;
        }
        if (x < 0) {
            xa = 1;
        }
        if (y < 0) {
            ya = 1;
        }

        // Check for collision with paddle
        if (x == paddleX && y + 20 > paddleY && y < paddleY + paddleHeight) {
            xa = 1;
        }

        repaint();
    }
}