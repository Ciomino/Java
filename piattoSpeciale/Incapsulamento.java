import java.util.HashMap;

public class Incapsulamento{
    public static void main(String[] args) {
        HashMap<String, Integer> ingredientiP = new HashMap<>();
        ingredientiP.put("Pane con semi di sesamo", 4);
        ingredientiP.put("Pane normale", 3);

        HashMap<String , Integer> ingredientiScelta = new HashMap<>();
        ingredientiScelta.put("Bacon", 2);
        ingredientiScelta.put("Formaggio", 1);
        ingredientiScelta.put("Maionese", 1);
        ingredientiScelta.put("Insalata", 1);
        ingredientiScelta.put("Cipolla carammellata", 3);
        ingredientiScelta.put("Cetriolo", 1);

        Piatto panino = new Piatto(ingredientiP, ingredientiScelta);
        Menu menu = new Menu(panino);
        menu.avvia();
    }
}
