package controllers;

import models.Enemy;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyManager extends ControllerManager {

    private EnemyManager() {
        super();
        int enX = 10;
        int enY = 10;
        for(int i = 0; i < 5; i++) {
            EnemyController enemyController = new EnemyController(
                    new Enemy(enX, enY),
                    new ImageDrawer("resources/plane1.png")
            );
            enX += 100;
            this.add(enemyController);
        }
    }

    @Override
    public void run() {
        super.run();
    }

    public final static EnemyManager instance = new EnemyManager();
}
