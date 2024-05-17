import java.util.Scanner;

public class Social {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);

        String[][] utenti = new String[4][5];
        // utente 1
        utenti[0][0] = "simone";      // username
        utenti[0][1] = "qwerty";      // password
        utenti[0][2] = "12@12.12";    // email
        utenti[0][3] = "123";         // numero (non usato, ma lasciato per completezza)
        utenti[0][4] = "20";          // età

        // utente 2
        utenti[1][0] = "giovanni";
        utenti[1][1] = "asdfg";
        utenti[1][2] = "34@34.34";
        utenti[1][3] = "456";
        utenti[1][4] = "30";

        // utente 3
        utenti[2][0] = "francesco";
        utenti[2][1] = "zxcvb";
        utenti[2][2] = "56@56.56";
        utenti[2][3] = "789";
        utenti[2][4] = "40";

        // utente nuovo (inizialmente vuoto)
        utenti[3][0] = "";
        utenti[3][1] = "";
        utenti[3][2] = "";
        utenti[3][3] = "";
        utenti[3][4] = "";

        System.out.println("Sei registrato? SI / NO");
        String x = in.nextLine();
        boolean confermaLog = false; // dichiarare confermaLog 

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
            } else {
                confermaLog = false;
            }
        } else {
            System.out.println("Dati inseriti errati");
            confermaLog = false;
        }

        if (confermaLog) {
            System.out.println("Vuoi eseguire dei calcoli?  SI/NO");
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
                            int num1 = inInt.nextInt();
                            int num2 = inInt.nextInt();
                            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                            break;
                        case "2":
                            System.out.println("Inserisci i 2 numeri di cui fare la sottrazione");
                            int num3 = inInt.nextInt();
                            int num4 = inInt.nextInt();
                            System.out.println(num3 + " - " + num4 + " = " + (num3 - num4));
                            break;
                        case "3":
                            System.out.println("Inserisci i 2 numeri di cui fare la moltiplicazione");
                            int num5 = inInt.nextInt();
                            int num6 = inInt.nextInt();
                            System.out.println(num5 + " * " + num6 + " = " + (num5 * num6));
                            break;
                        case "4":
                            System.out.println("Inserisci i 2 numeri di cui fare la divisione");
                            int num7 = inInt.nextInt();
                            int num8 = inInt.nextInt();
                            if (num8 != 0) {
                                System.out.println(num7 + " / " + num8 + " = " + (num7 / num8));
                            } else {
                                System.out.println("Errore: Divisione per zero non consentita.");
                            }
                            break;
                        default:
                            System.out.println("Operazione non valida.");
                    }
                    System.out.println("Vuoi fare altre operazioni? SI/NO");
                    String operazioni = in.nextLine();
                    if (operazioni.equalsIgnoreCase("si")) {
                        altreOperazioni = true;
                    } else {
                        altreOperazioni = false;
                    }
                }
            } else {
                System.out.println("Vuoi fare il logout?");
                String logout = in.nextLine();
                if (logout.equalsIgnoreCase("si")) {
                    System.out.println("Bene, ciao!");
                }
            }
        }
    }

    public static boolean login(String email, String password, String[][] user) {
        Scanner inLog = new Scanner(System.in);
        int tentativiEmail = 0;
        int tentativiPassword = 0;

        while (tentativiEmail < 3 || tentativiPassword < 3) {
            boolean emailTrovata = false;
            for (int i = 0; i < user.length; i++) {
                if (email.equals(user[i][2])) {  // Email è alla posizione 2
                    emailTrovata = true;
                    if (password.equals(user[i][1])) {  // Password è alla posizione 1
                        System.out.println("Benvenuto " + user[i][0]);  // Username è alla posizione 0
                        return true;
                    } else {
                        System.out.println("La password inserita non è corretta. Riprovare? SI/NO");
                        String riprovaPassword = inLog.nextLine();
                        if (riprovaPassword.equalsIgnoreCase("si")) {
                            tentativiPassword++;
                            System.out.println("Reinserisci password:");
                            password = inLog.nextLine();
                            break;  // Esci dal ciclo for per ricontrollare con le nuove credenziali.
                        } else {
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
                } else {
                    return false;
                }
            }
        }
        System.out.println("Hai finito i tentativi");
        return false;
    }

    public static boolean registrazione(String[][] user) {
        Scanner inReg = new Scanner(System.in);
        System.out.println("Inserisci un'email");
        String email = inReg.nextLine();
        boolean emailEsistente = false;
        for (int i = 0; i < user.length; i++) {
            if (user[i][2].equals(email)) {
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
                return login(emailLog, passLog, user);
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
            String eta = inReg.nextLine();
            boolean utenteInserito = false;
            for (int i = 0; i < user.length; i++) {
                if (user[i][2].isEmpty()) {
                    user[i][0] = username;
                    user[i][1] = password;
                    user[i][2] = email;
                    user[i][3] = numero;
                    user[i][4] = eta;
                    utenteInserito = true;
                    break;
                }
            }
            if(utenteInserito){
                System.out.println("utente inserito");
                return true;
            }

        }
        return true;
    }
    
}

