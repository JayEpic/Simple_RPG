import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    // Override
    public void keyTyped(KeyEvent o) {
        // TODO Auto-generated method stub
    }

    // Override
    public void keyPressed(KeyEvent o) {
         int code = o.getKeyCode();

         if (code == KeyEvent.VK_Z) {
            upPressed = true;
         }

         if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_Q) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    // Override
    public void keyReleased(KeyEvent o) {
        int code = o.getKeyCode();

        if (code == KeyEvent.VK_Z) {
            upPressed = false;
         }

         if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_Q) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }        
    }
}
