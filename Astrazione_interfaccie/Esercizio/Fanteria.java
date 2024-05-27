
import java.util.Scanner;

public class Fanteria extends Soldato implements Specialista{
    String nome;
    String cognome;
    int grado;
    String specializza;

    public Fanteria(String nome, String cognome, int grado,String specializza){
        this.nome=nome;
        this.cognome=cognome;
        this.grado=grado;
        this.specializza=null;
    }

    @Override
    public void combatti() {
        switch (specializza) {
            case "Fuciliere":
                System.out.println("Il fuciliere avanza e spara con il fucile d'assalto.");
                break;
            case "Granatiere":
                System.out.println("Il granatiere lancia una granata contro il nemico.");
                break;
            case "Mitragliere":
                System.out.println("Il mitragliere apre il fuoco con la mitragliatrice.");
                break;
            default:
                System.out.println("Non è stata scelta una specializzazione valida per il combattimento.");
        }
    }

    @Override
    public void specializzazione() {
        System.out.println("Scegli la tua specializzazione");
        System.out.println("1)Fuciliere\n2)Granatiere\n3)Mitragliere");
        Scanner inint= new Scanner(System.in);
        int scelta=inint.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("Hai scelto il fuciliere");
                specializza="Fuciliere";
                break;
            case 2:
                System.out.println("Hai scelto il granatiere");
                specializza="Granatiere";
                break;
            case 3:
                System.out.println("Hai scelto il mitragliere");
                specializza="Mitragliere";
                break;
            default:
                System.out.println("Scelta non valida");
        }
        
    }

    @Override
    public void useEquipaggiamentoSpeciale() {
        switch (specializza) {
            case "Fuciliere":
                System.out.println("Hai equipaggiato il Mirino Ottico Avanzato");
                break;
            case "Granatiere":
                System.out.println("Hai equipaggiato il Lanciagranate");
                break;
            case "Mitragliere":
                System.out.println("Hai equipaggiato il Bipiede per Mitragliatrice");
                break;
            default:
                System.out.println("Internal Error");
                
        }
        
    }
    
}
