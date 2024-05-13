package Java;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ServerSocketMultiThread
{



   public static void main(String[] argv)
   {
       ServerSocket server = null;
       HashMap<String, EchoThread> lista;

       try
       {
           server = new ServerSocket(2500);
       }
       catch(IOException ex)
       {
           ex.printStackTrace();
           System.exit(-1);
       }

       System.out.println("Server avviato...");

       lista =  new HashMap<>();

       while(true) {
           try
           {
               Socket client = server.accept();

               EchoThread echoThread = new EchoThread(client, lista);
               Thread worker = new Thread(echoThread);

               worker.start();
           }
           catch(IOException ex)
           {
               ex.printStackTrace();
           }
       }
   }
}


class EchoThread implements Runnable
{
   private Socket client = null;
   private String clientIp = null;
   HashMap<String, EchoThread> lista = new HashMap<>();

   BufferedReader reader = null;
   Writer writer = null;



   public EchoThread(Socket client, HashMap lista)
   {
       this.client = client;
       clientIp = this.client.getInetAddress().getHostAddress();
       System.out.println("[" + clientIp + "] " +
               ">> Connessione in ingresso <<");

       this.lista = lista;
       this.lista.put(clientIp, this);



   }

   public void run()
   {


       try
       {
           reader = new BufferedReader(
                   new InputStreamReader(this.client.getInputStream()));
           writer = new OutputStreamWriter(this.client.getOutputStream());

           while(true)
           {
               String response = reader.readLine();

               if(response == null ||
                       response.equalsIgnoreCase("quit"))
                   break;


               String output = "[" + clientIp + "] " + response;
               System.out.println(output);

               for(Map.Entry<String, EchoThread> entry: lista.entrySet()) {
                       entry.getValue().writer.write(response + "\n");
                       entry.getValue().writer.flush();
               }

           }
       }
       catch(IOException ex)
       {
           // possibile disconnessione del nodo
           // ignoro
       }
       finally
       {
           // Clean
           try
           {
               reader.close();
               writer.close();
               this.client.close();
           }
           catch(IOException ex)
           {
               ex.printStackTrace();
           }

           System.out.println("[" + clientIp + "] " +
                   ">> Connessione terminata <<");
       }
   }
}
