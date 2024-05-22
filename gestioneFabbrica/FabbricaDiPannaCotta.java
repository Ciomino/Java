import java.util.ArrayList;
import java.util.Scanner;

public class FabbricaDiPannaCotta{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        Scanner inInt= new Scanner(System.in);
        Scanner inDob= new Scanner(System.in);
        ArrayList<PannaCotta> pannacotte = new ArrayList<>();
        ArrayList<String> ingredienti = new ArrayList<>();

        System.out.println("Parte di preparazione");
        System.out.println("Mirko dicci come fai la tua pannacotta  (si onesto)");

        System.out.println("Dicci come la chiami");
        String nome=in.nextLine();
        System.out.println("Dicci quanti ingredienti ci metti");
        int numIng = inInt.nextInt();
        for(int i=0; i<numIng;i++){
            System.out.println("Inserisci un ingrediente");
            String ing = in.nextLine();
            ingredienti.add(ing);
        }
        System.out.println("Inserisci il prezzo");
        double prezzo = inDob.nextDouble();
        System.out.println("La fai con il cioccolato o con la frutta?  1) Cioccolato  2) Frutta");
        int risposta = inInt.nextInt();
        switch (risposta) {
            case 1:
                System.out.println("Inserisci la percentuale di cioccolato che usi");
                double cioccolato = inDob.nextDouble();
                PannaCottaCioccolato mirkoCio = new PannaCottaCioccolato(nome, ingredienti, prezzo, cioccolato);
                pannacotte.add(mirkoCio);
                break;
            case 2:
                System.out.println("Inserisci che tipo di frutta usi");
                String frutta= in.nextLine();
                PannaCottaFrutta mirkoFru = new PannaCottaFrutta(nome, ingredienti, prezzo, frutta);
                pannacotte.add(mirkoFru);
                break;
            default:
                System.err.println("Ciao");
        }
        Fabbrica mirkoSRL = new Fabbrica(pannacotte);

        System.out.println("Vuoi aggiungere altre pannacotte visualizzarle cercarle per nome o uscire?");
        System.out.println("1) Aggiungere \n2) Visualizzare \n3) Cercare \n4)Uscire");
        int scelta=inInt.nextInt();
        switch (scelta) {
            case 1:
                if(mirkoSRL.aggiungiPannaCotta()){
                    System.out.println("Aggiunta correttamente");
                }else{
                    System.out.println("ciao");
                }
                break;
            case 2:
                mirkoSRL.visualizzaPannacotte();
                break;
            case 3:
                System.out.println("Inserisci il nome della pannacotta da ricercare");
                String nomeP = in.nextLine();
                mirkoSRL.ricerca(nomeP);
                break;
            case 4:
                System.out.println("CIAOOO");
                break;
            default:
            System.out.println("Cosa hai fatto?");
                
        }
    }
}