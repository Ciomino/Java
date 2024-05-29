
import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean f = false;
        Estintore estintore = new Estintore("Estintore",false, 20, "schiuma");
        AllarmeAntincendio allarmeAntincendio = new AllarmeAntincendio("allarmeAntincendio",false, 5);
        SistemaDiVentilazione sistemaDiVentilazione = new SistemaDiVentilazione("Sistema di ventilazione",false, 5);
        KitDiProntoSoccorso kitDiProntoSoccorso = new KitDiProntoSoccorso("Kit di Prontosoccorso",false, 5);
        ArrayList<DispositiviDiSicurezza> array = new ArrayList<>();
        array.add(estintore);
        array.add(allarmeAntincendio);
        array.add(sistemaDiVentilazione);
        array.add(kitDiProntoSoccorso);
        for(DispositiviDiSicurezza dis : array){
            System.out.println("Vuoi sapere le condizioni dell"+dis.getNome()+" ?    SI/NO");
            String ris = in.nextLine();
            if (ris.equalsIgnoreCase("si")){
                f=funzionamento(dis);
            }
            if(f){
                System.out.println("Vuoi usare il "+dis.getNome()+" ?   Si/No");
                ris= in.nextLine();
                if(ris.equalsIgnoreCase("si")){
                    attiva(dis);
                }
            }
            
            
        }
    }

    public static void attiva(DispositiviDiSicurezza x){
        x.attiva();
    }
    public void disattiva(DispositiviDiSicurezza x){
        x.disattiva();
    }
    public static boolean funzionamento(DispositiviDiSicurezza x){
        return x.funzionamento();
    }
}