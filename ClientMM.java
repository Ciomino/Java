package Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMM {
   public static void main (String []args) {
       final Socket CSocket;
       final BufferedReader in;
       final PrintWriter out;
       final Scanner sc = new Scanner (System.in);
       try {
           CSocket=new Socket("192.168.25.54",2500);
           out=new PrintWriter(CSocket.getOutputStream());
           in=new BufferedReader(new InputStreamReader(CSocket.getInputStream()));
           Thread sender = new Thread(new Runnable() {
               String msg;
               @Override
               public void run() {
                   while (true){
                       msg=sc.nextLine();
                       out.println(msg);
                       out.flush();

                   }

               }
           });
           sender.start();
           Thread reciever = new Thread(new Runnable() {
               String msg;
               @Override
               public void run() {
               try {
                   msg = in.readLine();
                   while (msg!=null){
                       System.out.println("server :"+msg);
                       msg = in.readLine();
                   }
                   System.out.println("server out of service");
                   out.close();
                   CSocket.close();
               }catch (IOException e ){
                   e.printStackTrace();
               }
               }
           });
           reciever.start();
       }catch (Exception e ){
           System.out.println(e.getMessage());
       }
   }
}

