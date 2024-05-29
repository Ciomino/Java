public class SistemaDiVentilazione implements DispositiviDiSicurezza{

    private boolean stato;
    public int utilizzi;

    public SistemaDiVentilazione(boolean stato,int utilizzi){
        this.stato=false;
        this.utilizzi=utilizzi;
    }

    @Override
    public void attiva() {
        if(utilizzi>10){
            this.stato=true;
            this.utilizzi-=1;
        }
        
    }

    @Override
    public void disattiva() {
        this.stato=false;
        
    }

    @Override
    public boolean funzionamento() {
        if(utilizzi>0){
            System.out.println("Il sistema di ventilazione funziona e ti rimangono "+utilizzi+" utilizzi");
            return true;
        }else{
            return false;
        }
    }

    
    
}
