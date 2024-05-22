
import java.util.ArrayList;
import java.util.Scanner;

public class Fabbrica {
    ArrayList<PannaCotta> listaDiPannacotta;

    public Fabbrica(ArrayList<PannaCotta> listaDiPannacotta){
        this.listaDiPannacotta=listaDiPannacotta;
    }

    public ArrayList<PannaCotta> getListaDiPannacotta() {
        return listaDiPannacotta;
    }

    public boolean aggiungiPannaCotta(){
        Scanner in = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        Scanner inDob = new Scanner(System.in);
        ArrayList<String> ingredienti = new ArrayList<>();
        System.out.println("Vuoi aggiungere la pannacotta con la frutta o con il cioccolato?  FRUTTA/CIOCCOLATO");
        String risposta= in.nextLine();
        if (risposta.equalsIgnoreCase("frutta")) {
            System.out.println("Inserisci il nome");
            String nome = in.nextLine();
            System.out.println("Inserisci il numero di ingredienti");
            int num_ingredienti = inInt.nextInt();
            if(num_ingredienti>0){
                for(int i = 0; i<num_ingredienti; i++){
                    System.out.println("Inserisci un ingrediente");
                    String ing = in.nextLine();
                    if(!(ing.isEmpty())){
                        ingredienti.add(ing);
                    }else{
                        System.out.println("Hai provato a fregare mirko");
                        int x = 0;
                        while(x<3){
                            System.out.println("PERMA BAN IN : "+x);
                            x++;
                            try {
                                Thread.sleep(1000); 
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.exit(0);
                        in.close();
                        inInt.close();
                        inDob.close();
                        return false;
                    }
                }
            }
            System.out.println("Inserisci il prezzo");
            double prezzo = inDob.nextDouble();
            System.out.println("Inserisci che tipo di frutta usi");
            String frutta = in.nextLine();
            listaDiPannacotta.add(new PannaCottaFrutta(nome, ingredienti, prezzo, frutta));
            in.close();
            inInt.close();
            inDob.close();
            return true;
        }else if(risposta.equalsIgnoreCase("cioccolato")){
            System.out.println("Inserisci il nome");
            String nome = in.nextLine();
            System.out.println("Inserisci il numero di ingredienti");
            int num_ingredienti = inInt.nextInt();
            if(num_ingredienti>0){
                for(int i = 0; i<num_ingredienti; i++){
                    System.out.println("Inserisci un ingrediente");
                    String ing = in.nextLine();
                    if(!(ing.isEmpty())){
                        ingredienti.add(ing);
                    }else{
                        System.out.println("Hai provato a fregare mirko");
                        int x = 0;
                        while(x<3){
                            System.out.println("PERMA BAN IN : "+x);
                            x++;
                            try {
                                Thread.sleep(1000); 
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.exit(0);
                        in.close();
                        inInt.close();
                        inDob.close();
                        return false;
                    }
                }
            }
            System.out.println("Inserisci il prezzo");
            double prezzo = inDob.nextDouble();
            System.out.println("Inserisci la percentuale di cioccolato");
            double cioccolato = inDob.nextDouble();
            listaDiPannacotta.add(new PannaCottaCioccolato(nome, ingredienti, prezzo, cioccolato));
        }
        in.close();
        inInt.close();
        inDob.close();
        return true;
    }

    public void visualizzaPannacotte() {
        if (listaDiPannacotta.isEmpty()) {
            System.out.println("Non ci sono pannacotte da visualizzare.");
        } else {
            System.out.println("Lista di Pannacotte:");
            for (PannaCotta pannacotta : listaDiPannacotta) {
                System.out.println(pannacotta.getAll());
            }
        }
    }

    public void ricerca(String nome){
        for(PannaCotta panna : listaDiPannacotta){
            if(panna.getNome().equalsIgnoreCase(nome)){
                System.out.println(panna.getAll());
            }else{
                System.out.println("Il nome ricercato non corrisponde a nessuna pannacotta registrata");
            }
        }
    }
}
