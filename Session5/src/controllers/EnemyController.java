package controllers;

import controllers.Bombs.BombNotificationCenter;
import controllers.Bombs.BombSubscriber;
import models.Enemy;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */


public class EnemyController extends
        SingleController implements Colliable, BombSubscriber {

    public static final int SPEED = 3;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);

        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
        BombNotificationCenter.instance
                .subsribe(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"));
                break;
            case WHITE:
                enemyController = new EnemyController2(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"));
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }
}
