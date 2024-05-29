public class SistemaDiVentilazione implements DispositiviDiSicurezza{

    public String nome;
    private boolean stato;
    public int utilizzi;

    public SistemaDiVentilazione(String nome,boolean stato,int utilizzi){
        this.nome=nome;
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
            disattiva();
            return false;
        }
    }
    public boolean isStato() {
        return stato;
    }
    public String getNome() {
        return nome;
    }

    
    
}
