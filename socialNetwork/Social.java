
import java.util.ArrayList;
import java.util.Scanner;

public class Social {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Utente> utenti = new ArrayList<>(); // Crea un ArrayList per memorizzare gli utenti

        // Utente 1 pre-creato
        utenti.add(new Utente("simone", "qwerty", "12@12.12", "123", 20));

        // Utente 2 pre-creato
        utenti.add(new Utente("giovanni", "asdfg", "34@34.34", "456", 30));

        // Utente 3 pre-creato
        utenti.add(new Utente("francesco", "zxcvb", "56@56.56", "789", 40));

        System.out.println("Sei registrato? SI / NO"); // Domanda all'utente se è registrato
        String x = in.nextLine();

        boolean confermaLog = false; // Variabile per memorizzare se il login è confermato

        if (x.equalsIgnoreCase("si")) {
            System.out.println("Inserisci email e password"); // Richiesta di email e password
            String email = in.nextLine();
            String password = in.nextLine();

            confermaLog = login(email, password, utenti); // Tenta il login

        } else if (x.equalsIgnoreCase("no")) {
            if (registrazione(utenti)) { // Se l'utente si registra
                System.out.println("Inserisci email e password per il login"); // Richiesta di email e password
                String email = in.nextLine();
                String password = in.nextLine();

                confermaLog = login(email, password, utenti); // Tenta il login
            }

        } else {
            System.out.println("Dati inseriti errati"); // Errore se i dati inseriti non sono validi
        }

        if (confermaLog) { // Se il login è confermato
            System.out.println("Vuoi eseguire dei calcoli? SI/NO"); // Domanda se l'utente vuole fare calcoli
            String scelta = in.nextLine();

            if (scelta.equalsIgnoreCase("si")) {
                boolean altreOperazioni = true; // Variabile per controllare se l'utente vuole fare altre operazioni

                while (altreOperazioni) { // Ciclo per le operazioni
                    System.out.println("Che operazione vuoi fare? \n1: somma\n2: sottrazione\n3: moltiplicazione\n4: divisione"); // Menu delle operazioni
                    String sceltaOperazione = in.nextLine();

                    while (!(sceltaOperazione.equals("1") || sceltaOperazione.equals("2") || sceltaOperazione.equals("3") || sceltaOperazione.equals("4"))) { // Validazione della scelta
                        System.out.println("Devi scegliere tra 1 (somma), 2 (sottrazione), 3 (moltiplicazione), 4 (divisione)"); // Messaggio di errore
                        sceltaOperazione = in.nextLine();
                    }

                    switch (sceltaOperazione) { // Esegue l'operazione scelta
                        case "1":
                            System.out.println("Inserisci i 2 numeri di cui fare la somma"); // Richiesta dei numeri per la somma
                            int num1 = in.nextInt();
                            int num2 = in.nextInt();
                            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); // Esegue la somma
                            break;

                        case "2":
                            System.out.println("Inserisci i 2 numeri di cui fare la sottrazione"); // Richiesta dei numeri per la sottrazione
                            int num3 = in.nextInt();
                            int num4 = in.nextInt();
                            System.out.println(num3 + " - " + num4 + " = " + (num3 - num4)); // Esegue la sottrazione
                            break;

                        case "3":
                            System.out.println("Inserisci i 2 numeri di cui fare la moltiplicazione"); // Richiesta dei numeri per la moltiplicazione
                            int num5 = in.nextInt();
                            int num6 = in.nextInt();
                            System.out.println(num5 + " * " + num6 + " = " + (num5 * num6));
                            break;
                        case "4":
                            System.out.println("Inserisci i 2 numeri di cui fare la divisione"); // Richiesta dei numeri per la divisione
                            int num7 = in.nextInt();
                            int num8 = in.nextInt();

                            if (num8 != 0) { // Controllo se il divisore è diverso da zero
                                System.out.println(num7 + " / " + num8 + " = " + (num7 / num8)); // Esegue la divisione
                            } else {
                                System.out.println("Errore: Divisione per zero non consentita."); // Messaggio di errore per divisione per zero
                            }
                            break;

                        default:
                            System.out.println("Operazione non valida."); // Messaggio di errore per operazione non valida
                            break;
                    }

                    in.nextLine(); // Consuma il newline rimasto dopo in.nextInt()
                    System.out.println("Vuoi fare altre operazioni? SI/NO"); // Domanda se l'utente vuole fare altre operazioni
                    String operazioni = in.nextLine();

                    if (!operazioni.equalsIgnoreCase("si")) { // Se l'utente non vuole fare altre operazioni
                        altreOperazioni = false; // Termina il ciclo
                    }
                }

            } else {
                System.out.println("Vuoi cambiare nome utente e password?"); // Domanda se l'utente vuole cambiare nome utente e password
                String cambio = in.nextLine();

                if (cambio.equalsIgnoreCase("si")) {
                    System.out.println("Inserisci l'email con cui ti sei loggato"); // Richiesta dell'email
                    String emailCambio = in.nextLine();

                    modificaUtente(utenti, emailCambio); // Modifica l'utente con l'email specificata
                }
            }

            System.out.println("Vuoi fare il logout?"); // Domanda se l'utente vuole fare il logout
            String logout = in.nextLine();

            if (logout.equalsIgnoreCase("si")) {
                System.out.println("Bene, ciao!"); // Messaggio di saluto
            }

        }

        System.out.println("Vuoi vedere gli utenti registrati? SI/NO"); // Domanda se l'utente vuole vedere gli utenti registrati
        String printUser = in.nextLine();

        if (printUser.equalsIgnoreCase("si")) {
            stampaUtenti(utenti); // Stampa gli utenti registrati
        } else {
            System.out.println("arrivederci e grazie"); // Messaggio di saluto
        }

        in.close(); // Chiude lo scanner
    }

    // Metodo per il login
    public static boolean login(String email, String password, ArrayList<Utente> utenti) {
        Scanner inLog = new Scanner(System.in);
        int tentativiEmail = 0; // Contatore dei tentativi per l'email
        int tentativiPassword = 0; // Contatore dei tentativi per la password

        while (tentativiEmail < 3 || tentativiPassword < 3) { // Ciclo per i tentativi
            boolean emailTrovata = false; // Flag per indicare se l'email è stata trovata

            for (Utente utente : utenti) { // Ciclo per ogni utente
                if (email.equals(utente.getEmail())) { // Se l'email corrisponde
                    emailTrovata = true;

                    if (password.equals(utente.getPassword())) { // Se la password corrisponde
                        System.out.println("Benvenuto " + utente.getUsername()); // Messaggio di benvenuto
                        return true; // Login confermato
                    } else { // Se la password non corrisponde
                        System.out.println("La password inserita non è corretta. Riprovare? SI/NO"); // Messaggio di errore
                        String riprovaPassword = inLog.nextLine();

                        if (riprovaPassword.equalsIgnoreCase("si")) { // Se l'utente vuole riprovare
                            tentativiPassword++; // Incrementa il contatore dei tentativi per la password
                            System.out.println("Reinserisci email e password:"); // Richiesta di email e password
                            email = inLog.nextLine();
                            password = inLog.nextLine();

                            break; // Esce dal ciclo for per riprovare con le nuove credenziali
                        } else if (riprovaPassword.equalsIgnoreCase("no")) { // Se l'utente non vuole riprovare
                            System.out.println("Vuoi procedere con il recupero della password? SI/NO");
                            riprovaPassword = inLog.nextLine();
                            if (riprovaPassword.equalsIgnoreCase("si")) {
                                // Chiamata alla funzione per il recupero della password
                                System.out.println("Recupero password in corso");
                            } else {
                                System.out.println("CIAOOOOO!");
                                return false;
                            }
                        } else {
                            System.out.println("La risposta data non è valida. CIAO!");
                            return false;
                        }
                    }
                }
            }
            if (!emailTrovata) {
                System.out.println("L'email inserita non è corretta. Riprovare? SI/NO");
                String riprovaEmail = inLog.nextLine();
                if (riprovaEmail.equalsIgnoreCase("si")) {
                    tentativiEmail++;
                    System.out.println("Reinserisci email e password:");
                    email = inLog.nextLine();
                    password = inLog.nextLine();
                } else if (riprovaEmail.equalsIgnoreCase("no")) {
                    System.out.println("Vuoi procedere con il recupero dell'email? SI/NO");
                    riprovaEmail = inLog.nextLine();
                    if (riprovaEmail.equalsIgnoreCase("si")) {
                        // Chiamata alla funzione per il recupero dell'email
                        System.out.println("Recupero email in corso");
                    } else {
                        System.out.println("CIAOOOOO!");
                        return false;
                    }
                } else {
                    System.out.println("La risposta data non è valida. CIAO!");
                    return false;
                }
            }
        }
        System.out.println("Hai finito i tentativi");
        return false;
    }

// Funzione per gestire la registrazione di un nuovo utente
public static boolean registrazione(ArrayList<Utente> utenti) {
    Scanner inReg = new Scanner(System.in);
    System.out.println("Inserisci un'email");
    String email = inReg.nextLine();
    boolean emailEsistente = false;

    // Controlla se l'email inserita esiste già tra gli utenti registrati
    for (Utente utente : utenti) {
        if (utente.getEmail().equals(email)) {
            emailEsistente = true;
            break;
        }
    }

    // Se l'email esiste già, chiede all'utente se vuole procedere con il login
    if (emailEsistente) {
        System.out.println("Email già esistente, vuoi procedere con il login? SI/NO");
        String risposta = inReg.nextLine();
        if (risposta.equalsIgnoreCase("si")) {
            // Se l'utente vuole procedere con il login, richiede email e password
            System.out.println("Inserisci email e password");
            String emailLog = inReg.nextLine();
            String passLog = inReg.nextLine();
            return login(emailLog, passLog, utenti);
        } else {
            // Se l'utente non vuole procedere con il login, termina la registrazione
            System.out.println("Deciditi, ciao!");
            return false;
        }
    } else {
        // Se l'email non esiste già, richiede password, username, numero e età per la registrazione
        System.out.println("Inserisci password");
        String password = inReg.nextLine();
        while (password.isEmpty()) {
            System.out.println("Devi inserire una password");
            password = inReg.nextLine();
        }
        System.out.println("Inserisci username");
        String username = inReg.nextLine();
        System.out.println("Inserisci numero");
        String numero = inReg.nextLine();
        System.out.println("Inserisci età");
        int eta = inReg.nextInt();

        // Crea un nuovo oggetto Utente e lo aggiunge alla lista degli utenti registrati
        Utente nuovoUtente = new Utente(username, password, email, numero, eta);
        utenti.add(nuovoUtente);
        System.out.println("Utente registrato con successo");
        return true;
    }
}

    // Funzione per stampare gli utenti registrati
public static void stampaUtenti(ArrayList<Utente> utenti) {
    // Controlla se non ci sono utenti registrati
    if (utenti.isEmpty()) {
        System.out.println("Nessun utente registrato.");
    } else {
        // Stampa le informazioni di ciascun utente registrato
        for (Utente utente : utenti) {
            System.out.println("Username: " + utente.getUsername() + ", Email: " + utente.getEmail() + 
                               ", Numero: " + utente.getNumero() + ", Età: " + utente.getEta());
        }
    }
}

// Funzione per modificare i dati di un utente esistente
public static void modificaUtente(ArrayList<Utente> utenti, String email) {
    Scanner in = new Scanner(System.in);
    boolean utenteTrovato = false;

    // Cerca l'utente con l'email specificata
    for (Utente utente : utenti) {
        if (utente.getEmail().equalsIgnoreCase(email)) {
            utenteTrovato = true;

            // Chiede all'utente di inserire il nuovo nome utente e la nuova password
            System.out.println("Utente trovato: " + utente.getUsername());
            System.out.println("Inserisci il nuovo nome utente:");
            String nuovoNome = in.nextLine();
            System.out.println("Inserisci la nuova password:");
            String nuovaPassword = in.nextLine();

            // Aggiorna il nome utente e la password dell'utente trovato utilizzando i metodi setter
            utente.setUsername(nuovoNome);
            utente.setPassword(nuovaPassword);

            System.out.println("Nome utente e password aggiornati con successo.");
            break;
        }
    }

    // Se l'utente non viene trovato, stampa un messaggio di avviso
    if (!utenteTrovato) {
        System.out.println("Utente con l'email " + email + " non trovato.");
    }
}

        
}


