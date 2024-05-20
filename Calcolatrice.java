
import java.util.Random;
import java.util.Scanner;

public class Calcolatrice {
    public static void main(String[] args) {
        Scanner inInt = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Scanner inDouble = new Scanner(System.in);
        Random rand = new Random();
        boolean altreOperazioni = false;
        int[] contatori = new int[4];
        int contatore = 0;
        System.out.println("Vuoi fare delle operazioni?  SI/NO");
        String risposta= in.nextLine();
        if(risposta.equalsIgnoreCase("si")){
            altreOperazioni=true;
                while (altreOperazioni) {
                        contatore++;
                        System.out.println("Che cosa vuoi fare? \n1: Controllo numero massimo\n2: Controllo numero minimo\n3: Divisione tra interi con risultato arrotondato per eccesso\n4: Calcolare la lunghezza dell'ipotenusa di un triangolo rettangolo dati i cateti");
                        String sceltaOperazione = in.nextLine();
                        while (!(sceltaOperazione.equals("1") || sceltaOperazione.equals("2") || sceltaOperazione.equals("3") || sceltaOperazione.equals("4"))) {
                            System.out.println("Devi scegliere tra 1 (Controllo numero massimo), 2 (Controllo numero minimo), 3 (Divisione con risultato arrotondato per eccesso), 4 (divisione)");
                            sceltaOperazione = in.nextLine();
                        }
                        switch (sceltaOperazione) {
                            case "1":
                                System.out.println("Inserisci i 2 numeri di cui vuoi sapere il maggiore");
                                double num1 = inDouble.nextDouble();
                                double num2 = inDouble.nextDouble();
                                System.out.println("Il risultato corretto e' "+Math.max(num1, num2));
                                System.out.println("Il risultato sbagliato random e' "+rand.nextDouble(100));
                                contatori[0]+=1;
                                break;
                            case "2":
                                System.out.println("Inserisci i 2 numeri di cui vuoi sapere il minore");
                                double num3 = inDouble.nextDouble();
                                double num4 = inDouble.nextDouble();
                                System.out.println("Il risultato corretto e' "+Math.min(num4, num4));
                                System.out.println("Il risultato sbagliato random e' "+rand.nextDouble(100));
                                contatori[1]+=1;
                                break;
                            case "3":
                                System.out.println("Inserisci i 2 numeri di cui fare la v");
                                int num5 = inInt.nextInt();
                                int num6 = inInt.nextInt();
                                if (num5 != 0 || num6!=0) {
                                    System.out.println("Il risultato corretto e' "+Math.floorDiv(num6, num6));
                                    System.out.println("Il risultato sbagliato random e' "+rand.nextDouble(100));
                                    contatori[2]+=1;
                                } else {
                                    System.out.println("Errore: Divisione per zero non consentita.");
                                }
                                
                                break;
                            case "4":
                                System.out.println("Inserisci i 2 numeri di cui calcolare la lunghezza dell'ipotenusa di un triangolo rettangolo dati i cateti");
                                double num7 = inDouble.nextDouble();
                                double num8 = inDouble.nextDouble();
                                System.out.println("La lunghezza dell'ipotenusa e' "+Math.hypot(num7, num8));
                                System.out.println("Il risultato sbagliato random e' "+rand.nextDouble(100));
                                contatori[3]+=1;
                                break;
                            default:
                                System.out.println("Operazione non valida.");
                        }
                        System.out.println("Vuoi fare altre operazioni? SI/NO");
                        String operazioni = in.nextLine();
                        if (operazioni.equalsIgnoreCase("si")) {
                            altreOperazioni = true;
                        } else {
                            altreOperazioni = false;
                        }
                    }
            }else{
                System.out.println("Alla prossima");
            }
            System.out.println("Hai eseguito un totale di "+contatore+" operazioni di cui:");
            System.out.println(contatori[0]+" numero massimo");
            System.out.println(contatori[1]+" numero minimo");
            System.out.println(contatori[2]+" divisione tra interi con risultato arrotondato per eccesso");
            System.out.println(contatori[3]+" calcolo della lunghezza dell'ipotenusa di un triangolo rettangolo dati i cateti");
    }    
}
