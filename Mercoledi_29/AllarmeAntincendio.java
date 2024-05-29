public class AllarmeAntincendio implements DispositiviDiSicurezza{
    private boolean stato;
    public int utilizzi; //dopo un tot di utilizzi si rompe

    public AllarmeAntincendio(boolean stato, int ultimaManutenzione){
        this.stato=false;
        this.utilizzi=utilizzi;
    }

    @Override
    public void attiva() {
        if(utilizzi>0){
            this.stato=true;
            this.utilizzi-=1;
        }else{
            System.out.println("L'allarme non funziona");
            this.stato=false;
        }
        
    }

    @Override
    public void disattiva() {
        this.stato=false;
    }

    @Override
    public boolean funzionamento() {
        if (utilizzi>0){
            System.out.println("L'allarme funziona ti rimangono "+utilizzi+" utilizzi");
            return true;
        }else{
            return false;
        }
    }

    
}
