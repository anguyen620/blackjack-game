import java.io.*;
import java.net.*;
import javax.json.*;


public class ChatServerThread implements Runnable
{
   protected Socket socket;
   protected Thread thread;
   protected InputStream inputFromClient;
   protected JsonReader reader;
   protected Server server;
   public ChatServerThread(Socket socket, Server server) throws IOException
   {
      this.socket = socket;
      inputFromClient = socket.getInputStream();
      this.server = server;
      thread = null;
   }

   public void start()
   {
      if (thread == null)
      {
         thread = new Thread(this);
         thread.start();
      }
   }

   public void run()
   {
      while(thread != null && socket.isConnected())
      {
         try
         {
            if(inputFromClient.available() > 0)
            {
               readTextMessage();
            }
         }
         catch(IOException e){}
      }
      System.out.println("ChatServerThread quitting"); 
   }

   protected void readTextMessage()
   {
      try
      {
         reader = Json.createReader(inputFromClient);
         JsonObject textMessageJson = reader.readObject();
         TextMessage textMessage = new TextMessage(textMessageJson);
         System.out.println(textMessage);
         server.forwardMessage(textMessageJson);
      }
      catch(JsonException e)
      {
         System.out.println(e);
         thread = null;
      }
   }
}
