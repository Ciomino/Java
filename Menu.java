import java.util.HashMap;
import java.util.Scanner;

class Menu {
    private Piatto piatto;

    public Menu(Piatto piatto) {
        this.piatto = piatto;
    }

    public void avvia() {
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Benvenuto nel sistema di ordinazione!");
            stampaIngredienti(piatto.getIngredientiP(), "pubblici");
            stampaIngredienti(piatto.getIngredientiScelta(), "a scelta");

            HashMap<String, Integer> ordineTemp = new HashMap<>();
            int totale = 0;

            System.out.println("Scegli tra gli ingredienti pubblici:");
            for (String ingrediente : piatto.getIngredientiP().keySet()) {
                System.out.print("Vuoi aggiungere " + ingrediente + "? (si/no): ");
                String scelta = in.nextLine();
                if (scelta.equalsIgnoreCase("si")) {
                    ordineTemp.put(ingrediente, piatto.getIngredientiP().get(ingrediente));
                    totale += piatto.getIngredientiP().get(ingrediente);
                }
            }

            System.out.println("Inserisci gli ingredienti a scelta:");
            while (true) {
                System.out.print("Inserisci un ingrediente (o 'fine' per terminare): ");
                String ingrediente = in.nextLine();
                if (ingrediente.equalsIgnoreCase("fine")) {
                    loop = false;
                    break;
                }
                if (piatto.getIngredientiScelta().containsKey(ingrediente)) {
                    ordineTemp.put(ingrediente, piatto.getIngredientiScelta().get(ingrediente));
                    totale += piatto.getIngredientiScelta().get(ingrediente);
                } else {
                    System.out.println("Ingrediente non valido. Riprova.");
                }
            }

            piatto.setIngredientiScelta(ordineTemp);

            System.out.println("Il tuo ordine:");
            for (String ingrediente : piatto.getIngredientiScelta().keySet()) {
                System.out.println(ingrediente + ": " + piatto.getIngredientiScelta().get(ingrediente));
            }
            System.out.println("Totale: " + totale + "€");

            System.out.print("Vuoi fare un altro ordine? (si/no): ");
            String altraScelta = in.nextLine();
            if (altraScelta.equalsIgnoreCase("no")) {
                loop = false;
                break;
            }
        }
        in.close();
    }

    private void stampaIngredienti(HashMap<String, Integer> ingredienti, String tipo) {
        System.out.println("Ingredienti " + tipo + ":");
        for (String ingrediente : ingredienti.keySet()) {
            System.out.println(ingrediente + ": " + ingredienti.get(ingrediente) + "€");
        }
    }
}