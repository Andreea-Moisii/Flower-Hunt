package PaooGame.States;

import PaooGame.Items.Bee;
import PaooGame.Items.FlowersManager;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Bee bee;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    private FlowersManager flowersManager;
    public int counter=0;
    private int time;
    private int lvl=1;

    private Font font = new Font("Monospaced", Font.BOLD,40);
    private Font font2 = new Font("Monospaced", Font.BOLD,70);

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
       this.time=time;

            ///Construieste harta jocului
        flowersManager=new FlowersManager(refLink);
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        bee = new Bee(refLink,120, 100);
        time=40;
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        if (time>0) {
            map.Update();
            bee.Update();
            flowersManager.Update();
            counter++;
            if (counter == 60) {
                time--;
                counter = 0;
            }
        }


        if (refLink.GetKeyManager().esc==true){
            StateManager.returnToPrevious();
        }
        if (time==0 && refLink.GetKeyManager().space==true){
            if (lvl<4)
                nextLvl();
            else
                lvl=4;
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {

        map.Draw(g);
        flowersManager.Draw(g);
        if (time>0) {
            bee.Draw(g);
            g.setColor(Color.black);
            if (time>9) g.drawString("00:" + time, refLink.GetWidth() - 100, 20);
            else  g.drawString("00:0" + time, refLink.GetWidth() - 100, 20);
        }
        else
        {
            if (lvl!=4) {
                g.setFont(font2);
                g.setColor(Color.BLACK);
                g.drawString("End lvl "+lvl, 250, 200);
                g.drawString("SCORE : " + bee.getPoints(), 200, 270);
                g.drawString("space to continue",110,370);
            }
            else{
                g.setFont(font2);
                g.setColor(Color.BLACK);
                flowersManager.resetFlowers();
                g.drawString("GAME OVER", 300, 200);
                g.drawString("Total Score : " + bee.getTotalpoints(), 170, 270);
            }
        }
    }


    public void nextLvl(){
        ++lvl;
        if (lvl==2) time=25;
        if (lvl==3) time=15;
        bee.resetPoints();
        flowersManager.resetFlowers();
        map.LoadWorld();
    }
}
