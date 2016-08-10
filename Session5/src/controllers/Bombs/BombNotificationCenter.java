package controllers.Bombs;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 8/10/2016.
 */


public class BombNotificationCenter {
    private Vector<BombSubscriber> subscribers;

    public BombNotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
    }

    public void subsribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void onBomExpode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public static final BombNotificationCenter instance = new BombNotificationCenter();
}
