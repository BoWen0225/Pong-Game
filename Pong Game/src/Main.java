import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        Pong pong = new Pong();
        frame.add(pong);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    pong.paddleY -= 10;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    pong.paddleY += 10;
                }
            }
        });
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }
}
