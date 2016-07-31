package controllers;

import models.Enemy;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyController extends SingleController implements Colliable {

    public static final int SPEED = 3;
    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
