public class Dealer extends AbstractPlayer
{
   protected Deck deck;

   public Dealer()
   {
      hand = new Hand();
      deck = new Deck();
   }

   public Dealer(Hand hand, Deck deck)
   {
      this.hand = hand;
      this.deck = deck;
   }
   
   public void deal(AbstractPlayer player)
   {
      deck.deal(player);
   }
}
