package models;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class EnemyPlane extends GameObject {
    public int hp;

    public EnemyPlane(int x, int y, int width, int height, int hp) {
        super(x, y, width, height);
        this.hp = hp;
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
}
