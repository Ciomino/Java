import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    }

    // Funzione per gestire la registrazione di un nuovo utente
public static boolean registrazione(ArrayList<Utente> utenti) {
    Scanner inReg = new Scanner(System.in);
    Scanner inInt = new Scanner(System.in);
    System.out.println("Inserisci lo username");
    String username = inReg.nextLine();
    boolean userEsistente = false;

    // Controlla se username inserita esiste già tra gli utenti registrati
    for (Utente utente : utenti) {
        if (utente.getUsername().equals(username)) {
            userEsistente = true;
            break;
        }
    }

    // Se username esiste già, chiede all'utente se vuole procedere con il login
    if (userEsistente) {
        System.out.println("Username già esistente, vuoi procedere con il login? SI/NO");
        String risposta = inReg.nextLine();
        if (risposta.equalsIgnoreCase("si")) {
            // Se l'utente vuole procedere con il login, richiede user e password
            System.out.println("Inserisci user e password");
            String userLog = inReg.nextLine();
            String passLog = inReg.nextLine();
            return login(userLog, passLog, utenti); // in via di sviluppo
        } else {
            // Se l'utente non vuole procedere con il login, termina la registrazione
            System.out.println("Deciditi, ciao!");
            return false;
        }
    } else {
        // Se username non esiste già, richiede password, numero e età per la registrazione
        System.out.println("Inserisci password");
        String password = inReg.nextLine();
        while (password.isEmpty()) {
            System.out.println("Devi inserire una password");
            password = inReg.nextLine();
        }
        System.out.println("Inserisci il tuo budget");
        int budget = inReg.nextInt();

        // Crea un nuovo oggetto Utente e lo aggiunge alla lista degli utenti registrati
        Utente nuovoUtente = new Utente(username, password,budget);
        utenti.add(nuovoUtente);
        System.out.println("Utente registrato con successo");
        return true;
    }
}
}
