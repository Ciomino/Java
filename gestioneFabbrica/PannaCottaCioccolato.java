import java.util.ArrayList;

public class PannaCottaCioccolato extends PannaCotta {
    private double percentualeDiCioccolato;

    public PannaCottaCioccolato(String nome, ArrayList<String> ingredienti, double prezzo, double percentualeDiCioccolato){
        super(nome, ingredienti, prezzo);
        this.percentualeDiCioccolato=percentualeDiCioccolato;
    }

    public double getPercentualeDiCioccolato() {
        return percentualeDiCioccolato;
    }

    public void setPercentualeDiCioccolato(double percentualeDiCioccolato) {
        this.percentualeDiCioccolato = percentualeDiCioccolato;
    }

}
