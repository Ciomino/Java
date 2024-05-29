public class Estintore implements DispositiviDiSicurezza{

    public String nome;
    private boolean stato;
    public int livello;
    public String tipo;

    public Estintore(String nome,boolean stato,int livello, String tipo){
        this.nome=nome;
        this.stato=false;
        this.livello=livello;
        this.tipo=tipo;
    }

    @Override
    public void attiva() {
        this.stato=true;
    }

    @Override
    public void disattiva() {
        this.stato=false;
    }

    @Override
    public boolean funzionamento() {
        if(livello<=20){
            System.out.println("Funziona ma fai attenzione che ti rimane il 20%");
            return true;
        }else if(livello>20 && livello<80){
            System.out.println("Funziona e hai ancora "+livello+"%");
            return true;
        }else if (livello>=80){
            System.out.println("In ottime condizioni e praticamente pieno");
            return true;
        }else{
            System.out.println("L'estintore e' vuoto scemo brucia");
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
