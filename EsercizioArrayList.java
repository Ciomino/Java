import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        ArrayList<String>arrayList = new ArrayList<String>();
        System.out.println("Quanti nomi vuoi inserire?");
        int l = inInt.nextInt();
        for(int i = 0; i<l;i++){
            System.out.println("Inserisci un nome");
            arrayList.add(in.nextLine());
        }
        for(int i = 0; i<l;i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("Vuoi rimuovere un nome?  SI/NO");
        String risposta = in.nextLine();
        if(risposta.equalsIgnoreCase("SI")){
            String nomeRim = in.nextLine();
            for(int i = 0; i<arrayList.size();i++){
                if(arrayList.get(i).equalsIgnoreCase(nomeRim)){
                    arrayList.remove(i);
                }else{
                    System.out.println("Il nome inserito non e' presente nell'arrayList");
                }
            }
            System.out.println("Ecco l'arrayList aggiornato");
            for(int i = 0; i<arrayList.size();i++){
                System.out.println(arrayList.get(i));
            }
        }else{
            System.out.println("Ok allora ciao");
        }

    }
}
