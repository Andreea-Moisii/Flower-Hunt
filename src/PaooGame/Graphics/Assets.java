package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
//    public static BufferedImage beeLeft;
//    public static BufferedImage beeRight;
//    public static BufferedImage grass1;
//    public static BufferedImage grass2;
//    public static BufferedImage tree4;
//    public static BufferedImage tree1;
//    public static BufferedImage tree2;
//    public static BufferedImage tree3;
//  //  public static BufferedImage water;
//
//    public static BufferedImage flower4;
// //   public static BufferedImage tree;


    public static BufferedImage grass;
    public static BufferedImage water;
    public static BufferedImage tree;
    public static BufferedImage flower1;
    public static BufferedImage flower2;
    public static BufferedImage flower3;
    public static BufferedImage bee_left;
    public static BufferedImage bee_right;
    public static BufferedImage arrow;
    public static BufferedImage playback;
    public static BufferedImage aboutback;






    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sprite.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass=sheet.crop(0,0);
        water=sheet.crop(1,0);
        tree=sheet.crop(2,0);
        flower1=sheet.crop(0,1);
        flower2=sheet.crop(1,1);
        flower3=sheet.crop(2,1);
        bee_left=sheet.crop(1,2);
        bee_right=sheet.crop(0,2);
        arrow=sheet.crop(0,3);

        playback=ImageLoader.LoadImage("/textures/PLAY.png");
        aboutback=ImageLoader.LoadImage("/textures/ABOUT.png");
    }
}
