
import java.util.ArrayList;

public class PannaCottaFrutta extends PannaCotta {
    private String tipoDiFrutta;

    public PannaCottaFrutta(String nome, ArrayList<String> ingredienti, double prezzo, String tipoDiFrutta){
        super(nome, ingredienti, prezzo);
        this.tipoDiFrutta=tipoDiFrutta;
    }

    public String getTipoDiFrutta() {
        return tipoDiFrutta;
    }

    public void setTipoDiFrutta(String tipoDiFrutta) {
        this.tipoDiFrutta = tipoDiFrutta;
    }

}
