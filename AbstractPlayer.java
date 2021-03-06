import java.util.ArrayList;

public abstract class AbstractPlayer
{
   protected int score;
   protected Hand hand;

   protected AbstractPlayer()
   {
      score = 0;
      hand = new Hand();
   }
 
   protected AbstractPlayer(Hand hand)
   {
      this.hand = hand;
   }

   public int getScore()
   {
      updateScore();
      return score;
   }
   
   public void addToHand(Card card)
   {
      hand.add(card);
   }

   public ArrayList<Card> getHand()
   {
      return hand.getHand();
   }
   
   protected void updateScore()
   {
      ArrayList<Card> cards = hand.getHand();
      score = 0;

      boolean acesPresent = false;      
      int numAces = 0;

      for (Card card: cards)
      {
         if (card.getValue() == 1)
         {
            acesPresent = true;
            numAces++;
         }
         else
         {
            score += card.getValue();
         }
      }

      if (acesPresent)
      {
         for (int i = 0; i < numAces; i++)
         {
            if (score + 11 > 21)
            {
               score += 1;
            }
            else
            {
               score += 11;
            }
         }
      }
   }
   
   public String[] getImages()
   {
      ArrayList<Card> cards = hand.getHand();

      String[] temp = new String[cards.size()];

      int i = 0;
      for (Card c: cards)
      {
         temp[i] = c.getImagePath();
         i++;
      }

      return temp;
   }

   public abstract void hit(Card card);
   
   public void stand() {} // do nothing and end turn
}
