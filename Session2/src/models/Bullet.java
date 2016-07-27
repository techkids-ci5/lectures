package models;

/**
 * Created by qhuydtvt on 7/27/2016.
 */
public class Bullet {
    public int y;
    public int x;
    public int dx;
    public int dy;

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
}
