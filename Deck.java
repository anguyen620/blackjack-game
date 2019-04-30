import java.util.ArrayList;
import java.util.Random;

public class Deck
{
//   protected static final int MAX_DECK_SIZE = 52;
   protected ArrayList<Card> cards;
   protected Random rand;

   public Deck()
   {
      cards = new ArrayList<Card>();
      rand = new Random();
      for (int i = 0; i < 13; i++)
      {
          String temp = "";
          if (i == 0)
              temp = "ace";
          else if (i == 10)
              temp = "jack";
          else if (i == 11)
              temp = "queen";
          else if (i == 12) 
              temp = "king";
          else
              temp = Integer.toString(i);
              
          cards.add(new Card(Suit.SPADES, i, new CardImage("./images/"+temp+"_of_spades.png")));
          cards.add(new Card(Suit.HEARTS, i, new CardImage("./images/"+temp+"_of_hearts.png")));
          cards.add(new Card(Suit.DIAMONDS, i, new CardImage("./images/"+temp+"_of_diamonds.png")));
          cards.add(new Card(Suit.CLUBS, i, new CardImage("./images/"+temp+"_of_clubs")));
      }
   }
   
   public Deck(ArrayList<Card> cards)
   {
      this.cards = cards;
      this.rand = new Random();
   }
   
   public Card popCard()
   {
      int deckSize = getSize();
      int index = rand.nextInt(deckSize);
      Card card = getCard(index);
      removeCard(card);

      return card;
   }

   public int getSize()
   {
      return cards.size();
   }

   public Card getCard(int index)
   {
      return cards.get(index);
   }
   
   public void removeCard(Card card)
   {
      cards.remove(card);
   }
}
