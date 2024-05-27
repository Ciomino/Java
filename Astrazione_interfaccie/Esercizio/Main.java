import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione e utilizzo di un'istanza di Artiglieria
        System.out.println("Creazione di un artigliere:");
        System.out.print("Inserisci il nome: ");
        String nomeArtiglieria = scanner.nextLine();
        System.out.print("Inserisci il cognome: ");
        String cognomeArtiglieria = scanner.nextLine();
        System.out.print("Inserisci il grado: ");
        int gradoArtiglieria = scanner.nextInt();
        scanner.nextLine(); // Consumare il newline

        Artiglieria artigliere = new Artiglieria(nomeArtiglieria, cognomeArtiglieria, gradoArtiglieria,null);
        artigliere.specializzazione();
        artigliere.useEquipaggiamentoSpeciale();
        artigliere.combatti();

        // Creazione e utilizzo di un'istanza di Fanteria
        System.out.println("\nCreazione di un fante:");
        System.out.print("Inserisci il nome: ");
        String nomeFanteria = scanner.nextLine();
        System.out.print("Inserisci il cognome: ");
        String cognomeFanteria = scanner.nextLine();
        System.out.print("Inserisci il grado: ");
        int gradoFanteria = scanner.nextInt();
        scanner.nextLine(); // Consumare il newline

        Fanteria fante = new Fanteria(nomeFanteria, cognomeFanteria, gradoFanteria, null);
        fante.specializzazione();
        fante.useEquipaggiamentoSpeciale();
        fante.combatti();

        scanner.close();
    }
}
