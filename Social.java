import java.util.ArrayList;
import java.util.Scanner;

public class Social {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Utente> utenti = new ArrayList<>();
        // utente 1
        utenti.add(new Utente("simone", "qwerty", "12@12.12", "123", 20));

        // utente 2
        utenti.add(new Utente("giovanni", "asdfg", "34@34.34", "456", 30));

        // utente 3
        utenti.add(new Utente("francesco", "zxcvb", "56@56.56", "789", 40));

        System.out.println("Sei registrato? SI / NO");
        String x = in.nextLine();

        boolean confermaLog = false;
        if (x.equalsIgnoreCase("si")) {
            System.out.println("Inserisci email e password");
            String email = in.nextLine();
            String password = in.nextLine();
            confermaLog = login(email, password, utenti);
        } else if (x.equalsIgnoreCase("no")) {
            if (registrazione(utenti)) {
                System.out.println("Inserisci email e password per il login");
                String email = in.nextLine();
                String password = in.nextLine();
                confermaLog = login(email, password, utenti);
            }
        } else {
            System.out.println("Dati inseriti errati");
        }

        if (confermaLog) {
            System.out.println("Vuoi eseguire dei calcoli? SI/NO");
            String scelta = in.nextLine();
            if (scelta.equalsIgnoreCase("si")) {
                boolean altreOperazioni = true;
                while (altreOperazioni) {
                    System.out.println("Che operazione vuoi fare? \n1: somma\n2: sottrazione\n3: moltiplicazione\n4: divisione");
                    String sceltaOperazione = in.nextLine();
                    while (!(sceltaOperazione.equals("1") || sceltaOperazione.equals("2") || sceltaOperazione.equals("3") || sceltaOperazione.equals("4"))) {
                        System.out.println("Devi scegliere tra 1 (somma), 2 (sottrazione), 3 (moltiplicazione), 4 (divisione)");
                        sceltaOperazione = in.nextLine();
                    }
                    switch (sceltaOperazione) {
                        case "1":
                            System.out.println("Inserisci i 2 numeri di cui fare la somma");
                            int num1 = in.nextInt();
                            int num2 = in.nextInt();
                            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                            break;
                        case "2":
                            System.out.println("Inserisci i 2 numeri di cui fare la sottrazione");
                            int num3 = in.nextInt();
                            int num4 = in.nextInt();
                            System.out.println(num3 + " - " + num4 + " = " + (num3 - num4));
                            break;
                        case "3":
                            System.out.println("Inserisci i 2 numeri di cui fare la moltiplicazione");
                            int num5 = in.nextInt();
                            int num6 = in.nextInt();
                            System.out.println(num5 + " * " + num6 + " = " + (num5 * num6));
                            break;
                        case "4":
                            System.out.println("Inserisci i 2 numeri di cui fare la divisione");
                            int num7 = in.nextInt();
                            int num8 = in.nextInt();
                            if (num8 != 0) {
                                System.out.println(num7 + " / " + num8 + " = " + (num7 / num8));
                            } else {
                                System.out.println("Errore: Divisione per zero non consentita.");
                            }
                            break;
                        default:
                            System.out.println("Operazione non valida.");
                    }
                    in.nextLine();  // Consuma il newline rimasto dopo in.nextInt()
                    System.out.println("Vuoi fare altre operazioni? SI/NO");
                    String operazioni = in.nextLine();
                    if (!operazioni.equalsIgnoreCase("si")) {
                        altreOperazioni = false;
                    }
                }
            } else {
                System.out.println("Vuoi cambaire nome utente e password?");
                String cambio = in.nextLine();
                if (cambio.equalsIgnoreCase("si")) {
                    System.out.println("Inserisci l'email con cui ti sei loggato");
                    String emailCambio = in.nextLine();
                    modificaUtente(utenti, emailCambio);
                }
            }
            System.out.println("Vuoi fare il logout?");
                String logout = in.nextLine();
                if (logout.equalsIgnoreCase("si")) {
                    System.out.println("Bene, ciao!");
                }
        }
        System.out.println("Vuoi vedere gli utenti registrati?  SI/NO");
        String printUser= in.nextLine();
        if(printUser.equalsIgnoreCase("si")){
            stampaUtenti(utenti);
        }else{
            System.out.println("arrivederci e grazie");
        }
        in.close();
    }

    public static boolean login(String email, String password, ArrayList<Utente> utenti) {
        Scanner inLog = new Scanner(System.in);
        int tentativiEmail = 0;
        int tentativiPassword = 0;

        while (tentativiEmail < 3 || tentativiPassword < 3) {
            boolean emailTrovata = false;
            for (Utente utente : utenti) {
                if (email.equals(utente.getEmail())) {
                    emailTrovata = true;
                    if (password.equals(utente.getPassword())) {
                        System.out.println("Benvenuto " + utente.getUsername());
                        return true;
                    } else {
                        System.out.println("La password inserita non è corretta. Riprovare? SI/NO");
                        String riprovaPassword = inLog.nextLine();
                        if (riprovaPassword.equalsIgnoreCase("si")) {
                            tentativiPassword++;
                            System.out.println("Reinserisci email e password:");
                            email = inLog.nextLine();
                            password = inLog.nextLine();
                            break;  // Esci dal ciclo for per ricontrollare con le nuove credenziali.
                        } else if (riprovaPassword.equalsIgnoreCase("no")) {
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

    public static boolean registrazione(ArrayList<Utente> utenti) {
        Scanner inReg = new Scanner(System.in);
        System.out.println("Inserisci un'email");
        String email = inReg.nextLine();
        boolean emailEsistente = false;

        for (Utente utente : utenti) {
            if (utente.getEmail().equals(email)) {
                emailEsistente = true;
                break;
            }
        }

        if (emailEsistente) {
            System.out.println("Email già esistente, vuoi procedere con il login? SI/NO");
            String risposta = inReg.nextLine();
            if (risposta.equalsIgnoreCase("si")) {
                System.out.println("Inserisci email e password");
                String emailLog = inReg.nextLine();
                String passLog = inReg.nextLine();
                return login(emailLog, passLog, utenti);
            } else {
                System.out.println("Deciditi, ciao!");
                return false;
            }
        } else {
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

            Utente nuovoUtente = new Utente(username, password, email, numero, eta);
            utenti.add(nuovoUtente);
            System.out.println("Utente registrato con successo");
            return true;
        }
    }
    public static void stampaUtenti(ArrayList<Utente> utenti) {
        if (utenti.isEmpty()) {
            System.out.println("Nessun utente registrato.");
        } else {
            for (Utente utente : utenti) {
                System.out.println("Username: " + utente.getUsername() + ", Email: " + utente.getEmail() + 
                                   ", Numero: " + utente.getNumero() + ", Età: " + utente.getEta());
            }
        }
    }
    public static void modificaUtente(ArrayList<Utente> utenti, String email) {
        Scanner in = new Scanner(System.in);
        boolean utenteTrovato = false;
    
        for (Utente utente : utenti) {
            if (utente.getEmail().equalsIgnoreCase(email)) {
                utenteTrovato = true;
                
                System.out.println("Utente trovato: " + utente.getUsername());
                System.out.println("Inserisci il nuovo nome utente:");
                String nuovoNome = in.nextLine();
                System.out.println("Inserisci la nuova password:");
                String nuovaPassword = in.nextLine();
                
                // Usando i metodi setter per aggiornare i campi, è necessario aggiungere i metodi setter alla classe Utente
                utente.setUsername(nuovoNome);
                utente.setPassword(nuovaPassword);
                
                System.out.println("Nome utente e password aggiornati con successo.");
                break;
            }
        }
    
        if (!utenteTrovato) {
            System.out.println("Utente con l'email " + email + " non trovato.");
        }
    }
        
}


