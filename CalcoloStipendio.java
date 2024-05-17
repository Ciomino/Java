import java.util.Scanner;

public class CalcoloStipendio {
    public static void main(String[] args) {
        Scanner inInt = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il numero di mesi");
        int mesi = inInt.nextInt();
        System.out.println("Inserisci la percentuale di tasse");
        int tasse = inInt.nextInt();
        String[][] conteggio = new String[mesi][2];
        boolean conf = true;
        while (conf) {
            int stipendioTotale = 0; 
            for (int i = 0; i < mesi; i++) {
                System.out.println("Inserisci lo stipendio ricevuto nel mese " + (i + 1));
                int stipendio = inInt.nextInt();
                stipendioTotale += stipendio; 
                conteggio[i][0] = String.valueOf(stipendio * (tasse / 100.0)); 
                conteggio[i][1] = String.valueOf(stipendio);
            }
            double mediaStipendi = (double) stipendioTotale / mesi; 
            System.out.println("La media degli stipendi totali è: " + mediaStipendi);
            for (int i = 0; i < mesi; i++) {
                System.out.println("Il tuo stipendio tassato nel " + (i + 1) + " mese e': " + conteggio[i][0]);
                System.out.println("Il tuo stipendio non tassato nel " + (i + 1) + " mese e': " + conteggio[i][1]);
            }
            System.out.println("Vuoi ripetere l'operazione con un altro stipendio?   SI/NO");
            String rip = in.nextLine();
            if (rip.equalsIgnoreCase("si")) {
                conf = true;
            } else {
                conf = false;
            }
        }
        inInt.close();
        in.close();
    }
}
