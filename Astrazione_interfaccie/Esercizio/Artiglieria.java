import java.util.Scanner;

public class Artiglieria extends Soldato implements Specialista{
    String nome;
    String cognome;
    int grado;
    String specializza;

    public Artiglieria(String nome, String cognome, int grado,String specializza){
        this.nome=nome;
        this.cognome=cognome;
        this.grado=grado;
        this.specializza=null;
    }

    @Override
    public void specializzazione() {
        System.out.println("Scegli la tua specializzazione");
        System.out.println("1)Artigliere di Cannone\n2)Artigliere Antiaereo\n3)Artigliere di Mortaio");
        Scanner inint= new Scanner(System.in);
        int scelta=inint.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("Hai scelto l'artigliere di Cannone");
                specializza="Artigliere di Cannone";
                break;
            case 2:
                System.out.println("Hai scelto l'artigliere Antiaereo");
                specializza="Artigliere Antiaereo";
                break;
            case 3:
                System.out.println("Hai scelto l'artigliere di Mortaio");
                specializza="Artigliere di Mortaio";
                break;
            default:
                System.out.println("Scelta non valida");
        }
        
    }

    @Override
    public void useEquipaggiamentoSpeciale() {
        switch (specializza) {
            case "Artigliere di Cannone":
                System.out.println("Hai equipaggiato il Sistema di Puntamento Avanzato");
                break;
            case "Artigliere Antiaereo":
                System.out.println("Hai equipaggiato il Sistema Radar di Tracciamento");
                break;
            case "Artigliere di Mortaio":
                System.out.println("Hai equipaggiato il Telemetro Portatile");
                break;
            default:
                System.out.println("Internal Error");
                
        }
    }

    @Override
    public void combatti() {
        switch (specializza) {
            case "Artigliere di Cannone":
                System.out.println("L'artigliere di cannone prepara e spara il cannone verso il bersaglio.");
                break;
            case "Artigliere Antiaereo":
                System.out.println("L'artigliere antiaereo traccia e ingaggia un velivolo nemico.");
                break;
            case "Artigliere di Mortaio":
                System.out.println("L'artigliere di mortaio calcola la traiettoria e lancia un colpo di mortaio.");
                break;
            default:
                System.out.println("Non è stata scelta una specializzazione valida per il combattimento.");
        }
    }
    
}
