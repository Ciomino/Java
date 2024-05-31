import java.util.Scanner;

public class InputUser{
    
    static public  User createUser(){
        Scanner in = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        System.out.println("Inserisci il tuo nome");
        String nome = in.nextLine();
        while(nome.isEmpty()){
            System.out.println("Non puoi non inserire il tuo nome riscrivi il tuo nome");
            nome = in.nextLine();
        }
        System.out.println("Inserisci il tuo cognome");
        String cognome = in.nextLine();
        while(cognome.isEmpty()){
            System.out.println("Non puoi non inserire il tuo cognome riscrivi il tuo cognome");
            cognome = in.nextLine();
        }
        System.out.println("Inserisci la tua email");
        String email = in.nextLine();
        while(email.isEmpty()){
            System.out.println("Non puoi non inserire la tua email riscrivi la tua email");
            email = in.nextLine();
        }
        System.out.println("Inserisci la tua eta");
        int eta = inInt.nextInt();
        while(eta<0){
            System.out.println("Non puoi non inserire un'eta inferiore a 0 riprova");
            eta = inInt.nextInt();
        }
        User user = new User(nome, cognome, email, eta);
        in.close();
        inInt.close();
        return user;
    }
}
