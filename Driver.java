class Driver
{
    public static void main(String[] args)
   {
       TimeUnit time = TimeUnit.SECONDS;
       BlackjackView game = new BlackjackView();   
       game.displayMenu();
       time.sleep(3);
       game.displayGame();
       time.sleep(3);
       game.displayEndMessage();
   }
}