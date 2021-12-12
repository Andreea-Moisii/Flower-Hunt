package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Flower extends Item {

    protected  BufferedImage image;
    protected int points;

    public Flower(int x, int y, RefLinks R,BufferedImage image,int p)
    {
    super(R,x,y,48,48);
    points=p;
    bounds.x=x;
    bounds.y=y;
    bounds.height=48;
    bounds.width=48;
    this.image=image;
    }


    @Override
    public void Update() {
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image,(int)x,(int)y,null);
        g.setColor(Color.red);
      //  g.drawRect(bounds.x,bounds.y,bounds.width,bounds.height);
    }
    public int getPoints(){
        return points;
    }


}
