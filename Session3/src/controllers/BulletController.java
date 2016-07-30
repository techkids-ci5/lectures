package controllers;

import models.Bullet;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class BulletController extends SingleController {

    private static final int SPEED = 20;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }
}
