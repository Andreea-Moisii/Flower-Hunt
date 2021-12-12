package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    private BufferedImage fundal;
    private BufferedImage hand;
    private int sel=1;
    private int count=4;
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        fundal=Assets.playback;
        hand=Assets.arrow;
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        count--;
        if (count<0) {
        count=4;
            if (refLink.GetKeyManager().left == true) {

                if (sel != 1) sel--;

            }
            if (refLink.GetKeyManager().right == true) {
                if (sel != 3) sel++;
            }
            if (refLink.GetKeyManager().enter == true) {
                if (sel == 1) StateManager.SetState(new PlayState(refLink));
                if (sel == 2) StateManager.SetState(new AboutState(refLink));
                if (sel == 3) StateManager.EndGame();
            }
            System.out.println(sel);
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(fundal,0,0,null);
        if (sel==1) g.drawImage(hand,195,349,null);
        if (sel==2) g.drawImage(hand,450,349,null);
        if (sel==3) g.drawImage(hand,702,349,null);

    }
}
