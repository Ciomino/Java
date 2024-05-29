public class AllarmeAntincendio implements DispositiviDiSicurezza{
    public String nome;
    private boolean stato;
    public int utilizzi; //dopo un tot di utilizzi si rompe

    public AllarmeAntincendio(String nome,boolean stato, int utilizzi){
        this.nome=nome;
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
