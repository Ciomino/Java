import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inInt= new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        boolean continua = true;
        while (continua) {
            stampaMenu();

            int scelta = inInt.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il titolo del libro che vorresti prendere in prestito");
                    String titolo = in.nextLine();
                    biblioteca.prestaLibro(titolo);
                    break;
                case 2:
                    System.out.println("Inserisci il titolo del libro che vuoi restituire");
                    String titolo1 = in.nextLine();
                    biblioteca.restituisciLibro(titolo1);
                    break;
                case 3:
                    System.out.println("Inserisci il titolo del libro che vuoi aggiungere");
                    String titolo2 = in.nextLine();
                    System.out.println("Inserisci il numero di copie disponibili");
                    int copie = inInt.nextInt();
                    biblioteca.aggiungiLibro(titolo2, copie);
                    break;
                case 4:
                    System.out.println("Inserisci il titolo del libro da eliminare");
                    String titolo3 = in.nextLine();
                    biblioteca.rimuoviLibro(titolo3);
                    break;
                case 5:
                    biblioteca.stampaLibriDisponibili();
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        
        System.out.println("Grazie per aver utilizzato la gestione della biblioteca!");
    }

    private static void stampaMenu() {
        System.out.println("\nMenu gestione biblioteca:");
        System.out.println("1. Prendere un libro in prestito");
        System.out.println("2. Restituisci un libro");
        System.out.println("3. Aggiungi libro");
        System.out.println("4. Rimuovi libro");
        System.out.println("5. Stampa libri disponibili");
        System.out.println("0. Esci");
        System.out.print("Inserisci la tua scelta: ");
    }

}
