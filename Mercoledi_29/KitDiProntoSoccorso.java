public class KitDiProntoSoccorso implements DispositiviDiSicurezza{

   private boolean stato; //in utilizzo o meno
   public int scaduto;


   public KitDiProntoSoccorso(boolean stato,int scaduto){
    this.stato=false;
    this.scaduto=scaduto;
   }


    @Override
    public void attiva() {
        if(scaduto>0){
            this.stato=true;
            this.scaduto-=1;
        }else{
            System.out.println("Il kiti di prointo soccorso e' scaduto ciao");
            this.stato=false;
        }
    }

    @Override
    public void disattiva() {
        this.stato=false;
    }

    @Override
    public boolean  funzionamento() {
        if(scaduto>0){
            System.out.println("Il kit di pronto soccorso e' buono");
            return true;
        }else{
            disattiva();
            System.out.println("Il kit di pronto soccorso e' scaduto cambialo");
            return false;
        }
    }
    public boolean isStato() {
        return stato;
    }
    
}
