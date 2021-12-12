package PaooGame;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame =Game.getInstance("Flower Hunt", 960, 480);
        paooGame.StartGame();
    }
}
