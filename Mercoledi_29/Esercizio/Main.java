// Definizione della classe pubblica Main che contiene il metodo main
public class Main {
    
    // Metodo main: punto di ingresso dell'applicazione
    public static void main(String[] args) {
        // Creazione di un'istanza della classe Amministrativo
        Dipendente admin = new Amministrativo("Mirko Campari", 30000);
        // Creazione di un'istanza della classe Tecnico
        Dipendente tecnico = new Tecnico("Manuel Di Nardo", 40000);
        // Creazione di un'istanza della classe Manager
        Dipendente manager = new Manager("Francesco Gionta", 50000);

        // Stampa del nome e del bonus annuale del dipendente amministrativo
        System.out.println(admin.nome + " ha un bonus annuale di: " + admin.calcolaBonus());
        // Stampa del nome e del bonus annuale del dipendente tecnico
        System.out.println(tecnico.nome + " ha un bonus annuale di: " + tecnico.calcolaBonus());
        // Stampa del nome e del bonus annuale del dipendente manager
        System.out.println(manager.nome + " ha un bonus annuale di: " + manager.calcolaBonus());
    }
}
