package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;

public class FlowersManager {

    protected ArrayList<Flower> flowers=new ArrayList<>();
    protected RefLinks refLinks;

    public FlowersManager(RefLinks refLinks){
        this.refLinks=refLinks;
        refLinks.setFlowersManager(this);
    }
    public void Update() {
        Bee bee=refLinks.getBee();
        for (int i=0;i<flowers.size();++i){
            if ( bee.bounds.intersects(flowers.get(i).bounds)){
                refLinks.getBee().addFlower(flowers.get(i).getPoints());
                flowers.remove(i);
            }
        }
    }


    public void Draw(Graphics g) {
        for (int i=0;i<flowers.size();++i){
            flowers.get(i).Draw(g);
        }
    }

    public void addfFlower(Flower f){
        flowers.add(f);
    }
    public void resetFlowers(){
        flowers=new ArrayList<>();
    }
    public boolean noFlowers(){
        return flowers.isEmpty();
    }
}
