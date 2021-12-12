package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;

public class StateManager  {

    public static State previousState  = null; /*!< Referinta catre starea anterioara a jocului.*/
    public static State currentState   = null; /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    private static RefLinks refLinks;

   public StateManager(RefLinks refLinks)
   {
       currentState=new MenuState(refLinks);
       StateManager.refLinks =refLinks;
   }
    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
    }
    public static State GetState()
    {
        return currentState;
    }

    public void Draw(Graphics g)
    {
        currentState.Draw(g);
    }

    public void  Update()
    {
        currentState.Update();
    }

    public static void returnToPrevious(){
       State aux=currentState;
       currentState=previousState;
       previousState=currentState;
    }

    public static void EndGame(){
       refLinks.GetGame().StopGame();
    }
}
