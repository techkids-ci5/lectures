import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by qhuydtvt on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeImage;
    int planeX = 250;
    int planeY = 650;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;

    Thread thread;
    public GameWindow() {
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(600,800);
        this.setLocation(0,0);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        try {
            background = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            planeImage = ImageIO.read(new File("resources/plane4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.repaint();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_LEFT :
                        planeX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT :
                        planeX += 10;
                        break;
                    case KeyEvent.VK_UP :
                        planeY -= 10;
                        break;
                    case KeyEvent.VK_DOWN :
                        planeY += 10;
                        break;
                }
                //repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {

        bufferImageGraphic.drawImage(background, 0, 0, null);
        bufferImageGraphic.drawImage(planeImage, planeX, planeY, null);
        g.drawImage(bufferedImage,0,0,null);
        System.out.println("Paint");
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(27);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
