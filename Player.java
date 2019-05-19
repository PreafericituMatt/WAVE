package com.joc.main;

import java.awt.*;
import java.util.Random;
import java.awt.Rectangle;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
     //   collision();

    }

    //public Collision getCollision(){return collision;}


public Rectangle getBounds(){
    return new Rectangle(x,y ,32, 32);


}


public void tick() {

    x += velX;
    y += velY;

    x = Game.clamp(x, 0, Game.WIDTH - 49);
    y = Game.clamp(y, 0, Game.HEIGHT - 72);
    collision();

}

    private void collision () {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    HUD.HEALTH -= 2;
                    if(HUD.HEALTH<=0)
                    System.out.println("YOU ARE DEAD");
                }

            }


        }
    }

    public void render(Graphics g){

   Graphics2D g2d = (Graphics2D) g;

    g.setColor(Color.green);
    g2d.draw(getBounds());


      g.setColor(Color.white);
      g.fillRect(x, y, 32,32);
    }
}
