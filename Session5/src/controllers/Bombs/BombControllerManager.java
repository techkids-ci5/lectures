package controllers.Bombs;

import controllers.ControllerManager;

import java.util.Random;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class BombControllerManager extends ControllerManager {

    private int count;
    private static final int PERIOD = 150;

    public static final BombControllerManager instance = new BombControllerManager();

    @Override
    public void run() {
        count++;
        if(count >= PERIOD) {
            count = 0;
            /*  Generate bomb */
            Random r = new Random();
            int x = r.nextInt(600);
            int y = r.nextInt(800);
            BombController bombController = BombController
                    .create(x, y);
            this.add(bombController);
        }
        super.run();
    }
}
