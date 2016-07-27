import models.Bullet;
import models.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeImage;
    Image plane2Image;
    Image bulletImage;
//    int planeX = 250;
//    int planeY = 650;
//    int plane2X = 300;
//    int plane2Y = 650;

    Plane plane1;
    Plane plane2;

    int plane2Width;
    int plane2Height;

    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;

    Vector<Bullet> bulletVector;


    Thread thread;

    public GameWindow() {
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(600, 800);
        this.setLocation(0, 0);
        plane1 = new Plane(300,200);
        plane2 = new Plane(200,300);

        bulletVector = new Vector<Bullet>();

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
        // Google : java awt mouse invisible
        try {
            background = ImageIO.read(new File("resources/background.png"));
            planeImage = ImageIO.read(new File("resources/plane4.png"));
            plane2Image = ImageIO.read(new File("resources/plane3.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            this.plane2Width = plane2Image.getWidth(null);
            this.plane2Height = plane2Image.getHeight(null);
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
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane2.x, plane2.y);
                        bulletVector.add(bullet);
                        break;
                    case KeyEvent.VK_LEFT:
                        plane2.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane2.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane2.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane2.y += 10;
                        break;
                }
                //repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane1.moveTo(e.getX() - plane2Width / 2,
                        e.getY() - plane2Height / 2);

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
        bufferImageGraphic.drawImage(planeImage, plane1.x, plane1.y, null);
        bufferImageGraphic.drawImage(plane2Image, plane2.x, plane2.y, null);
        for (Bullet bullet : bulletVector) {
            bufferImageGraphic.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        g.drawImage(bufferedImage, 0, 0, null);
        System.out.println("Paint");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(27);

                Iterator<Bullet> bulletIterator = bulletVector.iterator();

                while(bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    if(bullet.y <= 0) {
                        bulletIterator.remove();
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
