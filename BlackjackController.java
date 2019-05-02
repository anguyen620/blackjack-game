import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/*
 * BlackjackController
 * Controller contains attributes for both View and Model
 */

public class BlackjackController
{
   BlackjackView view;
   BlackjackModel model;

   public BlackjackController(BlackjackView view, BlackjackModel model)
   {
      this.view = view;
      this.model = model;
      initResponsiveness(this.view);
   }

   public void addView(BlackjackView view)
   {
      this.view = view;
   }

   public void addModel(BlackjackModel model)
   {
      this.model = model;
   }

   public void playSinglePlayer()
   {
      addModel(new BlackjackModel(Mode.SINGLE_PLAYER));
   }

   public void playComp()
   {
      addModel(new BlackjackModel(Mode.VERSUS));
   }

   public void playerHit()
   {
      model.hit(PlayerType.USER);
   }

   public void playerSplit()
   {
      model.split(PlayerType.USER);
   }

   public void playerStand()
   {
      model.stand(PlayerType.USER);
      
      if (model.gameMode == Mode.VERSUS)
      {
         model.compPlay();
      }

      model.dealerPlay();
   }

   public ArrayList<Integer> getScores()
   {
      ArrayList<Integer> scores = new ArrayList<>();

      scores.add(model.score(PlayerType.USER));

      scores.add(model.score(PlayerType.DEALER));

      if (model.gameMode == Mode.VERSUS)
      {
         scores.add(model.score(PlayerType.COMPUTER));
      }

      return scores;
   }

   public void updateImages(PlayerType type)
   {
      view.updateGameplayImages(type, model.getImages(type));
   }

   protected void initResponsiveness(BlackjackView view)
   {
      view.addSinglePlayerModeListener(singleModeListener);
      view.addVersusModeListener(versusModeListener);
      view.addHelpListener(helpButtonListener);
      //view.addSplitListener(splitListener);
      view.addStandListener(standListener);
      view.addHitListener(hitListener);
   }

   protected ActionListener singleModeListener = new ActionListener() 
   {
       @Override
       public void actionPerformed(ActionEvent e)
       {
          playSinglePlayer();
          view.displayGame(GameType.SOLO);
       }
   };

   
   protected ActionListener versusModeListener = new ActionListener() 
   {   
       @Override
       public void actionPerformed(ActionEvent e)
       {
          playComp();
          view.displayGame(GameType.COMPUTER);
       }
   };

   protected ActionListener helpButtonListener = new ActionListener() 
   {     
       @Override
       public void actionPerformed(ActionEvent e)
       {
          view.displayHelp();    
       }
   };

   protected ActionListener hitListener = new ActionListener() 
   {    
       @Override
       public void actionPerformed(ActionEvent e)
       {
          model.hit(PlayerType.USER);
       }
   };

   protected ActionListener splitListener = new ActionListener() 
   {      
       @Override
       public void actionPerformed(ActionEvent e)
       {
          
       }
   };

   protected ActionListener standListener = new ActionListener()
   {      
       @Override
       public void actionPerformed(ActionEvent e)
       {
          model.stand(PlayerType.USER);
       }
   };
}

