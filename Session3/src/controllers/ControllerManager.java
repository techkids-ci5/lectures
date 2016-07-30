package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class ControllerManager implements BaseController {

    private Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<SingleController>();
    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }

    @Override
    public void draw(Graphics g) {
        for(BaseController controller : this.singleControllerVector) {
            controller.draw(g);
        }
    }

    @Override
    public void run() {
        Iterator<SingleController> singleControllerIterator =
                this.singleControllerVector.iterator();
        while(singleControllerIterator.hasNext()) {
            SingleController singleController = singleControllerIterator.next();
            if(!singleController.getGameObject().isAlive()) {
                singleControllerIterator.remove();
            } else {
                singleController.run();
            }
        }
    }
}
